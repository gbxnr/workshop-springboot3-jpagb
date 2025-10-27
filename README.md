# 🧩 Projeto Web Services com Spring Boot e JPA / Hibernate

Este projeto foi desenvolvido como parte do curso **Java Completo** do professor **Nelio Alves (DevSuperior)**.  
O objetivo é criar uma aplicação **RESTful API** utilizando **Spring Boot**, **JPA/Hibernate** e **H2** para gerenciamento de dados.

---

## 🚀 Objetivos do Projeto

- Criar um projeto **Spring Boot Java**
- Implementar o **modelo de domínio**
- Estruturar as **camadas lógicas**:
  - Resource (Controller)
  - Service
  - Repository
- Configurar o **banco de dados de teste (H2)**
- Povoar o banco de dados
- Implementar operações **CRUD** (Create, Retrieve, Update, Delete)
- Tratar **exceções personalizadas**
- (Opcional) Fazer o **deploy no Heroku** com **PostgreSQL**

---

## 🧱 Estrutura do Projeto

src/
└── main/
├── java/com/example/demo/
│ ├── entities/ # Entidades JPA (User, Order, Product, etc.)
│ ├── repositories/ # Interfaces JPARepository
│ ├── services/ # Regras de negócio
│ ├── resources/ # Controladores REST (API)
│ └── exceptions/ # Tratamento de erros e exceções
└── resources/
├── application.properties
├── application-test.properties
├── application-dev.properties
└── application-prod.properties


---

## 🧩 Modelo de Domínio

O modelo de domínio implementa relações entre entidades como:

- **User** → representa o cliente
- **Order** → representa um pedido
- **OrderItem** → associação entre Order e Product
- **Product** → produtos disponíveis
- **Category** → categorias de produtos
- **Payment** → associação one-to-one com Order

As relações são do tipo:
- `OneToMany` / `ManyToOne`
- `ManyToMany` com `@JoinTable`
- `OneToOne` com `@MapsId`

---

## ⚙️ Tecnologias Utilizadas

| Tecnologia | Descrição |
|-------------|------------|
| **Java 17** | Linguagem principal |
| **Spring Boot** | Framework principal |
| **Spring Data JPA** | Persistência e ORM |
| **Hibernate** | Implementação JPA |
| **H2 Database** | Banco de dados em memória para testes |
| **PostgreSQL** | Banco de dados para ambiente de produção |
| **Maven** | Gerenciador de dependências |
| **Heroku** | Hospedagem opcional |

---

## 🧰 Dependências Principais (pom.xml)

``
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
  <groupId>com.h2database</groupId>
  <artifactId>h2</artifactId>
  <scope>runtime</scope>
</dependency>

<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
  <scope>runtime</scope>
</dependency>

**Perfis de Aplicação**
spring.profiles.active=test
spring.jpa.open-in-view=true


## application-test.properties ##

## application.properties ##
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

## application-dev.properties ##
spring.datasource.url=jdbc:postgresql://localhost:5432/springboot_course
spring.datasource.username=postgres
spring.datasource.password=1234567
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true


spring.datasource.url=${DATABASE_URL}
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=false

🧠 Camadas Lógicas
Camada	Função
-Resource (Controller)	Define os endpoints REST
-Service	Regras de negócio e tratamento de exceções
-Repository	Interface com o banco de dados
-Entities	Representação das tabelas no modelo JPA

🔍 Exemplos de Endpoints
-Método	Endpoint	Descrição
-GET	/users	Retorna todos os usuários
-GET	/users/{id}	Retorna um usuário pelo ID
-POST	/users	Cadastra um novo usuário
-PUT	/users/{id}	Atualiza dados de um usuário
-DELETE	/users/{id}	Remove um usuário


