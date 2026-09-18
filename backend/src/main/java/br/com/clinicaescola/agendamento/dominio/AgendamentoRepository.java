package br.com.clinicaescola.agendamento.dominio;

import java.util.Optional;

public interface AgendamentoRepository {

    Optional<Agendamento> buscarPorChaveRequisicao(String chaveRequisicao);

    long contarPorHorario(Long horarioId);

    Agendamento salvar(Agendamento agendamento);
}
