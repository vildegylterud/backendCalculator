package no.ntnu.vildegy.backendCalculator.repo;

import no.ntnu.vildegy.backendCalculator.models.User.LoginRequest;
import no.ntnu.vildegy.backendCalculator.models.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoginRepo extends JpaRepository<User, Long> {

    @Override
    List<User> findAll();

    @Query("from User where username=?1 and password=?2")
    User findByUsernameAndPassword(String username, String password);
}
