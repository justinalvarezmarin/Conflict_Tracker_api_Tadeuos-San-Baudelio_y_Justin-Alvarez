package daw.fullstack.Conflict_Tracker_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import daw.fullstack.Conflict_Tracker_api.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
