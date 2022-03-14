package no.ntnu.vildegy.backendCalculator.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculatorResponse {


    @Column(name = "calculation")
    private String calculatorStatus;


    public CalculatorResponse(@JsonProperty("calculatorStatus")  String calculatorStatus) {
        this.calculatorStatus = calculatorStatus;
    }


    @JsonProperty("calculatorStatus")
    public String getCalculatorStatus() {
        return calculatorStatus;
    }

}
