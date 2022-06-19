package com.mydomain.project_server.config;

import jdk.javadoc.doclet.Doclet;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger_config {


    @Bean
    public GroupedOpenApi api1() {

        return GroupedOpenApi.builder().group("v1_site_panel")
                .pathsToMatch("/api/V1/site/admin")
                .packagesToScan("com.mydomain.project_server.routes.V1")
                .build();
    }

}
