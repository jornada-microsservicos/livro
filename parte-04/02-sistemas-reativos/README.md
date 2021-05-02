## Sistemas Reativos

Exemplo de Webflux

## Pré requisitos

- Maven 3+
- Java 11+
- Docker e Docker Compose

## Executando 

Primeiramente é preciso ter um banco de dados mongo no ar. Pode-se utilizar o docker-compose para iniciar uma instancia.

## Testes

### Criando uma sala

`curl --location --request POST 'http://localhost:8080/salas' \
--header 'Content-Type: application/json' \
--data-raw "{
\"nome\": \"Sala 1\",
\"dataInicio\": \"2021-05-02T14:32:41\",
\"dataFim\": \"2021-05-02T14:40:41\"
}"`

### Listando salas

`curl --location --request GET 'http://localhost:8080/salas'`

### Lista sala por id

`curl --location --request GET 'http://localhost:8080/salas/{id}'`

Os resultados dos testes podem ser vistos no [Mongo Express](http://localhost:8081/)

