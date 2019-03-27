package com.detroitlabs.releaf.Controller;

import com.detroitlabs.releaf.Model.*;
import com.detroitlabs.releaf.Service.CommentService;
import com.detroitlabs.releaf.Service.ReleafWebService;
import com.detroitlabs.releaf.Service.VolunteerService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DisasterController {


    @Autowired
    private ReleafWebService releafWebService;

    @Autowired
    private VolunteerService volunteerService;

    @Autowired
    private CommentService commentService;

    @Autowired VolunteerRepository volunteerRepository;

    @Autowired
    private CommentRepository commentRepository;

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
//
//        CommentWrapper commentWrapper = commentService.fetchAllComments();
//        System.out.println(commentWrapper);
////        List<Comment> commentList = new ArrayList<>();
//        for (Comment comments : commentWrapper){
//            System.out.println(comments);
//            if (comments.getDisasterId() == id) {
//                commentList.add(comments);
//            }
//        }

//        modelMap.put("commentList", commentList);

        modelMap.put("fields", fields);
        return "disasterdetails";
    }

//    @GetMapping("/volunteer")
//    public String addVolunteer(Model model){
//        model.addAttribute("newVolunteer", new NewVolunteer());
//        return "volunteer";
//    }
//
//    @PostMapping("/volunteer")
//    public String addNewVolunteer(@ModelAttribute NewVolunteer newVolunteer) {
//        String name = newVolunteer.getName();
//        String email = newVolunteer.getEmail();
//        String phone = newVolunteer.getPhone();
//        String personalDescription = newVolunteer.getPersonalDescription();
//        String dateAvailable = newVolunteer.getDateAvailable();
//        String volunteerOffering = newVolunteer.getVolunteerOffering();
//
//        Volunteer volunteerToAdd = new Volunteer(name, email, phone, personalDescription, dateAvailable, volunteerOffering);
//
//        volunteerToAdd.setName(name);
//        volunteerToAdd.setEmail(email);
//        volunteerToAdd.setPhone(phone);
//        volunteerToAdd.setPersonalDescription(personalDescription);
//        volunteerToAdd.setDateAvailable(dateAvailable);
//        volunteerToAdd.setVolunteerOffering(volunteerOffering);
//        volunteerRepository.save(volunteerToAdd);
//        return "volunteer";
//
//    }

    @RequestMapping ("/testimonial")
    public String displayVolunteerDetails(ModelMap modelMap){
        VolunteerWrapper volunteerWrapper = volunteerService.fetchAllVolunteers();
        modelMap.put("volunteerWrapper", volunteerWrapper);
        return "testimonial";
    }



}
