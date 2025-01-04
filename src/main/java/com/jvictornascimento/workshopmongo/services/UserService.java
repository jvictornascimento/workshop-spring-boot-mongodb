package com.jvictornascimento.workshopmongo.services;

import com.jvictornascimento.workshopmongo.domain.User;
import com.jvictornascimento.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;


    public List<User> findAll(){
        return repository.findAll();
    }
}
