package com.example.demo.entities;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Integer actorId;

    @Column
    public String firstName;

    @Column
    public String lastName;


    @ManyToMany(fetch = LAZY, mappedBy = "actors", cascade = CascadeType.ALL)
    public Set<Film> films = new HashSet<>();

    public Actor() {}

    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}