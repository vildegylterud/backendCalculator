package no.ntnu.vildegy.backendCalculator.service;

import lombok.extern.java.Log;
import no.ntnu.vildegy.backendCalculator.models.Register.RegisterRequest;
import no.ntnu.vildegy.backendCalculator.models.Register.RegisterResponse;
import no.ntnu.vildegy.backendCalculator.models.User.User;
import no.ntnu.vildegy.backendCalculator.repo.LoginRepo;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {

    @Autowired
    LoginRepo loginRepo;

    RegisterService(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }

    public RegisterResponse addUser(RegisterRequest registerRequest) {
        User user = loginRepo.findByUsername(registerRequest.getUsername());

            if(user != null) {
               return new RegisterResponse("Fail");
            }
            else {
                loginRepo.save(new User(registerRequest.getUsername(), registerRequest.getPassword()));
                return new RegisterResponse("Success");
            }
        }
    }




