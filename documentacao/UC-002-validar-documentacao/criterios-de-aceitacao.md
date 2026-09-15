# Critérios de aceitação do UC-002

## CA-002.01-01 — Envio aceito

**Dado** um estudante autenticado e um arquivo permitido  
**Quando** ele enviar o documento solicitado  
**Então** o sistema deve armazená-lo de forma protegida e marcar `Em análise`.

## CA-002.01-02 — Arquivo inseguro

**Dado** um arquivo com tipo, assinatura ou tamanho proibido  
**Quando** houver tentativa de envio  
**Então** o sistema deve rejeitá-lo e orientar a correção sem disponibilizá-lo publicamente.

## CA-002.02-01 — Recusa explicada

**Dado** um responsável autorizado analisando um documento  
**Quando** escolher `Recusar`  
**Então** o sistema deve exigir orientação, registrar a decisão e manter o estudante bloqueado.

## CA-002.03-01 — Aprovação completa

**Dado** que todos os documentos obrigatórios vigentes estão aprovados  
**Quando** a aptidão for recalculada  
**Então** o estudante deve ficar documentalmente apto.

## CA-002.03-02 — Pendência

**Dado** qualquer documento obrigatório pendente  
**Quando** o estudante tentar acessar horários  
**Então** o sistema deve bloquear a ação e indicar a existência de pendência.

