package br.com.clinicaescola.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.clinicaescola.model.Horario;
import jakarta.persistence.LockModeType;

public interface HorarioRepository extends JpaRepository<Horario, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT h FROM Horario h WHERE h.id = :id")
    Optional<Horario> findByIdComBloqueio(@Param("id") Long id);

}