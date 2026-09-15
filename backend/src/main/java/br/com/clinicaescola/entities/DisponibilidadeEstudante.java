package br.com.clinicaescola.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
	name = "disponibilidades_estudantes",
	uniqueConstraints = @UniqueConstraint(
		name = "uk_disponibilidade_estudante_horario",
		columnNames = {"estudante_id", "semestre_letivo_id", "dia_semana", "horario_inicio", "horario_fim"}
	)
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DisponibilidadeEstudante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "estudante_id", nullable = false)
	private Estudante estudante;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "semestre_letivo_id", nullable = false)
	private SemestreLetivo semestreLetivo;

	@NotNull
	@Column(name = "dia_semana", nullable = false)
	private DayOfWeek diaSemana;

	@NotNull
	@Column(name = "horario_inicio", nullable = false)
	private LocalTime horarioInicio;

	@NotNull
	@Column(name = "horario_fim", nullable = false)
	private LocalTime horarioFim;
}
