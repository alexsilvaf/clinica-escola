# Clínica Escola — Web

[Início](../README.md) · [Backend](../backend/README.md) · [Documentação](../documentacao/README.md)

Projeto Angular **22.1.6**, com CLI/build **22.1.8**, TypeScript **6.0.x**,
SCSS e componentes standalone. Usa a configuração moderna sem `AppModule`
e sem `zone.js`; não é necessário adicionar módulos legados para routing.

<details>
<summary>Sumário — navegar pelas seções</summary>

- [Ambiente e comandos](#ambiente-e-comandos)
- [Routing e HTTP](#routing-e-http)
- [Gerar componentes e serviços](#gerar-componentes-e-serviços)
- [Strict e testes](#strict-e-testes)
- [Referências](#referências)

</details>

## Ambiente e comandos

Usar Node.js 24.15.0 ou superior da linha 24 (ver `.nvmrc` e `engines`).
Outras linhas aceitas pelo Angular estão declaradas em `package.json`.

```bash
npm ci
npm start
npm test
npm run build
npm run format:check
```

O frontend estará em `[localhost:4200](http://localhost:4200)`. Para acompanhar testes em tempo
real, usar `npm run test:watch`. O build de produção fica em
`dist/clinica-escola-web/browser`.

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
npm run ng -- generate component features/estudantes/pages/lista-estudantes
npm run ng -- generate service features/estudantes/services/estudante
```

O CLI gera componentes standalone com template `.html`, estilo `.scss`
separados e arquivo de teste. Services, guards e demais artefatos também
mantêm a geração de testes habilitada. Nomes curtos como `app.ts` e `home.ts`
são a convenção atual do CLI, não uma falha de estrutura.

Organizar funcionalidades em `src/app/features`. Introduzir `core` para
infraestrutura global (ex.: interceptors, autenticação) e `shared` para
componentes/pipes realmente reutilizados, quando necessário.

## Strict e testes

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

O target `test` usa o builder oficial `@angular/build:unit-test` com Vitest/jsdom.
Os testes iniciais cobrem componente raiz, cliente HTTP, rota inicial lazy-loaded
e redirecionamento. E2E e lint podem ser adicionados conforme o produto crescer.

## Referências

- [Versões do Angular](https://angular.dev/reference/releases)
- [Compatibilidade](https://angular.dev/reference/versions)
- [Opções do compilador](https://angular.dev/reference/configs/angular-compiler-options)
