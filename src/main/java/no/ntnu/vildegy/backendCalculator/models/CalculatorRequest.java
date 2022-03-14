package no.ntnu.vildegy.backendCalculator.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculatorRequest {

    private String firstNumber;

    private String secondNumber;

    private String operator;



    @JsonCreator
    public CalculatorRequest(@JsonProperty("firstNumber") String firstNumber, @JsonProperty("secondNumber") String secondNumber, @JsonProperty("operator") String operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
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

