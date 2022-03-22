package no.ntnu.vildegy.backendCalculator.models.Register;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterResponse {

    private String registerStatus;

    @JsonCreator()
    public RegisterResponse(@JsonProperty("registerStatus") String registerStatus) {
        this.registerStatus = registerStatus;
    }

    public String getRegisterStatus() {
        return registerStatus;
    }

}
