package com.example.demos.model.dto;

public class UserDTO {
    public Long id;
    public String name;

    public UserDTO() {}

    public UserDTO(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
