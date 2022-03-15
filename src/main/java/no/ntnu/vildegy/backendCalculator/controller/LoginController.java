package no.ntnu.vildegy.backendCalculator.controller;

import no.ntnu.vildegy.backendCalculator.models.LoginRequest;
import no.ntnu.vildegy.backendCalculator.models.LoginResponse;
import no.ntnu.vildegy.backendCalculator.service.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping(value = "/login")
    @EnableAutoConfiguration
    @CrossOrigin
    public class LoginController {

        @Autowired
        LoginService loginService;

        @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(value = HttpStatus.CREATED)
        public LoginResponse login(final @RequestBody LoginRequest loginRequest) {
            return loginService.doLogin2(loginRequest);
        }
}
