package no.ntnu.vildegy.backendCalculator.models.Calculator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.security.auth.UserPrincipal;
import net.minidev.json.JSONUtil;
import no.ntnu.vildegy.backendCalculator.models.User.User;
import no.ntnu.vildegy.backendCalculator.repo.LoginRepo;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.SQLUpdate;
import org.hibernate.dialect.Database;

import javax.persistence.*;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "calculations")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculatorResponse {

    @Column(name = "calculation")
    private String calculatorStatus;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    public CalculatorResponse(@JsonProperty("calculatorStatus")  String calculatorStatus) {
        this.calculatorStatus = calculatorStatus;
    }

    public CalculatorResponse() {

    }

    public CalculatorResponse(String s, User user) {
        this.calculatorStatus = s;
        this.user = user;
    }

    @JsonProperty("calculatorStatus")
    public String getCalculatorStatus() {
        return calculatorStatus;
    }

    @OneToMany(cascade=CascadeType.ALL, mappedBy="calculatorStatus")
    @JsonIgnoreProperties("calculation")
    private List<CalculatorResponse> calculatorResponses = new ArrayList<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
