# Requisitos não funcionais do UC-003

[Início](../../README.md) · [Documentação](../README.md) · [UC-003](README.md) · Requisitos não funcionais

| ID               | Atributo    | Requisito verificável                                                                   | Prioridade |
| ---------------- | ----------- | --------------------------------------------------------------------------------------- | ---------- |
| `RNF-003.SEG-01` | Autorização | Somente papéis autorizados podem alterar disponibilidade ou limite de supervisor.       | Must       |
| `RNF-003.INT-01` | Integridade | Limite deve ser inteiro positivo nos contextos que exigem supervisão.                   | Must       |
| `RNF-003.AUD-01` | Auditoria   | Alterações de tipo, disponibilidade, ambiente, situação e limite devem ser rastreáveis. | Should     |
| `RNF-003.USA-01` | Usabilidade | Conflitos de horário e campos inválidos devem ser explicados junto ao dado afetado.     | Should     |
| `RNF-003.PRI-01` | Privacidade | Contatos e dados pessoais não devem aparecer na agenda pública.                         | Must       |
