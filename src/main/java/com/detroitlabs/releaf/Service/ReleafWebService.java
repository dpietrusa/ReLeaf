package com.detroitlabs.releaf.Service;

import com.detroitlabs.releaf.Model.AllDisastersWrapper;
import com.detroitlabs.releaf.Model.HomePageDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReleafWebService {
    public HomePageDetails fetchDisasterData(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://api.reliefweb.int/v1/disasters?appname=releaf&sort=date:desc", HomePageDetails.class);
    }

    public AllDisastersWrapper fetchDisasterDetailData(String id){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://api.reliefweb.int/v1/disasters/" + id, AllDisastersWrapper.class);
    }




}
