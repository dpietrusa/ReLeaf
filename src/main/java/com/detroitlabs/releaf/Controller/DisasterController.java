package com.detroitlabs.releaf.Controller;

import com.detroitlabs.releaf.Model.AllDisastersWrapper;
import com.detroitlabs.releaf.Model.DisasterData;
import com.detroitlabs.releaf.Model.HomePageDetails;
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
    @ResponseBody
    public String displayDisasters(ModelMap modelMap) {
        HomePageDetails homePage = releafWebService.fetchDisasterData();
        List<DisasterData> disasterData = homePage.getAllDisastersWrapper().getDisasterDataList();
        return disasterData.get(0).getFields().getName();
//        return "index";

    }



}
