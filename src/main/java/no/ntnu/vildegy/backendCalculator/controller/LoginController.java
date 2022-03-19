package no.ntnu.vildegy.backendCalculator.controller;
import no.ntnu.vildegy.backendCalculator.models.User.LoginRequest;
import no.ntnu.vildegy.backendCalculator.models.User.LoginResponse;
import no.ntnu.vildegy.backendCalculator.service.LoginService;
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

    @Autowired
    LoginService loginService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public LoginResponse login(final @RequestBody LoginRequest loginRequest) {
        return loginService.doLogin(loginRequest);
    }
}
    /**
     *
     *
     private static final Logger LOGGER = LogManager.getLogger(LoginController.class);
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
     @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
     @ResponseStatus(value = HttpStatus.CREATED)
     public LoginResponse login(final @RequestBody LoginRequest loginRequest) {
     return loginService.doLogin(loginRequest);
     }*/




