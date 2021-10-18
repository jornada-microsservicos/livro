package br.com.jornadacolaborativa.microsservicos.extrato.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MesDTO {
    private String mes;
    private BigDecimal valor;
}
