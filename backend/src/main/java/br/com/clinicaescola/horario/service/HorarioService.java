package br.com.clinicaescola.horario.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.clinicaescola.horario.DTO.HorarioDTO;
import br.com.clinicaescola.horario.entity.Horario;
import br.com.clinicaescola.horario.repository.HorarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HorarioService {

	private final HorarioRepository horarioRepository;

	@Transactional(readOnly = true)
	public List<HorarioDTO> listarDisponiveis() {
		LocalDateTime agora = LocalDateTime.now();

		return horarioRepository
				.findByDisponivelConfiguradoTrueAndInicioAfterOrderByInicioAsc(agora)
				.stream()
				.filter(horario -> horario.getCapacidadeRestante() > 0)
				.map(this::toResponse)
				.toList();
	}

	private HorarioDTO toResponse(Horario horario) {
		return HorarioDTO.builder()
				.id(horario.getId())
				.servico(horario.getServico())
				.local(horario.getLocal())
				.inicio(horario.getInicio())
				.fim(horario.getFim())
				.capacidadeRestante(horario.getCapacidadeRestante())
				.build();
	}
}
