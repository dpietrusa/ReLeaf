package com.detroitlabs.releaf.Service;

import com.detroitlabs.releaf.Model.AllDisastersWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReleafWebService {
    public AllDisastersWrapper fetchDisasterData(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://api.reliefweb.int/v1/disasters?appname=releaf&sort=date:desc", AllDisastersWrapper.class);
    }

    public AllDisastersWrapper fetchDisasterDetailData(String id){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://api.reliefweb.int/v1/disasters/" + id, AllDisastersWrapper.class);
    }




}
