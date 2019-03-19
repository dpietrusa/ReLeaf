package com.detroitlabs.releaf.Controller;

import com.detroitlabs.releaf.Model.AllDisastersWrapper;
import com.detroitlabs.releaf.Service.ReleafWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DisasterController {


@Autowired
    private ReleafWebService releafWebService;


@ResponseBody
@RequestMapping("/")
public String displayDisasters(){
    AllDisastersWrapper allDisastersWrapper = releafWebService.fetchDisasterData();
   return allDisastersWrapper.getDisasterDataList().get(0).getFields().getName();


}




}
