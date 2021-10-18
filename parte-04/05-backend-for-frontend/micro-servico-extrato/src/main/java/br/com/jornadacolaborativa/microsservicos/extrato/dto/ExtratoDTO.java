package br.com.jornadacolaborativa.microsservicos.extrato.dto;

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
    private List<MesDetalhadoDTO> mesesDetalhados;
    private ResumoDTO resumo;
    private RelatorioDTO relatorio;
}
