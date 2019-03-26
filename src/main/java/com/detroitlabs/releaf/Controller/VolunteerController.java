package com.detroitlabs.releaf.Controller;


import com.detroitlabs.releaf.Model.NewVolunteer;
import com.detroitlabs.releaf.Model.Volunteer;
import com.detroitlabs.releaf.Model.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/")
public class VolunteerController {


    @Autowired
    private VolunteerRepository volunteerRepository;

//    @GetMapping(path = "/add")
//    public @ResponseBody String addNewVolunteer (@RequestParam String name,
//                                                 @RequestParam String email,
//                                                 @RequestParam String phone,
//                                                 @RequestParam String personalDescription,
//                                                 @RequestParam String dateAvailable,
//                                                 @RequestParam String volunteerOffering){
//
//        Volunteer volunteerToAdd = new Volunteer();
//
//        volunteerToAdd.setName(name);
//        volunteerToAdd.setEmail(email);
//        volunteerToAdd.setPhone(phone);
//        volunteerToAdd.setPersonalDescription(personalDescription);
//        volunteerToAdd.setDateAvailable(dateAvailable);
//        volunteerToAdd.setVolunteerOffering(volunteerOffering);
//        volunteerRepository.save(volunteerToAdd);
//        return "saved";
//
//    }

    @GetMapping("/volunteer")
    public String addVolunteer(Model model){
        model.addAttribute("newVolunteer", new NewVolunteer());
        return "volunteer";
    }

    @PostMapping("/volunteer")
    public String addNewVolunteer(@ModelAttribute NewVolunteer newVolunteer) {
        String name = newVolunteer.getName();
        String email = newVolunteer.getEmail();
        String phone = newVolunteer.getPhone();
        String personalDescription = newVolunteer.getPersonalDescription();
        String dateAvailable = newVolunteer.getDateAvailable();
        String volunteerOffering = newVolunteer.getVolunteerOffering();

            Volunteer volunteerToAdd = new Volunteer(name, email, phone, personalDescription, dateAvailable, volunteerOffering);

            volunteerToAdd.setName(name);
            volunteerToAdd.setEmail(email);
            volunteerToAdd.setPhone(phone);
            volunteerToAdd.setPersonalDescription(personalDescription);
            volunteerToAdd.setDateAvailable(dateAvailable);
            volunteerToAdd.setVolunteerOffering(volunteerOffering);
            volunteerRepository.save(volunteerToAdd);
            return "volunteer";

        }

        @GetMapping(path = "/all")
        public @ResponseBody Iterable<Volunteer> getAllVolunteers () {
            return volunteerRepository.findAll();
        }
    }
