package com.hmi.stockmarket.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/market")
public class MarketController {

    @Autowired
    @Qualifier("YahooWebClient")
    public WebClient yahooWebClient;

    @RequestMapping(value = "/get-summary")
    public String summary(){
        return yahooWebClient.get().uri(uriBuilder -> uriBuilder.path("market/get-summary").queryParam("region","US").queryParam("lang","en").build()
                ).exchange().block().bodyToMono(String.class).block();
    }
}
