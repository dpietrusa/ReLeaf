package com.detroitlabs.releaf.Service;

import com.detroitlabs.releaf.Model.VolunteerWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class VolunteerService {
    public VolunteerWrapper fetchAllVolunteers(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/all", VolunteerWrapper.class);
    }
}
