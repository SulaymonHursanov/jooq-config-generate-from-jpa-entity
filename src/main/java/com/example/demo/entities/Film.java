package com.example.demo.entities;
import com.example.demo.converters.YearConverter;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


/**
 * @author Lukas Eder
 */
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Integer filmId;

    @Column
    public int length;

    // It is easy to reuse a JPA AttributeConverter by manually generating the relevant Converters in jOOQ.
    // A future version of jOOQ may auto-discover all such JPA AttributeConverters and reuse them in jOOQ as well.
    @Column(name = "RELEASE_YEAR")
    @Convert(converter = YearConverter.class)
    public Year releaseYear;

    @ManyToOne(fetch = LAZY)
    public Language language;

    @ManyToOne(fetch = LAZY)
    public Language originalLanguage;

    @ManyToMany(fetch = LAZY, cascade = CascadeType.ALL)
    public Set<Actor> actors = new HashSet<>();

    public Film() {}

    public Film(Language language, int length, Year releaseYear) {
        this.language = language;
        this.length = length;
        this.releaseYear = releaseYear;
    }
}
