# Especificação de telas

[Início](../../README.md) · [Documentação](../README.md) · [Índice de design](README.md)

Este documento diz **o que cada tela precisa informar e fazer**. Ele existe porque a interface não deve carregar referência de documentação: nenhum código de caso de uso, requisito ou norma aparece para quem usa o sistema. A rastreabilidade fica aqui.

| Informação         | Valor                                    |
| ------------------ | ---------------------------------------- |
| Protótipo          | Clínica-Escola — Sistema de Gestão (MVP) |
| Status             | Em validação                             |
| Última atualização | 15 de setembro de 2026                   |

<details>
<summary>Sumário — navegar pelas seções</summary>

- [Como usar](#como-usar)
- [Convenções de exibição de dados](#convenções-de-exibição-de-dados)
  - [1. Tempo com situação embutida](#1-tempo-com-situação-embutida)
  - [2. Medidor de capacidade](#2-medidor-de-capacidade)
  - [3. Anel de ocupação](#3-anel-de-ocupação)
  - [4. Minigráfico semanal](#4-minigráfico-semanal)
  - [5. Variação com base declarada](#5-variação-com-base-declarada)
  - [6. Quando ainda usar etiqueta de estado](#6-quando-ainda-usar-etiqueta-de-estado)
  - [7. Cor de marca não é cor de dado](#7-cor-de-marca-não-é-cor-de-dado)
  - [8. Regra de entropia: coluna que quase não varia deixa de ser coluna](#8-regra-de-entropia-coluna-que-quase-não-varia-deixa-de-ser-coluna)
  - [9. Colunas que se juntam](#9-colunas-que-se-juntam)
  - [10. Cartão explicativo não é interface](#10-cartão-explicativo-não-é-interface)
  - [11. Nada de valor derivável repetido](#11-nada-de-valor-derivável-repetido)
  - [12. Etiqueta não é o padrão para resultado de verificação](#12-etiqueta-não-é-o-padrão-para-resultado-de-verificação)
  - [13. Indicador é número, não parágrafo](#13-indicador-é-número-não-parágrafo)
  - [14. Um dado, uma linha: campo não quebra texto](#14-um-dado-uma-linha-campo-não-quebra-texto)
  - [15. Alinhamento pela linha do controle](#15-alinhamento-pela-linha-do-controle)
  - [16. Ícone no lugar do rótulo, só na tabela](#16-ícone-no-lugar-do-rótulo-só-na-tabela)
  - [17. O mesmo fato não se repete na mesma tela](#17-o-mesmo-fato-não-se-repete-na-mesma-tela)
  - [18. Toda ação e todo item de menu levam a algum lugar](#18-toda-ação-e-todo-item-de-menu-levam-a-algum-lugar)
  - [19. Alinhamento: o que é verificado antes de fechar uma tela](#19-alinhamento-o-que-é-verificado-antes-de-fechar-uma-tela)
  - [20. Consistência entre telas do mesmo fluxo](#20-consistência-entre-telas-do-mesmo-fluxo)
  - [21. Protótipo navegável: ligação conferida, não descrita](#21-protótipo-navegável-ligação-conferida-não-descrita)
  - [22. Dados coerentes entre telas](#22-dados-coerentes-entre-telas)
- [Estrutura final das tabelas](#estrutura-final-das-tabelas)
- [Estados obrigatórios](#estados-obrigatórios)
  - [Acessibilidade exigida em todas as telas](#acessibilidade-exigida-em-todas-as-telas)
- [Especificação por tela · área interna](#especificação-por-tela--área-interna)
  - [Entrar no sistema](#entrar-no-sistema)
  - [Painel da operação](#painel-da-operação)
  - [Estudantes · lista](#estudantes--lista)
  - [Estudante · cadastro](#estudante--cadastro)
  - [Validação de documentação](#validação-de-documentação)
  - [Professores e preceptores](#professores-e-preceptores)
  - [Capacidade de supervisão](#capacidade-de-supervisão)
  - [Clínicas, ambientes e equipamentos](#clínicas-ambientes-e-equipamentos)
  - [Configuração do semestre](#configuração-do-semestre)
  - [Calendário da oferta acadêmica](#calendário-da-oferta-acadêmica)
  - [Usuários e permissões](#usuários-e-permissões)
  - [Auditoria](#auditoria)
  - [Agendamentos · visão da clínica](#agendamentos--visão-da-clínica)
  - [Cadastro de supervisor](#cadastro-de-supervisor)
  - [Usuário e papel](#usuário-e-papel)
  - [Ambiente e capacidade](#ambiente-e-capacidade)
  - [Clínicas · tabela de ambientes](#clínicas--tabela-de-ambientes)
- [Especificação por tela · portal do estudante](#especificação-por-tela--portal-do-estudante)
  - [Meus documentos](#meus-documentos)
  - [Horários elegíveis](#horários-elegíveis)
  - [Meu perfil](#meu-perfil)
- [Especificação por tela · portal da comunidade](#especificação-por-tela--portal-da-comunidade)
  - [Início e busca de serviços](#início-e-busca-de-serviços)
  - [Horários disponíveis](#horários-disponíveis)
  - [Dados mínimos](#dados-mínimos)
  - [Comprovante](#comprovante)
  - [Gerenciar meu agendamento](#gerenciar-meu-agendamento)
  - [Endereços, horários e acessibilidade](#endereços-horários-e-acessibilidade)
  - [Presença confirmada e atendimento cancelado](#presença-confirmada-e-atendimento-cancelado)
  - [Adicionar do catálogo (diálogo)](#adicionar-do-catálogo-diálogo)
  - [Conflito pela última vaga](#conflito-pela-última-vaga)
  - [Cancelamento público (diálogo)](#cancelamento-público-diálogo)
  - [Fluxo móvel (390 px)](#fluxo-móvel-390-px)
- [Organização das páginas do protótipo](#organização-das-páginas-do-protótipo)
- [Mapa de ações e destinos](#mapa-de-ações-e-destinos)
  - [Área interna](#área-interna)
  - [Portal do estudante](#portal-do-estudante)
  - [Portal da comunidade](#portal-da-comunidade)
  - [Ações habilitadas que ficam sem ligação, e por quê](#ações-habilitadas-que-ficam-sem-ligação-e-por-quê)
  - [Ações retiradas por dependerem de decisão pendente](#ações-retiradas-por-dependerem-de-decisão-pendente)
- [Elementos retirados por não constarem na documentação](#elementos-retirados-por-não-constarem-na-documentação)
  - [Extrapolações que permanecem, com ressalva](#extrapolações-que-permanecem-com-ressalva)
- [Rastreabilidade](#rastreabilidade)
- [Pendências que a interface expõe sem resolver](#pendências-que-a-interface-expõe-sem-resolver)

</details>

## Como usar

| Seção                           | Para quem                                                       |
| ------------------------------- | --------------------------------------------------------------- |
| Convenções de exibição de dados | quem desenha telas novas e quem implementa componentes          |
| Estados obrigatórios            | quem implementa qualquer tela com lista, formulário ou consulta |
| Especificação por tela          | quem implementa aquela tela específica                          |
| Rastreabilidade                 | quem valida o atendimento aos requisitos                        |

Regra de escrita da interface: **o texto visível fala de clínica, estudante, horário e documento — nunca de requisito, norma ou heurística.** Em vez de “RF-002.06 · o bloqueio é automático”, a tela diz “O bloqueio é automático e some assim que o documento for aprovado”.

---

## Convenções de exibição de dados

O sistema evita a tabela genérica em que cada informação vira uma coluna com uma etiqueta colorida. Um dado bem exibido carrega mais de uma informação ao mesmo tempo, sem pedir mais espaço.

### 1. Tempo com situação embutida

**Onde:** fila de análise de documentos (coluna “Enviado e situação”) e auditoria (coluna “Quando e resultado”).

Em vez de uma coluna `ENVIADO` com “há 3 dias” e outra coluna `SITUAÇÃO` com uma etiqueta, um único bloco carrega as duas informações:

| Situação   | Marcador                       | Cor do tempo | Rótulo abaixo             |
| ---------- | ------------------------------ | ------------ | ------------------------- |
| Em análise | círculo preenchido             | azul         | `em análise`              |
| Pendente   | círculo vazado com anel grosso | âmbar        | `pendente · falta enviar` |
| Recusado   | `✕`                            | vermelho     | `recusado em 12/09`       |
| Aprovado   | `✓`                            | verde        | `concluída`               |
| Neutro     | círculo vazado fino            | cinza        | contexto livre            |

Três camadas redundantes garantem que a informação não dependa da cor: **forma do marcador**, **cor do texto** e **rótulo escrito**. O nome acessível do bloco é a frase completa (“em análise há 3 dias”), não apenas o tempo.

**Obrigatório:** uma legenda “Como ler a coluna X” acima da tabela, antes do primeiro uso da codificação.

### 2. Medidor de capacidade

**Onde:** lista de supervisores (coluna “Supervisão simultânea”), capacidade efetiva da clínica.

Duas informações em um bloco: o número absoluto (`6 de 8`) e a barra de proporção. A folga não é repetida em texto — a fração já a entrega. Cor: marca quando há folga, âmbar a partir de 75% de ocupação, vermelho quando esgotado, com borda mais grossa no esgotamento para não depender só de cor.

### 3. Anel de ocupação

**Onde:** indicador de capacidade de supervisão no painel.

Percentual em leitura periférica. O anel é decorativo: valor e legenda carregam o dado, e o cartão continua legível em preto e branco. Sempre acompanhado do número absoluto (`149 de 196 vagas ocupadas agora`) e, quando houver risco, de uma linha de consequência (`3 supervisores já estão no limite e recusam novas inscrições`).

### 4. Minigráfico semanal

**Onde:** indicador de agendamentos do dia no painel.

Sete barras, uma por dia, com o dia atual destacado. Serve para comparar ritmo, não para ler valores exatos — por isso vem sempre com o número do dia e uma legenda (`pico na sexta · 41 atendimentos`).

### 5. Variação com base declarada

Todo número comparado precisa dizer com o quê: `▲ 12% ante a média das últimas 4 segundas`. Percentual sem base é ruído.

### 6. Quando ainda usar etiqueta de estado

A etiqueta (selo) continua válida quando o estado **não** tem um dado natural para colorir — por exemplo a coluna `SITUAÇÃO` de um cadastro (`Ativo` / `Inativo`) ou a aptidão documental de um estudante na lista. A regra é: se existe um dado que a pessoa já precisa ler (um tempo, um número, uma data), a situação deve viajar nesse dado.

### 7. Cor de marca não é cor de dado

A cor institucional identifica navegação, ação primária e seleção. Contagens e informações neutras usam o selo neutro. Verde, âmbar, vermelho e azul são reservados a estado — nenhum elemento decorativo usa essas cores.

### 8. Regra de entropia: coluna que quase não varia deixa de ser coluna

Uma coluna em que quase todas as linhas mostram o mesmo valor ocupa espaço e não informa — a coluna `SITUAÇÃO` com seis etiquetas “Ativo” idênticas é ruído puro. A regra é:

| Situação do dado                                             | Tratamento                                                                                                                           |
| ------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------ |
| Varia pouco e o padrão é o esperado (ativo, disponível)      | vira filtro padrão da lista; a exceção aparece na própria linha                                                                      |
| A exceção precisa ser notada (inativo, bloqueado)            | linha esmaecida, faixa lateral colorida e o motivo escrito junto ao nome (`inativa desde 03/07`, `bloqueado até 16/09 · manutenção`) |
| Varia de verdade e orienta a ação (documentação, capacidade) | permanece como coluna, usando os padrões 1 a 3                                                                                       |

### 9. Colunas que se juntam

Dois dados sobre a mesma entidade viram uma célula de duas linhas: o dado que identifica em cima, o contexto embaixo. `Nome + matrícula + curso` cabem em uma coluna; `ambiente + tipo`, `serviço + sala`, `estudante + supervisor` também. O componente **Célula dupla** padroniza isso, com variante esmaecida para registros inativos.

O limite prático adotado: **no máximo quatro colunas por tabela**, mais a coluna de ação. Acima disso a leitura vira varredura.

### 10. Cartão explicativo não é interface

Um cartão que só explica regra (“Regras aplicadas nesta fila”, “Garantias da reserva”, “O que é auditado”) é documentação ocupando a tela. Ou vira conteúdo acionável — “No limite agora”, com os supervisores esgotados e os botões de ajuste —, ou sai da tela e fica neste documento. Aviso curto acoplado a uma decisão que a pessoa está tomando naquele instante continua válido.

### 11. Nada de valor derivável repetido

`6 de 8` já informa que há duas vagas; escrever “2 livres” ao lado é ruído. A regra: **um dado por informação**. O que o leitor consegue derivar em um passo — a folga a partir da fração, a validade a partir da data de aprovação, o autor da decisão a partir do registro — não ganha um segundo texto.

Aplicações:

| Antes                                                                                                                                      | Depois                                                                |
| ------------------------------------------------------------------------------------------------------------------------------------------ | --------------------------------------------------------------------- |
| célula da matriz com `6/8` e `2 livres`                                                                                                    | `6/8` com a cor da faixa e borda mais grossa quando esgotado          |
| medidor com `6 de 8` e `2 livres`                                                                                                          | `6 de 8` com barra proporcional                                       |
| cartão de documento com “Recusado em 12/09 por Marcos Reis” na linha de metadados **e** etiqueta “Recusado” **e** data no bloco de decisão | metadados com quem analisou, bloco de decisão com `recusado em 12/09` |

### 12. Etiqueta não é o padrão para resultado de verificação

Lista de verificação com uma pílula `OK` repetida em toda linha não informa — a repetição vira textura. Nessas listas a situação passa a ser dada pelo **marcador e pela cor do próprio título**, com o dado que sustenta o resultado abaixo. O componente **Item de verificação** cobre os quatro casos: conforme (`✓` verde), atenção (anel âmbar), impedimento (`✕` vermelho) e neutro (círculo vazado).

A etiqueta continua válida onde é o único portador do estado de um registro isolado — situação de um documento numa fila curta, por exemplo — e onde funciona como chip removível (vínculos do estudante).

### 13. Indicador é número, não parágrafo

Um indicador tem três partes e nada além disso: **rótulo em uma linha**, **número** e **até duas linhas de contexto**. Enumerar uma lista dentro dele (“Master, responsável, professor, preceptor, estudante e comunidade”) transforma o cartão em texto corrido e destrói a comparação visual entre os cartões da linha. O contexto escolhido deve ser o que muda a decisão — `de 154 estudantes ativos`, `recusando novas inscrições` — e nunca repetir o que já está em outro bloco da mesma tela.

Regras de layout da linha de indicadores:

- todos os cartões preenchem a mesma altura, independentemente do tamanho do texto;
- o número fica sempre na mesma posição vertical, para permitir a leitura em varredura;
- gráfico dentro do indicador (anel, barra) fica ao lado do número, nunca no lugar dele;
- texto que não couber em duas linhas pertence ao corpo da tela.

### 14. Um dado, uma linha: campo não quebra texto

Valor de campo ocupa **uma única linha**, com truncamento por reticências quando não couber. Endereço de e-mail quebrado em duas linhas desalinha o formulário inteiro e sugere um erro que não existe. O conteúdo completo continua disponível ao foco, ao leitor de tela e na edição.

### 15. Alinhamento pela linha do controle

Quando um botão acompanha um campo, ele se alinha à **linha do campo**, não ao bloco inteiro — o rótulo acima e o texto de apoio abaixo não deslocam a ação. O mesmo vale para a barra de filtros: os filtros alinham pela caixa de busca, não pelo topo do rótulo. Na prática: o texto de apoio da busca sai da barra de filtros e a ação recebe o recuo equivalente à altura do rótulo.

### 16. Ícone no lugar do rótulo, só na tabela

Ação que se repete linha a linha vira **botão de ícone** (componente próprio, alvo de 40 px). Vale porque o objeto da ação está na própria linha e o rótulo repetido oito vezes vira textura. Exigências: nome acessível completo (“Abrir cadastro de Bruno Lima Carvalho”), dica no foco e na passagem do ponteiro, e um único significado de ícone em todo o sistema.

Mantêm o rótulo escrito: ação primária de tela, ação destrutiva, ação única em cartão ou formulário, e qualquer ação do fluxo público — ali a clareza vale mais que a economia de espaço.

### 17. O mesmo fato não se repete na mesma tela

Varredura feita em todas as telas. Correções aplicadas:

| Onde                                          | Repetição                                                                        | Correção                                                                     |
| --------------------------------------------- | -------------------------------------------------------------------------------- | ---------------------------------------------------------------------------- |
| Estudantes, documentação, usuários, auditoria | o total aparecia no contexto do cabeçalho, no indicador e no rodapé da lista     | o cabeçalho passou a trazer outra informação (bloqueados, atrasados, escopo) |
| Painel                                        | “26 com pendência documental” no indicador e no bloco de bloqueios               | ficou só no bloco de bloqueios, que é acionável                              |
| Usuários                                      | “14 acessos negados” no indicador e no cartão lateral                            | ficou só no indicador                                                        |
| Clínicas                                      | “cadeira OD-02” na coluna de equipamentos, no motivo do bloqueio e no formulário | o motivo passou a dizer apenas “manutenção”                                  |
| Portal do estudante                           | pendência descrita no aviso do topo e repetida no cartão de situação             | ficou só no aviso                                                            |
| Meu agendamento                               | prazo no bloco de situação e em linha própria                                    | fundiu-se na situação: “Aguardando sua confirmação · até 14/09 às 20h00”     |
| Auditoria                                     | total de registros no resumo e no rodapé                                         | ficou só no rodapé                                                           |

### 18. Toda ação e todo item de menu levam a algum lugar

Item de navegação sem tela e botão sem destino são dívida de projeto: prometem uma função que não existe. A conferência é parte do fechamento do protótipo — lista-se cada item da barra lateral, cada aba do portal, cada link do cabeçalho público e cada rótulo de botão, e confronta-se com as telas existentes. Só há duas saídas possíveis: a tela é feita, ou a ação sai da interface.

Resultado da conferência feita em 15/09/2026:

| Ação sem destino                                     | Desfecho                                                                                                                                                        |
| ---------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Novo supervisor · Ajustar limite                     | tela **Cadastro de supervisor** criada                                                                                                                          |
| Novo usuário · Revogar papel · Revisar perfis        | tela **Usuário e papel** criada                                                                                                                                 |
| Adicionar ambiente · Editar capacidades              | tela **Ambiente e capacidade** criada                                                                                                                           |
| Aba Meu perfil (portal do estudante)                 | tela **Meu perfil** criada                                                                                                                                      |
| Endereços e horários · Acessibilidade (site público) | página **Endereços, horários e acessibilidade** criada                                                                                                          |
| Esqueci minha senha                                  | **removido** — a documentação não define recuperação de senha; o aviso do login passou a indicar o perfil Master, que é quem cria e redefine acesso (RF-009.03) |
| Falar com a coordenação                              | **removido** — não havia canal definido para essa ação                                                                                                          |

Os dez itens da barra lateral interna têm tela própria.

### 19. Alinhamento: o que é verificado antes de fechar uma tela

Alinhamento não se confere a olho — as falhas mais irritantes são de 1 a 3 px e aparecem em telas diferentes das que foram revisadas. O protótipo é varrido por um verificador que percorre todos os quadros e reprova oito condições:

| Verificação                    | O que reprova                                                          |
| ------------------------------ | ---------------------------------------------------------------------- |
| Colunas de tabela              | qualquer célula que não comece exatamente no mesmo x do seu cabeçalho  |
| Deslocamento vertical          | elemento posicionado em meio pixel dentro de um contêiner centralizado |
| Botão ao lado de campo         | botão irmão de um campo sem o recuo que o alinha à linha do controle   |
| Cartões na mesma linha         | grupo de três ou mais cartões com diferença de altura acima de 8 px    |
| Espaçamento                    | recuo ou espaço fora da escala adotada                                 |
| Texto com altura travada       | texto que não cresce com o conteúdo e por isso corta                   |
| Texto quebrando em célula fixa | conteúdo que passa a ocupar duas linhas dentro de largura fixa         |
| Conteúdo cortado               | quadro cuja altura é menor que o conteúdo                              |

Causas encontradas na varredura de 15/09/2026, todas corrigidas:

| Causa                                                   | Efeito                                                                                                               | Correção                                                         |
| ------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------- |
| Altura de linha em porcentagem                          | 13 px × 150% = 19,5 px, e o meio pixel se propagava para 768 elementos                                               | todas as alturas de linha passaram a ser pixels inteiros e pares |
| Faixa lateral de 3 px em linha de tabela                | a borda empurrava o conteúdo da linha destacada, desalinhando a coluna                                               | recuo esquerdo compensado em 3 px nessas linhas                  |
| Borda de 1 px em contêiner centralizado                 | a área interna ficava ímpar e o conteúdo caía em meio pixel — era o caso da barra superior e da matriz de permissões | recuo superior compensado em 1 px                                |
| Glifo de marcador com altura de linha maior que a caixa | o `✓` e o `✕` ficavam meio pixel fora do centro                                                                      | altura de linha do glifo igualada à caixa                        |
| Etapas do semestre com rótulo em duas linhas            | uma etapa 24 px mais alta que as outras quatro                                                                       | todas as etapas passaram a preencher a mesma altura              |
| Texto de apoio dentro da barra de filtros               | empurrava a busca e desalinhava os filtros                                                                           | o apoio saiu da barra; os filtros alinham pela caixa de busca    |

Duas condições permanecem e **não** são defeito: largura fracionária de coluna flexível (o navegador resolve no desenho) e posição fracionária de glifo centralizado (depende da métrica da fonte). Ambas foram medidas e isoladas para não poluir o relatório.

### 20. Consistência entre telas do mesmo fluxo

A varredura de alinhamento mede cada tela isoladamente e, por isso, deixou passar um tipo de erro: telas corretas individualmente, mas diferentes entre si. Os estados de uma tela (carregamento, vazio, carga) são a mesma tela em outro momento e precisam ter a mesma estrutura.

| Verificação                      | O que reprova                                                                                                               |
| -------------------------------- | --------------------------------------------------------------------------------------------------------------------------- |
| Cabeçalho e rodapé               | cabeçalho, rodapé ou atalho de teclado montado à mão; página pública sem o rodapé; portal sem o cabeçalho do próprio portal |
| Item ativo da navegação          | barra lateral com item ativo diferente do módulo da tela, ou com mais de um item ativo                                      |
| Filtros do módulo                | telas do mesmo módulo com conjunto ou ordem de filtros diferente                                                            |
| Esqueleto × tabela real          | esqueleto com número de colunas diferente do cabeçalho, ou cabeçalho diferente da tabela real                               |
| Mesmo elemento, mesmo componente | busca, filtro ou paginação montados à mão em vez do componente                                                              |

Divergências encontradas em 15/09/2026, todas corrigidas:

| Divergência                                                                          | Correção                                                                                                                                                                                         |
| ------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| O carregamento da lista de estudantes mostrava as seis colunas antigas               | o esqueleto de linha de tabela foi atualizado no componente para a anatomia atual (duas células duplas, situação e ação) e a tela passou a espelhar cabeçalho, legenda e paginação da lista real |
| O esqueleto de “Refinar busca” eram blocos genéricos                                 | nova variante de esqueleto **Campo** (rótulo, caixa e apoio); o carregamento público ganhou os quatro campos, o botão, o cartão de acessibilidade e os três dias da tela real                    |
| Filtros das telas de estudantes variavam entre 2, 3 e 4                              | as quatro telas usam curso, vínculo, documentação e situação, na mesma ordem                                                                                                                     |
| A ação “Novo estudante” não cabia com quatro filtros aplicados                       | a ação saiu da barra de filtros e foi para o cabeçalho do cartão da lista, igual nas quatro telas                                                                                                |
| Cabeçalho público em quatro variações (com e sem atalho, 0 ou 4 links, 1 ou 2 ações) | componente **Cabeçalho público**, com o atalho de teclado incluso e variante para o link ativo                                                                                                   |
| Rodapé presente em 3 de 10 páginas públicas                                          | componente **Rodapé público**, presente em todas                                                                                                                                                 |
| Cabeçalho do portal do estudante copiado três vezes                                  | componente **Cabeçalho do estudante**, com variante por aba                                                                                                                                      |
| Cabeçalho móvel copiado três vezes, com o sinal de “+” no lugar do menu              | componente **Cabeçalho público · móvel**, com ícone de menu e alvo de 40 px                                                                                                                      |

Com o rodapé adicionado, as alturas foram recalculadas pela altura intrínseca do conteúdo e conferidas elemento a elemento contra o próprio contêiner: nenhuma das 42 telas corta conteúdo.

### 21. Protótipo navegável: ligação conferida, não descrita

Um mapa de destinos escrito não prova navegação. O fechamento do protótipo inspeciona as reações de todos os nós e lista cada botão visível sem ligação, que precisa estar justificado na tabela “Ações habilitadas que ficam sem ligação”.

| Regra                      | Aplicação                                                                                                                                                     |
| -------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Registro certo             | ícone de abrir leva ao quadro do registro daquela linha; não existe “cadastro genérico” preenchido com outra pessoa                                           |
| Criação ≠ edição           | “Novo …” abre quadro vazio; abrir um registro abre o quadro daquele registro, com “Salvar alterações”                                                         |
| Persistência visível       | salvar volta à lista com notificação **no fluxo do conteúdo** (empurra a lista, não cobre filtros nem indicadores) e com a mudança aplicada nas linhas        |
| Diálogos                   | quadros próprios com cortina; “Manter …” e a cortina fecham; confirmar leva ao estado resultante                                                              |
| Escolha que muda o destino | variáveis do protótipo: horário escolhido (`reserva/*`) decide comprovante ou conflito; o que já foi corrigido (`semestre/*`) decide o estado da configuração |
| Mudança local              | variável ligada à visibilidade ou ao rótulo (remover equipamento, copiar código)                                                                              |
| Estados transitórios       | carregamento, ativação e envio avançam sozinhos depois de 1,5 a 2 s                                                                                           |
| Outra página               | portal da comunidade, do estudante e área interna ficam em páginas diferentes; a passagem entre eles usa o link do protótipo                                  |

Resultado da inspeção de 15/09/2026: 120 quadros de uso (Interno 90, Comunidade 21, Estudante 9), 1.400 nós com reação (Interno 1.217, Comunidade 135, Estudante 48), nenhuma reação apontando para quadro inexistente e oito pontos de partida de fluxo nomeados. Os controles visíveis sem reação são exatamente os listados na tabela de justificativas.

### 22. Dados coerentes entre telas

O mesmo registro aparece em várias telas e precisa contar a mesma história. A varredura de 15/09/2026 encontrou e corrigiu:

| Divergência                                                                                                                                                               | Correção                                                                                                             |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------- |
| 15/09/2026 aparecia como segunda-feira no portal público e os dias seguintes com o dia da semana errado                                                                   | todas as datas de setembro foram recalculadas: 15/09 é terça-feira                                                   |
| A mesma reserva mostrava estudante de outro curso (Diego, de Psicologia, numa avaliação de Fisioterapia com pendência documental) e supervisor fora do dia de atendimento | a agenda da Clínica de Fisioterapia usa só estudantes aptos de Fisioterapia sob a Prof.ª Helena Dias, nas salas dela |
| Diego tinha “carteira de vacinação pendente” na lista e “atestado recusado + carteira em análise” no próprio portal                                                       | lista, carga, fila e cadastro seguem o portal: atestado recusado em 12/09 e carteira em análise                      |
| Documento de estudante de Odontologia analisado por professora de Fisioterapia; documento de Psicologia “analisado” por preceptor, papel que a matriz não autoriza        | análises atribuídas à coordenação (perfil Master)                                                                    |
| Estudante apta na lista aparecia na fila com seguro em análise                                                                                                            | a fila passou a mostrar a estudante que de fato tem o seguro em análise                                              |
| “12 estudantes selecionados” com 3 linhas marcadas                                                                                                                        | a contagem é a das linhas marcadas (3), no lote e no diálogo; o cabeçalho da seleção mostra estado parcial           |
| Carga com filtros “Fisioterapia” e “Pendentes” aplicados, mas linhas de outros cursos e estudantes aptos                                                                  | filtros sem valor aplicado; a seleção total passou a “Selecionar os 154”                                             |
| Supervisão “na quarta” para preceptor que atende às terças e quintas; horário com professora inativa                                                                      | datas e supervisor ajustados à disponibilidade declarada                                                             |
| Usuária com “acesso revogado” na lista e “papel ainda atribuído” nos acessos a revisar                                                                                    | a lista mostra “papel ainda atribuído” até a revogação ser confirmada                                                |
| Equipamento do catálogo com o mesmo código de um equipamento já instalado em outra sala                                                                                   | códigos únicos                                                                                                       |
| Validação com “3 supervisores sem limite” e “2 disciplinas sem horário” sem quadros para os demais                                                                        | um impedimento de cada tipo, cada um com a sua correção demonstrada                                                  |

---

## Estrutura final das tabelas

Resultado da revisão de densidade. Todas as tabelas internas foram reconstruídas.

| Tela                      | Antes                                                                                  | Depois                                                                                                                          |
| ------------------------- | -------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- |
| Estudantes                | estudante · matrícula · curso e período · vínculo · documentação · situação · ação (7) | **estudante** (nome + matrícula + curso) · **vínculo** (atividade + supervisor) · **documentação** (data + situação) · ação (4) |
| Professores e preceptores | supervisor · papel · área · ambientes · disponibilidade · supervisão · situação (7)    | **supervisor** (nome + papel e área) · **onde e quando** (ambiente + disponibilidade) · **supervisão simultânea** (medidor) (3) |
| Fila de documentos        | estudante · documento · atividade · enviado · situação (5)                             | **estudante** (nome + curso) · **documento** (nome + atividade) · **enviado e situação** (3)                                    |
| Usuários                  | usuário · papel · escopo · último acesso · situação · ação (6)                         | **usuário** (nome + papel e escopo) · **último acesso** (data + situação) · ação (3)                                            |
| Auditoria                 | data · usuário · operação · objeto · resultado (5)                                     | **quando e resultado** · usuário e papel · operação · objeto (4)                                                                |
| Ambientes da clínica      | ambiente · tipo · atendimentos · estudantes · equipamentos · situação (6)              | **ambiente** (nome + tipo ou bloqueio) · **simultâneos** · **equipamentos** (3)                                                 |
| Agenda do dia (painel)    | horário · pessoa · serviço · estudante · supervisor · situação (6)                     | **horário e situação** · pessoa · **serviço e local** · **estudante e supervisor** (4)                                          |
| Reservas do dia (clínica) | horário · pessoa · serviço · ambiente · equipe · situação (6)                          | **horário e situação** · **pessoa** (iniciais + id) · **serviço e ambiente** · **estudante e supervisor** (4)                   |
| Histórico semestral       | semestre · período · atendimentos · ativado por · situação (5)                         | **semestre e situação** · período letivo · realizado · ativado por (4)                                                          |
| Matriz de permissões      | 11 linhas × 6 papéis com “Permitido/Negado” escrito em caixa colorida                  | mesma grade com `✓` e `–`, legenda acima e sem preenchimento por célula                                                         |

Cartões explicativos removidos das telas e absorvidos por este documento: _Regras aplicadas nesta fila_ (documentação), _Garantias da reserva_ (capacidade), _O que consome capacidade_ (virou “No limite agora”, acionável), _O que é auditado_ (virou “Resumo do período”), _Políticas de acesso_ (virou “Acessos a revisar”), _Como a tela se comporta quando o volume cresce_ (virou a seção de estados deste documento), além da redução de avisos repetidos no fluxo público.

---

## Estados obrigatórios

Nenhuma tela com lista, formulário ou consulta está pronta antes de responder às sete situações abaixo. A página `Estados` do protótipo demonstra cada uma em contexto real.

| Estado           | Gatilho                                 | Comportamento exigido                                                                                                                                                                                                   |
| ---------------- | --------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Carregando       | resposta acima de 300 ms                | esqueleto com a forma do conteúdo real; texto de status descrevendo o que está sendo consultado; `aria-busy` na região e anúncio em região viva ao concluir; acima de 10 s, troca para o estado de erro                 |
| Vazio inicial    | nenhum registro cadastrado              | explicar o que apareceria ali, ensinar a ordem das dependências e oferecer a ação primária                                                                                                                              |
| Vazio por filtro | há registros, o filtro não retorna nada | distinguir explicitamente do caso anterior; listar os filtros ativos como pílulas removíveis; prever quantos resultados voltam ao remover cada um                                                                       |
| Sem permissão    | papel sem autorização                   | dizer o papel exigido e a quem pedir; listar o que a pessoa pode fazer no lugar; registrar a tentativa; nunca carregar o dado protegido                                                                                 |
| Sucesso          | operação concluída                      | notificação temporária + mudança persistente na lista + efeito explicado; desfazer quando a operação admitir; foco do teclado vai para o item alterado                                                                  |
| Erro             | falha de consulta, rede ou servidor     | dizer o que falhou, o que **não** foi afetado, oferecer nova tentativa manual além das automáticas, preservar rascunhos, exibir código curto de ocorrência                                                              |
| Carga            | volume alto de registros                | paginação no servidor (25/50/100), ordenação estável com critério na URL, busca com atraso de 300 ms, seleção que sobrevive à troca de página, ações em lote assíncronas, densidade ajustável, falha isolada por página |

### Acessibilidade exigida em todas as telas

- rótulo visível permanente em todo campo, com texto de apoio explicando a finalidade do dado;
- erro descrito em texto junto ao campo, dizendo o que corrigir;
- alvo mínimo de 40 px de altura em botões, campos, abas, itens de navegação e células clicáveis (36 px na densidade compacta);
- contorno de foco de 2 px, visível e nunca coberto por elemento fixo;
- nenhuma informação transmitida apenas por cor;
- atalho “pular para o conteúdo principal” nas páginas públicas;
- diálogo modal com foco preso, `Esc` para fechar e retorno do foco ao elemento de origem;
- contraste mínimo de 4,5:1 em texto normal e 3:1 em bordas de componente.

---

## Especificação por tela · área interna

### Entrar no sistema

**Origem:** UC-009 · RF-009.01, RF-009.02 · **Ator:** usuário interno

| Item              | Especificação                                                                                                                                  |
| ----------------- | ---------------------------------------------------------------------------------------------------------------------------------------------- |
| Objetivo          | autenticar antes de liberar qualquer função restrita                                                                                           |
| Painel esquerdo   | apresenta a regra central do produto: as seis condições simultâneas de elegibilidade. Serve de contexto institucional, não de instrução de uso |
| Campos            | e-mail institucional e senha, ambos com rótulo visível; a senha exibe o estado de foco com contorno de 2 px                                    |
| Mensagem de apoio | primeiro acesso ou papel sem permissão orienta a pedir criação de usuário ao perfil Master                                                     |
| Rodapé            | informa que operações sensíveis ficam registradas — sem citar o requisito de auditoria                                                         |
| Estados           | erro de credencial (mensagem genérica, sem revelar se o e-mail existe), bloqueio após tentativas repetidas, carregando                         |
| A não fazer       | nunca informar qual dos dois campos está errado; nunca oferecer cadastro público                                                               |

### Painel da operação

**Origem:** visão consolidada das nove UCs · **Ator:** Master e responsável pela clínica

| Indicador                | O que precisa comunicar                                                                                                                                                                                     |
| ------------------------ | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Estudantes aptos         | quantos estudantes podem ocupar horários **agora**, sempre contra o total de ativos (`128 de 154`), e quantos estão bloqueados por documentação. O número sozinho não informa: a leitura útil é a diferença |
| Documentos em análise    | o tamanho da fila e, principalmente, quantos passaram do prazo de análise (`7 aguardam há mais de 48 h`), porque é isso que exige ação                                                                      |
| Capacidade de supervisão | percentual de ocupação em anel, com o número absoluto (`149 de 196 vagas ocupadas agora`) e a consequência concreta (`3 supervisores já estão no limite e recusam novas inscrições`)                        |
| Agendamentos de hoje     | volume do dia, variação contra a média das últimas quatro semanas do mesmo dia da semana e distribuição semanal em minigráfico, para diferenciar pico pontual de tendência                                  |

| Item                     | Especificação                                                                                                                                                         |
| ------------------------ | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Tabela do dia            | horário e situação · pessoa · serviço e local · estudante e supervisor. O horário carrega a situação: confirmado, aguardando confirmação, em confirmação ou cancelado |
| Bloqueios                | lista os motivos que estão **impedindo oferta de horários** nas últimas 24 h, com o efeito quantificado (`capacidade física reduzida em 8 vagas`) e ação direta       |
| Configuração do semestre | atalho para os itens de consistência ainda pendentes                                                                                                                  |
| Estados                  | carregando (esqueleto de cartão), erro isolado por bloco (um indicador falhar não derruba o painel), vazio fora do horário de operação                                |

### Estudantes · lista

**Origem:** UC-001 · RF-001.01 a RF-001.06; coluna Documentação reflete UC-002 · RF-002.06

| Item                | Especificação                                                                                                                                                                                                                                                       |
| ------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Objetivo            | localizar estudantes e enxergar, na própria lista, quem está impedido de ocupar horários                                                                                                                                                                            |
| Busca               | rótulo visível “Buscar estudante”; considera nome, matrícula e e-mail; consulta no servidor após 300 ms sem digitação                                                                                                                                               |
| Filtros             | curso, vínculo, documentação e situação, como pílulas que exibem o valor escolhido e permitem remoção em um clique                                                                                                                                                  |
| Colunas             | estudante (nome, matrícula e curso) · vínculo no semestre (atividade e supervisor) · documentação (data e situação) · ação                                                                                                                                          |
| Coluna Documentação | a data carrega a situação: `apta desde 02/08`, `1 pendência há 3 dias`, `recusado em 12/09`. É a coluna que explica por que um estudante ativo não recebe horários. Quando há mais de um documento com problema, mostra o mais grave (recusado antes de em análise) |
| Ação por linha      | ícone de abrir com alvo próprio; o nome acessível inclui o registro (“Abrir Bruno Lima Carvalho”) e leva ao cadastro daquele estudante                                                                                                                              |
| Inativação em lote  | a contagem da barra de lote é a das linhas marcadas; o diálogo lista os selecionados e, ao confirmar, a lista mostra os registros esmaecidos com “inativo desde” e a barra de lote some                                                                             |
| Rodapé              | recorte exibido, total real, itens por página e navegação de páginas                                                                                                                                                                                                |
| Estados             | carregando, vazio inicial, vazio por filtro, carga (154 registros), sem permissão para editar                                                                                                                                                                       |

### Estudante · cadastro

**Origem:** UC-001 · RF-001.01 a RF-001.05

| Item              | Especificação                                                                                                                                                                                                                                                                                                                                         |
| ----------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Identificação     | nome, matrícula, e-mail e telefone. A matrícula é única no escopo institucional — o erro de duplicidade aparece junto ao campo, com o registro conflitante identificado                                                                                                                                                                               |
| Vínculo acadêmico | curso, período e um ou mais vínculos do semestre, exibidos como pílulas removíveis                                                                                                                                                                                                                                                                    |
| Disponibilidade   | grade de turnos por dia. O texto precisa deixar claro que marcar um turno **não** agenda nada: apenas torna o estudante elegível                                                                                                                                                                                                                      |
| Situação          | seletor Ativo/Inativo com o aviso de que inativar preserva o histórico acadêmico                                                                                                                                                                                                                                                                      |
| Aptidão calculada | lista as seis condições como itens de verificação: marcador, título colorido conforme o resultado e o dado que o sustenta (`Documentação obrigatória · atestado ocupacional recusado em 12/09`). É leitura, não edição. O aviso abaixo muda com o resultado: alerta de pendência, sucesso “apto a receber horários” ou informação de cadastro inativo |
| Barra de ações    | informa que a alteração passa a valer no próximo cálculo e que a operação fica registrada                                                                                                                                                                                                                                                             |
| Modos             | **criação** (“Novo estudante”: campos vazios, só “+ Adicionar vínculo”, grade vazia, aptidão neutra, ações Cancelar · Salvar rascunho · Salvar estudante) · **edição de um registro** (um quadro por estudante das listas, com os dados daquela linha; ações Cancelar · Salvar alterações). A contagem de turnos na aptidão é a da grade exibida      |
| Estados           | rascunho salvo e cadastro salvo (lista com notificação no topo do conteúdo), erro de validação por campo, sem permissão (somente leitura), conflito de matrícula                                                                                                                                                                                      |

### Validação de documentação

**Origem:** UC-002 · RF-002.01 a RF-002.07

| Item                        | Especificação                                                                                                                                     |
| --------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------- |
| Objetivo                    | analisar a fila e decidir cada documento, sabendo o efeito imediato da decisão                                                                    |
| Abas                        | quantidade por situação: em análise, pendentes, recusados, aprovados                                                                              |
| Coluna “Enviado e situação” | aplica o padrão de tempo com situação embutida; substitui a antiga coluna de etiqueta. Ordenação padrão: mais antigo primeiro                     |
| Legenda                     | obrigatória acima da tabela, explicando marcador e cor                                                                                            |
| Painel de análise           | identificação do estudante, visualizador do arquivo, metadados (envio, validade, exigência, envio anterior) e decisão                             |
| Orientação de correção      | obrigatória ao recusar; é exibida integralmente ao estudante                                                                                      |
| Coluna Documento            | nome do documento com a atividade que o exige na segunda linha                                                                                    |
| Estados                     | fila vazia (“nenhum documento aguardando análise”), carregando, sucesso com desfazer de 30 s, erro ao abrir o arquivo, sem permissão para decidir |

### Professores e preceptores

**Origem:** UC-003 · RF-003.01 a RF-003.05; ocupação vem de UC-004

| Indicador                  | O que precisa comunicar                                                                                                                |
| -------------------------- | -------------------------------------------------------------------------------------------------------------------------------------- |
| Supervisores ativos        | o total ativo **e a composição** (`19 professores e 9 preceptores`), porque as regras de supervisão podem diferir entre os dois papéis |
| Capacidade total declarada | a soma dos limites individuais (`196 estudantes simultâneos`), que é o teto teórico da operação no semestre                            |
| Ocupação média             | percentual médio por intervalo, com a ressalva de que é calculado por intervalo e não por dia                                          |
| No limite agora            | quantos supervisores estão recusando novas inscrições neste momento — é o indicador acionável da tela                                  |

| Item                  | Especificação                                                                                        |
| --------------------- | ---------------------------------------------------------------------------------------------------- |
| Colunas               | supervisor (nome, papel e área) · onde e quando (ambiente e disponibilidade) · supervisão simultânea |
| Supervisão simultânea | medidor de capacidade com número absoluto, folga em texto e barra proporcional                       |
| Nota da lista         | supervisor sem disponibilidade declarada não gera oferta de horário, mesmo estando ativo             |
| Estados               | vazio inicial (com importação do semestre anterior), carregando, sem permissão, carga                |

### Capacidade de supervisão

**Origem:** UC-004 · RF-004.01 a RF-004.05; concorrência conforme RNF-008.CON-01

| Item                                             | Especificação                                                                                                                                                                                                                                                                                          |
| ------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Objetivo                                         | mostrar, por supervisor e por intervalo, quantas alocações ativas existem e quanta folga resta                                                                                                                                                                                                         |
| Matriz                                           | linhas por supervisor (com o limite declarado), colunas por intervalo; cada célula traz apenas `ocupadas/limite`, com a faixa de cor ao fundo e borda reforçada quando esgotado                                                                                                                        |
| Escala de cor                                    | verde com folga, âmbar a partir de 75%, vermelho quando esgotado — sempre com o texto correspondente                                                                                                                                                                                                   |
| Escala                                           | legenda com as três faixas em amostras de cor, acima da matriz                                                                                                                                                                                                                                         |
| Tentativa recusada                               | bloco que mostra a última recusa por limite, com horário, supervisor e a garantia de que nenhuma vaga foi consumida                                                                                                                                                                                    |
| No limite agora                                  | lista os supervisores que estão recusando inscrições neste momento, com os intervalos esgotados e ações de ajuste. As regras de consumo de capacidade (confirmado consome, aguardando consome enquanto o prazo estiver aberto, cancelado libera, falta não devolve) ficam neste documento, não na tela |
| Garantias (regra de implementação, fora da tela) | revalidação na confirmação; duas tentativas simultâneas confirmam no máximo uma; alteração de limite não derruba reservas existentes                                                                                                                                                                   |
| Estados                                          | erro ao consultar (demonstrado na página `Estados`), carregando, sem permissão                                                                                                                                                                                                                         |

### Clínicas, ambientes e equipamentos

**Origem:** UC-006 · RF-006.01 a RF-006.06

| Indicador           | O que precisa comunicar                                                                                |
| ------------------- | ------------------------------------------------------------------------------------------------------ |
| Clínicas            | quantas e quais — a lista nominal importa mais que o número                                            |
| Ambientes           | total de consultórios, salas e boxes disponíveis para oferta                                           |
| Equipamentos        | total controlado, indicando que há dois modelos convivendo: unidade identificada e quantidade por tipo |
| Recursos bloqueados | quantos estão fora de operação **e até quando**, porque isso reduz a oferta imediatamente              |

| Item                | Especificação                                                                                                                                                         |
| ------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Por clínica         | ambiente (nome e tipo) · simultâneos (atendimentos e estudantes) · equipamentos. Recurso bloqueado aparece com faixa vermelha, fundo tingido e o motivo junto ao nome |
| Capacidade efetiva  | bloco que soma os limites e destaca o resultado: vale sempre o menor limite entre todos os recursos exigidos pelo serviço                                             |
| Bloqueio temporário | formulário com recurso, período e motivo; avisa que reservas confirmadas no intervalo serão listadas para tratamento                                                  |
| Regra exibida       | nenhuma operação pode exceder a capacidade; a verificação é refeita na confirmação, em operação única                                                                 |
| Estados             | vazio inicial, carregando, sem permissão (responsável só enxerga a própria clínica), conflito ao bloquear recurso com reservas                                        |

### Configuração do semestre

**Origem:** UC-007 · RF-007.01 a RF-007.06

| Item                      | Especificação                                                                                                                                                                                                                                                                                                                                                                                     |
| ------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Etapas                    | identificação, oferta acadêmica, supervisão, capacidade física, validação e ativação — com o estado de cada uma                                                                                                                                                                                                                                                                                   |
| Validação de consistência | itens de verificação separando **impedimento** (`✕`, bloqueia a ativação) de **atenção** (anel âmbar, não bloqueia), cada um com a origem e ação de correção                                                                                                                                                                                                                                      |
| Ativação                  | botão desabilitado enquanto houver impedimento, com o motivo em texto ao lado. O desabilitado usa preenchimento próprio, nunca opacidade                                                                                                                                                                                                                                                          |
| Efeitos da ativação       | reservas confirmadas preservadas, mudanças posteriores exigem revisão, registro de quem ativou                                                                                                                                                                                                                                                                                                    |
| Histórico semestral       | semestre com a situação embutida · período letivo · realizado · quem ativou                                                                                                                                                                                                                                                                                                                       |
| Corrigir                  | cada impedimento leva ao seu próprio lugar de correção: limite de supervisão ao cadastro do supervisor em modo “limite do semestre”; disciplina sem horário ao **Calendário da oferta acadêmica**. Os dois botões nunca levam ao mesmo cadastro                                                                                                                                                   |
| Estados                   | com impedimentos (ativação desabilitada) · um impedimento resolvido (calendário corrigido ou limite corrigido) · pronta para ativar (botão habilitado, aviso de sucesso) · ativando (botões desabilitados, conclui sozinho) · sucesso da ativação como página inteira · semestre já ativo (etapa 5 concluída, histórico atualizado, sem botões de ativação) · sem permissão (exclusivo do Master) |

### Calendário da oferta acadêmica

**Origem:** UC-007 · RF-007.02, RF-007.03 · UC-005 · RF-005.01 · **Destino de:** “Corrigir” da disciplina sem horário

| Item                    | Especificação                                                                                                                                                                                                                              |
| ----------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Identificação da oferta | disciplina ou estágio (vem do catálogo), curso e período, semestre em configuração e clínica                                                                                                                                               |
| Dias e horários         | grade de turnos por dia com a marca “Oferta” e início e término dentro do turno. O texto lembra que o horário só existe quando estudante, supervisor e clínica também estão disponíveis                                                    |
| Antes de salvar         | oferta vinculada ao semestre, dias e horários definidos, supervisão disponível no turno                                                                                                                                                    |
| Saída                   | “Salvar horário” volta à configuração e executa a validação de novo; “Cancelar” volta sem salvar. O destino depende do que já foi corrigido: se o limite de supervisão também estiver resolvido, a configuração aparece pronta para ativar |
| Estados                 | erro por campo, conflito com o turno do supervisor, sem permissão (exclusivo do Master)                                                                                                                                                    |

### Usuários e permissões

**Origem:** UC-009 · RF-009.03, RF-009.04, RF-009.05

| Indicador                | O que precisa comunicar                                               |
| ------------------------ | --------------------------------------------------------------------- |
| Usuários internos        | total e a divisão entre ativos e inativos                             |
| Papéis                   | quantos papéis existem e quais são — a nomeação importa para a matriz |
| Perfis Master            | quantos existem e o escopo de cada um; é o indicador de risco da tela |
| Acessos negados (7 dias) | volume de tentativas barradas, ligando esta tela à auditoria          |

| Item                 | Especificação                                                                                                                                     |
| -------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------- |
| Lista                | usuário (nome, papel e escopo) · último acesso (data e situação) · ação                                                                           |
| Matriz de permissões | operações nas linhas, papéis nas colunas, `✓` e `–` com legenda acima — sem preenchimento colorido por célula                                     |
| Acessos a revisar    | pendências acionáveis: papel ativo em cadastro inativo, dois perfis Master no mesmo escopo, volume de acessos negados com atalho para a auditoria |
| Estados              | carregando, vazio por filtro, sem permissão, sucesso ao conceder ou revogar papel                                                                 |

### Auditoria

**Origem:** UC-009 · RF-009.07, RF-009.08; privacidade conforme RNF-002.AUD-01

| Item                        | Especificação                                                                                                                                                                 |
| --------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Objetivo                    | consultar operações sensíveis sem expor conteúdo de documento nem dado pessoal desnecessário                                                                                  |
| Coluna “Quando e resultado” | aplica o padrão de tempo com situação: concluída, bloqueio aplicado ou acesso negado, com marcador e legenda                                                                  |
| Colunas                     | quando e resultado · usuário e papel · operação · objeto                                                                                                                      |
| Filtros                     | período, usuário, operação e resultado                                                                                                                                        |
| Resumo do período           | operações concluídas, bloqueios aplicados, acessos negados e as operações mais frequentes, com exportação. A pendência de retenção aparece como aviso no bloco de privacidade |
| Estados                     | carregando, vazio por filtro, sem permissão (exclusivo do Master), carga (1.932 registros)                                                                                    |

### Agendamentos · visão da clínica

**Origem:** UC-008 · RF-008.05, RF-008.06, RF-008.07

| Indicador              | O que precisa comunicar                                                                            |
| ---------------------- | -------------------------------------------------------------------------------------------------- |
| Reservas do dia        | total com a composição por situação (`14 confirmadas · 3 pendentes · 1 cancelada`)                 |
| Vagas ainda ofertadas  | quantas ainda existem **neste momento**, deixando claro que o número é recalculado a cada consulta |
| Ocupação da clínica    | percentual contra o limite físico declarado, citando o limite (`4 atendimentos simultâneos`)       |
| Cancelamentos (7 dias) | volume de vagas devolvidas à oferta — mede reaproveitamento, não perda                             |

| Item                    | Especificação                                                                                                                                                                                                                                                                                                                  |
| ----------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Lista                   | horário e situação · pessoa (iniciais e identificador interno) · serviço e ambiente · estudante e supervisor                                                                                                                                                                                                                   |
| Oferta restante         | horários ainda disponíveis e, para os indisponíveis, o motivo (`sem supervisor`, `limite de supervisão`, `manutenção`)                                                                                                                                                                                                         |
| Detalhe da reserva      | dados mínimos da pessoa, recursos consumidos, prazo de confirmação e histórico                                                                                                                                                                                                                                                 |
| Confirmação             | revalida supervisor, capacidade física e documentação antes de manter a reserva                                                                                                                                                                                                                                                |
| Cancelamento            | exige diálogo de confirmação com a consequência descrita. “Manter atendimento” fecha o diálogo; “Cancelar atendimento” volta à lista com a linha “cancelado pela equipe”, o detalhe sem ações, o evento no histórico, a vaga de volta na oferta restante e os indicadores recalculados (17 reservas, 7 vagas, 6 cancelamentos) |
| Confirmação pela equipe | “Confirmar reserva” mostra a linha confirmada, o aviso de revalidação concluída e o evento no histórico; só “Cancelar” continua disponível                                                                                                                                                                                     |
| Estados                 | carregando, vazio (dia sem reservas), erro, sucesso, sem permissão                                                                                                                                                                                                                                                             |

### Cadastro de supervisor

**Origem:** UC-003 · RF-003.01 a RF-003.05 · **Destino de:** “Novo supervisor” e “Ajustar limite”

| Item                    | Especificação                                                                                                                                                                                                                                                                                                                         |
| ----------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Identificação           | nome, papel (professor ou preceptor), área ou curso e contato institucional                                                                                                                                                                                                                                                           |
| Ambientes de supervisão | vínculo com os ambientes onde pode supervisionar; sem ambiente vinculado não há oferta de horário                                                                                                                                                                                                                                     |
| Disponibilidade         | grade de turnos por dia, cruzada com a do estudante e a da clínica                                                                                                                                                                                                                                                                    |
| Limite simultâneo       | quantidade máxima de estudantes ao mesmo tempo, com o alerta de que reduzir o limite não cancela reservas já confirmadas                                                                                                                                                                                                              |
| Ocupação atual          | mostra o efeito imediato do limite nos intervalos do dia                                                                                                                                                                                                                                                                              |
| Antes de salvar         | itens de verificação, incluindo aviso quando o limite fica abaixo da ocupação de algum intervalo                                                                                                                                                                                                                                      |
| Modos                   | **criação** (campos vazios, nenhum ambiente, grade vazia, sem ocupação) · **edição de um registro** (um quadro por supervisor da lista; o ícone de abrir de cada linha leva ao próprio registro) · **limite do semestre** (aberto por “Corrigir” na configuração; campo do limite em foco, sem ocupação, salvar volta à configuração) |
| Ambientes               | um único selo “+ Adicionar ambiente” abre o catálogo de ambientes; os ambientes vinculados aparecem como selos removíveis                                                                                                                                                                                                             |
| Estados                 | erro por campo, sem permissão, sucesso (lista de supervisores com notificação)                                                                                                                                                                                                                                                        |

### Usuário e papel

**Origem:** UC-009 · RF-009.03, RF-009.04 · **Destino de:** “Novo usuário”, “Revogar papel” e “Revisar perfis”

| Item                          | Especificação                                                                                                                                                                                                                                 |
| ----------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Identificação                 | nome, e-mail institucional (também é o identificador de acesso), vínculo e situação do primeiro acesso                                                                                                                                        |
| Papel                         | um papel por usuário, cada opção com a descrição do que permite                                                                                                                                                                               |
| Escopo                        | unidade obrigatória e clínica opcional; fora do escopo a operação é negada mesmo com o papel correto                                                                                                                                          |
| O que este papel poderá fazer | leitura da matriz vigente para o papel escolhido, com permitido e negado                                                                                                                                                                      |
| Situação                      | ativo ou inativo; inativar preserva o histórico e encerra o acesso                                                                                                                                                                            |
| Pendência exibida             | o escopo do perfil Master ainda não foi decidido na documentação; o aviso aparece na criação e nos usuários com papel Master                                                                                                                  |
| Modos                         | **criação** (nenhum papel selecionado, o que o papel permite fica neutro até a escolha) · **edição de um registro** (um quadro por usuário da lista, com a leitura da matriz do papel dele; cadastro inativo mostra as permissões sem efeito) |
| Revogar papel                 | abre o diálogo de revogação da usuária apontada em “Acessos a revisar”; confirmar volta à lista com a situação “papel revogado” e o aviso resolvido                                                                                           |
| Revisar perfis                | lista filtrada pelo papel Master                                                                                                                                                                                                              |
| Estados                       | erro por campo, sem permissão (exclusivo do Master), sucesso (lista de usuários com notificação)                                                                                                                                              |

### Ambiente e capacidade

**Origem:** UC-006 · RF-006.01 a RF-006.03, RF-006.06 · **Destino de:** “Adicionar ambiente” e ícone de abrir de cada ambiente

| Item                          | Especificação                                                                                                                                                                                                                     |
| ----------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Identificação                 | clínica, nome do ambiente, tipo e localização                                                                                                                                                                                     |
| Capacidade simultânea         | atendimentos e estudantes ao mesmo tempo                                                                                                                                                                                          |
| Equipamentos                  | lista com quantidade ou unidade identificada, aceitando os dois modelos enquanto a decisão não vem                                                                                                                                |
| Capacidade efetiva resultante | itens de verificação e o número de vagas por horário                                                                                                                                                                              |
| Situação                      | disponível ou bloqueado, com o efeito sobre reservas confirmadas                                                                                                                                                                  |
| Modos                         | **criação** a partir do cartão de cada clínica (clínica preenchida, demais campos vazios) · **edição de um registro** (um quadro por ambiente; o ambiente bloqueado mostra o impedimento e zero vagas)                            |
| Remover equipamento           | sem uso por serviço, some da lista na hora (ainda não salvo); **em uso** por serviço, abre o diálogo que mostra quais serviços perdem vagas e quantas, e confirmar mostra o ambiente sem o equipamento e a capacidade recalculada |
| Adicionar equipamento         | abre o catálogo de equipamentos da clínica, com quantidade para equipamento por quantidade                                                                                                                                        |
| Estados                       | erro por campo, sem permissão, sucesso (Clínicas com notificação)                                                                                                                                                                 |

### Clínicas · tabela de ambientes

A ação “Editar capacidades” do cartão da clínica saiu: ela não dizia qual ambiente seria editado. Cada linha ganhou o ícone de abrir, que leva ao ambiente daquela linha. A coluna de simultâneos virou célula dupla (atendimentos em cima, estudantes embaixo) para não quebrar texto com a nova coluna.

---

## Especificação por tela · portal do estudante

### Meus documentos

**Origem:** UC-002 · RF-002.02, RF-002.03, RF-002.05, RF-002.07

| Item                | Especificação                                                                                                                             |
| ------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- |
| Aviso de bloqueio   | abre a tela informando que há pendência e que nenhum horário é oferecido enquanto ela existir                                             |
| Lista de documentos | cada item mostra situação, quem exigiu, quando foi enviado e a orientação de correção quando recusado — a orientação é exibida na íntegra |
| Envio               | área de arquivo com formatos e tamanho aceitos, informando que o documento não fica acessível publicamente                                |
| Situação lateral    | vínculo, situação acadêmica, resumo documental e o estado dos horários                                                                    |
| Histórico           | todos os envios e decisões, sem exclusão                                                                                                  |
| Estados             | nenhum documento exigido, carregando, erro de envio (arquivo inválido ou grande demais), sucesso de envio                                 |

| Estado do envio     | O que a área de envio mostra                                                                                                                          |
| ------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------- |
| Arquivo selecionado | nome, formato, tamanho e o documento a que se refere; ações “Enviar documento” e “Trocar arquivo”                                                     |
| Enviando            | barra de progresso com percentual e volume; única ação “Cancelar envio”; conclui sozinho                                                              |
| Erro no envio       | fundo e borda de erro, o motivo com o número (tamanho do arquivo contra o limite), a garantia de que nada foi enviado e “Escolher outro arquivo”      |
| Registrado          | notificação no topo, documento passa a “em análise desde 15/09” com o prazo, aviso do topo muda de bloqueio para análise e o envio entra no histórico |

### Horários elegíveis

**Origem:** UC-005 · RF-005.01 a RF-005.06; clareza do vazio conforme RNF-005.USA-01

| Item               | Especificação                                                                                                                                                                                    |
| ------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Objetivo           | mostrar apenas horários compatíveis e, quando não houver nenhum, explicar o motivo corrigível                                                                                                    |
| Estado vazio       | distingue “não há oferta” de “você está impedido”. No segundo caso, nomeia a pendência, diz como corrigir e leva à tela de documentos                                                            |
| Pré-visualização   | mostra os horários que existiriam, esmaecidos e marcados como bloqueados, para dar noção do que se perde                                                                                         |
| Seus requisitos    | os seis itens com resultado e o dado que sustenta cada um                                                                                                                                        |
| Privacidade        | a lista não expõe identidade de outros estudantes, pacientes ou supervisores fora do contexto                                                                                                    |
| Estados            | carregando, vazio por impedimento, vazio por ausência de oferta, erro, **liberado** (sem o cartão de impedimento; horários com texto em cor normal e “elegível” em verde; documentação conforme) |
| Coerência de datas | os horários respeitam a disponibilidade do supervisor (Prec. Marcos Reis, terças e quintas à tarde) e o filtro de período cobre todas as datas listadas                                          |

### Meu perfil

**Origem:** UC-001 · RF-001.01, RF-001.03 · US-001.02 · **Destino de:** aba “Meu perfil”

| Item                      | Especificação                                                                                                           |
| ------------------------- | ----------------------------------------------------------------------------------------------------------------------- |
| Contato                   | e-mail institucional e telefone, os dados que o estudante pode manter atualizados                                       |
| Disponibilidade declarada | grade de turnos; o texto deixa claro que marcar um turno não agenda nada                                                |
| Pendência exibida         | a documentação ainda não decidiu se o próprio estudante altera a disponibilidade ou se a mudança passa pela coordenação |
| Meu vínculo               | leitura do vínculo, da situação acadêmica e da documentação, com atalho para os documentos                              |
| Privacidade               | finalidade do uso dos dados e caminho para correção ou exclusão                                                         |
| Estados                   | salvo com sucesso, erro por campo, somente leitura quando a edição depender da coordenação                              |

---

## Especificação por tela · portal da comunidade

### Início e busca de serviços

**Origem:** UC-008 · RF-008.01

| Item               | Especificação                                                                                                              |
| ------------------ | -------------------------------------------------------------------------------------------------------------------------- |
| Objetivo           | explicar o serviço e levar à busca de horários no menor caminho                                                            |
| Chamada            | promessa verificável: os horários exibidos existem de verdade no momento da consulta                                       |
| Busca              | serviço, clínica ou bairro e data inicial, com rótulo visível em cada campo                                                |
| Cartões de serviço | nome, descrição, duração, clínica e quantidade de horários na semana — a contagem usa selo neutro, não a cor institucional |
| Como funciona      | três passos, do horário ao código de acesso                                                                                |
| Rodapé             | endereço, natureza do atendimento (estudantes sob supervisão), privacidade e acessibilidade                                |
| Estados            | carregando, sem oferta na semana (com data alternativa), erro                                                              |

### Horários disponíveis

**Origem:** UC-008 · RF-008.01; disponibilidade simultânea conforme UC-005 · RF-005.03

| Item           | Especificação                                                                               |
| -------------- | ------------------------------------------------------------------------------------------- |
| Trilha         | Início › serviço › procedimento › horários, marcada como trilha estruturada                 |
| Etapas         | indicador “Etapa 1 de 3” persistente no fluxo                                               |
| Aviso          | a disponibilidade é verificada de novo no momento da reserva                                |
| Agrupamento    | por dia, com horários disponíveis destacados e indisponíveis mantidos na lista com o motivo |
| Painel lateral | refinamento da busca e informações de acessibilidade do local                               |
| Estados        | carregando com esqueleto de horário, sem horário na semana, erro, conflito ao reservar      |

### Dados mínimos

**Origem:** UC-008 · RF-008.02, RF-008.03

| Item               | Especificação                                                                                                                           |
| ------------------ | --------------------------------------------------------------------------------------------------------------------------------------- |
| Coleta             | nome, telefone, data de nascimento e e-mail opcional. Nenhum campo além do necessário; CPF só entra se a instituição exigir formalmente |
| Consentimento      | caixa de seleção com texto claro sobre finalidade e direito de exclusão                                                                 |
| Acessibilidade     | campo opcional para necessidade de acessibilidade, que a clínica usa para preparar o atendimento                                        |
| Resumo             | serviço, data, duração, local e endereço visíveis durante o preenchimento                                                               |
| Reserva temporária | o horário fica reservado por 10 minutos, com o prazo informado                                                                          |
| Estados            | erro por campo, expiração da reserva temporária, conflito pela última vaga, carregando                                                  |

### Comprovante

**Origem:** UC-008 · RF-008.04, RF-008.05, RF-008.06

| Item             | Especificação                                                                           |
| ---------------- | --------------------------------------------------------------------------------------- |
| Confirmação      | data, hora, serviço e local em destaque                                                 |
| Código de acesso | identificador não previsível, com ação de cópia; nunca aparece na URL                   |
| Orientações      | chegada, documento, materiais e o pedido de cancelamento em caso de imprevisto          |
| Ações            | confirmar presença, adicionar ao calendário, cancelar                                   |
| Prazo            | data e hora limite para confirmar, com a consequência da não confirmação                |
| Estados          | sucesso (esta tela é um estado de sucesso), erro ao confirmar, agendamento já cancelado |

### Gerenciar meu agendamento

**Origem:** UC-008 · RF-008.05, RF-008.06

| Item    | Especificação                                                                                                      |
| ------- | ------------------------------------------------------------------------------------------------------------------ |
| Acesso  | pelo código, sem conta nem senha                                                                                   |
| Detalhe | serviço, data, local, prazo de confirmação, pessoa atendida e contato                                              |
| Ações   | confirmar presença e cancelar, esta última com diálogo de confirmação                                              |
| Ajuda   | caminho alternativo pela recepção para quem perdeu o código                                                        |
| Estados | código inválido ou expirado (mensagem genérica por segurança, com limite de tentativas), carregando, sucesso, erro |

### Endereços, horários e acessibilidade

**Origem:** UC-006 (dados das clínicas) e UC-008 (oferta pública) · **Destino de:** links “Endereços e horários” e “Acessibilidade”

| Item           | Especificação                                                                                            |
| -------------- | -------------------------------------------------------------------------------------------------------- |
| Por clínica    | nome, endereço, horário de funcionamento, serviços oferecidos, telefone e atalho para os horários        |
| Acessibilidade | o que já existe na unidade e como pedir apoio antes do atendimento, com antecedência declarada           |
| SEO            | é a página de SEO local: nome, endereço e telefone idênticos aos demais canais, e conteúdo em texto real |
| Estados        | carregando, erro; a página não tem estado vazio porque o conteúdo é institucional                        |

### Presença confirmada e atendimento cancelado

**Origem:** UC-008 · RF-008.05 e RF-008.06 · subfluxos Confirmar e Cancelar

Os dois desfechos existem como tela porque encerram um fluxo iniciado fora do sistema (pelo código de acesso) e precisam responder três coisas: o que mudou, o que a pessoa faz agora e o que aconteceu com a vaga.

| Tela                  | Conteúdo obrigatório                                                                                                                                   |
| --------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Presença confirmada   | confirmação com data, hora e local; orientações do dia; resumo com o código; ação de cancelar ainda disponível                                         |
| Atendimento cancelado | confirmação do cancelamento; aviso de que o código deixou de abrir o agendamento; horários próximos verificados no momento; o que aconteceu com a vaga |

### Adicionar do catálogo (diálogo)

**Origem:** UC-001 · RF-001.02, UC-006 · RF-006.02, UC-009 · RF-009.05

Seletor reutilizado por vínculo do estudante, ambiente do supervisor e equipamento do ambiente. Traz busca com rótulo, lista com seleção múltipla, o aviso de que vincular não cria horário sozinho e a ação nomeando quantos itens serão adicionados.

| Variante                | Conteúdo próprio                                                                                                                                                                                                             |
| ----------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Vínculo acadêmico       | disciplinas e estágios do semestre vigente, com curso, período e dia                                                                                                                                                         |
| Ambientes de supervisão | ambientes das clínicas ainda não vinculados ao supervisor; aviso de que ambiente vinculado não garante vaga                                                                                                                  |
| Equipamentos            | equipamentos da clínica, com o modelo (por quantidade ou identificado por unidade, com código) e o campo de quantidade no ambiente para os equipamentos por quantidade; aviso de que equipamento exigido limita a capacidade |

“Cancelar” fecha sem aplicar; “Adicionar” aplica a seleção e fecha, voltando ao formulário que abriu o catálogo.

### Conflito pela última vaga

**Origem:** UC-008 · RNF-008.CON-01, RNF-008.INT-01

Estado exibido quando duas pessoas disputam a mesma vaga. Precisa afirmar que **nenhuma reserva foi criada**, explicar o que aconteceu em linguagem comum e oferecer horários alternativos já verificados no momento da exibição.

No protótipo, o conflito aparece como sobreposição sobre os dados mínimos quando o horário escolhido é a última vaga (09h00 de terça, 15/09, Sala 3). A primeira alternativa vem pré-selecionada; “Reservar o horário escolhido” volta aos dados mínimos com o novo horário e os dados preservados — nenhuma reserva é criada automaticamente. Qualquer outro horário leva ao comprovante. Os dois desfechos nunca aparecem juntos.

### Cancelamento público (diálogo)

**Origem:** UC-008 · RF-008.06

Diálogo com a data, o serviço e o local da reserva pública — sem nenhuma informação interna da clínica — e a consequência: a vaga volta à comunidade e o código deixa de abrir o agendamento. “Manter atendimento” fecha; “Cancelar atendimento” leva a Atendimento cancelado. No celular, o mesmo conteúdo aparece como folha inferior com as ações empilhadas, a perigosa primeiro.

### Fluxo móvel (390 px)

**Origem:** UC-008 · RNF-008.RES-01, RNF-008.USA-01

As três etapas funcionam a partir de 360 px sem rolagem horizontal. Indicador de etapa fixo no topo, ação primária ancorada no rodapé, campos em coluna única e alvos de 44 px.

O fluxo móvel termina em telas móveis próprias, sem depender de tela de computador: comprovante, conflito pela última vaga, meu agendamento (consulta por código), presença confirmada e atendimento cancelado. O menu do cabeçalho móvel oferece apenas “Agendar atendimento” e “Meu agendamento”, porque as páginas institucionais ainda não têm versão móvel desenhada.

---

## Organização das páginas do protótipo

O protótipo do Figma só navega entre quadros da **mesma página**. Por isso a antiga página `Estados` foi desfeita e cada estado foi para a página do seu portal; cada página é organizada em linhas nomeadas no canvas, sem quadros sobrepostos.

| Página               | Linhas                                                                                                                                                                                                                                                                      |
| -------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Interno (equipe)     | telas principais · estados de tela · sobreposições e diálogos · semestre (calendário e estados de ativação) · estudantes por registro · supervisores por registro, criação e limite · usuários por registro · ambientes por registro e criação · resultados com notificação |
| Comunidade (público) | computador: telas, estados e sobreposições · celular: telas e estados, sobreposições                                                                                                                                                                                        |
| Estudante            | telas do portal · estados (horários liberados, envio de documento, disponibilidade salva)                                                                                                                                                                                   |

| Quadro de estado                      | Serve de referência para                                                                                 |
| ------------------------------------- | -------------------------------------------------------------------------------------------------------- |
| Carregamento · lista de estudantes    | esqueleto de tabela com altura idêntica à linha real; no protótipo avança sozinho para a lista           |
| Carregamento · horários públicos      | status descritivo em região viva e esqueleto de cartão de horário; avança sozinho para os horários       |
| Vazio · primeira execução do semestre | vazio que ensina a ordem das dependências entre cadastros                                                |
| Vazio · busca sem resultado           | filtros ativos visíveis e previsão de resultado ao remover cada um                                       |
| Vazio · filtros sem resultado         | o mesmo vazio depois de “Remover apenas a busca”: três filtros continuam ativos e ainda não há resultado |
| Sem permissão · área restrita         | itens sem permissão visíveis e esmaecidos, com alternativas e registro da tentativa                      |
| Sem permissão · código inválido       | mensagem genérica por segurança                                                                          |
| Sucesso · documento aprovado          | feedback em três níveis: notificação, mudança na lista e efeito explicado                                |
| Sucesso · semestre ativado            | sucesso de operação crítica como página, com consequências e pendências                                  |
| Carga · 154 registros                 | paginação, ordenação, seleção em lote e densidade                                                        |
| Confirmação de ação destrutiva        | diálogo com consequência concreta e botões nomeados, em cena completa                                    |
| Erro · falha ao carregar dados        | falha isolada, com o que continua funcionando e nova tentativa                                           |

Sobreposições são quadros próprios, com a cortina e o diálogo centralizado; clicar na cortina fecha. No celular, a folha fica ancorada na base e o menu no topo.

---

## Mapa de ações e destinos

As ligações abaixo **estão configuradas** no protótipo e foram conferidas por inspeção das reações de todos os nós (ver item 21). Desfechos: **tela** (navega), **sobreposição** (abre por cima; fechar devolve à tela de origem), **estado** (outro quadro da mesma tela) ou **local** (muda a própria tela por variável do protótipo).

### Área interna

| Ação                                                                              | Onde está                                                                         | Desfecho                                                                                                                                                                          |
| --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Itens da barra lateral                                                            | todas as telas internas                                                           | tela do módulo; o item ativo não tem ligação (é a tela atual)                                                                                                                     |
| Sair                                                                              | barra lateral                                                                     | tela · Entrar no sistema                                                                                                                                                          |
| Entrar                                                                            | Entrar no sistema                                                                 | tela · Painel da operação                                                                                                                                                         |
| Ver agenda completa · Revisar configuração                                        | Painel                                                                            | tela · Agendamentos · Configuração do semestre                                                                                                                                    |
| Novo estudante · Cadastrar estudante                                              | Estudantes, carregamento, vazios, carga                                           | tela · Novo estudante (criação)                                                                                                                                                   |
| Abrir (ícone, por linha)                                                          | Estudantes, carga, Supervisores, Usuários, Clínicas e os resultados dessas listas | tela · cadastro do registro daquela linha                                                                                                                                         |
| + Adicionar vínculo                                                               | cadastro de estudante                                                             | sobreposição · catálogo de vínculo acadêmico                                                                                                                                      |
| Salvar estudante · Salvar alterações                                              | cadastro de estudante                                                             | estado · Estudantes com notificação “Cadastro do estudante salvo”                                                                                                                 |
| Salvar rascunho                                                                   | Novo estudante                                                                    | estado · Estudantes com notificação “Rascunho salvo”                                                                                                                              |
| Cancelar                                                                          | cadastros de estudante, supervisor, usuário e ambiente                            | tela · lista do módulo, sem salvar                                                                                                                                                |
| Aprovar documento                                                                 | Validação de documentação                                                         | estado · Sucesso · documento aprovado                                                                                                                                             |
| Recusar                                                                           | Validação de documentação                                                         | estado · fila com notificação de recusa registrada                                                                                                                                |
| Analisar o próximo documento · Ver a estudante                                    | Sucesso · documento aprovado                                                      | tela · fila · cadastro da estudante aprovada                                                                                                                                      |
| Novo supervisor                                                                   | Supervisores                                                                      | tela · Novo supervisor (criação)                                                                                                                                                  |
| Ajustar limite                                                                    | Capacidade                                                                        | tela · cadastro do supervisor daquele cartão                                                                                                                                      |
| Ver alternativas · Ver horários alternativos                                      | Capacidade                                                                        | tela · Agendamentos da clínica                                                                                                                                                    |
| + Adicionar ambiente                                                              | cadastro de supervisor                                                            | sobreposição · catálogo de ambientes                                                                                                                                              |
| Salvar alterações · Salvar supervisor                                             | cadastro de supervisor                                                            | estado · Supervisores com notificação                                                                                                                                             |
| Adicionar ambiente                                                                | cartão de cada clínica                                                            | tela · Novo ambiente com a clínica preenchida                                                                                                                                     |
| Aplicar bloqueio                                                                  | Clínicas                                                                          | sobreposição · bloqueio com reservas afetadas → “Aplicar bloqueio” leva a Clínicas com notificação; “Voltar ao formulário” fecha                                                  |
| Adicionar equipamento                                                             | cadastro de ambiente                                                              | sobreposição · catálogo de equipamentos                                                                                                                                           |
| Remover (equipamento sem uso)                                                     | cadastro de ambiente                                                              | local · a linha some; Cancelar e Salvar restauram a demonstração                                                                                                                  |
| Remover (maca da Sala 1, em uso)                                                  | Ambiente · Sala 1                                                                 | sobreposição · remoção de equipamento em uso → estado · Sala 1 sem macas, capacidade 0                                                                                            |
| Salvar alterações · Salvar ambiente                                               | cadastro de ambiente                                                              | estado · Clínicas com notificação                                                                                                                                                 |
| Corrigir (limite de supervisão)                                                   | Configuração do semestre e estados                                                | tela · limite 2027.1 da Prec. Ana Beatriz                                                                                                                                         |
| Corrigir (disciplina sem horário)                                                 | Configuração do semestre e estados                                                | tela · Calendário da oferta acadêmica                                                                                                                                             |
| Salvar limite · Salvar horário                                                    | limite do semestre · calendário                                                   | estado · configuração com um impedimento resolvido ou pronta para ativar, conforme o que já foi corrigido (variáveis `semestre/limite-definido` e `semestre/calendario-definido`) |
| Cancelar                                                                          | limite do semestre · calendário                                                   | volta à tela anterior                                                                                                                                                             |
| Ativar semestre                                                                   | Configuração · pronta para ativar                                                 | estado · ativando → conclui sozinho em Sucesso · semestre ativado                                                                                                                 |
| Voltar à configuração                                                             | Sucesso · semestre ativado                                                        | estado · semestre 2027.1 ativo                                                                                                                                                    |
| Ver oferta publicada · Ver agenda                                                 | Sucesso · semestre ativado                                                        | portal da comunidade · Horários disponíveis (link do protótipo, outra página)                                                                                                     |
| Revisar fila · Ver capacidade                                                     | Sucesso · semestre ativado                                                        | tela · Validação de documentação · Capacidade                                                                                                                                     |
| Novo usuário                                                                      | Usuários                                                                          | tela · Usuário e papel (criação)                                                                                                                                                  |
| Revogar papel                                                                     | Usuários · acessos a revisar                                                      | sobreposição · revogação de papel → estado · Usuários com papel revogado; “Manter papel” fecha                                                                                    |
| Revisar perfis                                                                    | Usuários · acessos a revisar                                                      | estado · Usuários filtrados pelo papel Master                                                                                                                                     |
| Salvar alterações · Salvar usuário                                                | cadastro de usuário                                                               | estado · Usuários com notificação                                                                                                                                                 |
| Confirmar reserva                                                                 | Agendamentos                                                                      | estado · reserva confirmada                                                                                                                                                       |
| Cancelar (reserva)                                                                | Agendamentos, reserva confirmada, cena de confirmação                             | sobreposição · cancelamento interno → estado · reserva cancelada; “Manter atendimento” fecha                                                                                      |
| Inativar                                                                          | Carga                                                                             | sobreposição · inativação em lote → estado · 3 estudantes inativados; “Manter ativos” fecha                                                                                       |
| Limpar todos os filtros · Remover apenas a busca                                  | Vazio · busca sem resultado                                                       | tela · Estudantes · estado · Vazio · filtros sem resultado                                                                                                                        |
| Voltar ao painel · Abrir minha fila de documentos · Abrir (ícones de alternativa) | Sem permissão · área restrita                                                     | tela · Painel · Validação · Capacidade · Agendamentos                                                                                                                             |
| Tentar novamente · Voltar ao painel                                               | Erro · falha ao carregar dados                                                    | tela · Capacidade · Painel                                                                                                                                                        |

### Portal do estudante

| Ação                                              | Onde está                      | Desfecho                                                            |
| ------------------------------------------------- | ------------------------------ | ------------------------------------------------------------------- |
| Abas Meus horários · Meus documentos · Meu perfil | cabeçalho do estudante         | tela da aba; a aba ativa não tem ligação                            |
| Sair                                              | cabeçalho do estudante         | Entrar no sistema (link do protótipo, outra página)                 |
| Ir para meus documentos                           | Horários elegíveis, Meu perfil | tela · Meus documentos                                              |
| Reenviar documento                                | Meus documentos                | estado · documento selecionado                                      |
| Escolher arquivo                                  | Meus documentos                | estado · erro no envio (arquivo acima do limite)                    |
| Enviar documento · Trocar arquivo                 | documento selecionado          | estado · enviando (conclui sozinho em registrado) · Meus documentos |
| Cancelar envio · Escolher outro arquivo           | enviando · erro no envio       | estado · documento selecionado                                      |
| Salvar alterações                                 | Meu perfil                     | estado · disponibilidade salva; lá, “Cancelar” volta ao perfil      |

### Portal da comunidade

| Ação                                                                     | Onde está                                                 | Desfecho                                                                                                                           |
| ------------------------------------------------------------------------ | --------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------- |
| Serviços · Como funciona                                                 | cabeçalho público                                         | rolagem até a seção na página inicial; nas demais páginas, página inicial                                                          |
| Endereços e horários · Acessibilidade                                    | cabeçalho público                                         | tela · Endereços; em Endereços, Acessibilidade rola até a seção                                                                    |
| Marca                                                                    | cabeçalho público                                         | tela · Início                                                                                                                      |
| Meu agendamento · Agendar atendimento                                    | cabeçalho público e menu móvel                            | tela · Gerenciar (ou Meu agendamento móvel) · Horários disponíveis (ou versão móvel); na própria tela, sem ligação                 |
| Menu                                                                     | cabeçalho móvel                                           | sobreposição · menu móvel; o X e a cortina fecham                                                                                  |
| Horário disponível                                                       | Horários disponíveis (computador e celular)               | tela · Dados mínimos com data, hora e sala escolhidas (variáveis `reserva/*`)                                                      |
| Atualizar resultados                                                     | Horários disponíveis                                      | estado · carregamento público → volta sozinho                                                                                      |
| Reservar horário                                                         | Dados mínimos                                             | tela · Comprovante; se o horário escolhido for a última vaga (09h00 de 15/09), sobreposição · conflito (celular: tela de conflito) |
| Reservar o horário escolhido · Ver todos os horários                     | conflito                                                  | tela · Dados mínimos com a alternativa escolhida · Horários disponíveis                                                            |
| Voltar e escolher outro horário                                          | Dados mínimos                                             | tela · Horários disponíveis                                                                                                        |
| Copiar                                                                   | Comprovante                                               | local · o rótulo muda para “Copiado”                                                                                               |
| Confirmar presença                                                       | Comprovante, Gerenciar, telas móveis                      | tela · Presença confirmada (computador ou celular)                                                                                 |
| Cancelar atendimento                                                     | Comprovante, Gerenciar, Presença confirmada, telas móveis | sobreposição · diálogo público (celular: folha inferior) → tela · Atendimento cancelado; “Manter atendimento” fecha                |
| Ver meu agendamento · Voltar ao início · Agendar outro horário           | Presença confirmada, Atendimento cancelado                | tela · Gerenciar · Início · Horários disponíveis                                                                                   |
| Consultar outro código                                                   | Atendimento cancelado (celular)                           | tela · Meu agendamento móvel                                                                                                       |
| Tentar outro código · Ver contatos da clínica · Ver horários disponíveis | Código inválido                                           | tela · Gerenciar · Endereços · Horários disponíveis                                                                                |
| Ver horários                                                             | Início, Endereços                                         | tela · Horários disponíveis                                                                                                        |

### Ações habilitadas que ficam sem ligação, e por quê

| Ação                                                                                                                                                                                                                                         | Motivo                                                                         |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------ |
| Ativar semestre com impedimento; botões durante “ativando”                                                                                                                                                                                   | desabilitados de propósito; o texto ao lado diz o motivo                       |
| Item ativo da barra lateral, aba ativa, “Meu agendamento” em Gerenciar, “Agendar atendimento” em Horários, “Revisar perfis” já filtrado, “Recusar” após recusa, “Reenviar” com arquivo já selecionado, “Salvar” com disponibilidade já salva | o destino é a própria tela; o protótipo não aceita ligação para o mesmo quadro |
| Itens restritos na tela Sem permissão · área restrita                                                                                                                                                                                        | são a própria demonstração da restrição; continuam visíveis e esmaecidos       |
| Localizar (Gerenciar, Meu agendamento móvel, Código inválido)                                                                                                                                                                                | a tela já mostra o resultado daquele código                                    |
| Abrir documento                                                                                                                                                                                                                              | abre o arquivo protegido no visualizador do navegador, fora do produto         |
| Executar verificação novamente                                                                                                                                                                                                               | refaz a validação e devolve o mesmo resultado desenhado                        |
| Selecionar os 154 · Cancelar do formulário de bloqueio · Cancelar em Meu perfil                                                                                                                                                              | seleção e descarte locais sem mudança visual relevante para demonstrar         |

### Ações retiradas por dependerem de decisão pendente

| Ação                                           | Motivo                                                                                                                                              |
| ---------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------- |
| Esqueci minha senha                            | recuperação de acesso não está definida; o aviso do login indica o perfil Master, que cria e redefine usuários                                      |
| Tratar as reservas em conflito                 | a documentação ainda não decidiu o que acontece com reservas existentes quando o semestre muda; o aviso agora só informa e aponta tratamento manual |
| Falar com a coordenação                        | não havia canal definido                                                                                                                            |
| Solicitar acesso ao Master                     | não há canal nem fluxo de solicitação; virou “Abrir minha fila de documentos”, mantendo a orientação de procurar o Master                           |
| Falar com a recepção                           | a ação não fazia nada além do texto; virou “Ver contatos da clínica”, que leva a Endereços                                                          |
| Cobrar documentação pendente                   | cobrança ativa não está prevista; virou “Revisar fila”                                                                                              |
| Publicar a agenda da comunidade                | não existe publicação independente da ativação; virou “Ver agenda”                                                                                  |
| Editar capacidades (cartão da clínica)         | não dizia qual ambiente seria editado; substituída pelo ícone de abrir em cada ambiente                                                             |
| Selos “+ Sala 3” e “+ Ambulatório de Nutrição” | adicionavam ambientes específicos sem passar pelo catálogo; viraram um único “+ Adicionar ambiente”                                                 |
| Links institucionais no menu móvel             | Serviços, Como funciona, Endereços e Acessibilidade não têm versão móvel; o menu móvel oferece só agendar e consultar                               |

---

## Elementos retirados por não constarem na documentação

Estes itens existiam no protótipo por decisão de desenho, sem respaldo em requisito, regra ou critério de aceitação. Foram removidos das telas. Se a instituição quiser qualquer um deles, a decisão precisa entrar na documentação primeiro.

| Item retirado                             | Onde estava                                  | Por quê                                                                                               |
| ----------------------------------------- | -------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| Exportar lista, CSV e período             | painel, usuários, auditoria, estado de carga | nenhum requisito prevê exportação                                                                     |
| Importar ou clonar o semestre anterior    | supervisores, estado vazio                   | a clonagem é uma **decisão pendente** do UC-007, não uma funcionalidade aprovada                      |
| Salvar esta visão                         | estado de carga                              | filtros salvos não existem na documentação                                                            |
| Cobrar documentação em lote               | estado de carga                              | notificação ativa ao estudante não está prevista                                                      |
| Registrar exceção justificada             | capacidade de supervisão                     | não há regra de exceção ao limite; o limite “não pode ser excedido em nenhum instante”                |
| Desfazer a aprovação em 30 s              | sucesso do documento                         | o fluxo prevê decisão registrada e nova análise em caso de substituição, não reversão silenciosa      |
| Reserva temporária de 10 minutos          | dados mínimos do agendamento                 | o fluxo revalida na criação da reserva; não há bloqueio temporário previsto                           |
| Lembrete de confirmação                   | histórico da reserva, portal público         | lembretes automáticos estão **fora do MVP**                                                           |
| Adicionar ao calendário                   | comprovante                                  | integração não prevista                                                                               |
| Limite de 5 tentativas em 15 minutos      | código de acesso inválido                    | a regra manda negar sem revelar a existência do agendamento; o mecanismo específico não está definido |
| Código de ocorrência e canal de suporte   | estado de erro                               | não há canal de suporte definido para o MVP                                                           |
| Minigráfico semanal e variação percentual | painel                                       | comparação histórica é relatório, e relatórios avançados estão **fora do MVP**                        |

Mantidos por terem base explícita: prazo de confirmação (RN-008.04 fala em “estados e prazos configurados”), inativação em lote (RF-001.04), revogação de papel (RF-009.04), consulta a dados gerais no resumo da auditoria (RF-009.07), paginação e densidade (decorrem dos requisitos de desempenho e usabilidade).

### Extrapolações que permanecem, com ressalva

| Item                                                              | Situação                                                                                                                                           |
| ----------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------- |
| Painel da operação                                                | não corresponde a um caso de uso; é uma visão de navegação construída só com dados que as UCs já produzem. Depende de priorização do Product Owner |
| Lista de documentos exigidos (vacinação, termo, seguro, atestado) | a documentação trata isso como pendência (“quais documentos serão usados?”); os nomes no protótipo são exemplos fictícios de demonstração          |
| Serviços e durações das clínicas                                  | idem — pendência do UC-008, preenchida com exemplos plausíveis para permitir a demonstração                                                        |

---

## Rastreabilidade

| Caso de uso | Telas                                                                                                       | Requisitos cobertos no protótipo |
| ----------- | ----------------------------------------------------------------------------------------------------------- | -------------------------------- |
| UC-001      | Estudantes · lista e cadastro                                                                               | RF-001.01 a RF-001.06            |
| UC-002      | Validação de documentação · Meus documentos                                                                 | RF-002.01 a RF-002.07            |
| UC-003      | Professores e preceptores                                                                                   | RF-003.01 a RF-003.05            |
| UC-004      | Capacidade de supervisão                                                                                    | RF-004.01 a RF-004.05            |
| UC-005      | Horários elegíveis (estudante)                                                                              | RF-005.01 a RF-005.06            |
| UC-006      | Clínicas, ambientes e equipamentos                                                                          | RF-006.01 a RF-006.06            |
| UC-007      | Configuração do semestre e seus estados · Calendário da oferta acadêmica · limite de supervisão do semestre | RF-007.01 a RF-007.06            |
| UC-008      | Fluxo público (5 telas), conflito, móvel, agendamentos da clínica                                           | RF-008.01 a RF-008.07            |
| UC-009      | Entrar no sistema, usuários e permissões, auditoria, painel                                                 | RF-009.01 a RF-009.08            |

## Pendências que a interface expõe sem resolver

Estas decisões continuam abertas na documentação. As telas mostram o ponto como aviso explícito em vez de inventar regra:

1. matriz definitiva de permissões por papel — hoje é uma proposta visível na tela de permissões;
2. política de confirmação, cancelamento, prazo e falta no agendamento da comunidade;
3. tratamento de reservas futuras quando a configuração semestral muda;
4. modelo de equipamento: unidade identificada ou quantidade por tipo;
5. prazo de retenção e descarte dos registros de auditoria e dos documentos enviados;
6. volume real de dados da instituição, que define índices, tempo de resposta e comportamento da exportação em lote.
