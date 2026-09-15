# Especificação do UC-009

## Gatilho

O Master acessa uma função administrativa.

## Pré-condições

- usuário autenticado com permissão adequada;
- sessão válida;
- catálogos/referências exigidos existentes para a operação.

## Fluxo principal

1. O Master acessa o painel administrativo.
2. Seleciona usuários/permissões, catálogos, capacidades ou configurações.
3. O sistema verifica autorização no servidor.
4. O Master consulta ou informa a alteração.
5. O sistema valida campos, dependências e impacto histórico.
6. O Master confirma.
7. O sistema persiste a operação e registra auditoria.
8. O sistema informa o resultado sem expor dado desnecessário.

## Alternativas e exceções

- **A1 — Sem permissão:** negar no servidor, mesmo por acesso direto.
- **A2 — Referência em uso:** impedir exclusão destrutiva e oferecer inativação quando aplicável.
- **A3 — Último Master:** bloquear remoção comum do último acesso ativo.
- **A4 — Sessão expirada:** exigir nova autenticação.
- **A5 — Falha:** não persistir alteração parcial nem auditoria enganosa.

## Pós-condições

A alteração válida está aplicada de modo consistente e é rastreável por ator, alvo, resultado e instante.

