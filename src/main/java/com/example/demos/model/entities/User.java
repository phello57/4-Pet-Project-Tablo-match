package com.example.demos.model.entities;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="USER")
@EntityScan(basePackages="com.example.demos.model.entities")
public class User {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;

    public User() {

    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}