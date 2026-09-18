package br.com.clinicaescola.agendamento.dominio.exception;

public class HorarioNaoEncontradoException extends RuntimeException {

    public HorarioNaoEncontradoException() {
        super("Horário não encontrado.");
    }
}
