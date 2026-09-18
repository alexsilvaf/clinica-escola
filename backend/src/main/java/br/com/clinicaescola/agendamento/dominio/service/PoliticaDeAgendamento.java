package br.com.clinicaescola.agendamento.dominio.service;

import java.time.LocalDateTime;
import java.util.Objects;

import br.com.clinicaescola.agendamento.dominio.Horario;
import br.com.clinicaescola.agendamento.dominio.exception.HorarioIndisponivelException;

public class PoliticaDeAgendamento {

    public void validarReserva(
            Horario horario,
            LocalDateTime agora,
            long quantidadeAgendamentos) {
        Objects.requireNonNull(horario, "O horário é obrigatório.");
        Objects.requireNonNull(agora, "A data de referência é obrigatória.");
        validarQuantidade(quantidadeAgendamentos);

        if (!horario.getInicio().isAfter(agora)) {
            throw new HorarioIndisponivelException(
                    "Não é possível agendar um horário que já passou.");
        }
        if (!horario.isDisponivel()) {
            throw new HorarioIndisponivelException("Este horário está indisponível.");
        }
        if (quantidadeAgendamentos >= horario.getCapacidade()) {
            throw new HorarioIndisponivelException("Este horário está lotado.");
        }
    }

    public int calcularVagas(Horario horario, long quantidadeAgendamentos) {
        Objects.requireNonNull(horario, "O horário é obrigatório.");
        validarQuantidade(quantidadeAgendamentos);
        return (int) Math.max(0, horario.getCapacidade() - quantidadeAgendamentos);
    }

    private void validarQuantidade(long quantidadeAgendamentos) {
        if (quantidadeAgendamentos < 0) {
            throw new IllegalArgumentException("A quantidade de agendamentos não pode ser negativa.");
        }
    }
}
