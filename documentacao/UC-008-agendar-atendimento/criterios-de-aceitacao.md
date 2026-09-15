# Critérios de aceitação do UC-008

## CA-008.01-01 — Consulta pública

**Dado** um serviço com horários elegíveis  
**Quando** a comunidade consultar a agenda  
**Então** o sistema deve mostrar apenas informações necessárias, sem dados pessoais indevidos.

## CA-008.02-01 — Reserva válida

**Dado** horário disponível e dados mínimos válidos  
**Quando** a pessoa confirmar a solicitação  
**Então** o sistema deve revalidar todas as restrições, criar uma única reserva e fornecer identificador.

## CA-008.02-02 — Concorrência pela última vaga

**Dado** duas solicitações simultâneas pela última capacidade  
**Quando** forem processadas  
**Então** somente uma deve ser confirmada e a outra não pode gerar registro parcial.

## CA-008.03-01 — Confirmação idempotente

**Dado** um agendamento apto  
**Quando** a confirmação válida for enviada uma ou mais vezes  
**Então** deve existir um único agendamento confirmado, sem consumo duplicado.

## CA-008.04-01 — Cancelamento

**Dado** um agendamento cancelável e acesso válido  
**Quando** a pessoa cancelar  
**Então** o sistema deve alterar o status uma vez e liberar a capacidade conforme a política.

