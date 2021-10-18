package br.com.jornadacolaborativa.microsservicos.bff.mobile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtratoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String referencia;
    private List<MesDTO> meses;
    private ResumoDTO resumo;
}
