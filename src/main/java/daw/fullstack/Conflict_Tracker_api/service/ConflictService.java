package daw.fullstack.Conflict_Tracker_api.service;

import daw.fullstack.Conflict_Tracker_api.model.Conflict;
import daw.fullstack.Conflict_Tracker_api.repository.ConflictRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConflictService {

    private final ConflictRepository conflictRepository;

    public ConflictService(ConflictRepository conflictRepository) {
        this.conflictRepository = conflictRepository;
    }

    public List<Conflict> findAll() {
        return conflictRepository.findAll();
    }

    public Optional<Conflict> findById(Long id) {
        return conflictRepository.findById(id);
    }

    public Conflict save(Conflict conflict) {
        return conflictRepository.save(conflict);
    }

    public void deleteById(Long id) {
        conflictRepository.deleteById(id);
    }
}
