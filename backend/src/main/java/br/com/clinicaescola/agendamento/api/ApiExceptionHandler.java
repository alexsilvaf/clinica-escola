package br.com.clinicaescola.agendamento.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.clinicaescola.agendamento.dominio.exception.HorarioIndisponivelException;
import br.com.clinicaescola.agendamento.dominio.exception.HorarioNaoEncontradoException;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HorarioNaoEncontradoException.class)
    public ResponseEntity<String> tratarNaoEncontrado(HorarioNaoEncontradoException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(HorarioIndisponivelException.class)
    public ResponseEntity<String> tratarHorarioIndisponivel(HorarioIndisponivelException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> tratarEntradaInvalida(IllegalArgumentException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
        Map<String, String> erros = new LinkedHashMap<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(erro -> erros.putIfAbsent(erro.getField(), erro.getDefaultMessage()));
        return ResponseEntity.badRequest().body(erros);
    }
}
