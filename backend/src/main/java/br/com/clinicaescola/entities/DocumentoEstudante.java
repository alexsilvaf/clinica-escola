package br.com.clinicaescola.entities;

import br.com.clinicaescola.enums.StatusDocumento;
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
@Table(name = "documentos_estudantes")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DocumentoEstudante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "estudante_id", nullable = false)
	private Estudante estudante;

	@NotBlank
	@Size(max = 100)
	@Column(nullable = false, length = 100)
	private String tipoDocumento;

	@NotBlank
	@Size(max = 180)
	@Column(nullable = false, length = 180)
	private String nomeArquivo;

	@NotBlank
	@Size(max = 500)
	@Column(nullable = false, length = 500)
	private String urlArquivo;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private StatusDocumento status;

	@Size(max = 500)
	@Column(length = 500)
	private String observacaoAnalise;

	@NotNull
	@Column(nullable = false)
	private LocalDateTime enviadoEm;

	private LocalDateTime analisadoEm;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "responsavel_analise_id")
	private Profissional responsavelAnalise;
}
