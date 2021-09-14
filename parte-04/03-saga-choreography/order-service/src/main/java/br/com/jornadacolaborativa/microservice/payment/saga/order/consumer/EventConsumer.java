package br.com.jornadacolaborativa.microservice.payment.saga.order.consumer;

import br.com.jornadacolaborativa.microservice.payment.saga.order.model.Event;

public interface EventConsumer<T extends Event> {

    void consumeEvent(T event);
}
