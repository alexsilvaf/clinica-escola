# Critérios de aceitação do UC-009

[Início](../../README.md) · [Documentação](../README.md) · [UC-009](README.md) · Critérios de aceitação

## CA-009.01-01 — Acesso autorizado

- **Dado:** um Master autenticado com permissão
- **Quando:** acessar uma função administrativa
- **Então:** o sistema deve liberar apenas as operações concedidas.

## CA-009.02-01 — Acesso negado

- **Dado:** um usuário sem permissão
- **Quando:** chamar diretamente uma operação Master
- **Então:** o servidor deve negar a ação sem depender da ocultação da interface.

## CA-009.03-01 — Alteração auditada

- **Dado:** uma mudança administrativa válida
- **Quando:** ela for confirmada
- **Então:** o sistema deve aplicá-la e registrar ator, ação, alvo, resultado e instante.

## CA-009.01-02 — Último Master

- **Dado:** apenas um Master ativo
- **Quando:** houver tentativa comum de remover seu acesso
- **Então:** o sistema deve bloquear a operação e orientar o processo institucional de recuperação.

## CA-009.03-02 — Referência histórica

- **Dado:** um catálogo usado em registros anteriores
- **Quando:** houver tentativa de exclusão destrutiva
- **Então:** o sistema deve preservar a integridade e oferecer inativação quando aplicável.
