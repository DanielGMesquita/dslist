
# DSList

DSList é uma aplicação back-end construída durante a o intensivão Java Spring, evento organizado pela DevSuperior.

A aplicação consiste em uma lista de games, onde os dados são armazenados em um banco SQL e retornado de acordo com as requisições HTTP feitas, permitindo a categorização por gênero de jogo e também a alteração da ordem dos jogos exibidos na lista por meio de transações com o banco de dados.




## Documentação da API

#### Retorna todos os games

```http
  GET /lists
```

#### Retorna a lista de gêneros de games no banco SQL

```http
  GET /lists/{listId}/games
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `listId`      | `long` | **Obrigatório**. O ID da lista do gênero de games desejado |

```http
  POST /lists/{listId}/movement
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `listId`      | `long` | **Obrigatório**. O ID da lista do gênero de games desejado |
| `sourceIndex`      | `int` | **Obrigatório**. O índice do game que deseja movimentar na tabela SQL|
| `destinationIndex`      | `int` | **Obrigatório**. O índice da posição que deseja alocar o game na tabela SQL |

#### Retorna todos os games

```http
  GET /games
```
#### Retorna o game desejado

```http
  GET /games/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `long` | **Obrigatório**. O ID do game desejado |



## Modelo de domínio

![](https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/dslist-model.png)
## Stack utilizada

### Back-end
- Java
- Spring Boot
- JPA / Hibernate
- Maven

### Implantação em produção
- Deploy: Railway
- Banco de dados: Postgres



## Como executar o projeto

Pré-requisito: Java 17

```bash
# clonar repositório
git clone git@github.com:DanielGMesquita/dslist.git

# executar o projeto
./mvnw spring-boot:run
```
    
## Autores

Daniel Mesquita
- [@DanielGMesquita](https://www.github.com/DanielGMesquita)
- [Linkedin](https://www.linkedin.com/in/danielgmesquita/)

