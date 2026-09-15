package br.com.clinicaescola.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
	name = "semestres_letivos",
	uniqueConstraints = @UniqueConstraint(name = "uk_semestre_ano_periodo", columnNames = {"ano", "periodo"})
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SemestreLetivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@NotNull
	@Min(2026)
	@Column(nullable = false)
	private Integer ano;

	@NotNull
	@Min(1)
	@Max(2)
	@Column(nullable = false)
	private Integer periodo;

	@NotNull
	@Column(nullable = false)
	private LocalDate dataInicio;

	@NotNull
	@Column(nullable = false)
	private LocalDate dataFim;

	@NotNull
	@Column(nullable = false)
	private Boolean ativo;
}
