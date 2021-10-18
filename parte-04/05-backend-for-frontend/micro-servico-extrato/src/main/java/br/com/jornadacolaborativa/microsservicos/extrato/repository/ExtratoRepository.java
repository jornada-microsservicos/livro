package br.com.jornadacolaborativa.microsservicos.extrato.repository;

import br.com.jornadacolaborativa.microsservicos.extrato.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class ExtratoRepository {
    public ExtratoDTO buscarExtrato() {
        try {
            log.info("ExtratoRepository#buscarExtrato");
            return new ExtratoDTO("2020", this.buildMes(), this.buildMesDetalhado(),
                    this.buildResumo(), this.buildRelatorio());
        } catch (Exception ex) {
            log.error("ExtratoRepository#buscarExtrato {}", ex.getMessage());
            return null;
        }
    }

    private List<MesDTO> buildMes() {
        List<MesDTO> mesDTOS = new ArrayList<>();
        mesDTOS.add(new MesDTO("Janeiro", new BigDecimal(1000.0)));
        mesDTOS.add(new MesDTO("Fevereiro", new BigDecimal(3000.0)));
        mesDTOS.add(new MesDTO("Março", new BigDecimal(1500.0)));
        return mesDTOS;
    }

    private List<MesDetalhadoDTO> buildMesDetalhado() {
        List<MesDetalhadoDTO> mesDetalhadoDTOS = new ArrayList<>();
        mesDetalhadoDTOS.add(new MesDetalhadoDTO("Janeiro", new BigDecimal(1000.0), "Detalhes mes de janeiro", "Baixar comprovante"));
        mesDetalhadoDTOS.add(new MesDetalhadoDTO("Fevereiro", new BigDecimal(1000.0), "Detalhes mes de feveiro", "Baixar comprovante"));
        mesDetalhadoDTOS.add(new MesDetalhadoDTO("Março", new BigDecimal(1000.0), "Detalhes mes de março", "Baixar comprovante"));
        return mesDetalhadoDTOS;
    }

    private ResumoDTO buildResumo() {
        return new ResumoDTO(new BigDecimal(5000.0), new BigDecimal(2000.0), new BigDecimal(3000.0));
    }

    private RelatorioDTO buildRelatorio() {
        return new RelatorioDTO("Baixar PDF", "Baixar XLS");
    }
}
