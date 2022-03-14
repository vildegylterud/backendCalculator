package no.ntnu.vildegy.backendCalculator;

import no.ntnu.vildegy.backendCalculator.models.CalculatorRequest;
import no.ntnu.vildegy.backendCalculator.models.CalculatorResponse;
import no.ntnu.vildegy.backendCalculator.repo.CalculationsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration()
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CalculationsRepo calculationsRepo) {

        return args -> {
            log.info("Preloading " + calculationsRepo.save(new CalculatorRequest("4+4=8")));
        };
    }
}
