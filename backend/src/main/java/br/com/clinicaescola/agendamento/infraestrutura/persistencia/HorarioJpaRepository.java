package br.com.clinicaescola.agendamento.infraestrutura.persistencia;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.persistence.LockModeType;

public interface HorarioJpaRepository extends JpaRepository<HorarioJpaEntity, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select h from HorarioJpaEntity h where h.id = :id")
    Optional<HorarioJpaEntity> buscarPorIdComBloqueio(@Param("id") Long id);

    List<HorarioJpaEntity> findByDisponivelTrueAndInicioAfterOrderByInicioAsc(LocalDateTime instante);
}
