#  Agregador de Investimento

API REST para gerenciamento de usuários em uma plataforma de agregação de investimentos. Desenvolvida com Java 21 e Spring Boot, conectada a um banco MySQL via Docker.

---

## 🛠️ Tecnologias

- **Java 21**
- **Spring Boot 4.x**
- **Spring Data JPA / Hibernate**
- **MySQL 8.4** (via Docker)
- **Maven**

---

##  Como rodar localmente

### Pré-requisitos

- Java 21+
- Maven
- Docker e Docker Compose

### 1. Subir o banco de dados

```bash
docker compose up -d
```

Isso sobe um container MySQL na porta `3306` com as seguintes credenciais:

| Parâmetro | Valor        |
|-----------|--------------|
| Database  | mydatabase   |
| Usuário   | myuser       |
| Senha     | secret       |
| Porta     | 3307         |

### 2. Configurar o `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3307/mydatabase
spring.datasource.username=myuser
spring.datasource.password=secret
```

### 3. Rodar a aplicação

```bash
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

---

##  Endpoints

Base path: `/v1/users`

| Método   | Endpoint            | Descrição                  |
|----------|---------------------|----------------------------|
| `POST`   | `/v1/users`         | Criar novo usuário         |
| `GET`    | `/v1/users`         | Listar todos os usuários   |
| `GET`    | `/v1/users/{id}`    | Buscar usuário por ID      |
| `PUT`    | `/v1/users/{id}`    | Atualizar usuário por ID   |
| `DELETE` | `/v1/users/{id}`    | Deletar usuário por ID     |

### Exemplos de payload

**POST /v1/users**
```json
{
  "username": "tony_stark",
  "email": "tony123@starkLtda.com",
  "password": "iamironman"
}
```

**PUT /v1/users/{id}**
```json
{
  "username": "Tony",
  "password": "123"
}
```

---

##  Estrutura do projeto

```
src/
└── main/
    └── java/Tony/AgregadorDeInvestimento/
        ├── controller/     # Camada HTTP (endpoints + DTOs)
        ├── entity/         # Entidade JPA (User)
        ├── repository/     # Interface JpaRepository
        └── service/        # Regras de negócio
```

---

##  Observações

- IDs de usuário são gerados automaticamente como **UUID**.
- Os timestamps de criação e atualização são gerenciados automaticamente pelo Hibernate (`@CreationTimestamp`, `@UpdateTimestamp`).
- O schema é criado/atualizado automaticamente via `spring.jpa.hibernate.ddl-auto=update`.
