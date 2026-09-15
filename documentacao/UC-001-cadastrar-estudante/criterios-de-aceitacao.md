# Critérios de aceitação do UC-001

## CA-001.01-01 — Cadastro válido

**Dado** um usuário autorizado e dados obrigatórios válidos  
**Quando** o cadastro for confirmado  
**Então** o sistema deve criar um único estudante com os vínculos e a disponibilidade informados.

## CA-001.01-02 — Matrícula duplicada

**Dado** um estudante já cadastrado com a mesma matrícula  
**Quando** outro cadastro for solicitado no mesmo escopo  
**Então** o sistema deve rejeitar a operação sem criar registro parcial.

## CA-001.01-03 — Campos obrigatórios

**Dado** nome, matrícula, curso, período ou vínculo obrigatório ausente/inválido  
**Quando** o ator tentar salvar  
**Então** o sistema deve rejeitar a operação e indicar os campos a corrigir.

## CA-001.03-01 — Inativação

**Dado** um estudante inativado  
**Quando** novas alocações forem calculadas  
**Então** ele não deve ser considerado e seu histórico deve permanecer disponível a usuário autorizado.

