# UC-005 — Validar compatibilidade de horários

[Início](../../README.md) · [Documentação](../README.md)

| Informação          | Valor                                   |
| ------------------- | --------------------------------------- |
| Requisito de origem | compatibilidade com horários acadêmicos |
| Fonte               | desafio 2, requisito mínimo 5, página 7 |
| Ator principal      | estudante                               |
| Ator secundário     | sistema                                 |
| Prioridade          | Must                                    |
| Status              | Em refinamento                          |
| Validador           | A definir                               |

## Objetivo

Permitir ao estudante selecionar somente horários compatíveis com sua turma, disciplina ou estágio e com disponibilidade simultânea de estudante, supervisor e clínica.

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

UC-001, UC-002, UC-003, UC-004, UC-006 e UC-007.

## Decisões pendentes

- O estudante escolhe, solicita ou é alocado a um horário?
- Choques com toda a grade acadêmica serão considerados?
- Qual é a granularidade e a regra de sobreposição?
- Como feriados e bloqueios extraordinários serão representados?
