package com.detroitlabs.releaf.Service;

import com.detroitlabs.releaf.Model.Comment;
import com.detroitlabs.releaf.Model.Donation;
import com.detroitlabs.releaf.Model.DonationWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DonationService {
    public DonationWrapper fetchAllDonations() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/alldonations", DonationWrapper.class);
    }

    public double fetchDonationSum(String id) {
        DonationWrapper donationWrapper = fetchAllDonations();
        List<Donation> donationList = new ArrayList<>();

        for (Donation donation : donationWrapper) {
            if (donation.getDisasterIdForDonation().equals(id)) {
                donationList.add(donation);
            }
        }

        double sum = 0;
        for (Donation donation : donationList) {
            sum += donation.getAmountToDonate();
        }
        return sum;
    }

    public double findPercentageOfDonationGoal(double donationSum) {
        double donationGoal = 5000;
        double percentageOfDonation;

        if (donationSum >= donationGoal) {
            percentageOfDonation = 100;

        } else {
            percentageOfDonation = (donationSum / donationGoal) * 100;

        }
        return percentageOfDonation;
    }
}



