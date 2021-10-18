package br.com.jornadacolaborativa.microsservicos.bff.mobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BFFMobileApp {

    public static void main(String[] args) {
        SpringApplication.run(BFFMobileApp.class, args);
    }
}
