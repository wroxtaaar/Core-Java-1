package com.crio.session2.activity2;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class QuoteFetcher {

    private static final Logger log = LoggerFactory.getLogger(QuoteFetcher.class);
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate(); 
        Quote response = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random", Quote.class);
        log.info("==== RESTful API Response using Spring RESTTemplate START =======");
        log.info(response.toString());
        log.info("==== RESTful API Response using Spring RESTTemplate END ======="); 

        // Fetch list of Quotes
        Quote[] responseQuotes = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/", Quote[].class);
        log.info("==== RESTful API Response using Spring RESTTemplate START =======");
        log.info(Arrays.asList(responseQuotes).toString());
        log.info("==== RESTful API Response using Spring RESTTemplate END ======="); 


         // Fetch Quote with id 3
         Quote responseQuote3 = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/{id}", Quote.class,3);
         log.info("==== RESTful API Response using Spring RESTTemplate START =======");
         log.info(Arrays.asList(responseQuote3).toString());
         log.info("==== RESTful API Response using Spring RESTTemplate END ======="); 


    } 
}
