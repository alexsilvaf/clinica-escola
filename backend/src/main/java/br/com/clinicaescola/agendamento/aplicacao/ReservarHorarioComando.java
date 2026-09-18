package br.com.clinicaescola.agendamento.aplicacao;

public record ReservarHorarioComando(
        Long horarioId,
        String nome,
        String contato,
        String chaveRequisicao) {
}
