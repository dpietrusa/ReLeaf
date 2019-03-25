package com.detroitlabs.releaf.Service;

import com.detroitlabs.releaf.Model.DisasterDetailsWrapper;
import com.detroitlabs.releaf.Model.TopTenDisastersWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReleafWebService {
    public TopTenDisastersWrapper fetchDisasterData(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://api.reliefweb.int/v1/disasters?appname=releaf&sort=date:desc", TopTenDisastersWrapper.class);
    }

    public DisasterDetailsWrapper fetchDisasterDetailData(String url){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, DisasterDetailsWrapper.class);
    }




}
