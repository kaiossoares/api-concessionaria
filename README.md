# API Concessionária

API REST em Spring Boot para o cadastro de veículos de uma concessionária (CRUD), com persistência em PostgreSQL.

## Tecnologias

- Java 17+
- Spring Boot 3.5 (Spring Web, Spring Data JPA, Bean Validation)
- PostgreSQL
- Maven (com Maven Wrapper: `mvnw` / `mvnw.cmd`)

## Estrutura (padrão MVC)

```
src/main/java/br/com/concessionaria
├── ApiConcessionariaApplication.java    # classe principal
├── model/Carro.java                     # Model: entidade JPA (tabela "carros")
├── repository/CarroRepository.java      # acesso ao banco (Spring Data JPA)
├── service/CarroService.java            # regras de negócio
├── controller/CarroController.java      # Controller: endpoints REST /carros
└── exception/                           # tratamento de erros (404 e 400)
database/
├── 01-schema.sql                        # criação da tabela
└── 02-dados-exemplo.sql                 # dados de exemplo (opcional)
postman/api-concessionaria.postman_collection.json
```

Como é uma API REST, a "View" é a representação JSON devolvida pelo controller.

## Como executar

### 1. Banco de dados

**Opção A: Docker (recomendado)**

```bash
docker compose up -d
```

Isso sobe um PostgreSQL com o banco `concessionaria` (usuário `postgres`, senha `postgres`). Na primeira subida, os scripts da pasta `database/` são executados automaticamente.

Se o seu usuário ou senha forem diferentes de `postgres`/`postgres`, defina as variáveis de ambiente `DB_USERNAME` e `DB_PASSWORD` (e `DB_URL`, se necessário) antes de rodar a aplicação.

### 2. Aplicação

```bash
./mvnw spring-boot:run        # Linux/macOS
mvnw.cmd spring-boot:run      # Windows
```

Ou, no IntelliJ, execute a classe `ApiConcessionariaApplication`. A API sobe em `http://localhost:8080`.

## Endpoints

| Método | Endpoint       | Descrição                    | Sucesso          |
|--------|----------------|------------------------------|------------------|
| POST   | `/carros`      | Cadastrar um novo veículo    | 201 Created      |
| GET    | `/carros`      | Listar todos os veículos     | 200 OK           |
| GET    | `/carros/{id}` | Consultar um veículo pelo ID | 200 OK           |
| PUT    | `/carros/{id}` | Atualizar um veículo         | 200 OK           |
| DELETE | `/carros/{id}` | Excluir um veículo           | 204 No Content   |

Erros: `404 Not Found` para ID inexistente e `400 Bad Request` para dados inválidos (com a mensagem de cada campo).

### Exemplo de cadastro

```bash
curl -X POST http://localhost:8080/carros \
  -H "Content-Type: application/json" \
  -d '{"marca":"Volkswagen","modelo":"Golf","anoFabricacao":2020,"anoModelo":2021,"motorizacao":"1.4 TSI"}'
```

Resposta (`201 Created`):

```json
{
  "id": 6,
  "marca": "Volkswagen",
  "modelo": "Golf",
  "anoFabricacao": 2020,
  "anoModelo": 2021,
  "motorizacao": "1.4 TSI"
}
```


