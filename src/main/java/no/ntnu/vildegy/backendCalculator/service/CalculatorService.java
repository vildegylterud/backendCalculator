package no.ntnu.vildegy.backendCalculator.service;

import no.ntnu.vildegy.backendCalculator.controller.CalculatorController;

import no.ntnu.vildegy.backendCalculator.models.Calculator.CalculatorRequest;
import no.ntnu.vildegy.backendCalculator.models.Calculator.CalculatorResponse;
import no.ntnu.vildegy.backendCalculator.repo.CalculationsRepo;
import no.ntnu.vildegy.backendCalculator.repo.LoginRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorService {

    @Autowired
    CalculationsRepo calculationsRepo;

    @Autowired
    LoginRepo loginRepo;


    CalculatorService(CalculationsRepo calculationsRepo) {
        this.calculationsRepo = calculationsRepo;
    }

    private static final Logger LOGGER = LogManager.getLogger(CalculatorController.class);
    String calculation;
    ArrayList<CalculatorResponse> calculations = new ArrayList();


    public List<CalculatorResponse> getCalculations() {
        return calculationsRepo.findAll();
    }

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


            calculationsRepo.save(new CalculatorResponse(this.calculation));
            calculations.add(new CalculatorResponse(this.calculation));


            LOGGER.info("Dette er resultatet: " + this.calculation);
            return new CalculatorResponse(this.calculation);
        }
        return null;
    }


    public ArrayList<CalculatorResponse> returnInJson() {
        calculations.add(new CalculatorResponse(this.calculation));
        return calculations;
    }

    public void saveCalculation() {
     calculationsRepo.save(new CalculatorResponse(this.calculation));
    }

}

