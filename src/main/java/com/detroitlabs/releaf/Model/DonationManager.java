package com.detroitlabs.releaf.Model;

public class DonationManager {

    private int donationGoal;
    private int donationRaised = 0;

    public DonationManager(int donationRaised) {
        this.donationGoal = donationGoal;
        this.donationRaised = donationRaised;
    }



    public int getDonationGoal() {
        return donationGoal;
    }

    public void setDonationGoal() {
        this.donationGoal = 5000;
    }

    public int getDonationRaised() {
        return donationRaised;
    }

    public void setDonationRaised(int donationRaised) {
        this.donationRaised = donationRaised;
    }
}
