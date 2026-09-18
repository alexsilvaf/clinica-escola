package br.com.clinicaescola.agendamento.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinicaescola.agendamento.api.dto.AgendamentoResponse;
import br.com.clinicaescola.agendamento.api.dto.ReservarHorarioRequest;
import br.com.clinicaescola.agendamento.aplicacao.AgendamentoCriado;
import br.com.clinicaescola.agendamento.aplicacao.ReservarHorario;
import br.com.clinicaescola.agendamento.aplicacao.ReservarHorarioComando;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final ReservarHorario reservarHorario;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgendamentoResponse reservar(@Valid @RequestBody ReservarHorarioRequest request) {
        AgendamentoCriado resultado = reservarHorario.executar(new ReservarHorarioComando(
                request.horarioId(),
                request.nome(),
                request.contato(),
                request.chaveRequisicao()));

        return new AgendamentoResponse(
                resultado.protocolo(),
                resultado.servico(),
                resultado.local(),
                resultado.inicio(),
                resultado.fim());
    }
}
