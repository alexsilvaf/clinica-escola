# Critérios de aceitação do UC-006

## CA-006.01-01 — Configuração válida

**Dado** um usuário autorizado e valores não negativos  
**Quando** recursos e limites forem configurados  
**Então** o sistema deve salvá-los no contexto semestral aplicável.

## CA-006.02-01 — Recurso limitante

**Dado** quatro consultórios e apenas três equipamentos obrigatórios  
**Quando** a capacidade efetiva for calculada  
**Então** ela não deve ultrapassar três, respeitando eventual limite ainda menor.

## CA-006.03-01 — Capacidade esgotada

**Dado** qualquer limite obrigatório atingido  
**Quando** nova reserva simultânea for solicitada  
**Então** o sistema deve rejeitá-la sem alterar os registros existentes.

## CA-006.01-02 — Recurso bloqueado

**Dado** um recurso inativo ou bloqueado  
**Quando** a disponibilidade for calculada  
**Então** o recurso não deve compor a capacidade.

