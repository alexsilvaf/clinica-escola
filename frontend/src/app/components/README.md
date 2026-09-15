# Componentes de Horários disponíveis — referência para os estudantes

[Frontend](../../../README.md) · [Roteiro do MVP](../../../../README.md) · [Boas práticas do projeto](../../../../passo-a-passo.md)

A página inicial do MVP é **Horários disponíveis**, na rota `/`, implementada em `features/horarios-disponiveis`. Esta primeira implementação usa dados fictícios, sem API e sem criar reservas. O layout adapta a referência visual do Figma ao recorte reduzido do MVP.

## Estrutura e responsabilidades

```text
src/app/
├── components/                           # Apresentação e interação reutilizáveis
│   └── horario-card/
│       ├── horario-card.ts                # Inputs, outputs e comportamento do cartão
│       ├── horario-card.html              # Template
│       └── horario-card.scss              # Estilo encapsulado
├── features/horarios-disponiveis/
│   ├── horarios-disponiveis.ts            # Coordena carregamento e seleção
│   ├── horarios-disponiveis.html          # Compõe os componentes da página
│   ├── horarios-disponiveis.scss          # Layout da página, sem repetir estilos dos cartões
│   ├── mocks/                            # Clínica e horários fictícios
│   └── services/                         # Contrato de consulta dos horários
├── models/                               # Tipos compartilhados, sem detalhes de UI
└── utils/                                # Funções puras para tarefas como formatar datas
```

Cada componente tem sua própria pasta, template e estilo. Não criar componentes diferentes no mesmo arquivo, nem usar a página de horários para concentrar todo o HTML da aplicação. Nesta fase de aprendizado, não usamos `.spec.ts`; a geração desses arquivos está desativada no CLI.

| Componente             | Responsabilidade                                                          | Entrada / saída principal                       |
| ---------------------- | ------------------------------------------------------------------------- | ----------------------------------------------- |
| `cabecalho-publico`    | Marca, atalho acessível e navegação para seções existentes                | Sem consulta de dados                           |
| `etapas-agendamento`   | Indicar as três etapas previstas, sem links para telas ainda inexistentes | `etapaAtual`                                    |
| `aviso`                | Mensagens informativas e erros                                            | `titulo`, `descricao`, `tipo`                   |
| `botao`                | Botão nativo com variantes e estado desabilitado                          | `rotulo`, `desabilitado` → `acionado`           |
| `resumo-servico`       | Dados do atendimento e endereço ilustrativo                               | `clinica`                                       |
| `acessibilidade-local` | Lista de recursos de acessibilidade do local                              | `recursos`                                      |
| `horario-dia`          | Agrupar e compor os cartões de um dia                                     | `grupo`, `selecionadoId` → `horarioSelecionado` |
| `horario-card`         | Exibir e selecionar um horário; bloquear indisponíveis                    | `horario`, `selecionado` → `horarioSelecionado` |
| `estado-consulta`      | Carregamento com skeleton, lista vazia e erro com nova tentativa          | `estado`, `mensagemErro` → `tentarNovamente`    |
| `rodape-publico`       | Informações institucionais e limites da demonstração                      | `clinica`                                       |

## Dados entram, ações saem

Os componentes de apresentação não consultam a API, não importam os mocks e não fazem reservas. Recebem dados tipados por `input` e comunicam ações por `output`. A página `HorariosDisponiveis` decide o que fazer com essas ações.

```html
<app-horario-dia
  [grupo]="grupo"
  [selecionadoId]="horarioSelecionado()?.id ?? null"
  (horarioSelecionado)="selecionarHorario($event)"
/>
```

O `horario-dia` usa o mesmo padrão para compor `horario-card`. Essa separação permite reutilizar os cartões sem depender de uma API. Referências oficiais: [inputs](https://angular.dev/guide/components/inputs) e [outputs](https://angular.dev/guide/components/outputs).

## Estado reativo e integração futura

A página `HorariosDisponiveis` usa `signal` para carregamento, erro e seleção; `computed` deriva o agrupamento e o resumo sem duplicar estado. Os componentes usam `OnPush`, e a assinatura de consulta é encerrada com `takeUntilDestroyed` quando a página sai da tela.

`HorariosService.listar()` retorna `Observable<readonly Horario[]>`, com um pequeno atraso simulado para mostrar o skeleton. Os mocks geram os próximos três dias do calendário local, com capacidade de uma reserva por horário e exemplos de indisponibilidade.

Quando existir o backend, substituir a implementação de `listar()` pela consulta HTTP e adaptar o DTO da API ao modelo de apresentação, caso seus formatos sejam diferentes. Não espalhar chamadas HTTP nem conhecimento do DTO pelos componentes.

> [!IMPORTANT]
> Selecionar um cartão apenas destaca a escolha e mostra um resumo. Não consome vaga, não grava no H2 e não navega para um formulário fictício. As telas de dados e comprovante, a integração e as regras de reserva continuam pendentes no roteiro principal.

## Estilos, acessibilidade e verificação

As cores e os espaçamentos ficam em `src/styles.scss`, usando variáveis CSS. Os estilos de cada componente ficam no seu próprio `.scss`; a página de horários cuida apenas do layout. A fonte Inter é servida localmente em `public/fonts`, acompanhada da licença OFL; origem: [projeto Inter](https://github.com/rsms/inter).

Há layout adaptado para celular, foco visível, link para pular ao conteúdo, botões nativos, indicação textual de seleção e motivo visível para horários bloqueados. Skeletons e ícones decorativos ficam fora da leitura assistiva; mensagens de seleção e erro têm anúncio apropriado. A animação respeita a preferência de movimento reduzido.

Executar em `frontend`:

```bash
npm run build
npm run format:check
```

Conferir no navegador a seleção de horários, a troca e limpeza da seleção, o bloqueio dos indisponíveis, o carregamento e o layout no celular. Lista vazia e erro já têm componentes de apresentação; podem ser demonstrados temporariamente alterando a resposta do service mockado. Testes automatizados poderão ser introduzidos quando a turma estiver pronta.

O `strict: false` solicitado permanece inalterado; ainda assim, inputs, outputs, services e mocks usam tipos explícitos.
