package com.detroitlabs.releaf.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fields {

    private DisasterData disasterData;
    private String name;

    public DisasterData getDisasterData() {
        return disasterData;
    }

    public void setDisasterData(DisasterData disasterData) {
        this.disasterData = disasterData;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }
}
