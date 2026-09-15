# Critérios de aceitação do UC-004

[Início](../../README.md) · [Documentação](../README.md) · [UC-004](README.md) · Critérios de aceitação

## CA-004.01-01 — Vaga restante

- **Dado:** limite 5 e quatro estudantes ativos no intervalo
- **Quando:** uma quinta inscrição válida for confirmada
- **Então:** o sistema deve aceitá-la e marcar a capacidade como esgotada.

## CA-004.01-02 — Limite atingido

- **Dado:** capacidade de supervisão esgotada
- **Quando:** outra inscrição for solicitada
- **Então:** o sistema deve rejeitá-la sem persistir alocação parcial.

## CA-004.01-03 — Concorrência

- **Dado:** duas solicitações simultâneas pela única vaga restante
- **Quando:** forem processadas
- **Então:** no máximo uma deve ser confirmada e a outra deve receber indisponibilidade recuperável.

## CA-004.01-04 — Intervalo distinto

- **Dado:** limite atingido em um intervalo
- **Quando:** houver inscrição em intervalo não sobreposto
- **Então:** a ocupação anterior não deve bloquear a nova operação.
