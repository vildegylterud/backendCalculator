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
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping(value = "/login")
    @EnableAutoConfiguration
    @CrossOrigin
    public class LoginController {
        private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

        @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(value = HttpStatus.CREATED)
        public LoginResponse doLogin(final @RequestBody LoginRequest loginRequest){
            LOGGER.info("Logging in..." + loginRequest.getUsername());
            if(loginRequest.getUsername().equalsIgnoreCase("user")
                    && loginRequest.getPassword().equalsIgnoreCase("pass")) {
                return new LoginResponse("Success");
            }
            return new LoginResponse("Fail");
        }
    }
    /**


@Autowired
LoginService loginService;

@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseStatus(value = HttpStatus.CREATED)
public LoginResponse login(final @RequestBody LoginRequest loginRequest) {
    return loginService.doLogin2(loginRequest);
}
}*/


