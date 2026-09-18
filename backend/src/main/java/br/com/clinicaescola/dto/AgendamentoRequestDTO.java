package br.com.clinicaescola.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AgendamentoRequestDTO {

    @NotNull(message = "O horário é obrigatório.")
    private Long horarioId;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    private String nome;

    @NotBlank(message = "O contato é obrigatório.")
    @Size(max = 50, message = "O contato deve ter no máximo 50 caracteres.")
    private String contato;

    @NotBlank(message = "A chave de requisição é obrigatória.")
    @Size(max = 100, message = "A chave de requisição deve ter no máximo 100 caracteres.")
    private String chaveRequisicao;

    public Long getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(Long horarioId) {
        this.horarioId = horarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getChaveRequisicao() {
        return chaveRequisicao;
    }

    public void setChaveRequisicao(String chaveRequisicao) {
        this.chaveRequisicao = chaveRequisicao;
    }
}