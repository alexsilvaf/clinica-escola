package br.com.clinicaescola.agendamento.dominio.exception;

public class HorarioIndisponivelException extends RuntimeException {

    public HorarioIndisponivelException(String mensagem) {
        super(mensagem);
    }
}
