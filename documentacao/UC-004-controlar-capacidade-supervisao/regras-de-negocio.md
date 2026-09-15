# Regras de negócio do UC-004

[Início](../../README.md) · [Documentação](../README.md) · [UC-004](README.md) · Regras de negócio

| ID          | Regra                                                                         | Classe     | Status   |
| ----------- | ----------------------------------------------------------------------------- | ---------- | -------- |
| `RN-004.01` | Capacidade restante é o limite vigente menos as alocações ativas sobrepostas. | Inferido   | Rascunho |
| `RN-004.02` | O limite não pode ser excedido em nenhum instante.                            | Confirmado | Rascunho |
| `RN-004.03` | A validação final ocorre atomicamente na confirmação.                         | Inferido   | Rascunho |
| `RN-004.04` | Intervalos sem sobreposição não compartilham consumo.                         | Inferido   | Rascunho |
| `RN-004.05` | Estados que consomem e liberam capacidade devem ser configurados/validados.   | Proposto   | Rascunho |
