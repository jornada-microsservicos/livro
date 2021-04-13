package br.com.jornadacolaborativa.microservice.producer.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jornadacolaborativa.microservice.producer.PaymentProducer;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/payments")
@Slf4j
public class PaymentController {

    private final PaymentProducer paymentProducer;

    public PaymentController(PaymentProducer paymentProducer) {
        this.paymentProducer = paymentProducer;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void send(@RequestBody String payment) {
        paymentProducer.send(payment);
    }
}
