# Passo a passo — demonstração mínima de agendamento

[Frontend](frontend/README.md) · [Backend](backend/README.md) · [Documentação completa](documentacao/README.md) · [Design](documentacao/design/README.md) · [Padrão Markdown](documentacao/guia-markdown.md)

## Como executar os ambientes

### Pré-requisitos

Instale e valide no terminal:

- [Git](https://git-scm.com/downloads): `git --version`;
- [Node.js](https://nodejs.org/) **24.15.0 ou superior da linha 24**:
  `node --version` e `npm --version`;
- um JDK **25**: `java --version`.

O Gradle não precisa ser instalado separadamente. O repositório inclui o
Gradle Wrapper, que baixa e usa automaticamente a versão correta.

### 1 — Baixar o projeto

```bash
git clone https://github.com/alexsilvaf/clinica-escola.git
cd clinica-escola
```

Se o repositório já estiver no computador, entre na pasta dele e execute
`git pull` para obter as alterações mais recentes.

### 2 — Iniciar o backend

Abra um terminal na raiz do projeto e execute:

```powershell
cd backend
.\gradlew.bat bootRun
```

No macOS ou Linux, use `./gradlew bootRun`. Aguarde a aplicação iniciar; a API
ficará disponível em [localhost:8080](http://localhost:8080). Instruções sobre
o JDK, `JAVA_HOME`, Gradle, testes e H2 estão no
[README do backend](backend/README.md).

### 3 — Iniciar o frontend

Mantenha o backend em execução, abra **outro terminal** na raiz do projeto e
execute:

```bash
cd frontend
npm ci
npm start
```

Abra [localhost:4200](http://localhost:4200) no navegador. O comando `npm ci`
instala exatamente as versões registradas no `package-lock.json`; em caso de
alteração intencional das dependências, use `npm install`. Consulte o
[README do frontend](frontend/README.md) para o passo a passo detalhado.

Para encerrar qualquer ambiente, volte ao terminal correspondente e pressione
`Ctrl+C`.

## Objetivo e limite da entrega

Entregar um único fluxo funcional: consultar horários, preencher dados fictícios e receber o comprovante de uma reserva gravada no H2. A API deve impedir reserva de horário indisponível e não ultrapassar sua capacidade.

São somente três telas. Não criar área administrativa ou portal do estudante neste recorte.

> [!NOTE]
> Base atual do frontend: a página inicial “Horários disponíveis”, em `features/horarios-disponiveis`, já tem componentes separados e dados mockados para servir de referência aos estudantes. Selecionar um horário não realiza uma reserva; integração com a API, formulário e comprovante ainda não foram implementados. Ver a [estrutura dos componentes](frontend/src/app/components/README.md).

| Tela                 | Rota                  | Ação principal                          |
| -------------------- | --------------------- | --------------------------------------- |
| Horários disponíveis | `/`                   | Escolher um horário consultado na API   |
| Dados do agendamento | `/agendar/:horarioId` | Preencher os dados fictícios e reservar |
| Comprovante          | `/comprovante`        | Conferir o resultado real da reserva    |

> [!IMPORTANT]
> Esta entrega atende parcialmente ao UC-008. Os demais casos de uso ficam adiados; dados pré-carregados não significam que seus cadastros, aprovações e regras foram implementados.

A especificação completa permanece em [documentacao/README.md](documentacao/README.md), e as referências visuais estão em [documentacao/design/telas.md](documentacao/design/telas.md).

> [!WARNING]
> Executar apenas localmente, com dados fictícios e sem disponibilizar o sistema na internet. Não há autenticação nem área restrita neste recorte; antes de qualquer uso real, será necessário implementar os controles de acesso e os requisitos adiados.

## Ordem de implementação

Checklist do roteiro; os itens abaixo não indicam funcionalidades já concluídas.

- [ ] [1 — Preparar os dados fictícios, sem telas de cadastro](#1--preparar-os-dados-fictícios-sem-telas-de-cadastro)
- [ ] [2 — Criar somente a persistência necessária](#2--criar-somente-a-persistência-necessária)
- [ ] [3 — Criar a API de consulta e reserva](#3--criar-a-api-de-consulta-e-reserva)
- [ ] [4 — Criar a tela “Horários disponíveis”](#4--criar-a-tela-horários-disponíveis)
- [ ] [5 — Criar a tela “Dados do agendamento”](#5--criar-a-tela-dados-do-agendamento)
- [ ] [6 — Criar a tela “Comprovante”](#6--criar-a-tela-comprovante)
- [ ] [7 — Testar e encerrar a entrega](#7--testar-e-encerrar-a-entrega)

### 1 — Preparar os dados fictícios, sem telas de cadastro

- Subir frontend e backend seguindo [frontend/README.md](frontend/README.md) e [backend/README.md](backend/README.md).
- Usar uma clínica, um serviço e poucos horários futuros, fixos e sem sobreposição, cada um com capacidade de uma reserva.
- Considerar estudante, supervisor, semestre e documentos aptos por premissa dos dados de demonstração. Não criar upload, aprovação documental ou cálculo de elegibilidade acadêmica.
- Incluir um horário marcado como indisponível para testar o bloqueio. Essa marcação é uma simplificação da demonstração, não uma validação das seis condições do produto.
- Definir os dados iniciais que serão carregados no perfil local. O H2 atual é em memória: reiniciar o backend limpa os agendamentos; o carregamento inicial deverá restaurar a base de demonstração.

> **Pronto quando:** as aplicações sobem e os cenários disponível e indisponível estão definidos.

### 2 — Criar somente a persistência necessária

- Criar a entidade `Horario`: serviço, local, início, fim, disponibilidade configurada e capacidade.
- Criar a entidade `Agendamento`: horário, nome fictício, contato fictício, protocolo não previsível, instante da reserva e chave de requisição.
- Criar repositories, DTOs e um service de reserva. Não criar entidades e CRUDs para todos os catálogos do projeto.
- Carregar os horários fictícios definidos na etapa anterior somente no perfil local.
- Manter nomes e organização existentes: backend em `br.com.clinicaescola`, frontend em `features`, e validação de entrada com `jakarta.validation`.

> **Pronto quando:** horários e reservas podem ser gravados e consultados pelo backend durante a execução.

### 3 — Criar a API de consulta e reserva

Implementar apenas estes endpoints:

| Método | Endpoint               | Comportamento                                                                                        |
| ------ | ---------------------- | ---------------------------------------------------------------------------------------------------- |
| `GET`  | `/api/v1/horarios`     | Retornar horários futuros habilitados com capacidade restante, sem dados de pessoas agendadas.       |
| `POST` | `/api/v1/agendamentos` | Receber horário, nome, contato e chave de requisição; retornar protocolo e resumo da reserva criada. |

Regras mínimas:

- Validar campos obrigatórios e limites de tamanho no servidor.
- Rejeitar horário inexistente, passado, desabilitado ou esgotado.
- Revalidar a capacidade e gravar a reserva atomicamente, com proteção contra duas requisições concorrentes. Apenas consultar o horário não bloqueia uma vaga.
- Usar uma chave de requisição única para que repetir o mesmo envio não crie uma segunda reserva nem consuma capacidade novamente.
- Retornar erro de validação para dados inválidos e conflito quando a capacidade tiver acabado.
- Não implementar listagem pública de agendamentos nem consulta de dados pessoais por ID.

> **Pronto quando:** uma chamada cria a reserva real, uma repetição não duplica e duas tentativas diferentes pela última vaga não geram duas reservas.

### 4 — Criar a tela “Horários disponíveis”

**Rota:** `/`. Adaptar a página inicial já existente, sem criar uma landing page separada.

- Consultar a API real usando o proxy `/api` já configurado.
- Exibir cartões simples com serviço, local, dia e horário; botão “Agendar” leva ao formulário do horário escolhido.
- Exibir carregamento, nenhum horário disponível e erro com nova tentativa.
- Não criar busca avançada, múltiplos serviços, calendário, tabela ou paginação.

> **Pronto quando:** a tela reflete os dados do backend e permite escolher um horário disponível.

### 5 — Criar a tela “Dados do agendamento”

**Rota:** `/agendar/:horarioId`.

- Mostrar o resumo do horário escolhido e somente os campos nome e contato fictícios.
- Validar os campos, enviar a reserva real e desabilitar o botão enquanto a requisição estiver em andamento.
- Manter a mesma chave de requisição ao repetir um envio após falha de rede.
- Preservar os dados em erro; quando a vaga acabar, explicar o conflito e oferecer retorno aos horários.
- Tratar acesso direto a horário inválido ou indisponível sem permitir reserva.

> **Pronto quando:** o formulário grava no H2 e só avança após a confirmação de sucesso da API.

### 6 — Criar a tela “Comprovante”

**Rota:** `/comprovante`.

- Mostrar protocolo, serviço, local, dia e horário usando a resposta real da reserva.
- Receber o comprovante pela navegação em memória, sem criar um endpoint adicional de consulta ou gerenciamento.
- Se a página for aberta diretamente ou os dados forem perdidos, explicar que o comprovante não está disponível e oferecer retorno ao início, sem refazer a reserva automaticamente.
- Oferecer apenas “Voltar aos horários”; não criar confirmação adicional, cancelamento, PDF ou envio externo.

> **Pronto quando:** há comprovante após uma reserva real e retornar aos horários mostra a capacidade atualizada.

### 7 — Testar e encerrar a entrega

- Automatizar no backend: reserva válida, dados inválidos, horário indisponível, repetição da mesma requisição e disputa concorrente pela última vaga.
- Percorrer as três telas integradas à API, incluindo carregamento, erro e conflito.
- Verificar navegação direta, envio repetido, rótulos dos campos, foco visível e apresentação básica no celular.
- Executar em `backend`: `./gradlew test` e `./gradlew build`.
- Executar em `frontend`: `npm run build` e `npm run format:check`; conferir telas e interações no navegador. Não criar `.spec.ts` ou testes automatizados do Angular nesta fase de aprendizado.

**Demonstração de aceite:** consultar horários, reservar com dados fictícios, mostrar o comprovante e provar que a vaga ocupada não aceita outra reserva. Conferir a gravação no H2 local, sem criar uma tela administrativa.

**Onde parar:** encerrar após esse fluxo funcionar e os testes críticos passarem. Não adicionar funcionalidades extras antes disso. Este roteiro não constitui uma implementação já concluída.

## O que fica para depois

- Login, papéis, permissões, usuários e área administrativa.
- Cadastros de estudantes, supervisores, clínicas, ambientes e equipamentos.
- Upload, análise e histórico de documentos; validação real da aptidão documental.
- Configuração do semestre e cálculo completo de elegibilidade acadêmica.
- Capacidade compartilhada entre ofertas, supervisão de estudantes e recursos com intervalos sobrepostos. Neste recorte, a regra implementada é somente a capacidade por horário independente.
- Portal do estudante e telas de perfil, documentos e horários elegíveis.
- Listagem interna, consulta posterior de comprovante, confirmação e cancelamento de agendamentos.
- Dashboards, relatórios, auditoria completa, catálogos, modais avançados e biblioteca completa do Figma.
- Persistência além da sessão do H2, notificações, PDF e implantação em produção.

Não apresentar os dados fictícios pré-configurados como funcionalidades concluídas. A entrega é uma demonstração local de consulta e reserva, não o MVP completo das nove UCs.
