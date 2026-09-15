# Protótipo de interface (Figma)

[Início](../../README.md) · [Documentação](../README.md) · [Especificação de telas](telas.md)

Telas do MVP desenhadas a partir dos casos de uso desta documentação.

| Informação              | Valor                                                                                               |
| ----------------------- | --------------------------------------------------------------------------------------------------- |
| Arquivo                 | Clínica-Escola — Sistema de Gestão (MVP)                                                            |
| Status                  | Em validação                                                                                        |
| Última atualização      | 15 de setembro de 2026                                                                              |
| Especificação detalhada | [telas.md](telas.md) — o que cada tela informa, os padrões de exibição de dados e a rastreabilidade |
| Auditorias              | relatórios locais de navegação e componentes, não versionados no Git                                |

<details>
<summary>Sumário — navegar pelas seções</summary>

- [Organização do arquivo](#organização-do-arquivo)
- [Telas por caso de uso](#telas-por-caso-de-uso)
- [Estados obrigatórios de cada tela](#estados-obrigatórios-de-cada-tela)
- [Componentes](#componentes)
- [Correções aplicadas na revisão](#correções-aplicadas-na-revisão)
- [Decisões de design](#decisões-de-design)
- [Pendências herdadas da documentação](#pendências-herdadas-da-documentação)

</details>

## Organização do arquivo

| Página                 | Conteúdo                                                                                                                                     |
| ---------------------- | -------------------------------------------------------------------------------------------------------------------------------------------- |
| `Fundamentos`          | tokens, paleta com contraste medido, escala tipográfica, escala Fibonacci, princípios aplicados e índice de telas                            |
| `Componentes`          | 26 famílias de componentes e 24 ícones — ver a tabela de componentes abaixo                                                                  |
| `Comunidade (público)` | 21 quadros: telas, estados e sobreposições do agendamento em 1440 px e em 390 px                                                             |
| `Estudante`            | 9 quadros: telas do portal e estados de horários liberados, envio de documento e disponibilidade salva                                       |
| `Interno (equipe)`     | 90 quadros: telas principais, estados, sobreposições, estados do semestre, cadastros por registro e em criação, e resultados com notificação |

Cada página é organizada em linhas nomeadas no canvas. A antiga página `Estados` foi desfeita porque o protótipo do Figma só navega dentro da mesma página: cada estado foi para a página do seu portal. O protótipo está ligado — oito fluxos nomeados (entrar e operar, configurar e ativar o semestre, estudantes; agendar pelo computador, pelo celular e gerenciar; estudante com pendência e estudante apto). A conferência das ligações está no item 21 de [telas.md](telas.md).

As telas não exibem nenhum código de caso de uso, requisito ou norma: a rastreabilidade fica em [telas.md](telas.md).

## Telas por caso de uso

| Caso de uso | Tela                                                                                                                                                                                                                                         | Página                                  |
| ----------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------- |
| UC-001      | Estudantes (lista, carga, inativação em lote) · Novo estudante · cadastro de cada estudante · Meu perfil (estudante) e disponibilidade salva                                                                                                 | Interno (equipe) · Estudante            |
| UC-002      | Validação de documentação (aprovar e recusar) · Estudante · Meus documentos e estados de envio                                                                                                                                               | Interno (equipe) · Estudante            |
| UC-003      | Professores e preceptores · Novo supervisor · cadastro de cada supervisor · limite de supervisão do semestre                                                                                                                                 | Interno (equipe)                        |
| UC-004      | Capacidade de supervisão                                                                                                                                                                                                                     | Interno (equipe)                        |
| UC-005      | Estudante · Horários elegíveis, bloqueado e liberado                                                                                                                                                                                         | Estudante                               |
| UC-006      | Clínicas, ambientes e equipamentos · Novo ambiente · cadastro de cada ambiente · catálogo de equipamentos · bloqueio com reservas afetadas                                                                                                   | Interno (equipe)                        |
| UC-007      | Configuração do semestre e estados de ativação · Calendário da oferta acadêmica                                                                                                                                                              | Interno (equipe)                        |
| UC-008      | Início e busca · Horários disponíveis · Dados mínimos · Comprovante · Gerenciar agendamento · Endereços e horários · Conflito · Cancelamento público · telas móveis de ponta a ponta · Agendamentos (visão da clínica, confirmar e cancelar) | Comunidade (público) · Interno (equipe) |
| UC-009      | Entrar no sistema · Usuários e permissões (revogação e perfis Master) · Usuário e papel · cadastro de cada usuário · Auditoria · Painel da operação                                                                                          | Interno (equipe)                        |

## Estados obrigatórios de cada tela

Toda lista, formulário e consulta precisa responder a estas sete situações antes de ser considerada pronta.

| Estado           | Quando aparece                      | O que a tela precisa fazer                                                                      | Demonstração                                           |
| ---------------- | ----------------------------------- | ----------------------------------------------------------------------------------------------- | ------------------------------------------------------ |
| Carregando       | consulta acima de 300 ms            | esqueleto com a forma do conteúdo real, status em região viva, sem salto de layout              | Carregamento · lista de estudantes e horários públicos |
| Vazio inicial    | nenhum dado cadastrado              | explicar o que apareceria ali, ensinar o caminho, oferecer a primeira ação                      | Vazio · primeira execução do semestre                  |
| Vazio por filtro | há dados, o filtro não retorna nada | distinguir dos dois casos, listar filtros ativos, prever o efeito de remover cada um            | Vazio · busca sem resultado                            |
| Sem permissão    | papel sem autorização               | dizer o papel exigido, a quem pedir e o que é possível fazer no lugar                           | Sem permissão · área restrita e código inválido        |
| Sucesso          | operação concluída                  | notificação temporária, mudança persistente na lista, efeito explicado e desfazer quando couber | Sucesso · documento aprovado e semestre ativado        |
| Erro             | falha de consulta, rede ou servidor | dizer o que falhou, o que não foi afetado, oferecer nova tentativa, preservar o trabalho        | Erro · falha ao carregar dados                         |
| Carga            | volume alto de registros            | paginação no servidor, ordenação estável, seleção que sobrevive à página, densidade ajustável   | Carga · 154 registros com paginação                    |

Além desses, a área interna traz a confirmação de ação destrutiva em cena completa e, como sobreposições próprias, as confirmações contextuais: cancelar reserva, inativar em lote, revogar papel, remover equipamento em uso e aplicar bloqueio com reservas afetadas.

## Componentes

| Componente                                                                                | Variantes                                               | Observação                                                                              |
| ----------------------------------------------------------------------------------------- | ------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| Botão                                                                                     | Primária, Secundária, Texto, Perigo                     | alvo mínimo de 40 px                                                                    |
| Selo de status                                                                            | Aprovado, Pendente, Em análise, Recusado, Neutro, Marca | cor de marca reservada a estado; contagens usam Neutro                                  |
| Campo                                                                                     | Padrão, Foco, Erro                                      | rótulo visível permanente e texto de apoio                                              |
| Campo de busca                                                                            | —                                                       | substitui as buscas que usavam apenas placeholder                                       |
| Filtro                                                                                    | Padrão, Aplicado                                        | o estado aplicado mostra o valor e permite remover em um clique                         |
| Paginação                                                                                 | —                                                       | recorte exibido, total real e itens por página                                          |
| Esqueleto                                                                                 | Linha de tabela, Cartão, Bloco de texto, Horário, Campo | reproduz a anatomia real do conteúdo que substitui                                      |
| Tempo com situação                                                                        | Em análise, Pendente, Recusado, Aprovado, Neutro        | o tempo de espera carrega a situação por forma, cor e rótulo                            |
| Item de verificação                                                                       | Conforme, Atenção, Impedimento, Neutro                  | resultado por marcador e cor do título, sem etiqueta                                    |
| Célula dupla                                                                              | Normal, Esmaecido                                       | junta duas colunas em uma; a esmaecida marca registro inativo                           |
| Botão de ícone                                                                            | Abrir, Editar, Remover                                  | ação repetida em tabela, com nome acessível completo; leva ao registro da própria linha |
| Cabeçalho público                                                                         | Link ativo: Nenhum, Endereços e horários                | inclui o atalho para o conteúdo; usado em todas as páginas públicas e seus estados      |
| Rodapé público                                                                            | —                                                       | presente em todas as páginas públicas                                                   |
| Cabeçalho do estudante                                                                    | Aba: Meus horários, Meus documentos, Meu perfil         | único para o portal do estudante                                                        |
| Cabeçalho público · móvel                                                                 | —                                                       | abaixo de 768 px, com menu                                                              |
| Medidor de capacidade                                                                     | Livre, Quase cheio, Cheio                               | número, folga em texto e barra proporcional                                             |
| Minigráfico semanal                                                                       | —                                                       | ritmo dos últimos sete dias                                                             |
| Anel de ocupação                                                                          | —                                                       | percentual com valor absoluto ao lado                                                   |
| Legenda de situação                                                                       | —                                                       | obrigatória quando a cor de um dado carrega significado                                 |
| Estado da tela                                                                            | Vazio, Sem resultado, Sem permissão, Sucesso, Erro      | mesma anatomia: ícone, título, explicação e ações                                       |
| Notificação                                                                               | Sucesso, Erro, Alerta, Info                             | nunca é o único registro do que aconteceu                                               |
| Diálogo de confirmação                                                                    | —                                                       | foco preso, Esc fecha, botões nomeiam a ação                                            |
| Aviso, Cartão de métrica, Barra lateral, Barra superior, 24 ícones (inclui menu e fechar) | —                                                       | —                                                                                       |

## Correções aplicadas na revisão

| Ponto                    | O que mudou                                                                                                                                                                                                                                                                |
| ------------------------ | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| WCAG                     | busca com rótulo visível (3.3.2); ação “Editar” virou botão com alvo próprio (2.5.8); botão desabilitado deixou de depender de opacidade; atalho “pular para o conteúdo” nas páginas públicas (2.4.1); estados anunciados por região viva (4.1.3)                          |
| Nielsen                  | paginação e contagem real em todas as listas longas; trilha de navegação no fluxo público; confirmação nomeada para ações destrutivas; sucesso com desfazer                                                                                                                |
| Teoria das cores         | cor de marca passou a indicar exclusivamente estado — contagens migraram para o selo neutro                                                                                                                                                                                |
| SEO                      | folha de anotações por página pública com title, meta description, URL, hierarquia de títulos, dados estruturados e regra de indexação                                                                                                                                     |
| Componentização          | sete padrões que eram montados à mão viraram componentes únicos                                                                                                                                                                                                            |
| Navegação                | nenhuma ligação de protótipo existia; hoje 1.400 nós têm reação, sem destino inválido, e os controles sem ligação estão justificados                                                                                                                                       |
| Telas e modais restantes | calendário da oferta acadêmica, catálogos de ambientes e equipamentos, cinco confirmações contextuais, cancelamento público e folha móvel, estados do semestre, estados de envio, modos de criação e edição por registro, telas móveis finais e resultados com notificação |
| Alinhamento              | cabeçalho de dias das grades de turno estava deslocado por um marcador oculto; colunas passaram a ter largura inteira e igual ao cabeçalho                                                                                                                                 |
| Dados                    | dias da semana, estudantes da agenda, situação documental, analistas, contagens de seleção e datas de supervisão harmonizados entre telas (item 22 de telas.md)                                                                                                            |

## Decisões de design

| Base                   | Aplicação                                                                                                                                                                          |
| ---------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Fibonacci              | escala de espaçamento 2, 4, 8, 13, 21, 34, 55, 89 e escala tipográfica 11, 13, 21, 34, 55 com degraus intermediários de 16 e 26                                                    |
| WCAG 2.2 AA            | contraste mínimo de 4,5:1 em texto normal, alvos de 40 px, rótulo visível permanente, foco de 2 px, erro descrito em texto e estado nunca comunicado só por cor                    |
| Heurísticas de Nielsen | semestre vigente sempre visível, motivo de indisponibilidade exibido, ativação bloqueada com impedimento, recusa sempre acompanhada da orientação de correção                      |
| Teoria das cores       | matiz teal (cuidado e confiança), harmonia análoga, cores de feedback reservadas exclusivamente a estado, proporção 60-30-10                                                       |
| SEO                    | hierarquia semântica com um H1 por página, URLs legíveis, dados estruturados `MedicalClinic`/`Service`, SEO local, mobile-first a partir de 360 px e `noindex` nas áreas restritas |

## Pendências herdadas da documentação

As telas expõem essas lacunas como avisos explícitos, sem inventar regra:

- matriz de permissões definitiva por papel (UC-009);
- política de confirmação, cancelamento, prazo e falta (UC-008);
- tratamento de reservas futuras quando a configuração semestral muda (UC-007);
- modelo de equipamento: unidade identificada ou quantidade por tipo (UC-006);
- prazo de retenção e descarte dos registros de auditoria e dos documentos (UC-002, UC-009).
