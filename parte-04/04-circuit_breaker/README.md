# Exemplo de Circuit Breaker - Resiliense4j

Autores: Norberto Enomoto e Natália Rosa

## Pré-requisitos 

- Java 13
- Maven

## Exemplo Não Reativo

Nesse respositório temos o exemplo de uma aplicação não reativa.   

Utilizaremos dois endpoints para testar a eficiência do circuit breaker:

   1. `/get` - este endpoint faz uma solicitação ao endpoint https://httpbin.org/get e retorna os dados.
   2. `/delay/{seconds}` - este endpoint faz uma solicitação para o endpoint https://httpbin.org/delay passando o atraso na resposta em segundos. Como essa solicitação pode levar uma quantidade significativa de tempo, é envolvido o circuit breaker. Se o parâmetro seconds for maior ou igual a 3, que foi o valor configurado, o circuit breaker atingirá o tempo limite e retornará a resposta padrão `{"Olá": "mundo!"}`.

## Start
```
mvn install
```

```
mvn spring-boot:run
```


[Código Referência](https://github.com/spring-cloud-samples/spring-cloud-circuitbreaker-demo)