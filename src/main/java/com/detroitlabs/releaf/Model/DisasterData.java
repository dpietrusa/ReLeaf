package com.detroitlabs.releaf.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DisasterData {

    private String detailsUrl;

    @JsonProperty("href")
    public String getDetailsUrl() {
        return detailsUrl;
    }
    @JsonProperty("href")
    public void setDetailsUrl(String detailsUrl) {
        this.detailsUrl = detailsUrl;
    }
}


