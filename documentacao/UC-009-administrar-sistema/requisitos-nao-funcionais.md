# Requisitos não funcionais do UC-009

[Início](../../README.md) · [Documentação](../README.md) · [UC-009](README.md) · Requisitos não funcionais

| ID               | Atributo           | Requisito verificável                                                                          | Prioridade         |
| ---------------- | ------------------ | ---------------------------------------------------------------------------------------------- | ------------------ |
| `RNF-009.SEG-01` | Negação por padrão | Operação não concedida explicitamente deve ser negada no servidor.                             | Must               |
| `RNF-009.SEG-02` | Credenciais        | Senhas não podem ser armazenadas em texto puro; devem usar hash moderno com sal individual.    | Must               |
| `RNF-009.SEG-03` | Sessão             | Sessões devem expirar, permitir logout e usar atributos seguros quando baseadas em cookie.     | Must               |
| `RNF-009.SEG-04` | Transporte         | Ambiente publicado deve utilizar HTTPS.                                                        | Must para produção |
| `RNF-009.AUD-01` | Auditoria          | Evento deve conter ator, ação, alvo, resultado e instante, sem segredo ou conteúdo documental. | Must               |
| `RNF-009.PRI-01` | Privacidade        | Consulta geral deve respeitar necessidade, papel e contexto.                                   | Must               |
| `RNF-009.INT-01` | Integridade        | Cadastro referenciado não pode ser apagado de modo a quebrar histórico.                        | Must               |
