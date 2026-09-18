package br.com.clinicaescola.agendamento.infraestrutura.persistencia;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.clinicaescola.agendamento.dominio.Horario;
import br.com.clinicaescola.agendamento.dominio.HorarioRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class HorarioRepositoryImpl implements HorarioRepository {

    private final HorarioJpaRepository repository;

    @Override
    public Optional<Horario> buscarPorId(Long id) {
        return repository.findById(id).map(this::paraDominio);
    }

    @Override
    public Optional<Horario> buscarPorIdComBloqueio(Long id) {
        return repository.buscarPorIdComBloqueio(id).map(this::paraDominio);
    }

    @Override
    public List<Horario> buscarDisponiveisDepoisDe(LocalDateTime instante) {
        return repository.findByDisponivelTrueAndInicioAfterOrderByInicioAsc(instante)
                .stream()
                .map(this::paraDominio)
                .toList();
    }

    @Override
    public Horario salvar(Horario horario) {
        HorarioJpaEntity entity = new HorarioJpaEntity(
                horario.getId(),
                horario.getServico(),
                horario.getLocal(),
                horario.getInicio(),
                horario.getFim(),
                horario.isDisponivel(),
                horario.getCapacidade());
        return paraDominio(repository.save(entity));
    }

    private Horario paraDominio(HorarioJpaEntity entity) {
        return Horario.reconstituir(
                entity.getId(),
                entity.getServico(),
                entity.getLocal(),
                entity.getInicio(),
                entity.getFim(),
                entity.isDisponivel(),
                entity.getCapacidade());
    }
}
