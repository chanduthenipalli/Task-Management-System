package com.example.springboot.thymleafdemo.ConcurrencyAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/*APIConfig: Create a RestTemplate bean to be used for making HTTP requests.*/
@Configuration
public class APIConfig
{
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
