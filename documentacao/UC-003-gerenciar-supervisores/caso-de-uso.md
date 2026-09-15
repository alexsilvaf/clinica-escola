# Especificação do UC-003

## Gatilho

Um usuário autorizado precisa criar, alterar ou inativar um supervisor.

## Pré-condições

- usuário autenticado e autorizado;
- área/curso, ambiente e semestre previamente cadastrados.

## Fluxo principal

1. O ator inicia o cadastro de supervisor.
2. Informa nome, tipo, área/curso e situação.
3. Associa ambientes, dias e horários disponíveis.
4. Define o limite de estudantes simultâneos.
5. O sistema valida campos, referências, intervalos e limite.
6. O ator confirma.
7. O sistema persiste e informa o resultado.

## Alternativas e exceções

- **A1 — Limite inválido:** zero, negativo ou ausente impede uso do contexto que exige supervisão.
- **A2 — Horário inconsistente:** o sistema rejeita intervalo inválido ou fora do semestre.
- **A3 — Inativação:** não usar em novas ofertas; preservar histórico.
- **A4 — Alteração com impacto:** aplicar política ainda a validar às reservas futuras.
- **A5 — Acesso indevido:** negar no servidor.

## Pós-condições

O supervisor fica disponível para o cálculo de elegibilidade apenas nos contextos válidos e ativos.

