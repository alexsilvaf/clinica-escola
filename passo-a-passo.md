# Procedimento recomendado para se desenvolver um sistema com agentes:

1 - Desenvolvar a documentação
    Bases:
    - SCRUM
    - Caso de Uso
    - Critério de Aceitação
    - Requisitos Funcionais/Não funcionais
    - Priorização do MVP
    - Regras de negócio
    - Modelagem técnica

2 - Desenvolver as telas baseadas na documentação (Figma)
    Bases:
    - Fibonacci (Quando se quer desenovolver logo)
    - WCAG (Acessibilidade)
    - Heuristicas de Nielsen (Usabilidade/UX)
    - Teoria das cores
    - Estratégias de SEO
    - Estado vazio das telas
    - Estado de estresse de carga (Vários dados cadastrado, como a tela se comporta, normalmente as tabelas começam a ter paginação)
    - Estado de carregamento (Skeleton/Load)
    - Estado sem permissão
    - Estado de sucesso
    - Componentização

3 - Desenvolvimento da API baseada nos requisitos funcionais (Código)
    Bases:
    - Driven Domain Design
    - Clean Code
    - SOLID
    - Validação
    - Segurança
    - Testes
    - Documentação OpenAPI/Swagger

4 - Desenvolvimento das telas (Código)
    - Implementação fiel ao figma (As IAs costumam pecar bastante em detalhes)
    - Responsividade
    - Componentização (Sem isso, elas repetem muito código)
    - Animações
    - Estado reativo (Como a tela reage quando a API retorna uma resposta)
    - Controle de permissões

5 - Testes para cada requisito, pois apesar da IA testar por conta própria, ela sempre deixa erros e não reconhece
    - Unitários
    - Integração
    - API
    - Front-end
    - E2E
    - Responsividade
    - Acessibilidade
    - Permissões
    - Cenários negativos
    - Regressão

6 - Validação e entrega (Isso daqui é pra cada vez que a IA fizer um push para o remoto)
    - Code review
    - Build
    - Análise estática
    - Segurança
    - Testes E2E
    - Aprovação
    - Monitoramento/logs


Extra:
    Agentes recomendados:
    - Agente de Produto
    - Agente de Arquitetura
    - Agente UX/UI
    - Agente Backend
    - Agente Frontend
    - Agente QA