# UC-009 — Administrar sistema (perfil Master)

[Início](../../README.md) · [Documentação](../README.md)

| Informação          | Valor                                   |
| ------------------- | --------------------------------------- |
| Requisito de origem | perfil Master                           |
| Fonte               | desafio 2, requisito mínimo 9, página 8 |
| Ator principal      | Master                                  |
| Prioridade          | Must                                    |
| Status              | Em refinamento                          |
| Validador           | A definir                               |

## Objetivo

Administrar usuários, permissões, cursos, disciplinas, clínicas, ambientes, configurações e capacidades com controle de acesso e auditoria.

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

Esta UC fornece cadastros, permissões e configurações transversais a todas as demais.

## Decisões pendentes

- Quais papéis e permissões compõem a matriz de acesso?
- Master é global, por unidade ou por clínica?
- Quem concede/revoga o primeiro Master?
- Quais dados gerais podem ser consultados e com qual agregação?
