package no.ntnu.vildegy.backendCalculator.models;

import com.fasterxml.jackson.annotation.JsonCreator;
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
public class CalculatorRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstNumber;
    private String secondNumber;
    private String operator;
    @Column(name = "calculation")
    private String calculation;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="calculation")
    @JsonIgnoreProperties("calculations")
    private List<CalculatorRequest> calculations= new ArrayList<>();


    @JsonCreator
    public CalculatorRequest(@JsonProperty("firstNumber") String firstNumber, @JsonProperty("secondNumber") String secondNumber, @JsonProperty("operator") String operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;

    }

    @JsonCreator
    public CalculatorRequest(@JsonProperty("firstNumber") String firstNumber, @JsonProperty("secondNumber") String secondNumber, @JsonProperty("operator") String operator, String calculation ) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
        this.calculation = calculation;

    }

    public CalculatorRequest() {

    }

    public CalculatorRequest(String Calculation) {
    }

    @JsonProperty("firstNumber")
    public String getFirstNumber() {
        return firstNumber;
    }

    @JsonProperty("secondNumber")
    public String getSecondNumber() {
        return secondNumber;
    }

    @JsonProperty("operator")
    public String getOperator() {
        return operator;
    }


}
