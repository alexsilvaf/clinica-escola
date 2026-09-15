# UC-004 — Controlar capacidade de supervisão

- **Requisito de origem:** capacidade de supervisão
- **Fonte:** desafio 2, requisito mínimo 4, página 7
- **Ator principal:** sistema
- **Interessados:** responsável pela clínica, supervisor e estudante
- **Prioridade:** Must
- **Status:** Em refinamento
- **Validador:** A definir

## Objetivo

Impedir novas inscrições quando o limite de estudantes supervisionados simultaneamente for atingido.

## Documentos

- [Caso de uso](caso-de-uso.md)
- [Histórias de usuário](historias-de-usuario.md)
- [Requisitos funcionais](requisitos-funcionais.md)
- [Requisitos não funcionais](requisitos-nao-funcionais.md)
- [Regras de negócio](regras-de-negocio.md)
- [Critérios de aceitação](criterios-de-aceitacao.md)

## Dependências

- UC-003 fornece supervisor, disponibilidade e limite;
- UC-005 fornece intervalos elegíveis;
- UC-008 consome capacidade durante o agendamento.

## Decisões pendentes

- Quais estados de inscrição consomem capacidade?
- O limite é individual ou pode pertencer a uma equipe?
- Como substituição e sobreposição parcial são calculadas?

