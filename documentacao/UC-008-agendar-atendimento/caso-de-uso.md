# Especificação do UC-008

## Gatilho

A pessoa seleciona um serviço e horário disponível e decide prosseguir.

## Pré-condições

- configuração semestral ativa;
- serviço e horário publicados;
- combinação elegível de estudante, supervisor e recursos;
- aviso de privacidade aplicável apresentado.

## Fluxo principal — Agendar

1. O sistema apresenta serviço e horários realmente disponíveis.
2. A pessoa seleciona uma opção.
3. O sistema solicita somente os dados mínimos obrigatórios.
4. A pessoa informa, revisa e confirma os dados.
5. O sistema valida entradas e inicia a transação de reserva.
6. O sistema revalida semestre, estudante, supervisor e capacidade física.
7. O sistema cria exatamente um agendamento e consome capacidades.
8. O sistema fornece identificador não previsível e próxima ação.

## Subfluxo — Confirmar

1. A pessoa acessa o próprio agendamento por mecanismo válido.
2. O sistema verifica status e prazo.
3. A pessoa confirma.
4. O sistema altera o status uma única vez e informa o resultado.

## Subfluxo — Cancelar

1. A pessoa acessa o próprio agendamento por mecanismo válido.
2. O sistema verifica status e prazo.
3. A pessoa cancela.
4. O sistema altera o status, libera capacidade conforme política e informa o resultado.

## Alternativas e exceções

- **A1 — Dados inválidos:** identificar campos e permitir correção.
- **A2 — Última vaga perdida:** reverter tudo e oferecer nova escolha.
- **A3 — Reenvio/duplo clique:** aplicar idempotência, sem duplicar.
- **A4 — Acesso indevido:** negar sem revelar a existência de outro agendamento.
- **A5 — Falha técnica:** não deixar reserva ou capacidade parcial.

## Pós-condições de sucesso

- existe exatamente um agendamento;
- capacidades refletem o estado da reserva;
- a pessoa recebeu identificador e orientação;
- nenhuma restrição vigente foi violada.

