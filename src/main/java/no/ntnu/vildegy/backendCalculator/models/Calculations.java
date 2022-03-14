package no.ntnu.vildegy.backendCalculator.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
@Entity
@Table(name = "calculations")
public class Calculations {


    @OneToMany(cascade= CascadeType.ALL, mappedBy="calculation")
    @JsonIgnoreProperties("calculations")
    private List<Calculations> calculations= new ArrayList<>();


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "calculation")
    private String calculation;

    public Calculations() {

    }

    public Calculations(String calculation) {
        this.calculation = calculation;
    }

    public String getCalculation() {
        return calculation;
    }

    public void setCalculation(String calculation) {
        this.calculation = calculation;
    }

    public List<Calculations> getCalculations() {
        return calculations;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id +  "calculation=" + calculation + "]";
    }
}
*/
