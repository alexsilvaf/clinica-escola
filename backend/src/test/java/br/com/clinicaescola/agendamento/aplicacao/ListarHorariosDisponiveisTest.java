package br.com.clinicaescola.agendamento.aplicacao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.clinicaescola.agendamento.dominio.AgendamentoRepository;
import br.com.clinicaescola.agendamento.dominio.Horario;
import br.com.clinicaescola.agendamento.dominio.HorarioRepository;
import br.com.clinicaescola.agendamento.dominio.service.PoliticaDeAgendamento;

@ExtendWith(MockitoExtension.class)
class ListarHorariosDisponiveisTest {

    private static final Clock CLOCK = Clock.fixed(
            Instant.parse("2026-09-18T13:00:00Z"),
            ZoneId.of("America/Sao_Paulo"));

    @Mock
    private HorarioRepository horarioRepository;

    @Mock
    private AgendamentoRepository agendamentoRepository;

    private ListarHorariosDisponiveis listarHorarios;

    @BeforeEach
    void setUp() {
        listarHorarios = new ListarHorariosDisponiveis(
                horarioRepository,
                agendamentoRepository,
                new PoliticaDeAgendamento(),
                CLOCK);
    }

    @Test
    void deveListarHorariosComVagaEHorariosCheios() {
        LocalDateTime agora = LocalDateTime.now(CLOCK);
        Horario comVaga = Horario.reconstituir(
                1L, "Atendimento", "Clínica", agora.plusHours(1), agora.plusHours(2), true, 2);
        Horario lotado = Horario.reconstituir(
                2L, "Atendimento", "Clínica", agora.plusHours(3), agora.plusHours(4), true, 1);

        when(horarioRepository.buscarDisponiveisDepoisDe(agora)).thenReturn(List.of(comVaga, lotado));
        when(agendamentoRepository.contarPorHorario(1L)).thenReturn(1L);
        when(agendamentoRepository.contarPorHorario(2L)).thenReturn(1L);

        var resultado = listarHorarios.executar();

        assertThat(resultado)
                .extracting(HorarioDisponivel::vagas)
                .containsExactly(1, 0);
    }
}
