package br.com.clinicaescola.agendamento.api.dto;

import java.time.LocalDateTime;

public record HorarioResponse(
        Long id,
        String servico,
        String local,
        LocalDateTime inicio,
        LocalDateTime fim,
        int vagas) {
}
