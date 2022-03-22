package no.ntnu.vildegy.backendCalculator.controller;
import no.ntnu.vildegy.backendCalculator.models.User.LoginRequest;
import no.ntnu.vildegy.backendCalculator.models.User.LoginResponse;
import no.ntnu.vildegy.backendCalculator.models.User.User;
import no.ntnu.vildegy.backendCalculator.repo.LoginRepo;
import no.ntnu.vildegy.backendCalculator.service.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
    @RequestMapping(value = "/login")
    @EnableAutoConfiguration
    @CrossOrigin
    public class LoginController {

    @Autowired
    LoginService loginService;


    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public LoginResponse login(final @RequestBody LoginRequest loginRequest, HttpSession session,ModelMap modelMap) {
        return loginService.login_user(loginRequest,session,modelMap);
    }
}
