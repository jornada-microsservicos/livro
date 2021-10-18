package br.com.jornadacolaborativa.microsservicos.extrato.rest;

import br.com.jornadacolaborativa.microsservicos.extrato.dto.ExtratoDTO;
import br.com.jornadacolaborativa.microsservicos.extrato.repository.ExtratoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/extrato")
public class ExtratoRest {

    @Autowired
    private ExtratoRepository extratoRepository;

    @ResponseBody
    @GetMapping()
    public ExtratoDTO buscarExtrato() {
        log.info("ExtratoRest#buscarExtrato");
        return this.extratoRepository.buscarExtrato();
    }
}
