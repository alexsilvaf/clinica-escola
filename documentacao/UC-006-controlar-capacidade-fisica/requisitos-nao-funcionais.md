# Requisitos não funcionais do UC-006

| ID | Atributo | Requisito verificável | Prioridade |
|---|---|---|---|
| RNF-006.CON-01 | Concorrência | Duas reservas pela última capacidade devem confirmar no máximo uma. | Must |
| RNF-006.INT-01 | Integridade | Valores não podem ser negativos e referências devem existir. | Must |
| RNF-006.INT-02 | Atomicidade | Falha não pode deixar consumo parcial de múltiplos recursos. | Must |
| RNF-006.AUD-01 | Auditoria | Alterações de capacidade e bloqueio devem registrar ator, valor anterior/novo e instante. | Should |
| RNF-006.MAN-01 | Configurabilidade | Capacidade semestral deve mudar sem alteração ou recompilação do código. | Must |

