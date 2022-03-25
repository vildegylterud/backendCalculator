package no.ntnu.vildegy.backendCalculator.controller;
import com.sun.security.auth.UserPrincipal;
import no.ntnu.vildegy.backendCalculator.models.Calculator.CalculatorRequest;
import no.ntnu.vildegy.backendCalculator.models.Calculator.CalculatorResponse;
import no.ntnu.vildegy.backendCalculator.models.User.User;
import no.ntnu.vildegy.backendCalculator.repo.CalculationsRepo;
import no.ntnu.vildegy.backendCalculator.service.CalculatorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/calculate")
@EnableAutoConfiguration
@CrossOrigin
public class CalculatorController{

        @Autowired
        CalculatorService calculatorService;

        @Autowired
        CalculationsRepo calculatorRepo;

        private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

        @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(value = HttpStatus.CREATED)
        public CalculatorResponse doCalculate(final @RequestBody CalculatorRequest calculatorRequest, HttpSession session) {
                Long userId = (Long)session.getAttribute("user_id");
                if(userId == null){
                        return null;
                }

                return calculatorService.doCalculation(calculatorRequest, userId);
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

