package no.ntnu.vildegy.backendCalculator.models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginRequest {

    @Column
    private String username;
    @Column
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @JsonCreator
    public LoginRequest(@JsonProperty("username") final String username, @JsonProperty("password") final String password) {
        this.username = username;
        this.password = password;
    }

    public LoginRequest() {

    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }


    @JsonProperty("users")
    public String getCalculatorStatus() {
        return password + username;
    }

    @OneToMany(cascade=CascadeType.ALL, mappedBy="username")
    @JsonIgnoreProperties("users")
    private List<LoginRequest> loginRequests = new ArrayList<>();
}