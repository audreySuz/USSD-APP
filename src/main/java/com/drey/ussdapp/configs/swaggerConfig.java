package com.drey.ussdapp.configs;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(info())
                .externalDocs(new ExternalDocumentation());
    }

    private Info info() {
        return new Info()
                .title("USSD APP Api")
                .description("Documentation for USSD APP")
                .contact(new Contact()
                        .email("audreyasuzu@gmail.com")
                        .name("Asuzu Audrey")
                        .url("")
                )
                .termsOfService("")
                .version("2.0");
    }

}
