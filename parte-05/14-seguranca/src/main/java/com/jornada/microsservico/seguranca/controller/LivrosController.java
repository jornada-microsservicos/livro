package com.jornada.microsservico.seguranca.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jornada.microsservico.seguranca.domain.Livro;
import com.jornada.microsservico.seguranca.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    private LivroService service;

    public LivrosController(LivroService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RolesAllowed({"CLIENTE", "GERENTE"})
    public ResponseEntity<List<Livro>> lista() {
        return ResponseEntity.ok(service.lista());
    }

}
