package br.com.clinicaescola.horario.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HorarioDTO{

	private Long id;
	private String servico;
	private String local;
	private LocalDateTime inicio;
	private LocalDateTime fim;
	private Integer capacidadeRestante;
}
