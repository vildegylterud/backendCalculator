package no.ntnu.vildegy.backendCalculator;

import no.ntnu.vildegy.backendCalculator.models.CalculatorResponse;
import no.ntnu.vildegy.backendCalculator.models.User.LoginRequest;
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
    CommandLineRunner initDatabase(CalculationsRepo calculationsRepo, LoginRepo loginRepo) {

        return args -> {
            log.info("Preloading " + calculationsRepo.save(new CalculatorResponse("4+4=8")));
            log.info("Preloading: " + loginRepo.save(new LoginRequest("hei", "hallo")));
            log.info("Preloading: " + loginRepo.save(new LoginRequest("user", "pass")));

        };
    }
}
