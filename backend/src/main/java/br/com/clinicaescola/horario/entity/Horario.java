package br.com.clinicaescola.horario.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
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
@Table(name = "horarios")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@NotBlank
	@Size(min = 2, max = 120)
	@Column(nullable = false, length = 120)
	private String servico;

	@NotBlank
	@Size(min = 2, max = 120)
	@Column(nullable = false, length = 120)
	private String local;

	@NotNull
	@Column(nullable = false)
	private LocalDateTime inicio;

	@NotNull
	@Column(nullable = false)
	private LocalDateTime fim;

	@NotNull
	@Column(name = "disponivel_configurado", nullable = false)
	private Boolean disponivelConfigurado;

	@NotNull
	@Min(1)
	@Column(nullable = false)
	private Integer capacidade;

	@NotNull
	@Min(0)
	@Column(name = "reservas_realizadas", nullable = false)
	private Integer reservasRealizadas;

	@Version
	private Long versao;

	public boolean estaDisponivelParaReserva(LocalDateTime referencia) {
		return Boolean.TRUE.equals(disponivelConfigurado)
				&& inicio.isAfter(referencia)
				&& getCapacidadeRestante() > 0;
	}

	public int getCapacidadeRestante() {
		return capacidade - reservasRealizadas;
	}

	public void consumirVaga() {
		reservasRealizadas++;
	}

	@AssertTrue(message = "o horário final deve ser posterior ao horário inicial")
	public boolean isIntervaloValido() {
		return inicio == null || fim == null || fim.isAfter(inicio);
	}

	@AssertTrue(message = "as reservas realizadas não podem exceder a capacidade")
	public boolean isCapacidadeValida() {
		return capacidade == null || reservasRealizadas == null || reservasRealizadas <= capacidade;
	}
}
