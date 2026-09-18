package br.com.clinicaescola.agendamento.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinicaescola.agendamento.api.dto.HorarioResponse;
import br.com.clinicaescola.agendamento.aplicacao.ListarHorariosDisponiveis;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/horarios")
@RequiredArgsConstructor
public class HorarioController {

    private final ListarHorariosDisponiveis listarHorariosDisponiveis;

    @GetMapping
    public List<HorarioResponse> listar() {
        return listarHorariosDisponiveis.executar()
                .stream()
                .map(horario -> new HorarioResponse(
                        horario.id(),
                        horario.servico(),
                        horario.local(),
                        horario.inicio(),
                        horario.fim(),
                        horario.vagas()))
                .toList();
    }
}
