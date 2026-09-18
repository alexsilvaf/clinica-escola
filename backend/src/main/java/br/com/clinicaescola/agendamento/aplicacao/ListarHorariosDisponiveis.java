package br.com.clinicaescola.agendamento.aplicacao;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.clinicaescola.agendamento.dominio.AgendamentoRepository;
import br.com.clinicaescola.agendamento.dominio.Horario;
import br.com.clinicaescola.agendamento.dominio.HorarioRepository;
import br.com.clinicaescola.agendamento.dominio.service.PoliticaDeAgendamento;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListarHorariosDisponiveis {

    private final HorarioRepository horarioRepository;
    private final AgendamentoRepository agendamentoRepository;
    private final PoliticaDeAgendamento politicaDeAgendamento;
    private final Clock clock;

    @Transactional(readOnly = true)
    public List<HorarioDisponivel> executar() {
        return horarioRepository.buscarDisponiveisDepoisDe(LocalDateTime.now(clock))
                .stream()
                .map(this::montarResultado)
                .toList();
    }

    private HorarioDisponivel montarResultado(Horario horario) {
        long quantidadeAgendamentos = agendamentoRepository.contarPorHorario(horario.getId());
        return new HorarioDisponivel(
                horario.getId(),
                horario.getServico(),
                horario.getLocal(),
                horario.getInicio(),
                horario.getFim(),
                politicaDeAgendamento.calcularVagas(horario, quantidadeAgendamentos));
    }
}
