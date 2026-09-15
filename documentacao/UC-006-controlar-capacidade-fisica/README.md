# UC-006 — Controlar capacidade física

- **Requisito de origem:** capacidade física da clínica
- **Fonte:** desafio 2, requisito mínimo 6, páginas 7 e 8
- **Ator principal:** responsável pela clínica ou Master
- **Prioridade:** Must
- **Status:** Em refinamento
- **Validador:** A definir

## Objetivo

Manter consultórios, salas, equipamentos e limites de atendimento/estudantes e impedir uso acima da capacidade física.

## Documentos

- [Caso de uso](caso-de-uso.md)
- [Histórias de usuário](historias-de-usuario.md)
- [Requisitos funcionais](requisitos-funcionais.md)
- [Requisitos não funcionais](requisitos-nao-funcionais.md)
- [Regras de negócio](regras-de-negocio.md)
- [Critérios de aceitação](criterios-de-aceitacao.md)

## Dependências

- UC-007 contextualiza recursos por semestre;
- UC-005 e UC-008 consultam/consomem capacidade;
- UC-009 administra os cadastros-base.

## Decisões pendentes

- Equipamentos serão unidades identificadas ou quantidades por tipo?
- Quais recursos cada serviço exige?
- Como bloqueios temporários e manutenção serão representados?
- Estudantes observadores consomem capacidade?

