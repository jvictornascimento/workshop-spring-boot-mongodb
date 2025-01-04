package com.jvictornascimento.workshopmongo.services;

import com.jvictornascimento.workshopmongo.domain.User;
import com.jvictornascimento.workshopmongo.dto.UserDto;
import com.jvictornascimento.workshopmongo.repositories.UserRepository;
import com.jvictornascimento.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.jvictornascimento.workshopmongo.dto.UserDto.fromDto;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;


    public List<UserDto> findAll(){
        return repository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }

    public UserDto findById(String id) {
        if (repository.findById(id).isEmpty()){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return new UserDto(repository.findById(id).get());
    }

    public UserDto insert(UserDto dto){
        return new UserDto(repository.save(fromDto(dto)));
    }
}
