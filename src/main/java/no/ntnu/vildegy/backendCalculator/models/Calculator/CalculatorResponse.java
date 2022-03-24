package no.ntnu.vildegy.backendCalculator.models.Calculator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.minidev.json.JSONUtil;
import no.ntnu.vildegy.backendCalculator.models.User.User;
import no.ntnu.vildegy.backendCalculator.repo.LoginRepo;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.SQLUpdate;

import javax.persistence.*;
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

    @ManyToOne(targetEntity = User.class)
    //@JoinColumn(insertable = false, updatable = false)
    @JsonBackReference("users")
    @Fetch(FetchMode.JOIN)
    @PrimaryKeyJoinColumn
    User user;

    public CalculatorResponse(@JsonProperty("calculatorStatus")  String calculatorStatus) {
        this.calculatorStatus = calculatorStatus;
    }

    public CalculatorResponse() {

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

}
