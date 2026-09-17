package br.com.clinicaescola.agendamento.exception;
//erro 409
public class HorarioIndisponivelException extends RuntimeException {

	public HorarioIndisponivelException(String message) {
		super(message);
	}
}
