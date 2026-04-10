package daw.fullstack.Conflict_Tracker_api.service;

import daw.fullstack.Conflict_Tracker_api.dto.ConflictResponseDTO;
import daw.fullstack.Conflict_Tracker_api.mapper.ConflictMapper;
import daw.fullstack.Conflict_Tracker_api.repository.ConflictRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConflictService {

    private final ConflictRepository repository;
    private final ConflictMapper mapper;

    public ConflictService(ConflictRepository repository, ConflictMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ConflictResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ConflictResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDTO)
                .orElse(null);
    }
}