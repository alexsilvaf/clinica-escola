package br.com.clinicaescola.agendamento.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.clinicaescola.agendamento.DTO.AgendamentoRequest;
import br.com.clinicaescola.agendamento.DTO.AgendamentoResponse;
import br.com.clinicaescola.agendamento.entity.Agendamento;
import br.com.clinicaescola.agendamento.exception.HorarioIndisponivelException;
import br.com.clinicaescola.agendamento.exception.HorarioNaoEncontradoException;
import br.com.clinicaescola.agendamento.repository.AgendamentoRepository;
import br.com.clinicaescola.horario.entity.Horario;
import br.com.clinicaescola.horario.repository.HorarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

	private final AgendamentoRepository agendamentoRepository;
	private final HorarioRepository horarioRepository;

	@Transactional
	public AgendamentoResponse reservar(AgendamentoRequest request) {
		var existente = agendamentoRepository.findByChaveRequisicao(request.getChaveRequisicao());
		if (existente.isPresent()) {
			return toResponse(existente.get());
		}

		Horario horario =
				horarioRepository
						.findById(request.getHorarioId())
						.orElseThrow(() -> new HorarioNaoEncontradoException("Horário não encontrado."));

		LocalDateTime agora = LocalDateTime.now();
		if (!horario.estaDisponivelParaReserva(agora)) {
			throw new HorarioIndisponivelException(
					"Horário indisponível, esgotado ou já passou.");
		}

		horario.consumirVaga();

		try {
			// @Version em Horario garante bloqueio otimista: duas requisições
			// concorrentes pela última vaga não conseguem gravar ambas.
			horarioRepository.saveAndFlush(horario);
		} catch (OptimisticLockingFailureException e) {
			throw new HorarioIndisponivelException(
					"Horário acabou de ser reservado por outra pessoa.");
		}

		Agendamento agendamento =
				Agendamento.builder()
						.horario(horario)
						.nome(request.getNome())
						.contato(request.getContato())
						.protocolo(gerarProtocolo())
						.criadoEm(agora)
						.chaveRequisicao(request.getChaveRequisicao())
						.build();

		try {
			agendamentoRepository.saveAndFlush(agendamento);
		} catch (DataIntegrityViolationException e) {
			// corrida rara: outra requisição com a mesma chave venceu entre o
			// check inicial e este insert; devolve a reserva já existente.
			return agendamentoRepository
					.findByChaveRequisicao(request.getChaveRequisicao())
					.map(this::toResponse)
					.orElseThrow(() -> e);
		}

		return toResponse(agendamento);
	}

	private String gerarProtocolo() {
		return "AG-" + UUID.randomUUID().toString().replace("-", "").substring(0, 10).toUpperCase();
	}

	private AgendamentoResponse toResponse(Agendamento agendamento) {
		Horario horario = agendamento.getHorario();
		return AgendamentoResponse.builder()
				.protocolo(agendamento.getProtocolo())
				.servico(horario.getServico())
				.local(horario.getLocal())
				.inicio(horario.getInicio())
				.fim(horario.getFim())
				.criadoEm(agendamento.getCriadoEm())
				.build();
	}
}
