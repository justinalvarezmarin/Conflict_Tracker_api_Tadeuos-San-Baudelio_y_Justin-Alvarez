package daw.fullstack.Conflict_Tracker_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import daw.fullstack.Conflict_Tracker_api.model.Conflict;
import daw.fullstack.Conflict_Tracker_api.model.Conflict.Status;
import java.util.List;

public interface ConflictRepository extends JpaRepository<Conflict, Long> {}
