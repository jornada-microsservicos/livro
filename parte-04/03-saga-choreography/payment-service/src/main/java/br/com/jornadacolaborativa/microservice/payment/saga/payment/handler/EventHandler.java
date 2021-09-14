package br.com.jornadacolaborativa.microservice.payment.saga.payment.handler;

import br.com.jornadacolaborativa.microservice.payment.saga.payment.model.Event;

public interface EventHandler<T extends Event, R extends Event> {

    R handleEvent(T event);
}
