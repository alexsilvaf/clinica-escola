package br.com.clinicaescola.agendamento.exception;
//error 404
public class HorarioNaoEncontradoException extends RuntimeException {

	public HorarioNaoEncontradoException(String message) {
		super(message);
	}
}
