![](https://github.com/rcmoutinho/jornada-microsservicos-devops/workflows/automacao-livro-microsservicos/badge.svg)

# Jornada Microsserviços - DevOps

Este é um projeto exemplo para demonstrar conceitos e ideias do capítulo DevOps do livro Jornada Microsserviços.

## Executando o Projeto

Para executar este código na máquina local será necessário instalar o [Java 11](https://openjdk.java.net/install/).

Após clonar o código or realizar o fork deste projeto, execute o comando na mesma pasta que este README se encontra:

```
./mvnw spring-boot:run
```

Acesse a URL http://localhost:8080/jornada?nome=Rodrigo para obter o resultado a seguir.

```
{"id":1,"conteudo":"Bem-vindo à Jornada Microsserviços, Rodrigo!"}
```

O comando irá bloquear o terminal. Pressione Ctrl + C para encerrar o processo.

Uma alternativa é executar os seguintes comandos:

```
./mvnw clean package
java -jar target/devops-0.0.1-SNAPSHOT.jar
```

## Entendendo a automação

O fluxo da automação está localizado em `.github/workflows/main.yml` ([aqui](./.github/workflows/main.yml)). Para facilitar o entendimento e documentação, o arquivo possui comentários explicando o objetivo de cada configuração.
