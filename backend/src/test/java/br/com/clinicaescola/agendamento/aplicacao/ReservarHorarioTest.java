package br.com.clinicaescola.agendamento.aplicacao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.clinicaescola.agendamento.dominio.Agendamento;
import br.com.clinicaescola.agendamento.dominio.AgendamentoRepository;
import br.com.clinicaescola.agendamento.dominio.Horario;
import br.com.clinicaescola.agendamento.dominio.HorarioRepository;
import br.com.clinicaescola.agendamento.dominio.service.PoliticaDeAgendamento;

@ExtendWith(MockitoExtension.class)
class ReservarHorarioTest {

    private static final Clock CLOCK = Clock.fixed(
            Instant.parse("2026-09-18T13:00:00Z"),
            ZoneId.of("America/Sao_Paulo"));

    @Mock
    private AgendamentoRepository agendamentoRepository;

    @Mock
    private HorarioRepository horarioRepository;

    private ReservarHorario reservarHorario;

    @BeforeEach
    void setUp() {
        reservarHorario = new ReservarHorario(
                agendamentoRepository,
                horarioRepository,
                new PoliticaDeAgendamento(),
                CLOCK);
    }

    @Test
    void deveCriarAgendamentoComHorarioBloqueado() {
        Horario horario = horario();
        when(agendamentoRepository.buscarPorChaveRequisicao("requisicao-1"))
                .thenReturn(Optional.empty());
        when(horarioRepository.buscarPorIdComBloqueio(1L)).thenReturn(Optional.of(horario));
        when(agendamentoRepository.contarPorHorario(1L)).thenReturn(0L);
        when(agendamentoRepository.salvar(any(Agendamento.class)))
                .thenAnswer(invocation -> {
                    Agendamento novo = invocation.getArgument(0);
                    return Agendamento.reconstituir(
                            10L,
                            novo.getHorarioId(),
                            novo.getNome(),
                            novo.getContato(),
                            novo.getProtocolo(),
                            novo.getInstanteReserva(),
                            novo.getChaveRequisicao());
                });

        var resultado = reservarHorario.executar(comando());

        assertThat(resultado.protocolo()).isNotBlank();
        assertThat(resultado.servico()).isEqualTo("Atendimento Clínico");
        verify(horarioRepository).buscarPorIdComBloqueio(1L);
        verify(agendamentoRepository).salvar(any(Agendamento.class));
    }

    @Test
    void deveRetornarAgendamentoExistenteParaMesmaChave() {
        Agendamento existente = Agendamento.reconstituir(
                10L,
                1L,
                "Maria",
                "maria@email.com",
                "protocolo-existente",
                LocalDateTime.now(CLOCK),
                "requisicao-1");
        when(agendamentoRepository.buscarPorChaveRequisicao("requisicao-1"))
                .thenReturn(Optional.of(existente));
        when(horarioRepository.buscarPorId(1L)).thenReturn(Optional.of(horario()));

        var resultado = reservarHorario.executar(comando());

        assertThat(resultado.protocolo()).isEqualTo("protocolo-existente");
        verify(horarioRepository, never()).buscarPorIdComBloqueio(any());
        verify(agendamentoRepository, never()).salvar(any());
    }

    private ReservarHorarioComando comando() {
        return new ReservarHorarioComando(1L, "Maria", "maria@email.com", "requisicao-1");
    }

    private Horario horario() {
        return Horario.reconstituir(
                1L,
                "Atendimento Clínico",
                "Clínica-Escola",
                LocalDateTime.now(CLOCK).plusDays(1),
                LocalDateTime.now(CLOCK).plusDays(1).plusHours(1),
                true,
                1);
    }
}
