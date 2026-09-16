package br.com.clinicaescola.horario.controller;

import br.com.clinicaescola.horario.dto.HorarioDisponivelResponse;
import br.com.clinicaescola.horario.service.HorarioService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/horarios")
@RequiredArgsConstructor
public class HorarioController {

	private final HorarioService horarioService;

	@GetMapping
	public List<HorarioDisponivelResponse> listarDisponiveis() {
		return horarioService.listarDisponiveis();
	}
}
