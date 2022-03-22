package no.ntnu.vildegy.backendCalculator.service;

import no.ntnu.vildegy.backendCalculator.controller.LoginController;
import no.ntnu.vildegy.backendCalculator.models.User.LoginRequest;
import no.ntnu.vildegy.backendCalculator.models.User.LoginResponse;
import no.ntnu.vildegy.backendCalculator.models.User.User;
import no.ntnu.vildegy.backendCalculator.repo.LoginRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import javax.servlet.http.HttpSession;

@Service
public class LoginService {

    @Autowired
    LoginRepo loginRepo;

    LoginService(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }

    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);


    public LoginResponse login_user(LoginRequest loginRequest, HttpSession session, ModelMap modelMap) {

        User auser = loginRepo.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());

        if (auser != null) {
            String uname = auser.getUsername();
            String upass = auser.getPassw();

            LOGGER.info("Logging in..." + uname);

            if (loginRequest.getUsername().equalsIgnoreCase(uname) && loginRequest.getPassword().equalsIgnoreCase(upass)) {
                session.setAttribute("username", loginRequest.getUsername());
                return new LoginResponse("Success");
            } else {
                modelMap.put("error", "Invalid Account");
                return new LoginResponse("Fail");
            }
        } else {
            modelMap.put("error", "Invalid Account");
            return new LoginResponse("Fail");
        }
    }
}