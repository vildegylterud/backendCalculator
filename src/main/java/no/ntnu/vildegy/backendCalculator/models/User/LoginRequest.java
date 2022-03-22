package no.ntnu.vildegy.backendCalculator.models.User;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginRequest {
    private String username;
    private String password;

    @JsonCreator
    public LoginRequest(@JsonProperty("username") final String username, @JsonProperty("password") final String password) {
        this.username = username;
        this.password = password;
    }


    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }


}