# Telas e modais restantes — auditoria de navegação

Auditoria realizada em **15 de setembro de 2026**, por leitura do arquivo pelo MCP do Figma. Nenhuma camada ou conexão foi alterada no Figma. O link do arquivo permanece fora da documentação.

## Resultado principal

**Há telas desenhadas, mas nenhuma conexão de protótipo configurada.** Os botões inventariados abaixo não levam a uma tela por interação de protótipo neste estado do arquivo. Isso não significa que todas as telas de destino estejam faltando.

Foram inspecionadas as seis páginas, incluindo componentes, camadas internas e ancestrais: **9.266 nós**, dos quais **9.253 expõem `reactions`**, sem erro de leitura e sem nenhuma reação não vazia. Não foi encontrada conexão de navegação, abertura/fechamento de overlay, retorno, URL ou mudança interativa de estado nessas propriedades.

| Página | Telas/estados/modais de uso | Instâncias visíveis de Botão/Botão de ícone |
|---|---:|---:|
| Comunidade (público) | 10 | 35 |
| Interno (equipe) | 15 | 57 |
| Estudante | 3 | 6 |
| Estados | 14 | 58 |
| Total | 42 | 156 |

Fundamentos e Componentes também foram inspecionados, mas não entram na contagem de telas de uso. Os 156 incluem repetições e a ativação intencionalmente desabilitada. Menus, abas, horários e outros controles personalizados não entram nessa contagem; estão relacionados separadamente.

O [mapa de ações de telas.md](telas.md#mapa-de-ações-e-destinos) descreve **destinos esperados**, não conexões efetivamente configuradas. Esta auditoria separa evidência do arquivo e recomendações de conclusão.

## Como localizar e interpretar

Localize pela página, nome da tela, contexto da camada e ID do nó. IDs iniciados por `I` identificam filhos de instâncias; não são novas telas. Os IDs correspondem ao momento da inspeção e podem mudar se uma camada for recriada.

Todas as linhas do inventário estão **sem interação configurada**. A classificação informa o trabalho restante:

- **E — destino existente:** conectar a tela/diálogo desenhado; algumas entradas exigem modo de criação/edição, filtros ou contexto do registro.
- **M — desenho/variante ausente:** criar ou completar tela, modal ou variante antes de conectar.
- **L — ação local:** muda conteúdo, abre seletor nativo, copia ou fecha modal; não precisa navegar a uma tela nova.
- **D — decisão de comportamento/escopo:** esclarecer o destino ou retirar/renomear o CTA, preservando orientação útil.
- **B — bloqueado intencionalmente:** ausência de clique está correta enquanto a condição de bloqueio existir.

Os destinos descritos nas tabelas são propostas coerentes com o arquivo e a especificação; não foram configurados nesta auditoria.

## T1 — Tela/editor realmente restante

| Item | Origem comprovada | O que falta | Desfecho esperado |
|---|---|---|---|
| Calendário/oferta acadêmica do semestre | Interno → Configuração do semestre `23:1145` → Validação de consistência → segundo “Corrigir”, `72:2440` | Não há tela/modal de edição dos horários das disciplinas/estágios. A mensagem é “2 disciplinas sem horário no calendário do semestre”. O seletor de vínculo `96:1746` não edita calendário. | Editor com disciplina/estágio, curso/período, dias/horários e vínculo ao semestre; salvar/cancelar retorna à configuração e permite nova validação. |

Base: [RF-007.02 e RF-007.03](../UC-007-configurar-semestre/requisitos-funcionais.md) e [RF-005.01](../UC-005-validar-compatibilidade-horarios/requisitos-funcionais.md). O formato pode ser tela, etapa da configuração ou modal; a lacuna é a **edição do calendário**, não a obrigação de criar uma rota específica.

O **primeiro “Corrigir”**, `72:2431`, trata de “3 supervisores sem limite de supervisão simultânea”: seu destino já existe em Supervisores `18:711`/Cadastro de supervisor `89:2334`. Não ligar ambos os botões ao mesmo cadastro.

## Modais e variantes restantes

Há um catálogo desenhado e uma demonstração de confirmação de cancelamento. Reutilizar essas estruturas; os itens abaixo não exigem componentes totalmente novos.

| Item | Botões/camadas de origem | Evidência e trabalho restante |
|---|---|---|
| M1 · Catálogo de ambientes do supervisor | Cadastro de supervisor `89:2334`: selos de adição `89:2488` e `89:2490` | A especificação prevê seletor reutilizado. O único modal `96:1746` mostra disciplinas/estágios, não ambientes. Criar variante com ambientes, busca/seleção e retorno ao supervisor. Se os selos forem adição direta, documentar essa alternativa em vez de exigir modal. |
| M2 · Catálogo de equipamentos | Ambiente e capacidade → “Adicionar equipamento” `90:2955` | Falta variante de `96:1746` com equipamentos e campos compatíveis com o modelo aprovado. Não abrir lista de disciplinas para adicionar equipamento. |
| M3 · Confirmação de inativação em lote | Carga → “Inativar” `44:1156` | Só existe demonstração de cancelar um atendimento. Falta texto/contexto da inativação, quantidade selecionada, confirmar/manter e lista atualizada. |
| M4 · Confirmação de revogação de papel | Usuários → “Revogar papel” `63:2324` → Usuário e papel `90:2512` | Cadastro de destino existe; falta confirmação com pessoa, papel/escopo afetado, efeito e opção de manter acesso. |
| M5 · Confirmação de remoção de equipamento em uso | Ambiente → “Remover” `90:2939`, `90:2946`, `90:2953` | Remoção local pode bastar quando permitido. Para equipamento em uso, a confirmação prevista em telas.md não está demonstrada; não reutilizar texto de cancelamento de atendimento. |
| M6 · Bloqueio com reservas afetadas | Clínicas → “Aplicar bloqueio” `21:1293` | Formulário já existe e informa que reservas serão listadas para tratamento. Falta estado/lista dessas reservas e confirmação contextual quando houver reservas no período. Não inventar cancelamento automático enquanto a regra permanecer pendente. |
| M7 · Cancelamento público e móvel | `31:278`, `31:390`, `33:338`, `96:1696` | A confirmação existente é `45:1333`, dentro da tela interna de 1440 px `45:1186`. Extrair/reutilizar diálogo com conteúdo da reserva pública, sem expor lista interna; demonstrar adaptação móvel e ligar confirmação ao sucesso público `96:1698`. |

Para o **vínculo acadêmico do estudante**, o modal `96:1746` já é adequado: conectar “+ Adicionar vínculo” `16:559`, “Cancelar” `96:1790` e “Adicionar 1 selecionado” `96:1792`. Falta interação, não outra tela de catálogo acadêmico.

Para o **cancelamento interno**, o desenho já existe: `26:2031` pode abrir o diálogo demonstrado por `45:1333`. O frame `45:1186` é uma cena completa, não um overlay isolado. “Manter atendimento” deve fechar; “Cancelar atendimento” deve atualizar a lista interna. Não levar a equipe ao sucesso do portal público.

## CTAs sem comportamento definido ou com escopo ambíguo

| Item | Camada | O que foi observado | Encaminhamento |
|---|---|---|---|
| D1 · Solicitar acesso ao Master | Estados → Sem permissão `42:529` → `I42:645;39:115` | Não há tela de solicitação nem reação com canal externo. Orientar a procurar o Master não equivale a enviar solicitação. | Definir canal institucional e destino ou retirar botão mantendo explicação. Não inventar e-mail, mensageria ou fluxo de aprovação. |
| D2 · Falar com a recepção | Estados → Código inválido `42:731` → `I42:753;39:117` | Há telefone e atendimento presencial descritos no texto, mas nenhuma ação de chamada/navegação no botão. | Decidir se aciona chamada com contato confirmado ou abre Endereços `92:247`; neste caso, renomear para “Ver contatos da clínica”. O número ilustrativo não foi validado nesta auditoria. |
| D3 · Cobrar documentação pendente | Estados → Semestre ativado `43:890` → Passo 2 → “Abrir” `43:1063` | A camada permanece no Figma; telas.md informa que notificação ativa/cobrança em lote não está prevista. Não existe fluxo de cobrança. | Preferir “Revisar documentação pendente” ligado à fila `17:555`; cobrança ativa exigiria decisão de produto, não é tela restante automaticamente autorizada. |
| D4 · Publicar a agenda da comunidade | Estados → Semestre ativado → Passo 1 → “Abrir” `43:1055` | Existe consulta pública `29:112`, mas não operação independente de publicação. O sucesso já informa oferta sob o semestre ativado. | Se é consulta, renomear para “Ver agenda publicada” e conectar. Só criar publicação separada se entrar no escopo aprovado. |

## Estados que faltam demonstrar — sem necessidade de rota nova

| Contexto | Estado restante | Relação com os botões |
|---|---|---|
| Configuração `23:1145` | Consistência sem impedimentos, ativação habilitada, ativando e semestre já ativo | `23:1439` está corretamente bloqueado no exemplo atual; ligar sucesso `43:890` somente quando válido. |
| Horários elegíveis `27:123` | Oferta liberada após aptidão documental e recursos disponíveis | A tela desenhada mostra bloqueio. “Ir para meus documentos” `27:177` já tem destino `27:2`; falta situação elegível, não tela de documentos. |
| Documentos `27:2` | Arquivo selecionado, envio, erro e resultado registrado | `27:52`/`27:90` podem atuar localmente ou abrir seletor nativo; não demandam outra rota. |
| Cadastros `16:394`, `89:2334`, `90:2512`, `90:2770` | Criação versus edição, registro correto, validação e feedback de persistência | A mesma estrutura pode atender ambos os modos; os ícones “Abrir” não podem abrir sempre o mesmo registro fictício. |
| Público móvel `33:181`, `33:241`, `33:284` | Conflito, consulta por código e sucessos em viewport móvel | Conflito `31:408` e sucessos `96:1637`/`96:1698` já existem fora do recorte móvel. Adaptar apresentação; não duplicar funções de negócio. |
| Confirmação interna `45:1186` | Diálogo fechado e lista com reserva cancelada | O desenho do modal existe, mas confirmar/manter ainda não produz mudança no protótipo. |

## Navegação e controles fora do componente Botão

Todos os controles abaixo também estão sem reação. Rótulos de dados, selos puramente informativos e cartões sem intenção de clique não devem ganhar navegação artificial.

### Barra lateral interna

Conectar as réplicas das camadas `Nav/…` aos destinos existentes, respeitando o papel. Exemplo na Configuração do semestre: `I23:1146;7:23` (Painel).

| Camada | Destino existente |
|---|---|
| Nav/Painel | `11:46` |
| Nav/Agendamentos | `26:1749` |
| Nav/Documentação | `17:555` |
| Nav/Estudantes | `15:261` |
| Nav/Supervisores | `18:711` |
| Nav/Clínicas e ambientes | `21:990` |
| Nav/Capacidade | `19:842` |
| Nav/Semestre | `23:1145` |
| Nav/Usuários e permissões | `24:1373` |
| Nav/Auditoria | `26:1477` |

O ícone **Sair** também está sem ação: na mesma instância, `I23:1146;7:111`. Desfecho esperado: encerrar sessão e mostrar Login `9:2`, sem outra tela.

Em Sem permissão `42:529`, Semestre/Usuários/Auditoria aparecem restritos. Não ligar diretamente a dados protegidos como se estivessem liberados; demonstrar restrição.

### Cabeçalho público

Há réplicas de Serviços, Como funciona, Endereços e horários, Acessibilidade nas seis telas públicas de desktop. Na inicial: `29:11`, `29:13`, `29:15`, `29:17`; em Endereços: `92:257`, `92:259`, `92:261`, `92:263`.

Serviços/Como funciona devem ir às seções da inicial `29:2` (âncora/rolagem; voltar à inicial antes quando em outra tela). Endereços/Acessibilidade devem ir a `92:247`, com seção de acessibilidade quando aplicável. Não faltam quatro páginas novas.

### Abas e seletores

| Controle | IDs auditados | Desfecho esperado |
|---|---|---|
| Abas do estudante · Meus horários / Meus documentos / Meu perfil | `27:9`/`27:11`/`27:13`; `27:130`/`27:132`/`27:134`; `91:121`/`91:123`/`91:125` | Navegar respectivamente a `27:123`, `27:2`, `91:115`. |
| Abas da validação documental | `17:679`, `17:681`, `17:683`, `17:685` | Trocar filtro/fila em `17:555`; não criar quatro páginas. |
| Horários disponíveis · desktop | `29:213`, `29:216`, `29:222`, `29:229`, `29:232`, `29:238`, `29:248`, `29:251` | Selecionar data/sala/horário e abrir Dados mínimos `31:66`, levando seleção. |
| Horários disponíveis · móvel | `33:203`, `33:211`, `33:225`, `33:233` | Selecionar e abrir Dados mínimos móvel `33:241`. |
| Alternativas após conflito | `31:422`, `31:425`, `31:428` | Seleção local; “Reservar o horário escolhido” `31:432` continua revisão/revalidação, sem fingir reserva criada. |
| Paginação · exemplos | `46:1823` (Estudantes), `46:1843` (Documentação), `44:1395` (Carga) | Anterior/próxima/números mudam recorte na lista; itens por página altera tamanho. Componentes têm textos, mas não reação. |
| Densidade da lista | `44:1163` (Compacta) | Alternar densidade local; não é navegação. |
| Ver na fila, após aprovação | `I43:818;39:152` | Voltar à fila `17:555`, preservando contexto do documento. |

Os horários **indisponíveis** `29:219`, `29:235`, `29:245`, `29:254` e o móvel `33:219` devem permanecer sem seleção; a justificativa já aparece no desenho. Não são telas de destino faltantes.

## Inventário dos 156 botões sem interação

Todas as instâncias visíveis dos componentes Botão/Botão de ícone nas 42 telas/estados/modais de uso estão abaixo. Repetições idênticas na mesma tela foram agrupadas, mantendo cada ID. O desfecho é **esperado/recomendado**, não evidência de ligação existente.

### Comunidade (público)

#### UC-008 · Público · Início e busca de serviços — `29:2`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Meu agendamento | `29:20` | E · Gerenciar meu agendamento `31:328`. |
| Agendar atendimento | `29:22` | E · Horários disponíveis `29:112`. |
| Ver horários disponíveis · Ação alinhada ao campo | `29:43` | E · Horários disponíveis `29:112`. |
| Ver horários · Fisioterapia | `29:54` | E · Horários disponíveis `29:112`, preservando filtro de serviço/clínica. |
| Ver horários · Psicologia | `29:62` | E · Horários disponíveis `29:112`, preservando filtro de serviço/clínica. |
| Ver horários · Odontologia | `29:70` | E · Horários disponíveis `29:112`, preservando filtro de serviço/clínica. |
| Ver horários · Nutrição | `29:78` | E · Horários disponíveis `29:112`, preservando filtro de serviço/clínica. |

#### UC-008 · Público · Horários disponíveis — `29:112`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Meu agendamento | `29:130` | E · Gerenciar meu agendamento `31:328`. |
| Agendar atendimento | `29:132` | E · Horários disponíveis `29:112`. |
| Atualizar resultados · Refinar busca | `29:180` | L · Refazer consulta e atualizar horários em `29:112`. |

#### UC-008 · Público · Dados mínimos e revisão — `31:66`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Meu agendamento | `31:84` | E · Gerenciar meu agendamento `31:328`. |
| Agendar atendimento | `31:86` | E · Horários disponíveis `29:112`. |
| Reservar horário · Resumo do atendimento | `31:186` | E · Comprovante `31:190` se sucesso; conflito `31:408` se a vaga acabou; validação permanece no formulário. |
| Voltar e escolher outro horário · Resumo do atendimento | `31:188` | E · Horários disponíveis `29:112`, preservando contexto. |

#### UC-008 · Público · Comprovante do agendamento — `31:190`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Meu agendamento | `31:208` | E · Gerenciar meu agendamento `31:328`. |
| Agendar atendimento | `31:210` | E · Horários disponíveis `29:112`. |
| Copiar · Código de acesso | `31:231` | L · Copiar código e mostrar feedback; não exige tela. |
| Confirmar presença | `31:274` | E · Sucesso público `96:1637`, após confirmação válida. |
| Cancelar atendimento | `31:278` | M · Falta diálogo contextual público (M7); confirmar leva a `96:1698`. |

#### UC-008 · Público · Gerenciar meu agendamento — `31:328`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Meu agendamento | `31:346` | E · Gerenciar meu agendamento `31:328`. |
| Agendar atendimento | `31:348` | E · Horários disponíveis `29:112`. |
| Localizar · Ação alinhada ao campo | `31:365` | E · Reserva em `31:328` se código válido; erro `42:731` se inválido; consulta condicional. |
| Confirmar presença | `31:388` | E · Sucesso público `96:1637`, após confirmação válida. |
| Cancelar atendimento | `31:390` | M · Falta diálogo contextual público (M7); confirmar leva a `96:1698`. |

#### Estado · conflito pela última vaga — `31:408`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Reservar o horário escolhido | `31:432` | E · Selecionar alternativa e revisar em `31:66`, preservando preenchimento e revalidando; nenhuma reserva automática. |
| Ver todos os horários | `31:434` | E · Horários disponíveis `29:112`. |

#### Móvel 390 · Horários disponíveis — `33:181`

Sem instâncias de Botão/Botão de ícone. Controles personalizados descritos acima.

#### Móvel 390 · Dados mínimos — `33:241`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Reservar horário · Corpo | `33:282` | E/M · Comprovante móvel `33:284` se sucesso; conflito existe em `31:408`, sem variante móvel. |

#### Móvel 390 · Comprovante — `33:284`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Confirmar presença · Corpo | `33:336` | E/M · Sucesso `96:1637` existe; falta apresentação móvel. |
| Cancelar atendimento · Corpo | `33:338` | M · Falta confirmação pública/móvel (M7); depois sucesso `96:1698`, também sem variante móvel. |

#### UC-008 · Público · Endereços, horários e acessibilidade — `92:247`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Meu agendamento | `92:266` | E · Gerenciar meu agendamento `31:328`. |
| Agendar atendimento | `92:268` | E · Horários disponíveis `29:112`. |
| Ver horários · Telefone | `92:296`, `92:320`, `92:344`, `92:368` | E · Horários disponíveis `29:112`, preservando filtro de serviço/clínica. |

### Interno (equipe)

#### UC-009 · Entrar no sistema — `9:2`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Entrar | `9:70` | E · Painel `11:46`, após autenticação válida. |

#### Painel da operação — `11:46`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Ver agenda completa | `11:324` | E · Agendamentos da clínica `26:1749`. |
| Revisar configuração · Configuração do semestre | `72:2365` | E · Configuração do semestre `23:1145`. |

#### UC-001 · Estudantes — `15:261`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Novo estudante · Ação alinhada ao campo | `15:397` | E · Cadastro de estudante `16:394`, modo criação. |
| Abrir (ícone) | `82:592`, `82:600`, `82:605`, `82:610`, `82:615`, `82:620`, `82:625`, `82:630` | E · Cadastro de estudante `16:394`, registro da linha e modo consulta/edição. |

#### UC-001 · Cadastro de estudante — `16:394`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Cancelar | `16:683` | E · Voltar à lista `15:261`, sem salvar. |
| Salvar rascunho | `16:685` | E · Persistir rascunho e voltar à lista `15:261` com feedback. |
| Salvar estudante | `16:687` | E · Validar, salvar e voltar à lista `15:261` com feedback. |

#### UC-002 · Validação de documentação — `17:555`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Abrir documento · Visualizador | `17:805` | L · Abrir arquivo protegido no visualizador do navegador; não exige outra tela do produto. |
| Aprovar documento · Ações da decisão | `17:830` | E · Sucesso da aprovação `43:702`; atualizar também a fila. |
| Recusar · Ações da decisão | `17:832` | L · Exigir orientação de correção e atualizar a fila; campo já está no formulário. |

#### UC-003 · Professores e preceptores — `18:711`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Novo supervisor | `18:848` | E · Cadastro de supervisor `89:2334`, modo criação. |

#### UC-004 · Capacidade de supervisão — `19:842`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Ver horários alternativos | `19:1103` | E · Agendamentos da clínica `26:1749`, filtrados pelo intervalo. |
| Ver alternativas | `66:2296`, `66:2313`, `66:2330` | E · Agendamentos da clínica `26:1749`, filtrados pelo intervalo. |
| Ajustar limite | `66:2298`, `66:2315`, `66:2332` | E · Cadastro de supervisor `89:2334`, modo edição e supervisor selecionado. |

#### UC-006 · Clínicas, ambientes e equipamentos — `21:990`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Adicionar ambiente | `21:1181`, `21:1240` | E · Ambiente e capacidade `90:2770`, modo criação. |
| Editar capacidades | `21:1183`, `21:1242` | E · Ambiente e capacidade `90:2770`, modo edição. |
| Aplicar bloqueio | `21:1293` | L/M · Aplicar no formulário atual; falta confirmação/lista de reservas afetadas quando houver reservas no período (M6). |
| Cancelar | `21:1295` | L · Descartar/limpar o formulário de bloqueio em `21:990`. |

#### UC-007 · Configuração do semestre — `23:1145`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Corrigir · Verificação | `72:2431` | E · Supervisores `18:711` filtrados ou cadastro `89:2334`, modo edição do limite. |
| Corrigir · Verificação | `72:2440` | M · Falta editor do calendário/oferta acadêmica do semestre (T1). |
| Ativar semestre · Ativar o semestre 2027.1 | `23:1439` | B/E · Está desabilitado por impedimentos; quando resolvidos, ativar e exibir `43:890`. Falta estado habilitado. |
| Executar verificação novamente · Ativar o semestre 2027.1 | `23:1442` | L · Reexecutar validação em `23:1145`, com carregamento e resultado. |

#### UC-009 · Usuários e permissões — `24:1373`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Novo usuário | `24:1517` | E · Usuário e papel `90:2512`, modo criação. |
| Abrir (ícone) | `82:1956`, `82:1961`, `82:1966`, `82:1971`, `82:1976`, `82:1981` | E · Usuário e papel `90:2512`, registro da linha e modo edição. |
| Revogar papel · Acessos a revisar | `63:2324` | E/M · Usuário e papel `90:2512`, modo revogação; falta confirmação específica (M4). |
| Revisar perfis · Acessos a revisar | `63:2334` | E · Usuário e papel `90:2512`, modo revisão. |

#### UC-009 · Auditoria — `26:1477`

Sem instâncias de Botão/Botão de ícone. Controles personalizados descritos acima.

#### UC-008 · Agendamentos (visão da clínica) — `26:1749`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Confirmar reserva | `26:2029` | L · Revalidar e atualizar a reserva em `26:1749`. |
| Cancelar | `26:2031` | E · Abrir diálogo de cancelamento, instância `45:1333`; demonstração em `45:1186`. |

#### UC-003 · Cadastro de supervisor — `89:2334`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Cancelar | `89:2630` | E · Voltar à origem `18:711`/`19:842`/`23:1145`, conforme o fluxo, sem salvar. |
| Salvar supervisor | `89:2632` | E · Salvar e voltar à origem `18:711`/`19:842`/`23:1145` com feedback. |

#### UC-009 · Usuário e papel — `90:2512`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Cancelar | `90:2766` | E · Voltar a Usuários `24:1373`, sem salvar. |
| Salvar usuário | `90:2768` | E · Salvar e voltar a Usuários `24:1373` com feedback. |

#### UC-006 · Ambiente e capacidade — `90:2770`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Remover · Maca | `90:2939` | L/M · Remover Maca localmente; confirmação quando em uso não demonstrada (M5). |
| Remover · Tens | `90:2946` | L/M · Remover Tens localmente; confirmação quando em uso não demonstrada (M5). |
| Remover · Halteres | `90:2953` | L/M · Remover Halteres localmente; confirmação quando em uso não demonstrada (M5). |
| Adicionar equipamento · Equipamentos | `90:2955` | M · Reutilizar catálogo `96:1746`; falta variante de equipamentos (M2). |
| Cancelar | `90:3007` | E · Voltar a Clínicas `21:990`, sem salvar. |
| Salvar ambiente | `90:3009` | E · Salvar e voltar a Clínicas `21:990` com feedback. |

### Estudante

#### UC-002 · Estudante · Meus documentos — `27:2`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Reenviar documento · Atestado de saúde ocupacional | `27:52` | L · Ativar área de envio em `27:2`; não exige tela adicional. |
| Escolher arquivo · Área de envio | `27:90` | L · Seletor de arquivo do sistema; demonstrar seleção, envio e resultado na própria tela. |

#### UC-005 · Estudante · Horários elegíveis — `27:123`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Ir para meus documentos | `27:177` | E · Meus documentos `27:2`. |

#### UC-001 · Estudante · Meu perfil — `91:115`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Ir para meus documentos · Meu vínculo | `91:243` | E · Meus documentos `27:2`. |
| Cancelar | `91:251` | L · Descartar alterações de disponibilidade em `91:115`. |
| Salvar alterações | `91:253` | L · Salvar disponibilidade e mostrar feedback em `91:115`. |

### Estados

#### Carregamento · lista de estudantes — `40:23`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Novo estudante · Ação alinhada ao campo | `40:204` | E · Cadastro de estudante `16:394`, modo criação. |

#### Carregamento · horários públicos — `40:261`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Meu agendamento · Cabeçalho | `40:266` | E · Gerenciar meu agendamento `31:328`. |

#### Vazio · primeira execução do semestre — `41:255`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Cadastrar estudante | `I41:374;39:91` | E · Cadastro de estudante `16:394`, modo criação. |
| Ver configuração do semestre | `I41:374;39:93` | E · Configuração do semestre `23:1145`. |

#### Vazio · busca sem resultado — `41:416`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Novo estudante · Ação alinhada ao campo | `41:555` | E · Cadastro de estudante `16:394`, modo criação. |
| Limpar todos os filtros | `I41:560;39:103` | L · Limpar filtros e restaurar lista de estudantes `15:261`. |
| Remover apenas a busca | `I41:560;39:105` | L · Remover somente busca, preservando demais filtros. |

#### Sem permissão · área restrita — `42:529`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Solicitar acesso ao Master | `I42:645;39:115` | D · Não há solicitação/canal configurado; definir contato ou retirar CTA, mantendo orientação (D1). |
| Voltar ao painel | `I42:645;39:117` | E · Painel `11:46`. |
| Abrir · Analisar e decidir documentos | `73:2536` | E · Validação de documentação `17:555`, respeitando escopo. |
| Abrir · Consultar capacidade de supervisão | `73:2545` | E · Capacidade `19:842`, respeitando escopo. |
| Abrir · Ver agendamentos da sua clínica | `73:2554` | E · Agendamentos da clínica `26:1749`, respeitando escopo. |

#### Sem permissão · código de acesso inválido — `42:731`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Agendar atendimento · Cabeçalho | `42:736` | E · Horários disponíveis `29:112`. |
| Localizar · Ação alinhada ao campo | `42:751` | E · Reserva em `31:328` se código válido; erro `42:731` se inválido; consulta condicional. |
| Tentar outro código | `I42:753;39:115` | L · Limpar/recolocar foco no código da consulta `42:731`. |
| Falar com a recepção | `I42:753;39:117` | D · Há telefone no texto, mas não há ação de chamada/destino do CTA; definir comportamento e confirmar contato (D2). |
| Ver horários disponíveis · Ainda quer ser atendido? | `42:782` | E · Horários disponíveis `29:112`. |

#### Sucesso · documento aprovado — `43:702`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Analisar o próximo documento | `43:874` | E · Fila `17:555`, próximo documento selecionado. |
| Ver a estudante | `43:876` | E · Cadastro de estudante `16:394`, modo consulta/edição da estudante aprovada. |

#### Sucesso · semestre ativado — `43:890`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Ver oferta publicada | `I43:1006;39:127` | E · Horários públicos `29:112`, filtrados pelo semestre ativado. |
| Voltar à configuração | `I43:1006;39:129` | E · Configuração `23:1145`, modo semestre ativo. |
| Abrir · Passo 1 | `43:1055` | E/D · Oferta pública `29:112`; esclarecer “Publicar”, sem inventar publicação separada (D4). |
| Abrir · Passo 2 | `43:1063` | D · Cobrança não tem fluxo aprovado; preferir revisão da fila `17:555` (D3). |
| Abrir · Passo 3 | `43:1071` | E · Capacidade `19:842`/Supervisores `18:711`, filtrados pelos limites alterados. |

#### Carga · 154 registros com paginação — `44:1003`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Novo estudante · Ação alinhada ao campo | `44:1143` | E · Cadastro de estudante `16:394`, modo criação. |
| Selecionar os 47 · Ações em lote | `44:1150` | L · Selecionar os 47 registros filtrados, não apenas a página. |
| Inativar · Ações em lote | `44:1156` | M · Falta confirmação de inativação em lote e resultado em `44:1003`/`15:261` (M3). |
| Abrir (ícone) | `82:3594`, `82:3599`, `82:3604`, `82:3609`, `82:3614`, `82:3619`, `82:3624`, `82:3629`, `82:3634`, `82:3639`, `82:3644`, `82:3649` | E · Cadastro de estudante `16:394`, registro da linha e modo consulta/edição. |

#### Confirmação de ação destrutiva — `45:1186`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Cancelar · Linha | `45:1312`, `45:1321`, `45:1330` | E · Abrir diálogo `45:1333` para reserva da linha. |
| Manter atendimento | `I45:1333;39:186` | L · Fechar diálogo e preservar reserva/seleção; devolver foco ao acionador. |
| Cancelar atendimento | `I45:1333;39:188` | L · Cancelar e atualizar lista interna `26:1749`; falta demonstrar resultado interno, sem ir ao portal público. |

#### Erro · falha ao carregar dados — `45:1346`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Tentar novamente | `I45:1462;39:139` | L · Repetir consulta que falhou e trocar erro por resultado/carregamento. |
| Voltar ao painel | `I45:1462;39:141` | E · Painel `11:46`. |
| Tentar novamente | `45:1501` | L · Repetir consulta do bloco que falhou sem recarregar o restante. |

#### Sucesso · presença confirmada (público) — `96:1637`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Meu agendamento · Cabeçalho | `96:1642` | E · Gerenciar meu agendamento `31:328`. |
| Agendar atendimento · Cabeçalho | `96:1644` | E · Horários disponíveis `29:112`. |
| Ver meu agendamento | `I96:1647;39:127` | E · Gerenciar meu agendamento `31:328`. |
| Voltar ao início | `I96:1647;39:129` | E · Início público `29:2`. |
| Cancelar atendimento · Seu atendimento | `96:1696` | M · Falta diálogo contextual público (M7); confirmar leva a `96:1698`. |

#### Sucesso · atendimento cancelado (público) — `96:1698`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Meu agendamento · Cabeçalho | `96:1703` | E · Consulta `31:328`; o código cancelado não deve abrir reserva ativa. |
| Agendar atendimento · Cabeçalho | `96:1705` | E · Horários disponíveis `29:112`. |
| Agendar outro horário | `I96:1708;39:127` | E · Horários disponíveis `29:112`. |
| Voltar ao início | `I96:1708;39:129` | E · Início público `29:2`. |

#### Modal · adicionar do catálogo — `96:1746`

| Ação / contexto da camada | IDs sem interação | Desfecho esperado / pendência |
|---|---|---|
| Cancelar | `96:1790` | L · Fechar catálogo e voltar ao acionador sem aplicar seleção. |
| Adicionar 1 selecionado | `96:1792` | L · Aplicar seleção e fechar catálogo; atualizar origem. Variantes dos outros catálogos pendentes (M1/M2). |

## Ordem sugerida de conclusão

1. Conectar navegação estrutural e caminhos existentes: login, barra lateral, abas, busca → seleção de horário → dados → comprovante, consulta por código e sucessos. Demonstrar condições de erro/conflito.
2. Completar T1 (calendário), variantes M1/M2 e confirmações M3–M7. Reutilizar componentes e manter retorno ao acionador.
3. Resolver D1–D4 com o responsável pelo produto, sem introduzir cobrança ativa, canal fictício ou publicação independente por suposição.
4. Demonstrar estados habilitados/bloqueados, modos de edição e variantes móveis.

## Critérios para encerrar esta pendência

- Cada ação habilitada deve ter desfecho observável: tela existente, overlay, retorno/fechamento, ação local/estado ou canal institucional definido.
- Nenhuma conexão deve apontar para nó removido, registro errado ou área fora do papel do usuário.
- Cancelar/Manter em modal deve preservar dados e devolver foco; Confirmar deve mostrar resultado no contexto correto.
- Reservar deve demonstrar sucesso ou conflito, nunca ambos; confirmar/cancelar deve atualizar o estado da reserva.
- Controles desabilitados devem continuar explicando o motivo, sem clique que contorne a condição.
- O fluxo móvel deve terminar em sucesso, conflito e cancelamento sem depender de tela interna de desktop.
- Reexecutar inspeção de `reactions` e revisar os fluxos em apresentação após as ligações; o mapa textual sozinho não comprova conclusão.

Este relatório não altera escopo de negócio e não implementa telas no frontend/backend. Registra o estado do desenho/protótipo e os destinos a concluir.


