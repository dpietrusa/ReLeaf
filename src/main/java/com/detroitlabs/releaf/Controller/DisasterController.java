package com.detroitlabs.releaf.Controller;

import com.detroitlabs.releaf.Model.*;
import com.detroitlabs.releaf.Service.ReleafWebService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DisasterController {


    @Autowired
    private ReleafWebService releafWebService;


    @RequestMapping("/")
    public String displayDisasters(ModelMap modelMap) {
        TopTenDisastersWrapper topTenDisastersWrapper = releafWebService.fetchDisasterData();
        ArrayList<DisasterData> disasterDataList = topTenDisastersWrapper.getDisasterDataList();

        ArrayList<Fields> fieldsList = new ArrayList<>();

        for (DisasterData disasterData: disasterDataList){
            String detailsUrl = disasterData.getDetailsUrl();
            DisasterDetailsWrapper disasterDetailsWrapper = releafWebService.fetchDisasterDetailData(detailsUrl);
            Fields fields = disasterDetailsWrapper.getData().get(0).getFields();
            fieldsList.add(fields);

        }
        modelMap.put("fieldsList", fieldsList);
        return "index";
    }

    @RequestMapping("/details/{id}")
    public String displayDisasterDetails(@PathVariable String id, ModelMap modelMap){
        DisasterDetailsWrapper disasterDetailsWrapper = releafWebService.fetchDisasterDetailDataByID(id);
        Fields fields = disasterDetailsWrapper.getData().get(0).getFields();
        modelMap.put("fields", fields);
        return "disasterdetails";
    }

}
