package no.ntnu.vildegy.backendCalculator.repo;

import no.ntnu.vildegy.backendCalculator.models.CalculatorRequest;
import no.ntnu.vildegy.backendCalculator.models.CalculatorResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalculationsRepo extends JpaRepository<CalculatorRequest, Long> {

    List<CalculatorRequest> findByOperator(String operator);

}
