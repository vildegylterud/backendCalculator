package no.ntnu.vildegy.backendCalculator.repo;

import no.ntnu.vildegy.backendCalculator.models.Calculator.CalculatorResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CalculationsRepo extends JpaRepository<CalculatorResponse, Long> {

    Optional<CalculatorResponse> findById(Long id);

    @Query("from CalculatorResponse where calculatorStatus =?1 and id=?2")
    CalculatorResponse saveCalculation(long id, String calculation);


}
