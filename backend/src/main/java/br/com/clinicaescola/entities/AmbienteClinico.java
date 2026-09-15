package br.com.clinicaescola.entities;

import br.com.clinicaescola.enums.TipoAmbiente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(
	name = "ambientes_clinicos",
	uniqueConstraints = @UniqueConstraint(name = "uk_ambiente_clinica_nome", columnNames = {"clinica_id", "nome"})
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AmbienteClinico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@NotBlank
	@Size(max = 100)
	@Column(nullable = false, length = 100)
	private String nome;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private TipoAmbiente tipo;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "clinica_id", nullable = false)
	private Clinica clinica;

	@NotNull
	@Min(0)
	@Column(nullable = false)
	private Integer quantidadeEquipamentos;

	@NotNull
	@Min(1)
	@Column(nullable = false)
	private Integer capacidadeMaximaAtendimentos;

	@NotNull
	@Min(1)
	@Column(nullable = false)
	private Integer capacidadeMaximaEstudantes;

	@NotNull
	@Column(nullable = false)
	private Boolean ativo;
}
