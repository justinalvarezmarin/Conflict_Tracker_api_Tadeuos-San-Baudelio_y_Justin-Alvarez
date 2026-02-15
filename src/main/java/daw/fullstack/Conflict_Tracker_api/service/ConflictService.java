package daw.fullstack.Conflict_Tracker_api.service;

import daw.fullstack.Conflict_Tracker_api.dto.ConflictRequestDTO;
import daw.fullstack.Conflict_Tracker_api.dto.ConflictResponseDTO;
import daw.fullstack.Conflict_Tracker_api.mapper.ConflictMapper;
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

    public List<ConflictResponseDTO> getAllConflicts() {
        return repository.findAll()
                .stream()
                .map(ConflictMapper::toDTO)
                .toList();
    }

    public ConflictResponseDTO getConflictById(Long id) {
        Conflict conflict = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conflict not found"));

        return ConflictMapper.toDTO(conflict);
    }

    public ConflictResponseDTO createConflict(ConflictRequestDTO request) {
        Conflict conflict = ConflictMapper.toEntity(request);
        return ConflictMapper.toDTO(repository.save(conflict));
    }

    public ConflictResponseDTO updateConflict(Long id, ConflictRequestDTO request) {
        Conflict conflict = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conflict not found"));

        ConflictMapper.updateEntity(conflict, request);
        return ConflictMapper.toDTO(repository.save(conflict));
    }

    public void deleteConflict(Long id) {
        repository.deleteById(id);
    }
}
