package br.com.clinicaescola.agendamento.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ReservarHorarioRequest(
        @NotNull(message = "O horário é obrigatório.")
        Long horarioId,

        @NotBlank(message = "O nome é obrigatório.")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
        String nome,

        @NotBlank(message = "O contato é obrigatório.")
        @Size(max = 50, message = "O contato deve ter no máximo 50 caracteres.")
        String contato,

        @NotBlank(message = "A chave de requisição é obrigatória.")
        @Size(max = 100, message = "A chave de requisição deve ter no máximo 100 caracteres.")
        String chaveRequisicao) {
}
