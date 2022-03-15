package no.ntnu.vildegy.backendCalculator.service;

import no.ntnu.vildegy.backendCalculator.controller.LoginController;
import no.ntnu.vildegy.backendCalculator.models.LoginRequest;
import no.ntnu.vildegy.backendCalculator.models.LoginResponse;
import no.ntnu.vildegy.backendCalculator.repo.LoginRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    LoginRepo loginRepo;

    LoginService(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }

    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

    public LoginResponse doLogin(LoginRequest loginRequest) {
            LOGGER.info("Logging in..." + loginRequest.getUsername());
            if(loginRequest.getUsername().equalsIgnoreCase("user")
                    && loginRequest.getPassword().equalsIgnoreCase("pass")) {
        return new LoginResponse("Success");
    }
            return new LoginResponse("Fail");
    }

}
