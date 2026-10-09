# Sistema de Gestão de Pedidos

API REST desenvolvida em Java com Spring Boot para gerenciar clientes, produtos e pedidos. O projeto faz parte de uma atividade acadêmica e aplica conceitos de desenvolvimento de APIs, persistência de dados, validação e tratamento de exceções.

## Tecnologias utilizadas

- **Java 21**
- **Spring Boot 4**
- **Spring Web MVC** — criação dos endpoints REST
- **Spring Data JPA** — persistência e mapeamento objeto-relacional
- **H2 Database** — banco de dados em memória
- **Bean Validation** — validação dos dados recebidos
- **Lombok** — redução de código repetitivo
- **Springdoc OpenAPI / Swagger UI** — documentação e exploração dos endpoints
- **Maven** — gerenciamento de dependências e execução do projeto

## Funcionalidades

- Gerenciamento de clientes.
- Gerenciamento de produtos.
- Criação e gerenciamento de pedidos e seus itens.
- Associação entre clientes, pedidos e produtos.
- Cálculo dos valores dos itens e do total dos pedidos.
- Validação dos dados de entrada.
- Tratamento centralizado de exceções e respostas HTTP.
- Documentação interativa da API.

## Como executar

### Pré-requisitos

- JDK 21 ou superior.
- Git, para clonar o repositório.

### 1. Clone o repositório

```bash
git clone https://github.com/Victor140113/sistema-gestao-pedidos.git
cd sistema-gestao-pedidos
```

### 2. Execute a aplicação

No Windows, utilizando o Maven Wrapper:

```bash
mvnw.cmd spring-boot:run
```

No Linux ou macOS:

```bash
./mvnw spring-boot:run
```

A aplicação será iniciada na porta padrão `8080`, salvo configuração diferente.

## Banco de dados

O projeto utiliza o H2 em memória, configurado para iniciar com a aplicação.

- **URL JDBC:** `jdbc:h2:mem:pedidosdb`
- **Usuário:** `sa`
- **Senha:** vazia
- **Console H2:** http://localhost:8080/h2-console

Na tela do console H2, utilize as credenciais acima para conectar ao banco.

**Atenção:** por ser um banco em memória, os dados são perdidos quando a aplicação é encerrada.

## Documentação da API

Com a aplicação em execução, acesse:

- [Swagger UI](http://localhost:8080/swagger-ui/index.html) — documentação interativa dos endpoints.
- [OpenAPI JSON](http://localhost:8080/v3/api-docs) — especificação da API em formato JSON.

Pelo Swagger UI, é possível consultar os recursos disponíveis, visualizar os parâmetros e os códigos de resposta documentados e realizar requisições à API.

## Organização do projeto

A aplicação utiliza o Spring Boot para estruturar os recursos REST, a camada de persistência com JPA e as regras de negócio relacionadas ao gerenciamento de pedidos.

As entidades representam os dados do domínio, enquanto os controladores expõem os endpoints da API. A validação dos dados e o tratamento de exceções ajudam a manter as respostas consistentes diante de entradas inválidas ou situações previstas pelas regras de negócio.

## Autor

Desenvolvido por [Victor140113](https://github.com/Victor140113), como projeto acadêmico.
