package br.com.clinicaescola.agendamento.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoResponse {

	private String protocolo;
	private String servico;
	private String local;
	private LocalDateTime inicio;
	private LocalDateTime fim;
	private LocalDateTime criadoEm;
}
