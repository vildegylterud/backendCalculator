package no.ntnu.vildegy.backendCalculator.controller;
import no.ntnu.vildegy.backendCalculator.models.CalculatorRequest;
import no.ntnu.vildegy.backendCalculator.models.CalculatorResponse;
import no.ntnu.vildegy.backendCalculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/calculate")
@EnableAutoConfiguration
@CrossOrigin
public class CalculatorController {

        @Autowired
        CalculatorService calculatorService;


        @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(value = HttpStatus.CREATED)
        public CalculatorResponse doCalculate(final @RequestBody CalculatorRequest calculatorRequest) {
                return calculatorService.doCalculation(calculatorRequest);
        }



        @GetMapping("")
        public ArrayList<CalculatorResponse> returnToJSON() {
                return calculatorService.returnInJson();
        }


        @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(value = HttpStatus.OK)
        public List<CalculatorResponse> getCalculations() {
                return calculatorService.getCalculations();
        }

}

