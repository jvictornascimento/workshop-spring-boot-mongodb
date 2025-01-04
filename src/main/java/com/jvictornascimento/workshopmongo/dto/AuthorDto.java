package com.jvictornascimento.workshopmongo.dto;

import com.jvictornascimento.workshopmongo.domain.User;

public class AuthorDto {
    private String id;
    private String name;
    public AuthorDto(){
    }
    public AuthorDto(User obj){
        this.id = obj.getId();
        this.name = obj.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
