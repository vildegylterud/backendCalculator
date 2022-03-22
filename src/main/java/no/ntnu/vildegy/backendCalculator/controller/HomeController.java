package no.ntnu.vildegy.backendCalculator.controller;
import no.ntnu.vildegy.backendCalculator.models.User.LoginResponse;
import no.ntnu.vildegy.backendCalculator.service.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/")
@EnableAutoConfiguration
@CrossOrigin
public class HomeController {

    LoginService loginService;

    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);
    @GetMapping(value = "")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public LoginResponse doLogout(HttpSession session){
            return loginService.logout_user(session);
        }
    }
