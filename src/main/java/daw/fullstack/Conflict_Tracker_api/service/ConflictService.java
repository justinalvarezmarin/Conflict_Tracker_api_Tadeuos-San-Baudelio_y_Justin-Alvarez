package daw.fullstack.Conflict_Tracker_api.service;

import daw.fullstack.Conflict_Tracker_api.model.Conflict;
import daw.fullstack.Conflict_Tracker_api.repository.ConflictRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConflictService {

    private final ConflictRepository repository;

    public ConflictService(ConflictRepository repository) {
        this.repository = repository;
    }

    // Este método lo necesita el WebController
    public List<Conflict> findAll() {
        return repository.findAll();
    }

    // Este lo usa el ConflictController de la API
    public List<Conflict> getAllConflicts() {
        return repository.findAll();
    }

    public Conflict getConflictById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Conflict createConflict(Conflict conflict) {
        return repository.save(conflict);
    }

    public void deleteConflict(Long id) {
        repository.deleteById(id);
    }
}