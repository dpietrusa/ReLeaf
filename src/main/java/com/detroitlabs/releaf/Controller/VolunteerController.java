package com.detroitlabs.releaf.Controller;


import com.detroitlabs.releaf.Model.NewVolunteer;
import com.detroitlabs.releaf.Model.Volunteer;
import com.detroitlabs.releaf.Model.VolunteerRepository;
import com.detroitlabs.releaf.Model.VolunteerWrapper;
import com.detroitlabs.releaf.Service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping(path = "/")
public class VolunteerController {


    @Autowired
    private VolunteerRepository volunteerRepository;

    @Autowired
    private VolunteerService volunteerService;

    @GetMapping("/volunteer")
    public String addVolunteer(Model model, ModelMap modelMap) {
        model.addAttribute("newVolunteer", new NewVolunteer());

        VolunteerWrapper volunteerWrapper = volunteerService.fetchAllVolunteers();

        List<Volunteer> topFiveVolunteers = new ArrayList<>();

        Collections.sort(volunteerWrapper, new Comparator<Volunteer>() {
            @Override
            public int compare(Volunteer volunteer1, Volunteer volunteer2) {
                return volunteer2.getId().compareTo(volunteer1.getId());
            }
        });

        for (int i = 0; i <= 4; i++) {
            topFiveVolunteers.add(volunteerWrapper.get(i));
        }
        modelMap.put("topFiveVolunteers", topFiveVolunteers);

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

        Volunteer volunteerToAdd = new Volunteer(name, email, phone, personalDescription, dateAvailable,
                volunteerOffering);

        volunteerToAdd.setName(name);
        volunteerToAdd.setEmail(email);
        volunteerToAdd.setPhone(phone);
        volunteerToAdd.setPersonalDescription(personalDescription);
        volunteerToAdd.setDateAvailable(dateAvailable);
        volunteerToAdd.setVolunteerOffering(volunteerOffering);
        volunteerRepository.save(volunteerToAdd);
        return "confirmation";

    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }


}
