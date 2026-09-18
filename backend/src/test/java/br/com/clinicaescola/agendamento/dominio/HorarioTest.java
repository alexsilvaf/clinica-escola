package br.com.clinicaescola.agendamento.dominio;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class HorarioTest {

    private static final LocalDateTime AGORA = LocalDateTime.of(2026, 9, 18, 10, 0);

    @Test
    void deveImpedirPeriodoInvalido() {
        assertThatThrownBy(() -> Horario.criar(
                "Atendimento", "Clínica", AGORA.plusHours(2), AGORA.plusHours(1), true, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("O fim deve ser posterior ao início.");
    }

    @Test
    void deveImpedirCapacidadeInvalida() {
        assertThatThrownBy(() -> Horario.criar(
                "Atendimento", "Clínica", AGORA.plusHours(1), AGORA.plusHours(2), true, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("A capacidade deve ser maior que zero.");
    }
}
