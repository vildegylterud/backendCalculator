package no.ntnu.vildegy.backendCalculator.models.Register;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterRequest {

    private String name;
    private String address;
    private String username;
    private String password;
    private String email;
    private int phone;

    @JsonCreator
    public RegisterRequest(@JsonProperty("name") String name,
                           @JsonProperty("address") String address,
                           @JsonProperty("username") String username,
                           @JsonProperty("password") String password,
                           @JsonProperty("email") String email,
                           @JsonProperty("phone") int phone) {
        this.name = name;
        this.address = address;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("phone")
    public int getPhone() {
        return phone;
    }
}
