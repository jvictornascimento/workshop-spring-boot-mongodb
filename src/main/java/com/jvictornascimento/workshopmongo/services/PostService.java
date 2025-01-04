package com.jvictornascimento.workshopmongo.services;

import com.jvictornascimento.workshopmongo.domain.Post;
import com.jvictornascimento.workshopmongo.repositories.PostRepository;
import com.jvictornascimento.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;
    public Post findByid(String id){
        if(repository.findById(id).isEmpty()){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return repository.findById(id).get();
    }
}
