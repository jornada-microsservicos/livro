package br.com.jornadacolaborativa.microservice.payment.saga.order.config;

import java.util.function.Consumer;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.jornadacolaborativa.microservice.payment.saga.order.consumer.EventConsumer;
import br.com.jornadacolaborativa.microservice.payment.saga.order.model.OrderPurchaseEvent;
import br.com.jornadacolaborativa.microservice.payment.saga.order.model.TransactionEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Configuration
public class OrderServiceConfig {

    private final EventConsumer<TransactionEvent> transactionEventConsumer;

    @Autowired
    public OrderServiceConfig(EventConsumer<TransactionEvent> transactionEventConsumer) {
        this.transactionEventConsumer = transactionEventConsumer;
    }

    @Bean
    public Sinks.Many<OrderPurchaseEvent> sink() {
        return Sinks.many()
                .multicast()
                .directBestEffort();
    }

    @Bean
    public Supplier<Flux<OrderPurchaseEvent>> orderPurchaseEventPublisher(
            Sinks.Many<OrderPurchaseEvent> publisher) {
        return publisher::asFlux;
    }

    @Bean
    public Consumer<TransactionEvent> transactionEventProcessor() {
        return transactionEventConsumer::consumeEvent;
    }

}
