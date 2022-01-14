package com.crio.session2.activity2;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class QuoteFetcher {

    private static final Logger log = LoggerFactory.getLogger(QuoteFetcher.class);
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate(); 
        Quote response = restTemplate.getForObject("https://api.quotable.io/random", Quote.class);
        log.info("==== RESTful API Response using Spring RESTTemplate START =======");
        log.info(response.toString());
        log.info("==== RESTful API Response using Spring RESTTemplate END ======="); 

        // // Fetch list of Quotes
        QuotesList responseQuotes = restTemplate.getForObject("https://api.quotable.io/quotes", QuotesList.class);
        log.info("==== RESTful API Response using Spring RESTTemplate START =======");
        log.info(responseQuotes.toString());
        log.info("==== RESTful API Response using Spring RESTTemplate END =======");


         // Fetch Quote with id "QdK00IhCNX"
         Quote responseQuote3 = restTemplate.getForObject("https://api.quotable.io/quotes/{id}", Quote.class,"QdK00IhCNX");
         log.info("==== RESTful API Response using Spring RESTTemplate START =======");
         log.info(Arrays.asList(responseQuote3).toString());
         log.info("==== RESTful API Response using Spring RESTTemplate END ======="); 


    } 
}
