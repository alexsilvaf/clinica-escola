package br.com.clinicaescola.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflitoReservaException extends RuntimeException {

	public ConflitoReservaException(String mensagem) {
		super(mensagem);
	}

	public ConflitoReservaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
