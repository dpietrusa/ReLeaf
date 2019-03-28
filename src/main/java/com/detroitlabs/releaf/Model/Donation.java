package com.detroitlabs.releaf.Model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Donation {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int amountToDonate;
    private String firstName;
    private String lastName;
    private String email;
    private String disasterIdForDonation;


    public Donation(int amountToDonate, String firstName, String lastName, String email, String disasterIdForDonation) {
        this.amountToDonate = amountToDonate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.disasterIdForDonation = disasterIdForDonation;
    }

    public Donation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAmountToDonate() {
        return amountToDonate;
    }

    public void setAmountToDonate(int amountToDonate) {
        this.amountToDonate = amountToDonate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisasterIdForDonation() {
        return disasterIdForDonation;
    }

    public void setDisasterIdForDonation(String disasterIdForDonation) {
        this.disasterIdForDonation = disasterIdForDonation;
    }
}
