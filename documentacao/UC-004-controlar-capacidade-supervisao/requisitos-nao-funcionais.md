# Requisitos não funcionais do UC-004

[Início](../../README.md) · [Documentação](../README.md) · [UC-004](README.md) · Requisitos não funcionais

| ID               | Atributo         | Requisito verificável                                                               | Prioridade |
| ---------------- | ---------------- | ----------------------------------------------------------------------------------- | ---------- |
| `RNF-004.CON-01` | Concorrência     | Duas solicitações pela última vaga devem confirmar no máximo uma alocação.          | Must       |
| `RNF-004.INT-01` | Atomicidade      | Falha não pode deixar alocação parcial nem contador inconsistente.                  | Must       |
| `RNF-004.DES-01` | Desempenho       | O cálculo deve respeitar a meta de resposta definida para o ambiente de referência. | Should     |
| `RNF-004.AUD-01` | Rastreabilidade  | Bloqueios e alterações administrativas de limite devem ser investigáveis.           | Should     |
| `RNF-004.MAN-01` | Manutenibilidade | Regra de sobreposição e consumo deve ter testes automatizados isolados.             | Should     |
