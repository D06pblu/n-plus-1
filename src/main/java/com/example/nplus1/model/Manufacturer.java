package com.example.nplus1.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name="manufacturer")
@NoArgsConstructor
@Getter
@Setter
@ToString
@NamedEntityGraph(name = "manufacturer-graph",
        attributeNodes = {@NamedAttributeNode("models")})
public class Manufacturer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "foundation_year")
    private int foundationYear;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "manufacturer")
    private List<Model> models;

    public Manufacturer(String name, int foundationYear) {
        this.name = name;
        this.foundationYear = foundationYear;
    }
}
