package com.detroitlabs.releaf.Service;

import com.detroitlabs.releaf.Model.DonationWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DonationService {
    public DonationWrapper fetchAllDonations(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/alldonations", DonationWrapper.class);
    }

}
