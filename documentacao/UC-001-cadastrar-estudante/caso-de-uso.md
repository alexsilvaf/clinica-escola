# Especificação do UC-001

[Início](../../README.md) · [Documentação](../README.md) · [UC-001](README.md) · Caso de uso

## Gatilho

Um responsável autorizado solicita a criação ou alteração de um estudante.

## Pré-condições

- usuário autenticado e autorizado;
- semestre, curso e atividade acadêmica previamente cadastrados.

## Fluxo principal

1. O ator inicia um novo cadastro.
2. O sistema apresenta os campos obrigatórios.
3. O ator informa dados pessoais, acadêmicos, contato e disponibilidade.
4. O sistema valida campos, referências e unicidade da matrícula.
5. O ator confirma a operação.
6. O sistema persiste o estudante e seus vínculos.
7. O sistema informa o identificador e a situação do cadastro.

## Alternativas e exceções

- **A1 — Matrícula duplicada:** o sistema rejeita a operação e não cria registro parcial.
- **A2 — Referência inválida:** curso, período ou atividade inexistente/inativa impede a gravação.
- **A3 — Edição:** o sistema preserva o histórico exigido e recalcula impactos futuros.
- **A4 — Inativação:** o estudante deixa de participar de novas alocações, sem apagar o histórico.
- **A5 — Acesso indevido:** a operação é negada e não revela dados do estudante.

## Pós-condições de sucesso

- estudante persistido uma única vez;
- vínculos e disponibilidade associados ao semestre correto;
- evento sensível registrado quando aplicável.

## Garantia em caso de falha

Nenhum cadastro ou vínculo parcial deve permanecer.
