package br.com.clinicaescola.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clinicaescola.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    Optional<Agendamento> findByChaveRequisicao(String chaveRequisicao);

    long countByHorarioId(Long horarioId);

}