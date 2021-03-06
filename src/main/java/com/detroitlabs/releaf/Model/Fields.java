package com.detroitlabs.releaf.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fields {

    private String name;
    private String description;
    private String id;
    private String shortDescription;
    private String descriptionHtml;
    private double donationSum;
    private double donationPercentage;

    public double getDonationPercentage() {
        return donationPercentage;
    }

    public void setDonationPercentage(double donationPercentage) {
        this.donationPercentage = donationPercentage;
    }

    public double getDonationSum() {
        return donationSum;
    }

    public void setDonationSum(double donationSum) {
        this.donationSum = donationSum;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @JsonProperty("description-html")
    public String getDescriptionHtml() {
        return descriptionHtml;
    }

    @JsonProperty("description-html")
    public void setDescriptionHtml(String descriptionHtml) {
        this.descriptionHtml = descriptionHtml;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.shortDescription = description.substring(0, 480) + "...";
        this.description = description;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }
}


