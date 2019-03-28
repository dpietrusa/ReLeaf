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

    private String disasterId;


    @GetMapping("/donation/{id}")
    public String addDonation(@PathVariable String id,  Model model){
        model.addAttribute("newDonation" , new NewDonation());
        this.disasterId = id;
        return "donation";
    }

    @PostMapping("/donation")
    public String addNewDonation(@ModelAttribute NewDonation newDonation) {
        String firstName = newDonation.getFirstName();
        String lastName = newDonation.getLastName();
        String email = newDonation.getEmail();
        int donationAmount = newDonation.getAmountToDonate();
//      String disasterId = newDonation.getDisasterIdForDonation();

        Donation donationToAdd = new Donation(donationAmount, firstName, lastName, email, this.disasterId);

        donationToAdd.setDisasterIdForDonation(this.disasterId);
        donationToAdd.setFirstName(firstName);
        donationToAdd.setLastName(lastName);
        donationToAdd.setEmail(email);
        donationToAdd.setAmountToDonate(donationAmount);
        donationRepository.save(donationToAdd);
        return "confirmation";

   }


    @GetMapping(path = "/alldonations")
    public @ResponseBody Iterable<Donation> getAllDonations () {
        return donationRepository.findAll();
    }
}

