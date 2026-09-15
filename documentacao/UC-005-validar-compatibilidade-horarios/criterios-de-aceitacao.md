# Critérios de aceitação do UC-005

[Início](../../README.md) · [Documentação](../README.md) · [UC-005](README.md) · Critérios de aceitação

## CA-005.01-01 — Horário elegível

- **Dado:** estudante ativo, apto e vinculado à atividade
- **E:** estudante, supervisor e clínica disponíveis
- **Quando:** os horários forem consultados
- **Então:** a opção deve ser apresentada.

## CA-005.01-02 — Incompatibilidade acadêmica

- **Dado:** um horário sem vínculo com o estudante
- **Quando:** a consulta for realizada
- **Então:** esse horário não deve ser oferecido.

## CA-005.01-03 — Pendência documental

- **Dado:** um documento obrigatório pendente
- **Quando:** o estudante tentar acessar horários
- **Então:** o sistema deve bloquear a ação e orientar a correção.

## CA-005.01-04 — Recurso indisponível

- **Dado:** ausência de estudante, supervisor ou capacidade física no intervalo
- **Quando:** a elegibilidade for calculada
- **Então:** o horário não deve estar disponível para seleção.
