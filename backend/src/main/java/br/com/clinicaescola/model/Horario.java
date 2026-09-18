package br.com.clinicaescola.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String servico;

    private String local;

    private LocalDateTime inicio;

    private LocalDateTime fim;

    private boolean disponivel;

    private int capacidade;

@Version
private Long versao;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;


}

public String getServico() {
    return servico;
}

public void setServico(String servico) {
    this.servico = servico;
}
public String getLocal() {
    return local;
}

public void setLocal(String local) {
    this.local = local;
}

public LocalDateTime getInicio() {
    return inicio;
}

public void setInicio(LocalDateTime inicio) {
    this.inicio = inicio;
}

public LocalDateTime getFim() {
    return fim;
}

public void setFim(LocalDateTime fim) {
    this.fim = fim;
}

public boolean isDisponivel() {
    return disponivel;
}

public void setDisponivel(boolean disponivel) {
    this.disponivel = disponivel;
}

public int getCapacidade() {
    return capacidade;
}

public void setCapacidade(int capacidade) {
    this.capacidade = capacidade;
}

}