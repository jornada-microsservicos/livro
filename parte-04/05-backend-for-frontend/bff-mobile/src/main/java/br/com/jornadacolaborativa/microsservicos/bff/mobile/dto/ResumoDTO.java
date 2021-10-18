package br.com.jornadacolaborativa.microsservicos.bff.mobile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumoDTO {
    private BigDecimal entrada;
    private BigDecimal saida;
    private BigDecimal saldo;
}
