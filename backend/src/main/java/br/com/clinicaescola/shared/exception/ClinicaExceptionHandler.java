package br.com.clinicaescola.shared.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.clinicaescola.agendamento.exception.HorarioIndisponivelException;
import br.com.clinicaescola.agendamento.exception.HorarioNaoEncontradoException;

@RestControllerAdvice
public class ClinicaExceptionHandler  {

    @ExceptionHandler(HorarioNaoEncontradoException.class)
    public ResponseEntity<String> tratarNaoEncontrado(final HorarioNaoEncontradoException e) {
		return ResponseEntity.status(404).body("Horário não encontrado");
    }

    @ExceptionHandler(HorarioIndisponivelException.class)
    public ResponseEntity<String> tratarIndisponivel(final HorarioIndisponivelException e) {
		return ResponseEntity.status(409).body("Horário indisponível");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<...> tratarValidacao(final MethodArgumentNotValidException e) {
        // monta resposta com status 400, detalhando campos
    }
}
