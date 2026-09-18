package br.com.clinicaescola.agendamento.dominio;

import java.time.LocalDateTime;
import java.util.Objects;

import lombok.Getter;

@Getter
public final class Agendamento {

    private static final int TAMANHO_MAXIMO_NOME = 100;
    private static final int TAMANHO_MAXIMO_CONTATO = 50;
    private static final int TAMANHO_MAXIMO_CHAVE = 100;

    private final Long id;
    private final Long horarioId;
    private final String nome;
    private final String contato;
    private final String protocolo;
    private final LocalDateTime instanteReserva;
    private final String chaveRequisicao;

    private Agendamento(
            Long id,
            Long horarioId,
            String nome,
            String contato,
            String protocolo,
            LocalDateTime instanteReserva,
            String chaveRequisicao) {
        this.id = id;
        this.horarioId = Objects.requireNonNull(horarioId, "O horário é obrigatório.");
        this.nome = validarTexto(nome, "O nome é obrigatório.", TAMANHO_MAXIMO_NOME);
        this.contato = validarTexto(contato, "O contato é obrigatório.", TAMANHO_MAXIMO_CONTATO);
        this.protocolo = validarTexto(protocolo, "O protocolo é obrigatório.", TAMANHO_MAXIMO_CHAVE);
        this.instanteReserva = Objects.requireNonNull(instanteReserva, "O instante da reserva é obrigatório.");
        this.chaveRequisicao = validarTexto(
                chaveRequisicao,
                "A chave de requisição é obrigatória.",
                TAMANHO_MAXIMO_CHAVE);
    }

    public static Agendamento criar(
            Long horarioId,
            String nome,
            String contato,
            String protocolo,
            LocalDateTime instanteReserva,
            String chaveRequisicao) {
        return new Agendamento(null, horarioId, nome, contato, protocolo, instanteReserva, chaveRequisicao);
    }

    public static Agendamento reconstituir(
            Long id,
            Long horarioId,
            String nome,
            String contato,
            String protocolo,
            LocalDateTime instanteReserva,
            String chaveRequisicao) {
        return new Agendamento(
                Objects.requireNonNull(id, "O identificador é obrigatório."),
                horarioId,
                nome,
                contato,
                protocolo,
                instanteReserva,
                chaveRequisicao);
    }

    private static String validarTexto(String valor, String mensagem, int tamanhoMaximo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensagem);
        }
        String normalizado = valor.trim();
        if (normalizado.length() > tamanhoMaximo) {
            throw new IllegalArgumentException("O valor deve ter no máximo " + tamanhoMaximo + " caracteres.");
        }
        return normalizado;
    }
}
