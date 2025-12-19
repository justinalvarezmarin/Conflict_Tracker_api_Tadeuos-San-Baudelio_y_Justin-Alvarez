package daw.fullstack.Conflict_Tracker_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import daw.fullstack.Conflict_Tracker_api.model.Faction;

public interface FactionRepository extends JpaRepository<Faction, Long> {
}
