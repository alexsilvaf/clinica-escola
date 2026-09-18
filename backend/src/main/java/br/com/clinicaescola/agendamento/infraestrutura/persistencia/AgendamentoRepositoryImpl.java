package br.com.clinicaescola.agendamento.infraestrutura.persistencia;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.clinicaescola.agendamento.dominio.Agendamento;
import br.com.clinicaescola.agendamento.dominio.AgendamentoRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AgendamentoRepositoryImpl implements AgendamentoRepository {

    private final AgendamentoJpaRepository repository;

    @Override
    public Optional<Agendamento> buscarPorChaveRequisicao(String chaveRequisicao) {
        return repository.findByChaveRequisicao(chaveRequisicao).map(this::paraDominio);
    }

    @Override
    public long contarPorHorario(Long horarioId) {
        return repository.countByHorarioId(horarioId);
    }

    @Override
    public Agendamento salvar(Agendamento agendamento) {
        AgendamentoJpaEntity entity = new AgendamentoJpaEntity(
                agendamento.getId(),
                agendamento.getHorarioId(),
                agendamento.getNome(),
                agendamento.getContato(),
                agendamento.getProtocolo(),
                agendamento.getInstanteReserva(),
                agendamento.getChaveRequisicao());
        return paraDominio(repository.save(entity));
    }

    private Agendamento paraDominio(AgendamentoJpaEntity entity) {
        return Agendamento.reconstituir(
                entity.getId(),
                entity.getHorarioId(),
                entity.getNome(),
                entity.getContato(),
                entity.getProtocolo(),
                entity.getInstanteReserva(),
                entity.getChaveRequisicao());
    }
}
