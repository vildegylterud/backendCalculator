package no.ntnu.vildegy.backendCalculator.controller;

import no.ntnu.vildegy.backendCalculator.models.CalculatorRequest;
import no.ntnu.vildegy.backendCalculator.repo.CalculationsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**

@RestController
@CrossOrigin(origins = "http://localhost:8082")
@RequestMapping("/api")
public class CalculationsController {

    @Autowired
    CalculationsRepo calculationsRepo;

    @GetMapping("/calculations")
    public ResponseEntity<List<CalculatorRequest>> getAllCalculations(@RequestParam(required = false) String calculations) {
        try {
            List<CalculatorRequest> calculations1 = new ArrayList<CalculatorRequest>();
            if (calculations == null)
                calculationsRepo.findAll().forEach(calculations1::add);

            if (calculations1.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(calculations1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/calculations/{id}")
    public ResponseEntity<CalculatorRequest> getCalculationsById(@PathVariable("id") long id) {
        Optional<CalculatorRequest> calculationsData = calculationsRepo.findById(id);
        if (calculationsData.isPresent()) {
            return new ResponseEntity<>(calculationsData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/calculations")
    public ResponseEntity<HttpStatus> deleteAllCalculations() {
        try {
            calculationsRepo.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
*/