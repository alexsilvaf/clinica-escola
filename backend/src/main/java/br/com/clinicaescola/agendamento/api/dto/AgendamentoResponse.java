package br.com.clinicaescola.agendamento.api.dto;

import java.time.LocalDateTime;

public record AgendamentoResponse(
        String protocolo,
        String servico,
        String local,
        LocalDateTime inicio,
        LocalDateTime fim) {
}
