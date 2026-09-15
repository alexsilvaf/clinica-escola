# Padrão visual da documentação

[Início](../README.md) · [Documentação](README.md) · [Design](design/README.md)

Este guia orienta a apresentação dos arquivos Markdown do projeto. A prioridade é encontrar informações rapidamente, distinguir avisos de conteúdo comum e manter a leitura confortável no GitHub e no editor.

## Organização e navegação

- Usar um único título `#` por arquivo e seções `##`, com subseções `###` quando necessário.
- Deixar uma linha em branco entre títulos, parágrafos, listas, tabelas e blocos de código.
- Incluir links relativos para o índice da documentação e para o documento pai.
- Em documentos longos, oferecer sumário clicável; usar `<details>` e `<summary>` para recolher apenas essa navegação ou informações complementares.
- Manter regras, critérios de aceitação e advertências essenciais visíveis, sem escondê-los em seções recolhidas.

Links relativos acompanham o repositório, e seções recolhíveis permitem reduzir o volume inicial de conteúdo. Referências: [sintaxe e navegação no GitHub](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax), [seções recolhíveis](https://docs.github.com/en/get-started/writing-on-github/working-with-advanced-formatting/organizing-information-with-collapsed-sections).

## Recursos visuais adotados

| Recurso              | Usar para                                          | Evitar                                                 |
| -------------------- | -------------------------------------------------- | ------------------------------------------------------ |
| Títulos e subtítulos | Hierarquia e navegação                             | Texto em negrito fazendo o papel de título             |
| Tabelas              | Campos de referência, requisitos e comparações     | Transformar todo parágrafo em tabela                   |
| Listas               | Ações, condições e informações sequenciais         | Listas sem separação do parágrafo anterior             |
| Checklists           | Acompanhar as etapas planejadas no roteiro         | Marcar como concluído o que ainda não foi implementado |
| Código em linha      | IDs, rotas, comandos e nomes técnicos              | Usar como decoração de texto comum                     |
| Alertas              | Restrições de escopo e cuidados essenciais         | Destacar todos os parágrafos                           |
| Blocos de código     | Exemplos copiáveis com linguagem identificada      | Misturar comandos com explicações dentro do bloco      |
| Mermaid              | Fluxos com dependências ou ramificações relevantes | Diagramas que repetem uma lista simples                |

Os alertas do GitHub usam citações com tipos como `NOTE`, `IMPORTANT` e `WARNING`; limitar seu uso a informações essenciais. Blocos com linguagem identificada permitem destaque de sintaxe, e Mermaid é suportado em arquivos Markdown no GitHub. Referências: [alertas e checklists](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax), [blocos de código](https://docs.github.com/en/get-started/writing-on-github/working-with-advanced-formatting/creating-and-highlighting-code-blocks), [diagramas](https://docs.github.com/en/get-started/writing-on-github/working-with-advanced-formatting/creating-diagrams).

## Critérios e rastreabilidade

- Apresentar cada cenário com os itens **Dado**, **Quando** e **Então**, incluindo **E** quando já fizer parte da condição.
- Preservar os IDs de UCs, histórias, regras, requisitos e critérios.
- Não alterar prioridade, status, política ou regra de negócio para melhorar a apresentação.
- Manter o recorte reduzido do [README principal](../README.md) distinto da especificação completa.
- Não adicionar links para relatórios locais ignorados pelo Git nem publicar o link privado do protótipo.

## Ferramentas e verificação

### Visualizar no editor

No VS Code, usar `Ctrl+Shift+V` para abrir a prévia ou `Ctrl+K V` para vê-la ao lado do texto. O editor oferece navegação por títulos e recursos de verificação de links. Referência: [Markdown no VS Code](https://code.visualstudio.com/docs/languages/markdown).

### Formatar com Prettier

O projeto já possui Prettier nas dependências do frontend. Após instalar essas dependências, executar a partir da raiz:

```bash
node frontend/node_modules/prettier/bin/prettier.cjs --write --ignore-path .gitignore "*.md" "backend/*.md" "frontend/*.md" "documentacao/**/*.md"
```

Para apenas verificar, substituir `--write` por `--check`. A configuração da raiz mantém `proseWrap: "preserve"`: o formatador não força novas quebras nos parágrafos. Tabelas e espaçamento ficam padronizados. Referência: [opções do Prettier](https://prettier.io/docs/options).

### Validar com markdownlint

A configuração [.markdownlint-cli2.jsonc](../.markdownlint-cli2.jsonc) verifica a estrutura e exclui dependências, arquivos gerados e relatórios locais. Executar a partir da raiz:

```bash
npm exec --yes --package=markdownlint-cli2@0.23.2 -- markdownlint-cli2
```

O comando obtém a ferramenta pelo npm sem adicioná-la às dependências do projeto. As regras mantêm a hierarquia e os separadores consistentes; o limite de tamanho de linha fica desabilitado para não prejudicar tabelas e links longos. Referência: [markdownlint-cli2](https://github.com/DavidAnson/markdownlint-cli2).

Ao editar títulos, conferir também os links do sumário. Não é necessário instalar extensões do editor para ler os arquivos no GitHub.
