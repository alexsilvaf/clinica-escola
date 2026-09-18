package br.com.clinicaescola.agendamento.aplicacao;

import java.time.LocalDateTime;

public record AgendamentoCriado(
        String protocolo,
        String servico,
        String local,
        LocalDateTime inicio,
        LocalDateTime fim) {
}
