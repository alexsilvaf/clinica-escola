package br.com.clinicaescola.agendamento.aplicacao;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.clinicaescola.agendamento.dominio.Agendamento;
import br.com.clinicaescola.agendamento.dominio.AgendamentoRepository;
import br.com.clinicaescola.agendamento.dominio.Horario;
import br.com.clinicaescola.agendamento.dominio.HorarioRepository;
import br.com.clinicaescola.agendamento.dominio.exception.HorarioNaoEncontradoException;
import br.com.clinicaescola.agendamento.dominio.service.PoliticaDeAgendamento;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservarHorario {

    private final AgendamentoRepository agendamentoRepository;
    private final HorarioRepository horarioRepository;
    private final PoliticaDeAgendamento politicaDeAgendamento;
    private final Clock clock;

    @Transactional
    public AgendamentoCriado executar(ReservarHorarioComando comando) {
        validarComando(comando);

        return agendamentoRepository.buscarPorChaveRequisicao(comando.chaveRequisicao().trim())
                .map(this::montarResultadoExistente)
                .orElseGet(() -> criarNovoAgendamento(comando));
    }

    private AgendamentoCriado criarNovoAgendamento(ReservarHorarioComando comando) {
        Horario horario = horarioRepository.buscarPorIdComBloqueio(comando.horarioId())
                .orElseThrow(HorarioNaoEncontradoException::new);

        Optional<Agendamento> agendamentoExistente = agendamentoRepository
                .buscarPorChaveRequisicao(comando.chaveRequisicao().trim());
        if (agendamentoExistente.isPresent()) {
            return montarResultadoExistente(agendamentoExistente.get());
        }

        LocalDateTime agora = LocalDateTime.now(clock);
        long quantidadeAgendamentos = agendamentoRepository.contarPorHorario(horario.getId());
        politicaDeAgendamento.validarReserva(horario, agora, quantidadeAgendamentos);

        Agendamento agendamento = Agendamento.criar(
                horario.getId(),
                comando.nome(),
                comando.contato(),
                UUID.randomUUID().toString(),
                agora,
                comando.chaveRequisicao());

        return montarResultado(agendamentoRepository.salvar(agendamento), horario);
    }

    private AgendamentoCriado montarResultadoExistente(Agendamento agendamento) {
        Horario horario = horarioRepository.buscarPorId(agendamento.getHorarioId())
                .orElseThrow(HorarioNaoEncontradoException::new);
        return montarResultado(agendamento, horario);
    }

    private AgendamentoCriado montarResultado(Agendamento agendamento, Horario horario) {
        return new AgendamentoCriado(
                agendamento.getProtocolo(),
                horario.getServico(),
                horario.getLocal(),
                horario.getInicio(),
                horario.getFim());
    }

    private void validarComando(ReservarHorarioComando comando) {
        Objects.requireNonNull(comando, "Os dados do agendamento são obrigatórios.");
        Objects.requireNonNull(comando.horarioId(), "O horário é obrigatório.");
        if (comando.chaveRequisicao() == null || comando.chaveRequisicao().isBlank()) {
            throw new IllegalArgumentException("A chave de requisição é obrigatória.");
        }
    }
}
