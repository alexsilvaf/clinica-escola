package br.com.clinicaescola.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long horarioId;

    private String nome;

    public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

    private String contato;

    public String getContato() {
    return contato;
}

public void setContato(String contato) {
    this.contato = contato;
}

    private String protocolo;

    public String getProtocolo() {
    return protocolo;
}

public void setProtocolo(String protocolo) {
    this.protocolo = protocolo;
}

    private LocalDateTime instanteReserva;

public LocalDateTime getInstanteReserva() {
    return instanteReserva;
}

public void setInstanteReserva(LocalDateTime instanteReserva) {
    this.instanteReserva = instanteReserva;
}

@Column(unique = true)
private String chaveRequisicao;

public String getChaveRequisicao() {
    return chaveRequisicao;
}

public void setChaveRequisicao(String chaveRequisicao) {
    this.chaveRequisicao = chaveRequisicao;
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public Long getHorarioId() {
    return horarioId;
}

public void setHorarioId(Long horarioId) {
    this.horarioId = horarioId;
}

}
