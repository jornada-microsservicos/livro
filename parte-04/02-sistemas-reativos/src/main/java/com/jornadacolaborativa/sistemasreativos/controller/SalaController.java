package com.jornadacolaborativa.sistemasreativos.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jornadacolaborativa.sistemasreativos.model.Sala;
import com.jornadacolaborativa.sistemasreativos.repository.SalaRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController("Salas")
@RequestMapping("/salas")
public class SalaController {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    private SalaRepository salaRepository;

    public SalaController(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Sala> criarReserva(@RequestBody Sala sala) {
        log.info("Criando uma nova reserva para a sala {}  de {}  ate {} ",
                sala.getNome(), sala.getDataInicio(), sala.getDataFim());
        return salaRepository.save(sala);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Sala> listaReservas() {
        log.info("Listando todas as reservas de sala");
        Sala sala = new Sala("01", "Sala 01", new Date(), new Date());
        System.out.println(sala.toString());
        return salaRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Sala>> obtemSalaPorId(@PathVariable(value = "id") String salaId) {
        log.info("Acessando as informacoes da sala {} ", salaId);
        return salaRepository.findById(salaId)
                .map(savedSala -> ResponseEntity.ok(savedSala))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Sala>> updateSala(@PathVariable(value = "id") String salaId,
            @RequestBody Sala sala) {
        log.info("Atualizando a reserva da sala {}  para a data e hora de {}  e {} ", salaId,
                sala.getDataInicio(), sala.getDataFim());
        return salaRepository.findById(salaId)
                .flatMap(existingSala -> {
                    existingSala.setDataInicio(sala.getDataInicio());
                    existingSala.setDataFim(sala.getDataFim());
                    return salaRepository.save(existingSala);
                }).map(updateSala -> new ResponseEntity<>(updateSala, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Void>> deletaSala(@PathVariable(value = "id") String salaId) {
        log.info("Excluindo reserva da sala {} ", salaId);
        return salaRepository
                .findById(salaId)
                .flatMap(existingSala ->
                        salaRepository.delete(existingSala)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
