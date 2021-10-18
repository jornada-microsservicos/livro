package br.com.jornadacolaborativa.microsservicos.bff.mobile.config;

import br.com.jornadacolaborativa.microsservicos.common.config.CommonSwaggerConfig;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends CommonSwaggerConfig {

    public SwaggerConfig() {
        this.setBasePackage("bff.mobile");
        this.setTitle("BFF - Mobile");
        this.setDescription("Backend For Frontend - Mobile");
        this.setVersion("1.0.0");
    }
}
