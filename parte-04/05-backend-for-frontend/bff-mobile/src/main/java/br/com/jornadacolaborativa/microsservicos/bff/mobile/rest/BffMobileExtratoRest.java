package br.com.jornadacolaborativa.microsservicos.bff.mobile.rest;

import br.com.jornadacolaborativa.microsservicos.bff.mobile.dto.ExtratoDTO;
import br.com.jornadacolaborativa.microsservicos.bff.mobile.translator.ExtratoTranslator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/bff-mobile/extrato")
public class BffMobileExtratoRest {

    @Autowired
    private ExtratoTranslator extratoTranslator;

    @ResponseBody
    @GetMapping()
    public ExtratoDTO buscarExtrato() {
        log.info("BffMobileExtratoRest#buscarExtrato");
        return this.extratoTranslator.extratoDtoToBffMobile();
    }
}
