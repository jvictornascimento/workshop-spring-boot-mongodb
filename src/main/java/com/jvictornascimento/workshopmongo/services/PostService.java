package com.jvictornascimento.workshopmongo.services;

import com.jvictornascimento.workshopmongo.domain.Post;
import com.jvictornascimento.workshopmongo.repositories.PostRepository;
import com.jvictornascimento.workshopmongo.resources.utils.URL;
import com.jvictornascimento.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jvictornascimento.workshopmongo.resources.utils.URL.decodeParam;

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
    public List<Post> findTitle(String text){
        text = URL.decodeParam(text);

        if(repository.findByTitleContainingIgnoreCase(text).isEmpty()){
            System.out.println(text);
            throw new ObjectNotFoundException("Lista não encontrado");
        }
        return repository.searchTitle(text);
    }

}
