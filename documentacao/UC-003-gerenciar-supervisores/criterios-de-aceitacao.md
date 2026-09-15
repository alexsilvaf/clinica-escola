# Critérios de aceitação do UC-003

## CA-003.01-01 — Cadastro completo

**Dado** um usuário autorizado e dados válidos  
**Quando** o supervisor for cadastrado  
**Então** o sistema deve registrar tipo, área/curso, ambientes, disponibilidade e limite simultâneo.

## CA-003.03-01 — Limite inválido

**Dado** limite zero, negativo ou ausente em contexto que exige supervisão  
**Quando** o ator tentar ativar a configuração  
**Então** o sistema deve rejeitar a operação e indicar a correção.

## CA-003.02-01 — Disponibilidade

**Dado** dias e horários válidos dentro do semestre  
**Quando** forem salvos  
**Então** eles devem ficar disponíveis ao cálculo de elegibilidade.

## CA-003.01-02 — Inativação

**Dado** um supervisor inativo  
**Quando** novas ofertas forem calculadas  
**Então** sua disponibilidade não deve ser utilizada e seu histórico deve ser preservado.

