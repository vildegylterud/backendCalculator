package no.ntnu.vildegy.backendCalculator.controller;

import no.ntnu.vildegy.backendCalculator.models.Register.RegisterRequest;
import no.ntnu.vildegy.backendCalculator.models.Register.RegisterResponse;
import no.ntnu.vildegy.backendCalculator.models.User.LoginRequest;
import no.ntnu.vildegy.backendCalculator.models.User.LoginResponse;
import no.ntnu.vildegy.backendCalculator.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/register")
@EnableAutoConfiguration
@CrossOrigin
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public RegisterResponse register(final @RequestBody RegisterRequest registerRequest) {
        return registerService.addUser(registerRequest);
    }



}
