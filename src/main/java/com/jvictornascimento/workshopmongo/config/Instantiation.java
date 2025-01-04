package com.jvictornascimento.workshopmongo.config;

import com.jvictornascimento.workshopmongo.domain.User;
import com.jvictornascimento.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        User maria = new User(null,"Maria fazendeira","maria@email.com");
        User antonio = new User(null,"antonio leiteiro","antonio@email.com");
        User jose = new User(null,"jose padeiro","jose@email.com");

        repository.saveAll(Arrays.asList(maria,jose,antonio));

    }
}
