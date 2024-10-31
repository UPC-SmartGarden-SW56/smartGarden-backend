package com.pe.upc.smartgardenbackend.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI smartGardenformOpenApi() {
        var openApi = new OpenAPI();
        openApi
                .info(new Info()
                        .title("Smart Garden platform API")
                        .description("Smart Graden platform application REST API documentation.")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0")
                                .url("https://springdoc.org"))
                );
        // Add security scheme

        /*final String securitySchemeName = "bearerAuth";

        openApi.addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));*/

        // Return OpenAPI configuration object with all the settings


                    return openApi;

                }

}