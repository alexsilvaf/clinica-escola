# Critérios de aceitação do UC-007

## CA-007.01-01 — Criação

**Dado** um Master autorizado  
**Quando** criar uma configuração semestral  
**Então** o sistema deve permitir associar todos os elementos obrigatórios do requisito.

## CA-007.02-01 — Ativação válida

**Dado** uma configuração completa e consistente  
**Quando** o Master solicitar ativação  
**Então** ela deve reger novos cálculos e a ação deve ser auditada.

## CA-007.02-02 — Ativação inválida

**Dado** horário sem supervisor ou capacidade obrigatória  
**Quando** houver tentativa de ativação  
**Então** o sistema deve rejeitar a operação e listar inconsistências corrigíveis.

## CA-007.04-01 — Histórico

**Dado** a ativação de um novo semestre  
**Quando** usuário autorizado consultar o anterior  
**Então** os dados devem manter o contexto e os valores vigentes naquele período.

