package br.com.jornadacolaborativa.microservice.payment.saga.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jornadacolaborativa.microservice.payment.saga.order.model.Order;
import br.com.jornadacolaborativa.microservice.payment.saga.order.model.OrderPurchase;
import br.com.jornadacolaborativa.microservice.payment.saga.order.service.OrderService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Mono<OrderPurchase> createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping
    public Flux<OrderPurchase> getAllOrders() {
        return orderService.getAll();
    }

    @GetMapping(path = "all/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<List<OrderPurchase>> getAllOrdersStream() {
        return orderService.reactiveGetAll();
    }

    @GetMapping("/{id}")
    public Mono<OrderPurchase> getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

}
