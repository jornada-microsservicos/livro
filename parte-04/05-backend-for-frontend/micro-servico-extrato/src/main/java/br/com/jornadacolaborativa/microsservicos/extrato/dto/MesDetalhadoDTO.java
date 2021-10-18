package br.com.jornadacolaborativa.microsservicos.extrato.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MesDetalhadoDTO {
    private String mes;
    private BigDecimal valor;
    private String descricao;
    private String comprovante;
}
