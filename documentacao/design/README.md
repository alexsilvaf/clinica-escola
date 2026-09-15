# Protótipo de interface (Figma)

Telas do MVP desenhadas a partir dos casos de uso desta documentação.

> **Arquivo:** Clínica-Escola — Sistema de Gestão (MVP)
> **Status:** Em validação
> **Última atualização:** 15 de setembro de 2026
> **Especificação detalhada:** [telas.md](telas.md) — o que cada tela informa, os padrões de exibição de dados e a rastreabilidade
> **Auditoria de navegação:** [telas-modais-restantes.md](telas-modais-restantes.md) — botões sem interação, destinos existentes e telas/modais/variantes restantes

## Organização do arquivo

| Página | Conteúdo |
|---|---|
| `Fundamentos` | tokens, paleta com contraste medido, escala tipográfica, escala Fibonacci, princípios aplicados e índice de telas |
| `Componentes` | 14 componentes e 22 ícones — ver a tabela de componentes abaixo |
| `Comunidade (público)` | fluxo de agendamento da comunidade, em 1440 px e em 390 px |
| `Estudante` | portal do estudante |
| `Interno (equipe)` | área autenticada da instituição |
| `Estados` | carregamento, vazio, sem permissão, sucesso, erro e carga demonstrados em contexto real |

As telas não exibem nenhum código de caso de uso, requisito ou norma: a rastreabilidade fica em [telas.md](telas.md).

## Telas por caso de uso

| Caso de uso | Tela | Página |
|---|---|---|
| UC-001 | Estudantes (lista) · Cadastro de estudante · Meu perfil (estudante) | Interno (equipe) · Estudante |
| UC-002 | Validação de documentação · Estudante · Meus documentos | Interno (equipe) · Estudante |
| UC-003 | Professores e preceptores · Cadastro de supervisor | Interno (equipe) |
| UC-004 | Capacidade de supervisão | Interno (equipe) |
| UC-005 | Estudante · Horários elegíveis (com estado vazio explicando o impedimento) | Estudante |
| UC-006 | Clínicas, ambientes e equipamentos · Ambiente e capacidade | Interno (equipe) |
| UC-007 | Configuração do semestre (validação de consistência e ativação) | Interno (equipe) |
| UC-008 | Início e busca · Horários disponíveis · Dados mínimos · Comprovante · Gerenciar agendamento · Endereços e horários · Estado de conflito · Agendamentos (visão da clínica) | Comunidade (público) · Interno (equipe) |
| UC-009 | Entrar no sistema · Usuários e permissões · Usuário e papel · Auditoria · Painel da operação | Interno (equipe) |

## Estados obrigatórios de cada tela

Toda lista, formulário e consulta precisa responder a estas sete situações antes de ser considerada pronta.

| Estado | Quando aparece | O que a tela precisa fazer | Demonstração |
|---|---|---|---|
| Carregando | consulta acima de 300 ms | esqueleto com a forma do conteúdo real, status em região viva, sem salto de layout | Carregamento · lista de estudantes e horários públicos |
| Vazio inicial | nenhum dado cadastrado | explicar o que apareceria ali, ensinar o caminho, oferecer a primeira ação | Vazio · primeira execução do semestre |
| Vazio por filtro | há dados, o filtro não retorna nada | distinguir dos dois casos, listar filtros ativos, prever o efeito de remover cada um | Vazio · busca sem resultado |
| Sem permissão | papel sem autorização | dizer o papel exigido, a quem pedir e o que é possível fazer no lugar | Sem permissão · área restrita e código inválido |
| Sucesso | operação concluída | notificação temporária, mudança persistente na lista, efeito explicado e desfazer quando couber | Sucesso · documento aprovado e semestre ativado |
| Erro | falha de consulta, rede ou servidor | dizer o que falhou, o que não foi afetado, oferecer nova tentativa, preservar o trabalho | Erro · falha ao carregar dados |
| Carga | volume alto de registros | paginação no servidor, ordenação estável, seleção que sobrevive à página, densidade ajustável | Carga · 154 registros com paginação |

Além desses, a página `Estados` traz a confirmação de ação destrutiva, com regras de foco, escrita da consequência e nomeação dos botões.

## Componentes

| Componente | Variantes | Observação |
|---|---|---|
| Botão | Primária, Secundária, Texto, Perigo | alvo mínimo de 40 px |
| Selo de status | Aprovado, Pendente, Em análise, Recusado, Neutro, Marca | cor de marca reservada a estado; contagens usam Neutro |
| Campo | Padrão, Foco, Erro | rótulo visível permanente e texto de apoio |
| Campo de busca | — | substitui as buscas que usavam apenas placeholder |
| Filtro | Padrão, Aplicado | o estado aplicado mostra o valor e permite remover em um clique |
| Paginação | — | recorte exibido, total real e itens por página |
| Esqueleto | Linha de tabela, Cartão, Bloco de texto, Horário | mantém a forma do conteúdo real |
| Tempo com situação | Em análise, Pendente, Recusado, Aprovado, Neutro | o tempo de espera carrega a situação por forma, cor e rótulo |
| Item de verificação | Conforme, Atenção, Impedimento, Neutro | resultado por marcador e cor do título, sem etiqueta |
| Célula dupla | Normal, Esmaecido | junta duas colunas em uma; a esmaecida marca registro inativo |
| Botão de ícone | Abrir, Editar, Remover | ação repetida em tabela, com nome acessível completo |
| Medidor de capacidade | Livre, Quase cheio, Cheio | número, folga em texto e barra proporcional |
| Minigráfico semanal | — | ritmo dos últimos sete dias |
| Anel de ocupação | — | percentual com valor absoluto ao lado |
| Legenda de situação | — | obrigatória quando a cor de um dado carrega significado |
| Estado da tela | Vazio, Sem resultado, Sem permissão, Sucesso, Erro | mesma anatomia: ícone, título, explicação e ações |
| Notificação | Sucesso, Erro, Alerta, Info | nunca é o único registro do que aconteceu |
| Diálogo de confirmação | — | foco preso, Esc fecha, botões nomeiam a ação |
| Aviso, Cartão de métrica, Barra lateral, Barra superior, 22 ícones | — | — |

## Correções aplicadas na revisão

| Ponto | O que mudou |
|---|---|
| WCAG | busca com rótulo visível (3.3.2); ação “Editar” virou botão com alvo próprio (2.5.8); botão desabilitado deixou de depender de opacidade; atalho “pular para o conteúdo” nas páginas públicas (2.4.1); estados anunciados por região viva (4.1.3) |
| Nielsen | paginação e contagem real em todas as listas longas; trilha de navegação no fluxo público; confirmação nomeada para ações destrutivas; sucesso com desfazer |
| Teoria das cores | cor de marca passou a indicar exclusivamente estado — contagens migraram para o selo neutro |
| SEO | folha de anotações por página pública com title, meta description, URL, hierarquia de títulos, dados estruturados e regra de indexação |
| Componentização | sete padrões que eram montados à mão viraram componentes únicos |

## Decisões de design

| Base | Aplicação |
|---|---|
| Fibonacci | escala de espaçamento 2, 4, 8, 13, 21, 34, 55, 89 e escala tipográfica 11, 13, 21, 34, 55 com degraus intermediários de 16 e 26 |
| WCAG 2.2 AA | contraste mínimo de 4,5:1 em texto normal, alvos de 40 px, rótulo visível permanente, foco de 2 px, erro descrito em texto e estado nunca comunicado só por cor |
| Heurísticas de Nielsen | semestre vigente sempre visível, motivo de indisponibilidade exibido, ativação bloqueada com impedimento, recusa sempre acompanhada da orientação de correção |
| Teoria das cores | matiz teal (cuidado e confiança), harmonia análoga, cores de feedback reservadas exclusivamente a estado, proporção 60-30-10 |
| SEO | hierarquia semântica com um H1 por página, URLs legíveis, dados estruturados `MedicalClinic`/`Service`, SEO local, mobile-first a partir de 360 px e `noindex` nas áreas restritas |

## Pendências herdadas da documentação

As telas expõem essas lacunas como avisos explícitos, sem inventar regra:

- matriz de permissões definitiva por papel (UC-009);
- política de confirmação, cancelamento, prazo e falta (UC-008);
- tratamento de reservas futuras quando a configuração semestral muda (UC-007);
- modelo de equipamento: unidade identificada ou quantidade por tipo (UC-006);
- prazo de retenção e descarte dos registros de auditoria e dos documentos (UC-002, UC-009).
