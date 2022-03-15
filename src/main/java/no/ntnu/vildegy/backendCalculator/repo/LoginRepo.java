package no.ntnu.vildegy.backendCalculator.repo;

import no.ntnu.vildegy.backendCalculator.models.LoginRequest;
import no.ntnu.vildegy.backendCalculator.models.LoginResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginRepo extends JpaRepository<LoginRequest, Long> {

    @Override
    List<LoginRequest> findAll();
}
