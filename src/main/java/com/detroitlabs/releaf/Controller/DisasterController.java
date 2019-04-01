package com.detroitlabs.releaf.Controller;

import com.detroitlabs.releaf.Model.*;
import com.detroitlabs.releaf.Service.DonationService;
import com.detroitlabs.releaf.Service.ReleafWebService;
import com.detroitlabs.releaf.Service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class DisasterController {


    @Autowired
    private ReleafWebService releafWebService;

    @Autowired
    private VolunteerService volunteerService;


    @Autowired
    VolunteerRepository volunteerRepository;

    @Autowired
    DonationService donationService;


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
            fields.setDonationSum(donationService.fetchDonationSum(fields.getId()));

            fields.setDonationPercentage(donationService.findPercentageOfDonationGoal(fields.getDonationSum()));

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


//    @RequestMapping ("/volunteer")
//    public String displayVolunteerDetails(ModelMap modelMap){
//        VolunteerWrapper volunteerWrapper = volunteerService.fetchAllVolunteers();
//        modelMap.put("volunteerWrapper", volunteerWrapper);
//
//        for (Volunteer volunteer: volunteerWrapper) {
//            System.out.println(volunteer.getName());
//        }
//        return "volunteeredit";
//    }

    @RequestMapping("donation")
    public String displayDonations(){
        return "donation";
    }

    @RequestMapping("confirmation")
    public String displayConfirmation(){
        return "confirmation";
    }


}
