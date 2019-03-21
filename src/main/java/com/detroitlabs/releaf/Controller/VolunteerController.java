package com.detroitlabs.releaf.Controller;


import com.detroitlabs.releaf.Model.Volunteer;
import com.detroitlabs.releaf.Model.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/demo")
public class VolunteerController {


    @Autowired
    private VolunteerRepository volunteerRepository;

    @GetMapping(path = "/add")
    public @ResponseBody String addNewVolunteer (@RequestParam String name,
                                                 @RequestParam String email,
                                                 @RequestParam String phone,
                                                 @RequestParam String personalDescription,
                                                 @RequestParam String dateAvailable,
                                                 @RequestParam String volunteerOffering){

        Volunteer volunteerToAdd = new Volunteer();

        volunteerToAdd.setName(name);
        volunteerToAdd.setEmail(email);
        volunteerToAdd.setPhone(phone);
        volunteerToAdd.setPersonalDescription(personalDescription);
        volunteerToAdd.setDateAvailable(dateAvailable);
        volunteerToAdd.setVolunteerOffering(volunteerOffering);
        volunteerRepository.save(volunteerToAdd);
        return "saved";

    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Volunteer> getAllVolunteers(){
        return volunteerRepository.findAll();
    }
}
