package br.com.clinicaescola.agendamento.infraestrutura.persistencia;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoJpaRepository extends JpaRepository<AgendamentoJpaEntity, Long> {

    Optional<AgendamentoJpaEntity> findByChaveRequisicao(String chaveRequisicao);

    long countByHorarioId(Long horarioId);
}
