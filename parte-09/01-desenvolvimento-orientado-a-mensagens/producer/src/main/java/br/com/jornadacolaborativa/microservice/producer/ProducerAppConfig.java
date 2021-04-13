package br.com.jornadacolaborativa.microservice.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class ProducerAppConfig {

    public static void main(String[] args) {
        SpringApplication.run(ProducerAppConfig.class, args);
        log.info("The application is using {} mb", (Runtime.getRuntime().totalMemory() / 1024 / 1024));        
    }

}