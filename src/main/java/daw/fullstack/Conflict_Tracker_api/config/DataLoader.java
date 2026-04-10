package daw.fullstack.Conflict_Tracker_api.config;

import daw.fullstack.Conflict_Tracker_api.model.Conflict;
import daw.fullstack.Conflict_Tracker_api.repository.ConflictRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(ConflictRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                System.out.println("Inyectando datos iniciales para el examen...");

                repository.save(new Conflict(
                        "Guerra d'Ucraïna",
                        "Conflicte armat a gran escala a Europa de l'Est amb gran impacte geopolític.",
                        "ACTIVE",
                        LocalDate.of(2022, 2, 24),
                        "ua"
                ));

                repository.save(new Conflict(
                        "Guerra Civil de Sudan",
                        "Lluita pel poder entre l'exèrcit i les forces de suport ràpid.",
                        "ACTIVE",
                        LocalDate.of(2023, 4, 15),
                        "sd"
                ));

                repository.save(new Conflict(
                        "Conflicte de Gaza",
                        "Escalada militar intensa a l'Orient Mitjà iniciada el 2023.",
                        "ACTIVE",
                        LocalDate.of(2023, 10, 7),
                        "ps"
                ));

                repository.save(new Conflict(
                        "Disputa de les Illes Kurils",
                        "Conflicte territorial històric entre Japó i Rússia que encara es manté latent.",
                        "FROZEN",
                        LocalDate.of(1945, 8, 18),
                        "jp"
                ));

                System.out.println("Dades carregades: 4 conflictes disponibles.");
            } else {
                System.out.println("La base de dades ja conté dades, saltant injecció.");
            }
        };
    }
}