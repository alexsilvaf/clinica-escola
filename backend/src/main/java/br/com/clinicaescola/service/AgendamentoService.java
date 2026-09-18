package br.com.clinicaescola.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.clinicaescola.model.Agendamento;
import br.com.clinicaescola.model.Horario;
import br.com.clinicaescola.repository.AgendamentoRepository;
import br.com.clinicaescola.repository.HorarioRepository;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final HorarioRepository horarioRepository;

    public AgendamentoService(
            AgendamentoRepository agendamentoRepository,
            HorarioRepository horarioRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.horarioRepository = horarioRepository;
    }

    public Horario buscarHorario(Long horarioId) {
        return horarioRepository.findById(horarioId)
                .orElseThrow(() -> new IllegalArgumentException("Horário não encontrado."));
    }

    public Optional<Agendamento> buscarPorChaveRequisicao(String chaveRequisicao) {
        return agendamentoRepository.findByChaveRequisicao(chaveRequisicao);
    }

    private String gerarProtocolo() {
        return UUID.randomUUID().toString();
    }

    @Transactional
    public Agendamento criarAgendamento(
            Long horarioId,
            String nome,
            String contato,
            String chaveRequisicao) {

        Horario horario = horarioRepository.findByIdComBloqueio(horarioId)
                .orElseThrow(() -> new IllegalArgumentException("Horário não encontrado."));

        if (horario.getInicio().isBefore(LocalDateTime.now())) {
            throw new IllegalStateException(
                    "Não é possível agendar um horário que já passou.");
        }

        if (!horario.isDisponivel()) {
            throw new IllegalStateException(
                    "Este horário está indisponível.");
        }

        Agendamento agendamentoExistente =
                buscarPorChaveRequisicao(chaveRequisicao).orElse(null);

        if (agendamentoExistente != null) {
            return agendamentoExistente;
        }

        long quantidadeAgendamentos =
                agendamentoRepository.countByHorarioId(horarioId);

        if (quantidadeAgendamentos >= horario.getCapacidade()) {
            throw new IllegalStateException(
                    "Este horário está lotado.");
        }

        Agendamento agendamento = new Agendamento();

        agendamento.setHorarioId(horario.getId());
        agendamento.setNome(nome);
        agendamento.setContato(contato);
        agendamento.setProtocolo(gerarProtocolo());
        agendamento.setInstanteReserva(LocalDateTime.now());
        agendamento.setChaveRequisicao(chaveRequisicao);

        return agendamentoRepository.save(agendamento);
    }
}