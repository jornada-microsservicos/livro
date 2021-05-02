package br.com.jornadacolaborativa.microservice.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.jornadacolaborativa.microservice.consumer.model.Payment;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PaymentConsumer {

    @KafkaListener(topics = "${payment.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(final ConsumerRecord<String, Payment> consumerRecord) {
        log.info("key: " + consumerRecord.key());
        log.info("Headers: " + consumerRecord.headers());
        log.info("Partion: " + consumerRecord.partition());
        log.info("Payment: " + consumerRecord.value());
    }
}