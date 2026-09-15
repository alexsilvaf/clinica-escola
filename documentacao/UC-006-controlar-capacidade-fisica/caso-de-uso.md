# Especificação do UC-006

[Início](../../README.md) · [Documentação](../README.md) · [UC-006](README.md) · Caso de uso

## Gatilho

Um responsável configura recursos/capacidades ou uma operação tenta consumi-los.

## Pré-condições

- clínica, ambiente e semestre cadastrados;
- usuário autorizado para configuração;
- serviço com necessidades de recursos definidas.

## Fluxo principal

1. O ator seleciona clínica, ambiente e contexto.
2. Informa quantidade de consultórios/salas e equipamentos.
3. Define limites simultâneos de atendimentos e estudantes.
4. O sistema valida valores e referências.
5. O ator confirma a configuração.
6. O sistema calcula a capacidade efetiva pelo recurso mais restritivo.
7. Ao reservar, o sistema revalida e consome capacidade atomicamente.

## Alternativas e exceções

- **A1 — Valor negativo:** rejeitar a configuração.
- **A2 — Recurso inativo/bloqueado:** excluir da capacidade futura.
- **A3 — Capacidade esgotada:** rejeitar nova reserva.
- **A4 — Concorrência:** somente uma operação consome a última unidade.
- **A5 — Falha:** não deixar capacidade ou reserva parcial.

## Pós-condições

A ocupação simultânea não ultrapassa consultórios, salas, equipamentos, atendimentos ou estudantes permitidos.
