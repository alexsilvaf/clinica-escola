package br.com.clinicaescola.agendamento.entity;

import br.com.clinicaescola.horario.entity.Horario;
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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
		name = "agendamentos",
		uniqueConstraints = {
				@UniqueConstraint(name = "uk_agendamentos_protocolo", columnNames = "protocolo"),
				@UniqueConstraint(name = "uk_agendamentos_chave_requisicao", columnNames = "chave_requisicao")
		})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "horario_id", nullable = false)
	private Horario horario;

	@NotBlank
	@Size(min = 2, max = 120)
	@Column(name = "nome_ficticio", nullable = false, length = 120)
	private String nomeFicticio;

	@NotBlank
	@Size(min = 3, max = 160)
	@Column(name = "contato_ficticio", nullable = false, length = 160)
	private String contatoFicticio;

	@NotBlank
	@Size(max = 80)
	@Column(nullable = false, length = 80, unique = true)
	private String protocolo;

	@NotNull
	@Column(name = "reservado_em", nullable = false)
	private LocalDateTime reservadoEm;

	@NotBlank
	@Size(max = 120)
	@Column(name = "chave_requisicao", nullable = false, length = 120, unique = true)
	private String chaveRequisicao;
}
