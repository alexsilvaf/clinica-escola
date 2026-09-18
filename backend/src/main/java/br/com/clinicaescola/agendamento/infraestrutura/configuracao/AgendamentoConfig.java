package br.com.clinicaescola.agendamento.infraestrutura.configuracao;

import java.time.Clock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.clinicaescola.agendamento.dominio.service.PoliticaDeAgendamento;

@Configuration
public class AgendamentoConfig {

    @Bean
    Clock relogio() {
        return Clock.systemDefaultZone();
    }

    @Bean
    PoliticaDeAgendamento politicaDeAgendamento() {
        return new PoliticaDeAgendamento();
    }
}
