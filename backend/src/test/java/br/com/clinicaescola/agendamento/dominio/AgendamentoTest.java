package br.com.clinicaescola.agendamento.dominio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class AgendamentoTest {

    @Test
    void deveNormalizarDadosAoCriar() {
        Agendamento agendamento = Agendamento.criar(
                1L, "  Maria  ", "  maria@email.com  ", " protocolo ", LocalDateTime.now(), " chave ");

        assertThat(agendamento.getNome()).isEqualTo("Maria");
        assertThat(agendamento.getContato()).isEqualTo("maria@email.com");
        assertThat(agendamento.getChaveRequisicao()).isEqualTo("chave");
    }

    @Test
    void naoDevePermitirDadosObrigatoriosVazios() {
        assertThatThrownBy(() -> Agendamento.criar(
                1L, " ", "contato", "protocolo", LocalDateTime.now(), "chave"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("O nome é obrigatório.");
    }
}
