package br.com.clinicaescola.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinicaescola.dto.AgendamentoRequestDTO;
import br.com.clinicaescola.dto.AgendamentoResponseDTO;
import br.com.clinicaescola.model.Agendamento;
import br.com.clinicaescola.model.Horario;
import br.com.clinicaescola.service.AgendamentoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgendamentoResponseDTO criar(
            @Valid @RequestBody AgendamentoRequestDTO request) {

        Agendamento agendamento = agendamentoService.criarAgendamento(
                request.getHorarioId(),
                request.getNome(),
                request.getContato(),
                request.getChaveRequisicao());

        Horario horario = agendamentoService.buscarHorario(
                agendamento.getHorarioId());

        AgendamentoResponseDTO response = new AgendamentoResponseDTO();

        response.setProtocolo(agendamento.getProtocolo());
        response.setServico(horario.getServico());
        response.setLocal(horario.getLocal());
        response.setInicio(horario.getInicio());
        response.setFim(horario.getFim());

        return response;
    }
}