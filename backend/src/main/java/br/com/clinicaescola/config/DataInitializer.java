package br.com.clinicaescola.config;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.clinicaescola.model.Horario;
import br.com.clinicaescola.repository.HorarioRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner carregarDados(HorarioRepository horarioRepository) {
        return args -> {

            Horario horario1 = new Horario();
            horario1.setServico("Atendimento Clínico");
            horario1.setLocal("Clínica-Escola");
            horario1.setInicio(LocalDateTime.now()
                    .plusDays(1)
                    .withHour(9)
                    .withMinute(0)
                    .withSecond(0)
                    .withNano(0));
            horario1.setFim(LocalDateTime.now()
                    .plusDays(1)
                    .withHour(10)
                    .withMinute(0)
                    .withSecond(0)
                    .withNano(0));
            horario1.setDisponivel(true);
            horario1.setCapacidade(1);

            Horario horario2 = new Horario();
            horario2.setServico("Atendimento Clínico");
            horario2.setLocal("Clínica-Escola");
            horario2.setInicio(LocalDateTime.now()
                    .plusDays(2)
                    .withHour(14)
                    .withMinute(0)
                    .withSecond(0)
                    .withNano(0));
            horario2.setFim(LocalDateTime.now()
                    .plusDays(2)
                    .withHour(15)
                    .withMinute(0)
                    .withSecond(0)
                    .withNano(0));
            horario2.setDisponivel(true);
            horario2.setCapacidade(1);

            Horario horario3 = new Horario();
            horario3.setServico("Atendimento Clínico");
            horario3.setLocal("Clínica-Escola");
            horario3.setInicio(LocalDateTime.now()
                    .plusDays(3)
                    .withHour(10)
                    .withMinute(0)
                    .withSecond(0)
                    .withNano(0));
            horario3.setFim(LocalDateTime.now()
                    .plusDays(3)
                    .withHour(11)
                    .withMinute(0)
                    .withSecond(0)
                    .withNano(0));
            horario3.setDisponivel(false);
            horario3.setCapacidade(1);

            horarioRepository.save(horario1);
            horarioRepository.save(horario2);
            horarioRepository.save(horario3);
        };
    }
}