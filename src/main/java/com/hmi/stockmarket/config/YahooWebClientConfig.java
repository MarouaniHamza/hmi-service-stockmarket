package com.hmi.stockmarket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

@Configuration
public class YahooWebClientConfig {

    @Bean(name = "YahooWebClient")
    public WebClient configWebClent() {
        return WebClient
                .builder()
                .baseUrl("https://apidojo-yahoo-finance-v1.p.rapidapi.com")
                .defaultCookie("cookieKey", "cookieValue")
                .defaultHeader("x-rapidapi-host","apidojo-yahoo-finance-v1.p.rapidapi.com")
                .defaultHeader("x-rapidapi-key","3eaef784b5mshc3d6b692b13456cp1dbf48jsn460ac8d76230")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "https://apidojo-yahoo-finance-v1.p.rapidapi.com"))
                .build();
    }
}
