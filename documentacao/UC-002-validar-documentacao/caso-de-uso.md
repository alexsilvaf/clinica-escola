# Especificação do UC-002

## Gatilho

O estudante envia um documento ou um responsável inicia sua análise.

## Pré-condições

- estudante cadastrado e ativo;
- lista documental aplicável configurada;
- usuário autenticado e autorizado para a ação.

## Fluxo principal

1. O estudante consulta documentos exigidos e pendências.
2. O estudante seleciona o tipo e envia um arquivo válido.
3. O sistema protege o arquivo e registra a situação `Em análise`.
4. O responsável autorizado consulta a fila documental.
5. O responsável verifica o documento.
6. O responsável aprova ou recusa; a recusa exige orientação de correção.
7. O sistema registra a decisão, o ator e o instante.
8. O sistema recalcula a aptidão documental do estudante.

## Alternativas e exceções

- **A1 — Arquivo inválido:** rejeitar antes do armazenamento definitivo.
- **A2 — Recusa:** manter o estudante bloqueado e permitir novo envio.
- **A3 — Substituição:** iniciar nova análise sem apagar a decisão anterior.
- **A4 — Acesso direto indevido:** negar arquivo e metadados sensíveis.
- **A5 — Falha:** não registrar decisão sem garantir a persistência da auditoria aplicável.

## Pós-condições

O estudante estará documentalmente apto somente se todos os documentos obrigatórios vigentes estiverem aprovados.

