# UC-007 — Configurar semestre

- **Requisito de origem:** configuração por semestre
- **Fonte:** desafio 2, requisito mínimo 7, página 8
- **Ator principal:** Master
- **Atores secundários:** responsável acadêmico e responsável pela clínica
- **Prioridade:** Must
- **Status:** Em refinamento
- **Validador:** A definir

## Objetivo

Configurar estudantes, capacidades, horários, supervisores, limites, disciplinas, períodos e consultórios para cada semestre, sem modificar código nem perder histórico.

## Documentos

- [Caso de uso](caso-de-uso.md)
- [Histórias de usuário](historias-de-usuario.md)
- [Requisitos funcionais](requisitos-funcionais.md)
- [Requisitos não funcionais](requisitos-nao-funcionais.md)
- [Regras de negócio](regras-de-negocio.md)
- [Critérios de aceitação](criterios-de-aceitacao.md)

## Dependências

- utiliza cadastros de UC-001, UC-003 e UC-006;
- fornece contexto para todas as demais UCs;
- depende das permissões do UC-009.

## Decisões pendentes

- Pode existir mais de uma configuração ativa por unidade, curso ou clínica?
- Haverá clonagem do semestre anterior?
- Quais mudanças são permitidas após a ativação?
- Como reservas futuras são tratadas quando a configuração muda?

