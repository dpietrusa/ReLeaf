package com.detroitlabs.releaf.Controller;

import com.detroitlabs.releaf.Model.Comment;
import com.detroitlabs.releaf.Model.CommentRepository;
import com.detroitlabs.releaf.Model.NewComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/comment")
    public String addNewComment(Model model){
        model.addAttribute("newComment", new NewComment());
        return "disasterdetails";

    }

    @PostMapping("/comment")
    public String addNewComment(@ModelAttribute NewComment newComment) {
        String firstName = newComment.getFirstName();
        String lastName = newComment.getLastName();
        String phone = newComment.getPhone();
        String email = newComment.getEmail();
        String message = newComment.getMessage();

        Comment commentToAdd = new Comment(firstName, lastName, phone, email, message);

        commentToAdd.setFirstName(firstName);
        commentToAdd.setLastName(lastName);
        commentToAdd.setPhone(phone);
        commentToAdd.setEmail(email);
        commentToAdd.setMessage(message);
        commentRepository.save(commentToAdd);

        return "disasterdetails";
    }

    @GetMapping(path = "/allcomments")
    public @ResponseBody Iterable<Comment> getAllComments(){
        return commentRepository.findAll();
    }
}
