package br.com.clinicaescola.agendamento.infraestrutura.persistencia;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "agendamento")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AgendamentoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long horarioId;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 50)
    private String contato;

    @Column(nullable = false, unique = true, length = 100)
    private String protocolo;

    @Column(nullable = false)
    private LocalDateTime instanteReserva;

    @Column(nullable = false, unique = true, length = 100)
    private String chaveRequisicao;
}
