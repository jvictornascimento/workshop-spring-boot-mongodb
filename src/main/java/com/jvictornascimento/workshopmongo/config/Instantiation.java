package com.jvictornascimento.workshopmongo.config;

import com.jvictornascimento.workshopmongo.domain.User;
import com.jvictornascimento.workshopmongo.domain.Post;
import com.jvictornascimento.workshopmongo.dto.AuthorDto;
import com.jvictornascimento.workshopmongo.dto.UserDto;
import com.jvictornascimento.workshopmongo.repositories.PostRepository;
import com.jvictornascimento.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        repository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null,"Maria fazendeira","maria@email.com");
        User antonio = new User(null,"antonio leiteiro","antonio@email.com");
        User jose = new User(null,"jose padeiro","jose@email.com");
        repository.saveAll(Arrays.asList(maria,jose,antonio));

        Post post1 = new Post(null, sdf.parse("21/03/2018"),"Partiu Viagem","Vou viajar para São Paulo. Abraços!",new AuthorDto(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"),"Bom dia ","Acordei feliz hoje!",new AuthorDto(maria));

        postRepository.saveAll(Arrays.asList(post2,post1));


    }
}
