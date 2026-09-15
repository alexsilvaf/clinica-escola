# UC-001 — Cadastrar estudante

[Início](../../README.md) · [Documentação](../README.md)

| Informação          | Valor                                   |
| ------------------- | --------------------------------------- |
| Requisito de origem | cadastro dos estudantes                 |
| Fonte               | desafio 2, requisito mínimo 1, página 7 |
| Ator principal      | responsável autorizado                  |
| Atores secundários  | estudante e Master                      |
| Prioridade          | Must                                    |
| Status              | Em refinamento                          |
| Validador           | A definir                               |

## Objetivo

Manter nome, matrícula, curso, período, contato, disciplina ou estágio, disponibilidade e situação do estudante para permitir o cálculo posterior de elegibilidade.

## Documentos

| Documento                                                 | Conteúdo                                       |
| --------------------------------------------------------- | ---------------------------------------------- |
| [Caso de uso](caso-de-uso.md)                             | Fluxos, alternativas e pós-condições           |
| [Histórias de usuário](historias-de-usuario.md)           | Valor, prioridade e situação das histórias     |
| [Requisitos funcionais](requisitos-funcionais.md)         | Comportamentos esperados e rastreabilidade     |
| [Requisitos não funcionais](requisitos-nao-funcionais.md) | Qualidade, segurança e requisitos verificáveis |
| [Regras de negócio](regras-de-negocio.md)                 | Restrições e políticas do domínio              |
| [Critérios de aceitação](criterios-de-aceitacao.md)       | Cenários de validação em Dado / Quando / Então |

## Dependências

- UC-007 fornece semestre, curso, período e disciplina;
- UC-002 complementa a elegibilidade documental;
- UC-005 utiliza vínculos e disponibilidade.

## Decisões pendentes

- Quem cria e quem edita o cadastro?
- A matrícula é única globalmente ou por unidade?
- Quais canais de contato são obrigatórios?
- Como representar disponibilidade recorrente e exceções?
