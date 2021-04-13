package br.com.jornadacolaborativa.microservice.consumer.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Payment implements Serializable {

    private String cPF;
    private String nome;
    private String numeroCartaoCredito;
    private String dataValidade;
    private String codigoVerificador;
}
