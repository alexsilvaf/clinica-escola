package br.com.clinicaescola.horario.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clinicaescola.horario.entity.Horario;

public interface HorarioRepository extends JpaRepository<Horario, Long> {

	List<Horario> findByDisponivelConfiguradoTrueAndInicioAfterOrderByInicioAsc(LocalDateTime referencia);
}
