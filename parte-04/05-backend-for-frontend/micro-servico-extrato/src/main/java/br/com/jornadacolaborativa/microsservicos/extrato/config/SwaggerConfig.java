package br.com.jornadacolaborativa.microsservicos.extrato.config;

import br.com.jornadacolaborativa.microsservicos.common.config.CommonSwaggerConfig;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends CommonSwaggerConfig {

    public SwaggerConfig() {
        this.setBasePackage("extrato");
        this.setTitle("Micro Serviço de Extratos");
        this.setDescription("Micro Serviço de Extratos");
        this.setVersion("1.0.0");
    }
}
