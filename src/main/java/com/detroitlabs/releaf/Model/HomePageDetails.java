package com.detroitlabs.releaf.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Field;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HomePageDetails {


    private AllDisastersWrapper allDisastersWrapper;

    private Fields fields;

    @JsonProperty("data")
    public AllDisastersWrapper getAllDisastersWrapper() {
        return allDisastersWrapper;
    }

    @JsonProperty("data")
    public void setAllDisastersWrapper(AllDisastersWrapper allDisastersWrapper) {
        this.allDisastersWrapper = allDisastersWrapper;
    }

    @JsonProperty("fields")
    public Fields getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(Fields fields) {
        this.fields = fields;
    }
}
