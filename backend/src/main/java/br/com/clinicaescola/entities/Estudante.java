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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "estudantes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Estudante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@NotBlank
	@Size(max = 120)
	@Column(nullable = false, length = 120)
	private String nome;

	@NotBlank
	@Size(max = 30)
	@Column(nullable = false, unique = true, length = 30)
	private String matricula;

	@NotBlank
	@Email
	@Size(max = 160)
	@Column(nullable = false, length = 160)
	private String email;

	@Size(max = 20)
	@Column(length = 20)
	private String telefone;

	@NotNull
	@Min(1)
	@Max(12)
	@Column(nullable = false)
	private Integer periodo;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "curso_id", nullable = false)
	private Curso curso;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "disciplina_id", nullable = false)
	private Disciplina disciplina;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "semestre_letivo_id", nullable = false)
	private SemestreLetivo semestreLetivo;

	@NotNull
	@Column(nullable = false)
	private Boolean documentacaoAprovada;

	@NotNull
	@Column(nullable = false)
	private Boolean ativo;
}
