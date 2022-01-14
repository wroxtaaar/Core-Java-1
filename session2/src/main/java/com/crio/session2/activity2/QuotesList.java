package com.crio.session2.activity2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuotesList {
    @JsonProperty("results")
    private List<Quote> quotesList;

    public List<Quote> getQuotesList() {
        return quotesList;
    }

    public void setQuotesList(List<Quote> quotesList) {
        this.quotesList = quotesList;
    }

    @Override
    public String toString() {
        return "QuotesList [quotesList=" + quotesList + "]";
    }
    
}
