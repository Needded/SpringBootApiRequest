package com.example.weather.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*
 *WeatherConfig configuration class that create a RestTemplate Bean so Spring container can manage it.
 */
@Configuration
public class WeatherConfig {

	@Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
