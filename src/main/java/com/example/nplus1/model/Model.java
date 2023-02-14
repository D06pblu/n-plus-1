package com.example.nplus1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "model")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ToString.Exclude
    @JsonBackReference
    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(
            name = "manufacturer_id",
            referencedColumnName = "id")
    private Manufacturer manufacturer;

    @Column(name = "name")
    private String modelName;

    @Column(name = "production_start")
    private int productionStartYear;

    @Column(name = "production_stop")
    private int productionStopYear;

    public Model(Manufacturer manufacturer, String modelName, int productionStartYear, int productionStopYear) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.productionStartYear = productionStartYear;
        this.productionStopYear = productionStopYear;
    }
}
