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
@Table(name = "horario")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class HorarioJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String servico;

    @Column(nullable = false, length = 100)
    private String local;

    @Column(nullable = false)
    private LocalDateTime inicio;

    @Column(nullable = false)
    private LocalDateTime fim;

    @Column(nullable = false)
    private boolean disponivel;

    @Column(nullable = false)
    private int capacidade;
}
