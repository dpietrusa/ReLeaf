package com.detroitlabs.releaf.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class DisasterDetailsWrapper {

    private ArrayList<FieldsWrapper> data;

    @JsonProperty("data")
    public ArrayList<FieldsWrapper> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(ArrayList<FieldsWrapper> data) {
        this.data = data;
    }
}
