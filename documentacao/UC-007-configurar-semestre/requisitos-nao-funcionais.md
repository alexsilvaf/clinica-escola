# Requisitos não funcionais do UC-007

[Início](../../README.md) · [Documentação](../README.md) · [UC-007](README.md) · Requisitos não funcionais

| ID               | Atributo          | Requisito verificável                                                           | Prioridade |
| ---------------- | ----------------- | ------------------------------------------------------------------------------- | ---------- |
| `RNF-007.MAN-01` | Configurabilidade | Dados que variam por semestre devem mudar sem alteração/recompilação do código. | Must       |
| `RNF-007.INT-01` | Integridade       | Configuração inconsistente não pode ser ativada.                                | Must       |
| `RNF-007.AUD-01` | Auditoria         | Ativação e alterações devem registrar ator, instante e valores relevantes.      | Must       |
| `RNF-007.SEG-01` | Autorização       | Somente papel autorizado pode ativar ou modificar configuração.                 | Must       |
| `RNF-007.HIS-01` | Historicidade     | Consulta anterior deve exibir os valores vigentes naquele semestre.             | Must       |
