package br.com.clinicaescola.agendamento.dominio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface HorarioRepository {

    Optional<Horario> buscarPorId(Long id);

    Optional<Horario> buscarPorIdComBloqueio(Long id);

    List<Horario> buscarDisponiveisDepoisDe(LocalDateTime instante);

    Horario salvar(Horario horario);
}
