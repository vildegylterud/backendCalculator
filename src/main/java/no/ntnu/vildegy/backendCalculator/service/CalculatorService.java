package no.ntnu.vildegy.backendCalculator.service;

import no.ntnu.vildegy.backendCalculator.controller.CalculatorController;

import no.ntnu.vildegy.backendCalculator.models.CalculatorRequest;
import no.ntnu.vildegy.backendCalculator.models.CalculatorResponse;
import no.ntnu.vildegy.backendCalculator.repo.CalculationsRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CalculatorService {

    @Autowired
    static CalculationsRepo calculationsRepo;

    CalculatorService(CalculationsRepo calculationsRepo) {
        this.calculationsRepo = calculationsRepo;
    }

    private static final Logger LOGGER = LogManager.getLogger(CalculatorController.class);
    String calculation;
    ArrayList<CalculatorResponse> calculations = new ArrayList();

    public CalculatorResponse doCalculation(CalculatorRequest calculatorRequest) {

        float a = Float.parseFloat(calculatorRequest.getFirstNumber());
        float b = Float.parseFloat(calculatorRequest.getSecondNumber());
        String operatorSign = null;
        float result = 0;
        if (calculatorRequest.getOperator() != null) {
            switch (calculatorRequest.getOperator()) {
                case "plus":
                    result = (a + b);
                    operatorSign = "+";
                    break;
                case "minus":
                    result = (a - b);
                    operatorSign = "-";
                    break;
                case "divide":
                    result = a / b;
                    operatorSign = "÷";
                    break;
                case "multiply":
                    result = a * b;
                    operatorSign = "×";
                    break;

            }
            this.calculation = a + " " + operatorSign + " " + b + " = " + result;
            LOGGER.info("Dette er resultatet: " + this.calculation);
            return new CalculatorResponse(this.calculation);
        }
        return null;
    }

    public ArrayList<CalculatorResponse> returnInJson() {
        calculations.add(new CalculatorResponse(this.calculation));
        return calculations;
    }


    public CalculatorResponse saveCalculation() {
        return calculationsRepo.save(new CalculatorResponse(this.calculation));

    }
}

