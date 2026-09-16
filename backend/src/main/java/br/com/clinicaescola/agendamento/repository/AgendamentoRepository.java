package br.com.clinicaescola.agendamento.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clinicaescola.agendamento.entity.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

	Optional<Agendamento> findByChaveRequisicao(String chaveRequisicao);
}
