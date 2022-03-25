package no.ntnu.vildegy.backendCalculator;

import no.ntnu.vildegy.backendCalculator.models.Calculator.CalculatorResponse;
import no.ntnu.vildegy.backendCalculator.models.User.User;
import no.ntnu.vildegy.backendCalculator.repo.CalculationsRepo;
import no.ntnu.vildegy.backendCalculator.repo.LoginRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration()
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(LoginRepo loginRepo, CalculationsRepo calculationsRepo) {

        return args -> {
            log.info("Preloading: " + loginRepo.save(new User("hei", "hallo")));
            log.info("Preloading: " + loginRepo.save(new User("user", "pass")));

            User testuser = loginRepo.findByUsernameAndPassword("user", "pass");
            log.info("Preloading: " + calculationsRepo.save(new CalculatorResponse("2+2=4", testuser)));
        };
    }
}
