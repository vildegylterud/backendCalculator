package no.ntnu.vildegy.backendCalculator.repo;

import no.ntnu.vildegy.backendCalculator.models.User.LoginRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoginRepo extends JpaRepository<LoginRequest, Long> {

    @Override
    List<LoginRequest> findAll();


    LoginRequest findByUsernameAndPassword(String username, String password);


    Optional<LoginRequest> findByUsername(String username);
}
