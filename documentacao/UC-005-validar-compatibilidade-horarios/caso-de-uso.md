# Especificação do UC-005

[Início](../../README.md) · [Documentação](../README.md) · [UC-005](README.md) · Caso de uso

## Gatilho

Um estudante apto solicita os horários disponíveis para sua atividade.

## Pré-condições

- estudante ativo e documentalmente apto;
- vínculo acadêmico e disponibilidade cadastrados;
- semestre ativo;
- supervisor e clínica configurados.

## Fluxo principal

1. O estudante seleciona disciplina ou estágio elegível.
2. O sistema localiza os horários da atividade no semestre ativo.
3. Exclui intervalos incompatíveis com vínculo ou disponibilidade do estudante.
4. Exclui horários sem supervisor habilitado/disponível.
5. Exclui horários sem capacidade de supervisão ou física.
6. Apresenta apenas opções integralmente elegíveis.
7. O estudante seleciona uma opção.
8. O sistema revalida antes da operação seguinte.

## Alternativas e exceções

- **A1 — Pendência documental:** bloquear acesso e indicar pendências.
- **A2 — Sem vínculo:** não apresentar horário de outra atividade.
- **A3 — Sem capacidade:** retirar a opção ou marcá-la indisponível, conforme UX validada.
- **A4 — Mudança concorrente:** informar indisponibilidade e permitir nova escolha.
- **A5 — Nenhuma opção:** apresentar estado vazio com orientação.

## Pós-condições

A opção selecionada ainda não garante reserva; a disponibilidade será novamente validada na confirmação.
