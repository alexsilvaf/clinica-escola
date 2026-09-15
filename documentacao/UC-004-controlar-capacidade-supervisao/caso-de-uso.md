# Especificação do UC-004

[Início](../../README.md) · [Documentação](../README.md) · [UC-004](README.md) · Caso de uso

## Gatilho

Uma operação tenta alocar estudante a um supervisor em determinado intervalo.

## Pré-condições

- supervisor ativo, disponível e habilitado;
- limite simultâneo configurado;
- intervalo e estudante elegíveis.

## Fluxo principal

1. O sistema recebe a tentativa de inscrição/alocação.
2. Identifica supervisor, intervalo e contexto.
3. Conta alocações ativas que se sobrepõem ao intervalo.
4. Calcula a capacidade restante.
5. Revalida a capacidade dentro da transação.
6. Se houver vaga, confirma uma única alocação.
7. Atualiza a disponibilidade apresentada aos demais usuários.

## Alternativas e exceções

- **A1 — Limite atingido:** rejeitar sem criar alocação parcial.
- **A2 — Concorrência:** somente uma solicitação pode consumir a última vaga.
- **A3 — Intervalo não sobreposto:** capacidade de outro intervalo não bloqueia a operação.
- **A4 — Supervisor indisponível/inativo:** rejeitar mesmo que o contador esteja abaixo do limite.
- **A5 — Falha transacional:** reverter alocação e contador.

## Pós-condições

A quantidade de estudantes simultâneos nunca ultrapassa o limite vigente.
