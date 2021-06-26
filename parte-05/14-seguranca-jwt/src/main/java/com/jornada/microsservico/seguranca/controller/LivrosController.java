package com.jornada.microsservico.seguranca.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jornada.microsservico.seguranca.domain.Livro;
import com.jornada.microsservico.seguranca.exception.BaseException;
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
    public ResponseEntity<List<Livro>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @RolesAllowed("GERENTE")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Livro> adicionar(@RequestBody Livro livro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.adicionar(livro));
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @RolesAllowed({"CLIENTE", "GERENTE"})
    public ResponseEntity<Livro> buscarPorId(@PathVariable("id") String id) throws BaseException {
        return ResponseEntity.ok(service.buscarPorId(Integer.valueOf(id)));
    }

}
