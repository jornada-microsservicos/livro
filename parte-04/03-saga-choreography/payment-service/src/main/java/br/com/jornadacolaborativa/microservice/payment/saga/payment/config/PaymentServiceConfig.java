package br.com.jornadacolaborativa.microservice.payment.saga.payment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.jornadacolaborativa.microservice.payment.saga.payment.handler.EventHandler;
import br.com.jornadacolaborativa.microservice.payment.saga.payment.model.OrderPurchaseEvent;
import br.com.jornadacolaborativa.microservice.payment.saga.payment.model.PaymentEvent;
import br.com.jornadacolaborativa.microservice.payment.saga.payment.model.TransactionEvent;

import java.util.function.Function;

@Configuration
public class PaymentServiceConfig {

    private final EventHandler<PaymentEvent, TransactionEvent> paymentEventHandler;
    private final EventHandler<OrderPurchaseEvent, PaymentEvent> orderPurchaseEventHandler;

    @Autowired
    public PaymentServiceConfig(
            EventHandler<PaymentEvent, TransactionEvent> paymentEventHandler,
            EventHandler<OrderPurchaseEvent, PaymentEvent> orderPurchaseEventHandler) {
        this.paymentEventHandler = paymentEventHandler;
        this.orderPurchaseEventHandler = orderPurchaseEventHandler;
    }

    @Bean
    public Function<OrderPurchaseEvent, PaymentEvent> orderPurchaseEventProcessor() {
        return orderPurchaseEventHandler::handleEvent;
    }

    @Bean
    public Function<PaymentEvent, TransactionEvent> paymentEventSubscriber() {
        return paymentEventHandler::handleEvent;
    }

}
