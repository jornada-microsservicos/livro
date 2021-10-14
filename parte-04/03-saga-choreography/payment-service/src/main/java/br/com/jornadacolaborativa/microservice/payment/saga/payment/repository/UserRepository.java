package br.com.jornadacolaborativa.microservice.payment.saga.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jornadacolaborativa.microservice.payment.saga.payment.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
