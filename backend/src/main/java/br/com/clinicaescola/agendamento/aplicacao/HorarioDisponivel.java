package br.com.clinicaescola.agendamento.aplicacao;

import java.time.LocalDateTime;

public record HorarioDisponivel(
        Long id,
        String servico,
        String local,
        LocalDateTime inicio,
        LocalDateTime fim,
        int vagas) {
}
