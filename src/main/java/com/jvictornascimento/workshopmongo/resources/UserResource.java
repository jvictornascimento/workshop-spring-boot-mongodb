package com.jvictornascimento.workshopmongo.resources;

import com.jvictornascimento.workshopmongo.domain.User;
import com.jvictornascimento.workshopmongo.dto.UserDto;
import com.jvictornascimento.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
    @PostMapping
    public ResponseEntity<UserDto> insert(@RequestBody UserDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
    }
}
