package com.detroitlabs.releaf.Controller;


import com.detroitlabs.releaf.Model.NewDonation;
import com.detroitlabs.releaf.Model.Donation;
import com.detroitlabs.releaf.Model.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/")
public class DonationController {


    @Autowired
    private DonationRepository donationRepository;


    @GetMapping("/donation")
    public String addDonation(Model model){
        model.addAttribute("newVolunteer", new NewDonation());
        return "donation";
    }

    @PostMapping("/donation")
    public String addNewVolunteer(@ModelAttribute NewDonation newDonation) {
        String firstName = newDonation.getFirstName();
        String lastName = newDonation.getLastName();
        String email = newDonation.getEmail();
        String disasterId = newDonation.getDisasterIdForDonation();
        int donationAmount = newDonation.getAmountToDonate();

        Donation donationToAdd = new Donation(donationAmount,firstName,lastName, email, disasterId);

        donationToAdd.setFirstName(firstName);
        donationToAdd.setLastName(lastName);
        donationToAdd.setEmail(email);
        donationToAdd.setAmountToDonate(donationAmount);
        donationRepository.save(donationToAdd);
        return "donation";

    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Donation> getAllVolunteers () {
        return donationRepository.findAll();
    }
}

