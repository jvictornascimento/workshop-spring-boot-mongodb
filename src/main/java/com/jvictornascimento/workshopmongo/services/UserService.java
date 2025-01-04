package com.jvictornascimento.workshopmongo.services;

import com.jvictornascimento.workshopmongo.domain.User;
import com.jvictornascimento.workshopmongo.dto.UserDto;
import com.jvictornascimento.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;


    public List<UserDto> findAll(){
        return repository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }
}
