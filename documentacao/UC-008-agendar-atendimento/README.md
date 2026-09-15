# UC-008 — Agendar atendimento da comunidade

[Início](../../README.md) · [Documentação](../README.md)

| Informação          | Valor                                   |
| ------------------- | --------------------------------------- |
| Requisito de origem | agendamento pela comunidade             |
| Fonte               | desafio 2, requisito mínimo 8, página 8 |
| Ator principal      | pessoa da comunidade                    |
| Atores secundários  | sistema e responsável pela clínica      |
| Prioridade          | Must                                    |
| Status              | Em refinamento                          |
| Validador           | A definir                               |

## Objetivo

Permitir consultar horários disponíveis, criar um agendamento válido e posteriormente confirmá-lo ou cancelá-lo.

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

UC-004, UC-005, UC-006 e UC-007; controles administrativos do UC-009.

## Decisões pendentes

- Quais serviços, durações e dados mínimos serão usados?
- O agendamento nasce pendente ou confirmado?
- Como a pessoa comprova acesso para confirmar/cancelar?
- Quais prazos, faltas e notificações se aplicam?
