package br.com.clinicaescola.agendamento.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinicaescola.agendamento.DTO.AgendamentoRequest;
import br.com.clinicaescola.agendamento.DTO.AgendamentoResponse;
import br.com.clinicaescola.agendamento.service.AgendamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

	private final AgendamentoService agendamentoService;

	@PostMapping
	public ResponseEntity<AgendamentoResponse> reservar(
			@Valid @RequestBody AgendamentoRequest request) {
		AgendamentoResponse response = agendamentoService.reservar(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
