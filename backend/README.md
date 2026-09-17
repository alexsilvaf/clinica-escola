# Clínica Escola — API

[Início](../README.md) · [Frontend](../frontend/README.md) · [Referências adicionais](HELP.md)

<details>
<summary>Sumário — navegar pelas seções</summary>

- [Stack e identificação](#stack-e-identificação)
- [Executar o backend](#executar-o-backend)
- [Testar e gerar o artefato](#testar-e-gerar-o-artefato)
- [Configuração local](#configuração-local)
- [Organização recomendada](#organização-recomendada)
- [Validações e tabelas](#validações-e-tabelas)
- [Referências](#referências)

</details>

## Stack e identificação

- Java **25**, definido no toolchain do Gradle.
- Spring Boot **4.1.1**, Gradle Wrapper **9.7.1**.
- REST: `spring-boot-starter-webmvc` (não SOAP).
- JPA/Hibernate: `spring-boot-starter-data-jpa`; não é necessário declarar
  Hibernate separadamente.
- Bean Validation/Hibernate Validator: `spring-boot-starter-validation`.
- H2 e Lombok, com processamento de anotações para código principal e testes.

Projeto Gradle e aplicação: `clinica-escola-api`. Grupo e pacote-base:
`br.com.clinicaescola`. Classe de entrada: `ClinicaEscolaApplication`.
Este namespace é provisório: quando a organização definir seu domínio,
ajustar grupo e pacotes para o domínio reverso correspondente, sem presumir
titularidade de `clinicaescola.com.br`.

As versões de Hibernate, H2, Lombok e Validator são gerenciadas pelo BOM do
Spring Boot; evitar versões avulsas sem necessidade.

## Executar o backend

### 1 — Instalar e verificar o Git

Baixe o [Git](https://git-scm.com/downloads), conclua a instalação e abra um
novo terminal. Confirme que o comando está disponível:

```bash
git --version
```

### 2 — Instalar o JDK 25

Instale um **JDK 25** — não apenas um JRE — usando uma distribuição como
[Eclipse Temurin](https://adoptium.net/) ou [Oracle JDK](https://www.oracle.com/java/technologies/downloads/).

No Windows, durante a instalação, habilite as opções para definir `JAVA_HOME`
e adicionar o Java ao `PATH`, quando disponíveis. Se precisar configurar
manualmente:

1. abra **Editar as variáveis de ambiente do sistema**;
2. em **Variáveis de Ambiente**, crie `JAVA_HOME` apontando para a pasta do JDK
   25, sem incluir a subpasta `bin`;
3. edite a variável `Path` e adicione `%JAVA_HOME%\bin`;
4. feche e abra novamente o terminal.

No macOS ou Linux, configure `JAVA_HOME` de acordo com o gerenciador de pacotes
ou a distribuição do JDK utilizada e adicione `$JAVA_HOME/bin` ao `PATH`.

Verifique a configuração:

```bash
java --version
javac --version
```

Os dois comandos devem indicar a versão 25. No PowerShell, também é possível
conferir o caminho configurado com `echo $env:JAVA_HOME`.

### 3 — Baixar o projeto

Escolha uma pasta de trabalho e execute:

```bash
git clone https://github.com/alexsilvaf/clinica-escola.git
cd clinica-escola/backend
```

Se o projeto já estiver baixado, basta abrir o terminal na pasta `backend`.

### 4 — Verificar o Gradle Wrapper

Não é necessário instalar o Gradle globalmente. O projeto contém o Gradle
Wrapper e fixa a versão **9.7.1**. Na primeira execução, ele baixará essa versão,
portanto é necessário estar conectado à internet.

No Windows (Prompt de Comando ou PowerShell):

```powershell
.\gradlew.bat --version
```

No macOS ou Linux:

```bash
./gradlew --version
```

O resultado deve mostrar Gradle 9.7.1 e JVM 25. Se a JVM exibida não for a 25,
revise `JAVA_HOME` e o `PATH` antes de continuar.

### 5 — Iniciar a API

No Windows:

```powershell
.\gradlew.bat bootRun
```

No macOS ou Linux:

```bash
./gradlew bootRun
```

Aguarde a mensagem de inicialização e acesse
[localhost:8080](http://localhost:8080). Para encerrar a API, pressione
`Ctrl+C`. O primeiro build também baixa as dependências do projeto e pode levar
mais tempo.

## Testar e gerar o artefato

Execute dentro da pasta `backend`. No Windows:

```powershell
.\gradlew.bat test
.\gradlew.bat clean build
```

No macOS ou Linux:

```bash
./gradlew test
./gradlew clean build
```

O artefato executável será gerado em
`build/libs/clinica-escola-api-0.0.1-SNAPSHOT.jar`.
Os testes verificam inicialização, conexão H2, Hibernate como provedor JPA,
limites numéricos/textuais e processamento de anotações Lombok.

## Configuração local

`application.properties` contém as configurações comuns. O perfil padrão é
`dev`, definido em `application-dev.properties`:

- porta `8080` (alterável via `SERVER_PORT`);
- banco `jdbc:h2:mem:clinicaescola;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE`;
- usuário `sa`, senha vazia, apenas para desenvolvimento local;
- console em `http://localhost:8080/h2-console`, sem acesso remoto habilitado;
- `ddl-auto=create-drop`: gera as tabelas a partir das entidades e descarta
  os dados ao encerrar. Ainda não há entidades ou tabelas de negócio.

O perfil `test` usa H2 com nome único por contexto e console desabilitado.
O console H2 e DevTools são dependências `developmentOnly` e não integram
o JAR de produção. Fora dos perfis locais, banco embarcado e DDL automático
ficam desabilitados. Um perfil de produção ainda precisa ser configurado,
inclusive com o driver do banco escolhido.

`spring.jpa.open-in-view=false` mantém o acesso a dados dentro das transações.
`spring.mvc.problemdetails.enabled=true` habilita o formato de erro padrão do
Spring MVC; erros de domínio poderão receber tratamento específico no futuro.

## Organização recomendada

Criar pacotes por funcionalidade abaixo de `br.com.clinicaescola`, conforme
os casos de uso forem implementados. Exemplo: `estudante.controller`,
`estudante.dto`, `estudante.entity`, `estudante.repository`, `estudante.service`.
Código transversal pode ir em `config` e `shared`, somente quando necessário.
Usar PascalCase para classes, minúsculas para pacotes e um idioma consistente.
Não é necessário criar classes ou diretórios vazios agora.

Usar DTOs na API, entidades na persistência e transações nos services.
Evitar retornar entidades diretamente ou usar `@Data` indiscriminadamente
em entidades com relacionamentos JPA.

## Validações e tabelas

As anotações são de `jakarta.validation`, não `javax.validation`:

```java
@NotBlank
@Size(min = 2, max = 100)
private String nome;

@NotNull
@Min(1)
@Max(10)
private Integer capacidade;
```

No controller, usar `@Valid @RequestBody` para validar DTOs de entrada.
Os limites devem vir das regras de negócio, não destes valores ilustrativos.
Para strings/coleções usar `@Size`; para números usar `@Min`/`@Max` ou
`@DecimalMin`/`@DecimalMax`. Limites numéricos não rejeitam `null` sozinhos:
associar `@NotNull` quando o campo for obrigatório.

Aplicar validações também nas entidades quando forem invariantes da persistência.
Configurar `@Column(nullable = false, length = 100)`, unicidade e relacionamentos
conforme a modelagem. Bean Validation não substitui um schema corretamente
definido: restrições `CHECK`, chaves e limites devem ser explicitados/testados
nas migrations do banco definitivo.

## Referências

- [Requisitos do Spring Boot](https://docs.spring.io/spring-boot/system-requirements.html)
- [JPA e H2](https://docs.spring.io/spring-boot/reference/data/sql.html)
- [Validação](https://docs.spring.io/spring-boot/reference/io/validation.html)
