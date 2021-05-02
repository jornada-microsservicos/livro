package com.jornadacolaborativa.sistemasreativos.repository;

import com.jornadacolaborativa.sistemasreativos.model.Sala;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends ReactiveMongoRepository<Sala, String> {
}
