# Requisitos não funcionais do UC-008

[Início](../../README.md) · [Documentação](../README.md) · [UC-008](README.md) · Requisitos não funcionais

| ID               | Atributo       | Requisito verificável                                                                                   | Prioridade |
| ---------------- | -------------- | ------------------------------------------------------------------------------------------------------- | ---------- |
| `RNF-008.USA-01` | Usabilidade    | Pessoa deve concluir o fluxo principal em até 3 minutos e 5 etapas primárias; meta sujeita a validação. | Should     |
| `RNF-008.ACC-01` | Acessibilidade | Fluxo principal deve atender WCAG 2.2 nível AA, incluindo teclado, foco, rótulos e erros.               | Should     |
| `RNF-008.RES-01` | Responsividade | Fluxo deve funcionar sem rolagem horizontal a partir de 360 px.                                         | Should     |
| `RNF-008.CON-01` | Concorrência   | Duas reservas pela última capacidade devem confirmar no máximo uma.                                     | Must       |
| `RNF-008.INT-01` | Atomicidade    | Falha não pode deixar reserva ou consumo parcial.                                                       | Must       |
| `RNF-008.IDE-01` | Idempotência   | Reenvio da confirmação não pode duplicar agendamento ou capacidade.                                     | Must       |
| `RNF-008.PRI-01` | Privacidade    | Agenda pública, URL, logs e erros não devem expor dados de outras pessoas.                              | Must       |
| `RNF-008.DES-01` | Desempenho     | Consulta deve responder em até 2 s no p95 no ambiente de referência a definir.                          | Should     |
