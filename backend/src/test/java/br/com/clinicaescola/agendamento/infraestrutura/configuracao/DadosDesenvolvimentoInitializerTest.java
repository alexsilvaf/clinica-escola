package br.com.clinicaescola.agendamento.infraestrutura.configuracao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.clinicaescola.agendamento.dominio.Agendamento;
import br.com.clinicaescola.agendamento.dominio.AgendamentoRepository;
import br.com.clinicaescola.agendamento.dominio.Horario;
import br.com.clinicaescola.agendamento.dominio.HorarioRepository;

@ExtendWith(MockitoExtension.class)
class DadosDesenvolvimentoInitializerTest {

    private static final Clock CLOCK = Clock.fixed(
            Instant.parse("2026-09-18T13:00:00Z"),
            ZoneId.of("America/Sao_Paulo"));

    @Mock
    private HorarioRepository horarioRepository;

    @Mock
    private AgendamentoRepository agendamentoRepository;

    private DadosDesenvolvimentoInitializer initializer;

    @BeforeEach
    void setUp() {
        initializer = new DadosDesenvolvimentoInitializer(
                horarioRepository,
                agendamentoRepository,
                CLOCK);
    }

    @Test
    void deveCriarQuatroHorariosEmDiasUteisDoisNoSabadoENenhumNoDomingo() throws Exception {
        AtomicLong proximoId = new AtomicLong(1);
        when(horarioRepository.buscarDisponiveisDepoisDe(any())).thenReturn(List.of());
        when(horarioRepository.salvar(any(Horario.class)))
                .thenAnswer(invocation -> {
                    Horario horario = invocation.getArgument(0);
                    return Horario.reconstituir(
                            proximoId.getAndIncrement(),
                            horario.getServico(),
                            horario.getLocal(),
                            horario.getInicio(),
                            horario.getFim(),
                            horario.isDisponivel(),
                            horario.getCapacidade());
                });

        initializer.run();

        ArgumentCaptor<Horario> horarios = ArgumentCaptor.forClass(Horario.class);
        verify(horarioRepository, times(22)).salvar(horarios.capture());
        assertThat(horarios.getAllValues())
                .noneMatch(horario -> horario.getInicio().getDayOfWeek() == DayOfWeek.SUNDAY);
        assertThat(horarios.getAllValues())
                .filteredOn(horario -> horario.getInicio().getDayOfWeek() == DayOfWeek.SATURDAY)
                .hasSize(2);
        assertThat(horarios.getAllValues())
                .filteredOn(horario -> horario.getInicio().getDayOfWeek() != DayOfWeek.SATURDAY)
                .hasSize(20);

        ArgumentCaptor<Agendamento> agendamentos = ArgumentCaptor.forClass(Agendamento.class);
        verify(agendamentoRepository, times(6)).salvar(agendamentos.capture());
        assertThat(agendamentos.getAllValues())
                .allMatch(agendamento -> agendamento.getHorarioId() != null);
    }
}
