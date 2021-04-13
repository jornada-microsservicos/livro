package br.com.jornadacolaborativa.microservice.producer;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PaymentProducer {

    @Value("${payment.topic}")
    private String paymentTopic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public PaymentProducer(final KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(final @RequestBody String payment) {
        final String messageKey = UUID.randomUUID().toString();
        kafkaTemplate.send(paymentTopic, messageKey,  payment);
        log.info("paymentoTopic: " + paymentTopic);
        log.info("messsakey: " + messageKey);
        log.info("payment: " + payment);
    }
}
