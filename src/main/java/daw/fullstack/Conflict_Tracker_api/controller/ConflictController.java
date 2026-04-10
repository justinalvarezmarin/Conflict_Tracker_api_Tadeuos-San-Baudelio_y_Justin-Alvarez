package daw.fullstack.Conflict_Tracker_api.controller;

import daw.fullstack.Conflict_Tracker_api.dto.ConflictResponseDTO;
import daw.fullstack.Conflict_Tracker_api.service.ConflictService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/conflicts")
@CrossOrigin(origins = "*")
public class ConflictController {

    private final ConflictService service;

    public ConflictController(ConflictService service) {
        this.service = service;
    }

    @GetMapping
    public List<ConflictResponseDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ConflictResponseDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }
}