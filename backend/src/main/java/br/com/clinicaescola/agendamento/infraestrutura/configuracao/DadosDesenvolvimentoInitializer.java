package br.com.clinicaescola.agendamento.infraestrutura.configuracao;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.clinicaescola.agendamento.dominio.Agendamento;
import br.com.clinicaescola.agendamento.dominio.AgendamentoRepository;
import br.com.clinicaescola.agendamento.dominio.Horario;
import br.com.clinicaescola.agendamento.dominio.HorarioRepository;
import lombok.RequiredArgsConstructor;

@Component
@Profile("dev")
@RequiredArgsConstructor
public class DadosDesenvolvimentoInitializer implements CommandLineRunner {

    private static final int[] HORAS_DIAS_UTEIS = {8, 9, 10, 11};
    private static final int[] HORAS_SABADO = {8, 9};
    private static final int DIAS_A_GERAR = 7;
    private static final DateTimeFormatter SUFIXO_DEMONSTRACAO =
            DateTimeFormatter.ofPattern("yyyyMMddHHmm");

    private final HorarioRepository horarioRepository;
    private final AgendamentoRepository agendamentoRepository;
    private final Clock clock;

    @Override
    public void run(String... args) {
        LocalDateTime agora = LocalDateTime.now(clock);
        if (!horarioRepository.buscarDisponiveisDepoisDe(agora).isEmpty()) {
            return;
        }

        LocalDate primeiraData = agora.toLocalDate().plusDays(1);
        for (int dia = 0; dia < DIAS_A_GERAR; dia++) {
            criarAgendaDoDia(primeiraData.plusDays(dia), agora);
        }
    }

    private void criarAgendaDoDia(LocalDate data, LocalDateTime agora) {
        int[] horas = horasPara(data.getDayOfWeek());
        for (int indice = 0; indice < horas.length; indice++) {
            Horario horario = horarioRepository.salvar(criarHorario(data, horas[indice]));
            if (indice == horas.length - 1) {
                criarAgendamentoDemonstracao(horario, agora);
            }
        }
    }

    private int[] horasPara(DayOfWeek diaDaSemana) {
        if (diaDaSemana == DayOfWeek.SUNDAY) {
            return new int[0];
        }
        if (diaDaSemana == DayOfWeek.SATURDAY) {
            return HORAS_SABADO;
        }
        return HORAS_DIAS_UTEIS;
    }

    private Horario criarHorario(LocalDate data, int hora) {
        LocalDateTime inicio = data.atTime(hora, 0);

        return Horario.criar(
                "Atendimento Clínico",
                "Clínica-Escola",
                inicio,
                inicio.plusHours(1),
                true,
                1);
    }

    private void criarAgendamentoDemonstracao(Horario horario, LocalDateTime agora) {
        String sufixo = horario.getInicio().format(SUFIXO_DEMONSTRACAO);
        agendamentoRepository.salvar(Agendamento.criar(
                horario.getId(),
                "Paciente Demonstração",
                "demo@clinica.local",
                "DEMO-" + sufixo,
                agora,
                "seed-" + sufixo));
    }
}
