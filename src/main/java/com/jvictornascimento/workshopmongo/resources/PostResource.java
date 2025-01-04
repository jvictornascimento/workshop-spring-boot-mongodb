package com.jvictornascimento.workshopmongo.resources;

import com.jvictornascimento.workshopmongo.domain.Post;
import com.jvictornascimento.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findByid(id));
    }
    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findtitle(@RequestParam(value = "text",defaultValue = "") String text){
        return ResponseEntity.status(HttpStatus.OK).body(service.findTitle(text));
    }
}
