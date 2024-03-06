package com.conrado.financialtranfer.infra.config;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CorsConfig implements WebMvcConfigurer  {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8280")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
