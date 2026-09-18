package br.com.clinicaescola.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinicaescola.dto.HorarioResponseDTO;
import br.com.clinicaescola.model.Horario;
import br.com.clinicaescola.repository.AgendamentoRepository;
import br.com.clinicaescola.repository.HorarioRepository;

@RestController
@RequestMapping("/api/v1/horarios")
public class HorarioController {

    private final HorarioRepository horarioRepository;
    private final AgendamentoRepository agendamentoRepository;

    public HorarioController(
            HorarioRepository horarioRepository,
            AgendamentoRepository agendamentoRepository) {
        this.horarioRepository = horarioRepository;
        this.agendamentoRepository = agendamentoRepository;
    }

    @GetMapping
    public ResponseEntity<List<HorarioResponseDTO>> listarHorarios() {

        List<HorarioResponseDTO> horarios = horarioRepository.findAll()
                .stream()
                .filter(horario -> horario.getInicio().isAfter(LocalDateTime.now()))
                .filter(Horario::isDisponivel)
                .map(this::converterParaDTO)
                .toList();

        return ResponseEntity.ok(horarios);
    }

    private HorarioResponseDTO converterParaDTO(Horario horario) {

        int agendamentos = (int) agendamentoRepository.findAll()
                .stream()
                .filter(agendamento ->
                        agendamento.getHorarioId().equals(horario.getId()))
                .count();

        int vagas = horario.getCapacidade() - agendamentos;

        if (vagas < 0) {
            vagas = 0;
        }

        HorarioResponseDTO dto = new HorarioResponseDTO();

        dto.setId(horario.getId());
        dto.setServico(horario.getServico());
        dto.setLocal(horario.getLocal());
        dto.setInicio(horario.getInicio());
        dto.setFim(horario.getFim());
        dto.setVagas(vagas);

        return dto;
    }
}