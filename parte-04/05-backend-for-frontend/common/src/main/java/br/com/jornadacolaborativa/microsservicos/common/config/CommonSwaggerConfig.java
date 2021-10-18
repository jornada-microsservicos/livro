package br.com.jornadacolaborativa.microsservicos.common.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class CommonSwaggerConfig {

    private String basePackage;
    private String title;
    private String description;
    private String version;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("br.com.jornadacolaborativa.microsservicos." + this.getBasePackage()))
                .paths(PathSelectors.any())
                .build().apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title(this.getTitle())
                .description(this.getDescription())
                .contact(new Contact("Jornada Colaborativa",
                        "https://www.jornadas.io",
                        "contato@jornadas.io"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version(this.getVersion())
                .build();
    }

    private String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    private String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
