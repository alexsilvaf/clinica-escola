# Requisitos não funcionais do UC-001

[Início](../../README.md) · [Documentação](../README.md) · [UC-001](README.md) · Requisitos não funcionais

| ID               | Atributo    | Requisito verificável                                                                 | Prioridade |
| ---------------- | ----------- | ------------------------------------------------------------------------------------- | ---------- |
| `RNF-001.SEG-01` | Autorização | O servidor deve negar consulta ou alteração a usuário sem permissão sobre o cadastro. | Must       |
| `RNF-001.PRI-01` | Privacidade | Listagens devem exibir apenas dados necessários ao papel do usuário.                  | Must       |
| `RNF-001.INT-01` | Integridade | Matrícula e vínculos não podem ficar parcialmente gravados após falha.                | Must       |
| `RNF-001.USA-01` | Usabilidade | Erros devem identificar o campo e orientar a correção sem expor detalhe interno.      | Should     |
| `RNF-001.AUD-01` | Auditoria   | Alterações de situação e vínculo devem registrar ator, alvo, resultado e instante.    | Should     |

Metas adicionais de desempenho serão definidas após a equipe estabelecer volume e ambiente de referência.
