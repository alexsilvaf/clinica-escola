package br.com.clinicaescola.agendamento.infraestrutura.configuracao;

import java.time.Clock;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.clinicaescola.agendamento.dominio.Horario;
import br.com.clinicaescola.agendamento.dominio.HorarioRepository;
import lombok.RequiredArgsConstructor;

@Component
@Profile("dev")
@RequiredArgsConstructor
public class DadosDesenvolvimentoInitializer implements CommandLineRunner {

    private final HorarioRepository horarioRepository;
    private final Clock clock;

    @Override
    public void run(String... args) {
        LocalDateTime agora = LocalDateTime.now(clock);

        horarioRepository.salvar(criarHorario(agora, 1, 9, true));
        horarioRepository.salvar(criarHorario(agora, 2, 14, true));
        horarioRepository.salvar(criarHorario(agora, 3, 10, false));
    }

    private Horario criarHorario(
            LocalDateTime agora,
            int diasAdiante,
            int hora,
            boolean disponivel) {
        LocalDateTime inicio = agora.plusDays(diasAdiante)
                .withHour(hora)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);

        return Horario.criar(
                "Atendimento Clínico",
                "Clínica-Escola",
                inicio,
                inicio.plusHours(1),
                disponivel,
                1);
    }
}
