package br.com.jornadacolaborativa.microsservicos.bff.mobile.translator;

import br.com.jornadacolaborativa.microsservicos.bff.mobile.dto.ExtratoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ExtratoTranslator {

    public static final String MICRO_SERVICE_EXTRATO = "http://172.29.1.3:7001/api/v1/extrato";

    @Autowired
    private RestTemplate restTemplate;

    public ExtratoDTO extratoDtoToBffMobile() {
        try {
            log.info("ExtratoTranslator#extratoDtoToBffMobile");
            return this.restTemplate.getForObject(MICRO_SERVICE_EXTRATO, ExtratoDTO.class);
        } catch (Exception ex) {
            log.error("ExtratoTranslator#extratoDtoToBffMobile {}", ex.getMessage());
            return null;
        }
    }
}
