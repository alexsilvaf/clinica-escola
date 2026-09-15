# Especificação do UC-007

## Gatilho

O Master precisa preparar ou ativar a operação de um período letivo.

## Pré-condições

- Master autenticado e autorizado;
- catálogos institucionais mínimos cadastrados.

## Fluxo principal

1. O Master cria uma configuração e informa ano/período.
2. Associa cursos, disciplinas, estágios e períodos.
3. Associa estudantes e supervisores.
4. Define horários, ambientes, consultórios, equipamentos e capacidades.
5. Define limites de supervisão e exigências documentais.
6. O sistema valida referências e consistência.
7. O Master solicita ativação.
8. O sistema revalida e ativa a configuração.
9. O sistema registra a operação e preserva semestres anteriores.

## Alternativas e exceções

- **A1 — Configuração incompleta:** impedir ativação e listar inconsistências.
- **A2 — Identificador duplicado:** impedir segundo semestre no mesmo escopo.
- **A3 — Edição após ativação:** aplicar política institucional ainda a validar.
- **A4 — Impacto em reservas:** impedir ou exigir tratamento explícito.
- **A5 — Acesso indevido:** negar a operação no servidor.

## Pós-condições

Uma configuração consistente rege os novos cálculos, sem alterar o contexto histórico anterior.

