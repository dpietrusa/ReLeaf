package com.detroitlabs.releaf.Controller;

import com.detroitlabs.releaf.Model.AllDisastersWrapper;
import com.detroitlabs.releaf.Model.DisasterData;
import com.detroitlabs.releaf.Service.ReleafWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DisasterController {


    @Autowired
    private ReleafWebService releafWebService;


    @RequestMapping("/")
    public String displayDisasters(ModelMap modelMap) {
        AllDisastersWrapper allDisastersWrapper = releafWebService.fetchDisasterData();
        List<DisasterData> disasterData = allDisastersWrapper.getDisasterDataList();
////   return allDisastersDetailWrapper.getDisasterDataList().get(0).getFields().getDescription();
//        allDisastersWrapper.getDisasterDataList().get(0).getId();
        modelMap.put("disasterData", disasterData);

        String id = null;
        for(DisasterData data : disasterData){
          id = data.getId();
        }


        AllDisastersWrapper allDisastersDetailWrapper = releafWebService.fetchDisasterDetailData(id);
        List<DisasterData> disasterDetails = allDisastersDetailWrapper.getDisasterDataList();
        modelMap.put("disasterDetails", disasterDetails);

        return "index";

    }



}
