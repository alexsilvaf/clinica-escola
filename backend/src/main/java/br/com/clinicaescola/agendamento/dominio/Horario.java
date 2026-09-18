package br.com.clinicaescola.agendamento.dominio;

import java.time.LocalDateTime;
import java.util.Objects;

import lombok.Getter;

@Getter
public final class Horario {

    private final Long id;
    private final String servico;
    private final String local;
    private final LocalDateTime inicio;
    private final LocalDateTime fim;
    private final boolean disponivel;
    private final int capacidade;

    private Horario(
            Long id,
            String servico,
            String local,
            LocalDateTime inicio,
            LocalDateTime fim,
            boolean disponivel,
            int capacidade) {
        this.id = id;
        this.servico = textoObrigatorio(servico, "O serviço é obrigatório.");
        this.local = textoObrigatorio(local, "O local é obrigatório.");
        this.inicio = Objects.requireNonNull(inicio, "O início é obrigatório.");
        this.fim = Objects.requireNonNull(fim, "O fim é obrigatório.");
        this.disponivel = disponivel;
        this.capacidade = capacidade;

        if (!fim.isAfter(inicio)) {
            throw new IllegalArgumentException("O fim deve ser posterior ao início.");
        }
        if (capacidade < 1) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero.");
        }
    }

    public static Horario criar(
            String servico,
            String local,
            LocalDateTime inicio,
            LocalDateTime fim,
            boolean disponivel,
            int capacidade) {
        return new Horario(null, servico, local, inicio, fim, disponivel, capacidade);
    }

    public static Horario reconstituir(
            Long id,
            String servico,
            String local,
            LocalDateTime inicio,
            LocalDateTime fim,
            boolean disponivel,
            int capacidade) {
        return new Horario(
                Objects.requireNonNull(id, "O identificador é obrigatório."),
                servico,
                local,
                inicio,
                fim,
                disponivel,
                capacidade);
    }

    private static String textoObrigatorio(String valor, String mensagem) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensagem);
        }
        return valor.trim();
    }
}
