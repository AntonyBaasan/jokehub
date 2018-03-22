package com.antonybasan.jokehub.jokehub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {

    @Bean
    @Scope("prototype")
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
