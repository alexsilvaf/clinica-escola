# Clínica Escola — Web

[Início](../README.md) · [Backend](../backend/README.md) · [Documentação](../documentacao/README.md)

Projeto Angular **22.1.6**, com CLI/build **22.1.8**, TypeScript **6.0.x**,
SCSS e componentes standalone. Usa a configuração moderna sem `AppModule`
e sem `zone.js`; não é necessário adicionar módulos legados para routing.

<details>
<summary>Sumário — navegar pelas seções</summary>

- [Executar o frontend](#executar-o-frontend)
- [Comandos úteis](#comandos-úteis)
- [Routing e HTTP](#routing-e-http)
- [Gerar componentes e serviços](#gerar-componentes-e-serviços)
- [Horários disponíveis — página componentizada e mockada](#horários-disponíveis--página-componentizada-e-mockada)
- [Strict e aprendizado inicial](#strict-e-aprendizado-inicial)
- [Referências](#referências)

</details>

## Executar o frontend

### 1 — Instalar e verificar o Git

Baixe o [Git](https://git-scm.com/downloads), conclua a instalação e abra um
novo terminal. Confirme que o comando está disponível:

```bash
git --version
```

### 2 — Instalar e verificar o Node.js

Instale o [Node.js](https://nodejs.org/) **24.15.0 ou superior da linha 24**,
linha selecionada pelo arquivo `.nvmrc` e versão mínima definida no campo
`engines` do `package.json`. Esse campo também declara as outras linhas
compatíveis.

Após instalar, abra um novo terminal e verifique o Node.js e o npm:

```bash
node --version
npm --version
```

O primeiro comando deve mostrar `v24.15.0` ou uma versão mais recente da linha 24. O npm é instalado junto com o Node.js.

### 3 — Baixar o projeto

Escolha uma pasta de trabalho e execute:

```bash
git clone https://github.com/alexsilvaf/clinica-escola.git
cd clinica-escola/frontend
```

Se o projeto já estiver baixado, basta abrir o terminal na pasta `frontend`.

### 4 — Instalar as dependências

```bash
npm ci
```

Como o projeto possui `package-lock.json`, `npm ci` é o comando recomendado
para obter uma instalação limpa e reproduzível. Use `npm install` quando for
adicionar, remover ou atualizar uma dependência e precisar alterar o lockfile.

### 5 — Iniciar o servidor de desenvolvimento

```bash
npm start
```

Quando o terminal indicar que a compilação terminou, abra
[localhost:4200](http://localhost:4200). O servidor acompanha alterações nos
arquivos e recompila a aplicação automaticamente. Para encerrá-lo, pressione
`Ctrl+C`.

Para usar as chamadas `/api`, mantenha também o backend em execução conforme o
[passo a passo da API](../backend/README.md#executar-o-backend). O proxy local
encaminha essas chamadas para `http://localhost:8080`.

## Comandos úteis

Execute os comandos abaixo dentro da pasta `frontend`:

```bash
npm start
npm run build
npm run format:check
```

- `npm start`: inicia o ambiente local;
- `npm run build`: gera o build de produção em
  `dist/clinica-escola-web/browser`;
- `npm run format:check`: verifica a formatação sem alterar os arquivos.

Se `node`, `npm` ou `git` não for reconhecido, feche e reabra o terminal após a
instalação e confirme que o programa foi adicionado ao `PATH`. Se houver erro de
versão do Node.js, instale a versão informada na etapa 2 e repita `npm ci`.

Se o PowerShell informar que `npm.ps1` não pode ser executado por causa da
política de execução, use os executáveis do Windows sem alterar essa política:

```powershell
npm.cmd ci
npm.cmd start
```

## Routing e HTTP

`app.config.ts` registra `provideRouter(routes)` e `provideHttpClient()`.
O componente raiz contém `RouterOutlet`. `app.routes.ts` carrega a página
inicial via `loadComponent` (lazy loading) e redireciona rotas desconhecidas
para ela. Definir uma página 404 quando houver navegação real.

O proxy de desenvolvimento encaminha `/api/**` para `http://localhost:8080`
preservando o caminho. Nos services usar URLs relativas, por exemplo,
`/api/v1/estudantes`. Não há endpoints de negócio implementados ainda.
Em produção, configurar o servidor/gateway para encaminhar `/api/**` e
servir `index.html` ao acessar diretamente as rotas da SPA; o proxy do CLI
não faz parte do build publicado.

## Gerar componentes e serviços

```bash
npm run ng -- generate component components/resumo-agendamento
npm run ng -- generate component features/agendamento/pages/dados-agendamento
npm run ng -- generate service features/agendamento/services/agendamento
```

O CLI gera componentes standalone com template `.html`, estilo `.scss`
separados, sem arquivos de teste. Components, services, guards e demais artefatos
usam `skipTests: true` no `angular.json`, para não gerar `.spec.ts` nesta etapa.
Nomes sem o sufixo `.component`, como `app.ts` e `horarios-disponiveis.ts`,
são a convenção atual do CLI, não uma falha de estrutura.

Organizar funcionalidades em `src/app/features` e os componentes de apresentação
em `src/app/components`, cada um na sua pasta. Introduzir `core` para
infraestrutura global (ex.: interceptors, autenticação) quando necessário;
não duplicar os componentes em uma segunda pasta `shared`.

## Horários disponíveis — página componentizada e mockada

A rota `/` apresenta **Horários disponíveis**, com três dias de horários fictícios,
cartões selecionáveis, bloqueio dos indisponíveis e estados de carregamento,
lista vazia e erro. Os componentes ficam separados em `src/app/components`;
a página em `src/app/features/horarios-disponiveis` compõe a tela e consulta
`HorariosService`, que ainda usa mocks locais.

Selecionar um horário somente demonstra a interação. Não há reserva, formulário,
comprovante ou chamada à API de negócio nesta implementação.

Ver a [referência de estrutura, componentes e boas práticas](src/app/components/README.md)
para entender os inputs, outputs, estado reativo e ponto de integração futura.

## Strict e aprendizado inicial

Conforme solicitado, `tsconfig.json` declara explicitamente:

```json
{
  "compilerOptions": { "strict": false },
  "angularCompilerOptions": { "strictTemplates": false }
}
```

As verificações independentes de retorno, sobrescrita, fall-through e injeção
foram mantidas. `strict: false` reduz a segurança de tipos; reavaliar a opção
quando a equipe estiver confortável, sem bloquear o desenvolvimento inicial.

O frontend não possui `.spec.ts`, target `test`, comandos `npm test`/`test:watch`
ou dependências diretas de Vitest/jsdom. Por decisão didática, os testes
automatizados do Angular ficam para uma etapa futura. Nesta fase, validar a
aplicação pelo build e pela conferência das telas e interações no navegador.

## Referências

- [Versões do Angular](https://angular.dev/reference/releases)
- [Compatibilidade](https://angular.dev/reference/versions)
- [Opções do compilador](https://angular.dev/reference/configs/angular-compiler-options)
