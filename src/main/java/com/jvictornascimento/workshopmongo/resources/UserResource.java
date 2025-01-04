package com.jvictornascimento.workshopmongo.resources;

import com.jvictornascimento.workshopmongo.domain.User;
import com.jvictornascimento.workshopmongo.dto.UserDto;
import com.jvictornascimento.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService service;
    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id){
        return ResponseEntity.ok().body(service.findById(id));
    }
}
