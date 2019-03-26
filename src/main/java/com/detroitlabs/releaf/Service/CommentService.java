package com.detroitlabs.releaf.Service;

import com.detroitlabs.releaf.Model.Comment;
import com.detroitlabs.releaf.Model.CommentWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CommentService {
    public CommentWrapper fetchAllComments(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/allcomments", CommentWrapper.class);
    }

}
