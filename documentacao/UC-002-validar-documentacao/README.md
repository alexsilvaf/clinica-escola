# UC-002 — Validar documentação

[Início](../../README.md) · [Documentação](../README.md)

| Informação          | Valor                                   |
| ------------------- | --------------------------------------- |
| Requisito de origem | validação obrigatória da documentação   |
| Fonte               | desafio 2, requisito mínimo 2, página 7 |
| Ator principal      | professor ou responsável autorizado     |
| Atores secundários  | estudante e Master                      |
| Prioridade          | Must                                    |
| Status              | Em refinamento                          |
| Validador           | A definir                               |

## Objetivo

Receber documentos digitais, permitir análise e correção e impedir acesso do estudante aos horários enquanto existir pendência obrigatória.

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

- UC-001 fornece o estudante;
- UC-007 define exigências documentais por contexto;
- UC-009 fornece permissões e auditoria.

## Decisões pendentes

- Quais documentos, formatos, tamanhos, validades e prazos serão usados?
- Quem pode analisar cada documento?
- Qual é a retenção e a política de descarte?
- Uma nova pendência afeta reservas já existentes?
