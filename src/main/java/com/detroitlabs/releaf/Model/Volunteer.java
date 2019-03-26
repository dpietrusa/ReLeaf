package com.detroitlabs.releaf.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Volunteer {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String personalDescription;
    private String dateAvailable;
    private String volunteerOffering;

    public Volunteer(String name, String email, String phone, String personalDescription, String dateAvailable, String volunteerOffering) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.personalDescription = personalDescription;
        this.dateAvailable = dateAvailable;
        this.volunteerOffering = volunteerOffering;
    }

    public Volunteer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPersonalDescription() {
        return personalDescription;
    }

    public void setPersonalDescription(String personalDescription) {
        this.personalDescription = personalDescription;
    }

    public String getDateAvailable() {
        return dateAvailable;
    }

    public void setDateAvailable(String dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    public String getVolunteerOffering() {
        return volunteerOffering;
    }

    public void setVolunteerOffering(String volunteerOffering) {
        this.volunteerOffering = volunteerOffering;
    }
}
