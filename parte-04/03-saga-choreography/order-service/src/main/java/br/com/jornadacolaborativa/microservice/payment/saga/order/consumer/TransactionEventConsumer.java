package br.com.jornadacolaborativa.microservice.payment.saga.order.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jornadacolaborativa.microservice.payment.saga.order.enums.*;
import br.com.jornadacolaborativa.microservice.payment.saga.order.model.OrderPurchase;
import br.com.jornadacolaborativa.microservice.payment.saga.order.model.TransactionEvent;
import br.com.jornadacolaborativa.microservice.payment.saga.order.repository.OrderPurchaseRepository;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@Component
public class TransactionEventConsumer implements EventConsumer<TransactionEvent> {

    private final OrderPurchaseRepository orderPurchaseRepository;
    private final Scheduler jdbcScheduler;

    @Autowired
    public TransactionEventConsumer(
            OrderPurchaseRepository orderPurchaseRepository,
            Scheduler jdbcScheduler) {
        this.orderPurchaseRepository = orderPurchaseRepository;
        this.jdbcScheduler = jdbcScheduler;
    }

    public void consumeEvent(TransactionEvent event) {
        Mono.fromRunnable(
                () -> orderPurchaseRepository.findById(event.getOrderId())
                        .ifPresent(order -> {
                            setStatus(event, order);
                            orderPurchaseRepository.save(order);
                        }))
                .subscribeOn(jdbcScheduler)
                .subscribe();
    }

    private void setStatus(TransactionEvent transactionEvent, OrderPurchase order) {
        order.setStatus(TransactionStatus.SUCCESSFUL.equals(transactionEvent.getStatus())
                ? OrderStatus.COMPLETED
                : OrderStatus.FAILED);
    }

}
