package no.ntnu.vildegy.backendCalculator.service;

import no.ntnu.vildegy.backendCalculator.controller.LoginController;
import no.ntnu.vildegy.backendCalculator.models.LoginRequest;
import no.ntnu.vildegy.backendCalculator.models.LoginResponse;
import no.ntnu.vildegy.backendCalculator.repo.LoginRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

            if(loginRequest.equals(findUser(loginRequest.getUsername(), loginRequest.getPassword()))) {
        return new LoginResponse("Success");
    }
            return new LoginResponse("Fail");
    }

    public Optional<LoginRequest> findUser(String username, String password) {
        return loginRepo.findAll().stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password)).findFirst();
    }




    public LoginResponse doLogin2(LoginRequest loginRequest) {
        LOGGER.info("Logging in..." + loginRequest.getUsername());

        if(loginRequest.equals(loginRepo.findAll().stream().findFirst())) {
            return new LoginResponse("Success");
        }
        return new LoginResponse("Fail");
    }


}
