package br.com.clinicaescola.agendamento.dominio.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import br.com.clinicaescola.agendamento.dominio.Horario;
import br.com.clinicaescola.agendamento.dominio.exception.HorarioIndisponivelException;

class PoliticaDeAgendamentoTest {

    private static final LocalDateTime AGORA = LocalDateTime.of(2026, 9, 18, 10, 0);
    private final PoliticaDeAgendamento politica = new PoliticaDeAgendamento();

    @Test
    void deveAceitarReservaQuandoHorarioTemVaga() {
        Horario horario = horario(true, 2);

        assertThatCode(() -> politica.validarReserva(horario, AGORA, 1))
                .doesNotThrowAnyException();
        assertThat(politica.calcularVagas(horario, 1)).isEqualTo(1);
    }

    @Test
    void naoDeveAceitarReservaDeHorarioPassado() {
        Horario horario = Horario.reconstituir(
                1L, "Atendimento", "Clínica", AGORA.minusHours(2), AGORA.minusHours(1), true, 1);

        assertThatThrownBy(() -> politica.validarReserva(horario, AGORA, 0))
                .isInstanceOf(HorarioIndisponivelException.class)
                .hasMessage("Não é possível agendar um horário que já passou.");
    }

    @Test
    void naoDeveAceitarReservaDeHorarioIndisponivelOuLotado() {
        assertThatThrownBy(() -> politica.validarReserva(horario(false, 1), AGORA, 0))
                .isInstanceOf(HorarioIndisponivelException.class)
                .hasMessage("Este horário está indisponível.");

        assertThatThrownBy(() -> politica.validarReserva(horario(true, 1), AGORA, 1))
                .isInstanceOf(HorarioIndisponivelException.class)
                .hasMessage("Este horário está lotado.");
    }

    private Horario horario(boolean disponivel, int capacidade) {
        return Horario.reconstituir(
                1L, "Atendimento", "Clínica", AGORA.plusHours(1), AGORA.plusHours(2), disponivel, capacidade);
    }
}
