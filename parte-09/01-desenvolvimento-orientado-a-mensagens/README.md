# spring-boot-kafka

## Pré requisitos

- Maven 3+
- Java 11+
- Docker Desktop 3.3.0+ 

## Preparando ambiente

- Execute o `docker-compose up` para inicializar o Zookeeper e Kafka.
- Execute `mvn clean package` na pasta do projeto para realizar o build das aplicações.

## Executando 

- Inicialize o projeto `producer`
````
cd producer
mvn spring-boot:run
````

Obs: a aplicação Producer disponibiliza o endpoint `POST http://localhost:9000/payments` para receber os eventos dos pagamentos.


-  Inicialize o projeto `consumer`
````
cd consumer
mvn spring-boot:run
````
Obs: O projeto do consumer não tem endpoint, ele apenas conecta no tópico do Kafka para escutar o stream.


## Executando 


Para testar, pode ser utilizado o seguinte comando: `./send-payment.sh "{\"CPF\": \"110.110.110-48\",\"Nome\": \"Norberto Hideaki Enomoto\", \"CartaoCredito\": \"0011-0011-0011-0111\", \"DataValidade\": \"01/26\", \"CodigoVerificador\": \"001\"}"`, onde será inserido o pagamento no tópico do Kafka, via a microsserviço `producer`, e será consumido pela microsserviço `consumer`, como no log abaixo:
````
2021-04-11 19:30:41.083  INFO 19892 --- [ntainer#0-0-C-1] b.c.j.m.consumer.PaymentConsumer         : key: f967cc40-8296-4ead-b549-e33ab49768d8
2021-04-11 19:30:41.084  INFO 19892 --- [ntainer#0-0-C-1] b.c.j.m.consumer.PaymentConsumer         : Headers: RecordHeaders(headers = [], isReadOnly = false)
2021-04-11 19:30:41.085  INFO 19892 --- [ntainer#0-0-C-1] b.c.j.m.consumer.PaymentConsumer         : Partion: 0
2021-04-11 19:30:41.085  INFO 19892 --- [ntainer#0-0-C-1] b.c.j.m.consumer.PaymentConsumer         : Order: {
    "CPF":"110.110.110-48",
    "Nome":"Norberto Hideaki Enomoto",
    "CartaoCredito": "0011-0011-0011-0111",
    "DataValidade": "01/26",
    "CodigoVerificador" : "001"
}
````

## Visualizando o painel do kafka

Para melhor visialização do que acontece no kafka, é inicializado o projeto [Kafdrop](https://github.com/obsidiandynamics/kafdrop)

Acesse:

[http://localhost:19000/](http://localhost:19000/)
