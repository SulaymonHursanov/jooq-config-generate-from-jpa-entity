package com.example.demo.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Lukas Eder
 */
@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Integer languageId;

    @Column
    public String name;

    public Language() {}

    public Language(String name) {
        this.name = name;
    }
}