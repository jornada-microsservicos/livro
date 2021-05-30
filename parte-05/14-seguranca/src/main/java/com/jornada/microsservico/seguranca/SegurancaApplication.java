package com.jornada.microsservico.seguranca;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jornada.microsservico.seguranca.domain.Livro;
import com.jornada.microsservico.seguranca.service.LivroService;

@SpringBootApplication
public class SegurancaApplication implements CommandLineRunner {

    private LivroService service;

    public SegurancaApplication(LivroService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(SegurancaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Livro l1 = new Livro();
        l1.setId(1);
        l1.setNome("Livro 1");
        l1.setAutor("Autor 1");

        Livro l2 = new Livro();
        l2.setId(2);
        l2.setNome("Livro 2");
        l2.setAutor("Autor 2");

        service.adiciona(l1);
        service.adiciona(l2);
    }
}
