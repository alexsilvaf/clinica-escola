# UC-003 — Gerenciar professores e preceptores

[Início](../../README.md) · [Documentação](../README.md)

| Informação          | Valor                                   |
| ------------------- | --------------------------------------- |
| Requisito de origem | cadastro de professores e preceptores   |
| Fonte               | desafio 2, requisito mínimo 3, página 7 |
| Ator principal      | Master ou responsável autorizado        |
| Prioridade          | Must                                    |
| Status              | Em refinamento                          |
| Validador           | A definir                               |

## Objetivo

Manter professor ou preceptor, área de atuação, ambiente, disponibilidade e quantidade máxima de estudantes supervisionados simultaneamente.

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

- UC-006 fornece clínicas e ambientes;
- UC-007 fornece semestre, cursos e horários;
- UC-009 fornece controle de acesso.

## Decisões pendentes

- Professor e preceptor terão regras ou permissões diferentes?
- O limite varia por clínica, disciplina, ambiente ou atividade?
- Como ausências e substituições serão tratadas?
