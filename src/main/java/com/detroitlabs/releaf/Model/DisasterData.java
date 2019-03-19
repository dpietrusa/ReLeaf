package com.detroitlabs.releaf.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DisasterData {

    private String id;
    private String fields;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("fields")
    public String getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(String fields) {
        this.fields = fields;
    }
}
