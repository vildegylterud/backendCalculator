package no.ntnu.vildegy.backendCalculator.service;

import no.ntnu.vildegy.backendCalculator.controller.LoginController;
import no.ntnu.vildegy.backendCalculator.models.User.LoginRequest;
import no.ntnu.vildegy.backendCalculator.models.User.LoginResponse;
import no.ntnu.vildegy.backendCalculator.repo.LoginRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoginService {

    @Autowired
    LoginRepo loginRepo;

    LoginService(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }

    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

    public List<LoginRequest> getUsers() {
        return this.loginRepo.findAll();
    }

    public LoginResponse doLogin(LoginRequest loginRequest) {
        LOGGER.info("Logging in..." + loginRequest.getUsername() + loginRepo.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword()));
        if(loginRequest.equals(loginRepo.findAll())) {
            return new LoginResponse("Success");
        }
        return new LoginResponse("Fail");
    }
}
