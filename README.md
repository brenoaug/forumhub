# ForumHub

[![Java](https://img.shields.io/badge/Java-21-red?logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.2-brightgreen?logo=spring-boot)](https://spring.io/projects/spring-boot)
[![REST API](https://img.shields.io/badge/REST-API-02569B?logo=fastapi&logoColor=white)](https://restfulapi.net/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Spring Security](https://img.shields.io/badge/Spring%20Security-Enabled-6DB33F?logo=springsecurity&logoColor=white)](https://spring.io/projects/spring-security)
[![JWT](https://img.shields.io/badge/JWT-Auth0%204.5.0-000000?logo=jsonwebtokens&logoColor=white)](https://github.com/auth0/java-jwt)
[![Maven](https://img.shields.io/badge/Maven-4.0.0-C71A36?logo=apache-maven)](https://maven.apache.org/)
[![Flyway](https://img.shields.io/badge/Flyway-Enabled-CC0200?logo=flyway&logoColor=white)](https://flywaydb.org/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

API REST para gerenciamento de fóruns desenvolvida como projeto de estudos. A aplicação permite criar, listar, atualizar e deletar tópicos, além de implementar autenticação segura com JWT.

## Sobre o Projeto

ForumHub é uma API RESTful que simula um sistema de fórum. O projeto foi desenvolvido aplicando conceitos de Spring Boot, segurança com JWT, validação de dados e documentação automática com Swagger. Os usuários podem se autenticar e gerenciar tópicos através de requisições HTTP.

## Funcionalidades

- **Criar Tópico**: Cadastra novos tópicos com validação de duplicidade de título e mensagem
- **Listar Tópicos**: Exibe todos os tópicos com paginação e ordenação por data de criação
- **Detalhar Tópico**: Consulta informações detalhadas de um tópico específico
- **Buscar por Filtros**: Filtra tópicos por curso e/ou ano
- **Atualizar Tópico**: Edita título, mensagem, status e curso de tópicos existentes
- **Deletar Tópico**: Remove tópicos do sistema
- **Autenticação JWT**: Sistema de login que gera token para acesso aos endpoints protegidos

## Tecnologias Utilizadas

- **Java 21**: Linguagem de programação principal
- **Spring Boot 4.0.2**: Framework para desenvolvimento da aplicação
- **Spring Data JPA**: Abstração para acesso a dados
- **Spring Security**: Gerenciamento de autenticação e autorização
- **Spring Validation**: Validação de dados de entrada
- **Hibernate**: Implementação JPA para mapeamento objeto-relacional
- **MySQL**: Sistema de gerenciamento de banco de dados
- **Flyway**: Ferramenta para versionamento e migração de banco de dados
- **Auth0 Java JWT 4.5.0**: Geração e validação de tokens JWT
- **SpringDoc OpenAPI 2.8.5**: Geração automática de documentação da API
- **Swagger UI**: Interface interativa para testar a API
- **Maven**: Gerenciador de dependências e build

## Arquitetura do Projeto

```
forumhub/
├── src/
│   ├── main/
│   │   ├── java/com/alura/forumhub/
│   │   │   ├── controller/       # Endpoints REST
│   │   │   ├── dto/              # Data Transfer Objects
│   │   │   ├── entity/           # Entidades JPA
│   │   │   ├── repository/       # Repositórios Spring Data
│   │   │   └── infrastructure/
│   │   │       ├── component/    # Filtros de segurança
│   │   │       ├── config/       # Configurações
│   │   │       └── service/      # Lógica de negócio
│   │   └── resources/
│   │       ├── application.properties
│   │       └── db/migration/     # Scripts Flyway
│   └── test/
└── pom.xml
```

## Endpoints da API

### Autenticação
- `POST /login` - Autenticar usuário e receber token JWT

### Tópicos (requer autenticação)
- `POST /topicos/criar-topico` - Criar um novo tópico
- `GET /topicos` - Listar todos os tópicos (com paginação)
- `GET /topicos/{id}` - Consultar detalhes de um tópico específico
- `GET /topicos/busca?curso={curso}&ano={ano}` - Buscar tópicos por filtros
- `PUT /topicos/{id}` - Atualizar um tópico
- `DELETE /topicos/{id}` - Deletar um tópico

## Pré-requisitos

- Java JDK 21 ou superior
- Maven 3.6 ou superior
- MySQL 8.0 ou superior

## Configuração do Banco de Dados

1. Crie um banco de dados MySQL:
```sql
CREATE DATABASE forumhub;
```

2. Configure as variáveis de ambiente:
```properties
DB_JDBC_URL_PROD=jdbc:mysql://localhost:3306/forumhub
DB_USERNAME_PROD=seu_usuario
DB_PASSWORD_PROD=sua_senha
JWT_SECRET_PROD=sua_chave_secreta_jwt
```

Ou edite o arquivo `application.properties` com suas credenciais locais.

## Instalação e Execução

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/forumhub.git
cd forumhub
```

2. Execute o projeto com Maven:
```bash
mvn spring-boot:run
```

Ou compile e execute o JAR:
```bash
mvn clean package
java -jar target/forumhub-0.0.1-SNAPSHOT.jar
```

A API estará disponível em `http://localhost:8080`

## Documentação da API

Após iniciar a aplicação, acesse a documentação interativa:

- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8080/v3/api-docs`

A interface Swagger permite testar todos os endpoints diretamente pelo navegador.

### Como usar a autenticação no Swagger:

1. Faça login no endpoint `POST /login`
2. Copie o token JWT retornado
3. Clique no botão "Authorize" no topo da página
4. Cole o token e clique em "Authorize"
5. Agora você pode testar os endpoints protegidos

## Segurança

A aplicação utiliza **JWT (JSON Web Token)** para autenticação stateless:

1. Usuário envia credenciais para `/login`
2. API valida e retorna um token JWT
3. Cliente envia o token no header `Authorization: Bearer {token}` nas próximas requisições
4. Filtro de segurança valida o token antes de processar cada requisição

As senhas são criptografadas com **BCrypt** antes de serem armazenadas no banco de dados.

## Estrutura do Banco de Dados

O projeto utiliza Flyway para gerenciar as migrações. As principais tabelas são:

- **topicos**: Armazena os tópicos do fórum (título, mensagem, data de criação, status, autor, curso)
- **usuarios**: Contém os dados dos usuários (email, senha criptografada)

### Migrações:
- **V1**: Criação da tabela `topicos`
- **V2**: Alteração da tabela `topicos` para permitir valores nulos
- **V3**: Criação da tabela `usuarios`

## Aprendizados

Este projeto de estudos abordou:

- Desenvolvimento de APIs REST
- Autenticação e autorização com JWT
- Validação de dados e regras de negócio
- Persistência com JPA/Hibernate
- Migrações de banco de dados com Flyway
- Documentação automática com Swagger
- Relacionamento entre entidades
- Paginação e ordenação de resultados
- Boas práticas de segurança

## Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
