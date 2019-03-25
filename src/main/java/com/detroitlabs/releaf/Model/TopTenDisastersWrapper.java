package com.detroitlabs.releaf.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TopTenDisastersWrapper {

    private ArrayList<DisasterData> disasterDataList;

    @JsonProperty("data")
    public ArrayList<DisasterData> getDisasterDataList() {
        return disasterDataList;
    }

    @JsonProperty("data")
    public void setDisasterDataList(ArrayList<DisasterData> disasterDataList) {
        this.disasterDataList = disasterDataList;
    }
}

