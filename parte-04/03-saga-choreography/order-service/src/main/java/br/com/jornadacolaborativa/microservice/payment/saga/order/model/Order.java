package br.com.jornadacolaborativa.microservice.payment.saga.order.model;

import lombok.Data;

@Data
public class Order {

    private Integer userId;
    private Integer productId;

}
