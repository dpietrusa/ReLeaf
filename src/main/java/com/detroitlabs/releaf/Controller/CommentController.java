package com.detroitlabs.releaf.Controller;

import com.detroitlabs.releaf.Model.*;
import com.detroitlabs.releaf.Service.ReleafWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ReleafWebService releafWebService;

    private String disasterId;

    @GetMapping("/details/{id}")
    public String addNewComment(@PathVariable String id, Model model, ModelMap modelMap){
        DisasterDetailsWrapper disasterDetailsWrapper = releafWebService.fetchDisasterDetailDataByID(id);
        Fields fields = disasterDetailsWrapper.getData().get(0).getFields();
        this.disasterId = fields.getId();
        modelMap.put("fields", fields);
        model.addAttribute("newComment", new NewComment());
        return "disasterdetails";

    }

    @PostMapping("/")
    public String addNewComment(@ModelAttribute NewComment newComment) {
//        String disasterId = newComment.getDisasterId();
        String firstName = newComment.getFirstName();
        String lastName = newComment.getLastName();
        String phone = newComment.getPhone();
        String email = newComment.getEmail();
        String message = newComment.getMessage();

        Comment commentToAdd = new Comment(disasterId, firstName, lastName, phone, email, message);

        commentToAdd.setDisasterId(this.disasterId);
        commentToAdd.setFirstName(firstName);
        commentToAdd.setLastName(lastName);
        commentToAdd.setPhone(phone);
        commentToAdd.setEmail(email);
        commentToAdd.setMessage(message);
        commentRepository.save(commentToAdd);

        return "index";
    }

    @GetMapping(path = "/allcomments")
    public @ResponseBody Iterable<Comment> getAllComments(){
        return commentRepository.findAll();
    }
}
