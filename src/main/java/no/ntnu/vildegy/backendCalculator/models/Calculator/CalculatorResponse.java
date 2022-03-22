package no.ntnu.vildegy.backendCalculator.models.Calculator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "calculations")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculatorResponse {

    @Column(name = "calculation")
    private String calculatorStatus;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    public CalculatorResponse(@JsonProperty("calculatorStatus")  String calculatorStatus) {
        this.calculatorStatus = calculatorStatus;
    }

    public CalculatorResponse() {

    }

    @JsonProperty("calculatorStatus")
    public String getCalculatorStatus() {
        return calculatorStatus;
    }

    @OneToMany(cascade=CascadeType.ALL, mappedBy="calculatorStatus")
    @JsonIgnoreProperties("calculation")
    private List<CalculatorResponse> calculatorResponses = new ArrayList<>();

}
