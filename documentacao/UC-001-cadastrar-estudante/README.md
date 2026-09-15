# UC-001 — Cadastrar estudante

- **Requisito de origem:** cadastro dos estudantes
- **Fonte:** desafio 2, requisito mínimo 1, página 7
- **Ator principal:** responsável autorizado
- **Atores secundários:** estudante e Master
- **Prioridade:** Must
- **Status:** Em refinamento
- **Validador:** A definir

## Objetivo

Manter nome, matrícula, curso, período, contato, disciplina ou estágio, disponibilidade e situação do estudante para permitir o cálculo posterior de elegibilidade.

## Documentos

- [Caso de uso](caso-de-uso.md)
- [Histórias de usuário](historias-de-usuario.md)
- [Requisitos funcionais](requisitos-funcionais.md)
- [Requisitos não funcionais](requisitos-nao-funcionais.md)
- [Regras de negócio](regras-de-negocio.md)
- [Critérios de aceitação](criterios-de-aceitacao.md)

## Dependências

- UC-007 fornece semestre, curso, período e disciplina;
- UC-002 complementa a elegibilidade documental;
- UC-005 utiliza vínculos e disponibilidade.

## Decisões pendentes

- Quem cria e quem edita o cadastro?
- A matrícula é única globalmente ou por unidade?
- Quais canais de contato são obrigatórios?
- Como representar disponibilidade recorrente e exceções?

