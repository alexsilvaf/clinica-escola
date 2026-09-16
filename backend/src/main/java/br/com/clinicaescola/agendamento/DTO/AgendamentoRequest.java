package br.com.clinicaescola.agendamento.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoRequest {

	@NotNull
	private Long horarioId;

	@NotBlank
	@Size(min = 2, max = 120)
	private String nome;

	@NotBlank
	@Size(min = 3, max = 120)
	private String contato;

	@NotBlank
	@Size(min = 8, max = 100)
	private String chaveRequisicao;
}
