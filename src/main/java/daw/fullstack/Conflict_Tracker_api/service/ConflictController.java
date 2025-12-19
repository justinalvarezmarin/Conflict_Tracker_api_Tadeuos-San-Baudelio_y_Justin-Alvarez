package daw.fullstack.Conflict_Tracker_api.service;

import daw.fullstack.Conflict_Tracker_api.dto.ConflictDTO;
import daw.fullstack.Conflict_Tracker_api.model.Conflict;
import daw.fullstack.Conflict_Tracker_api.repository.ConflictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/conflicts")
public class ConflictController {

    @Autowired
    private ConflictRepository conflictRepository;

    // GET ALL + FILTER
    @GetMapping
    public List<Conflict> getAll(
            @RequestParam(required = false) Conflict.Status status) {

        if (status != null) {
            return conflictRepository.findByStatus(status);
        }
        return conflictRepository.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Conflict getById(@PathVariable Long id) {
        return conflictRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conflict not found"));
    }

    // POST
    @PostMapping
    public Conflict create(@RequestBody ConflictDTO dto) {
        Conflict c = new Conflict();
        c.setName(dto.getName());
        c.setStartDate(dto.getStartDate());
        c.setStatus(dto.getStatus());
        c.setDescription(dto.getDescription());
        return conflictRepository.save(c);
    }

    // PUT
    @PutMapping("/{id}")
    public Conflict update(@PathVariable Long id, @RequestBody ConflictDTO dto) {
        Conflict c = conflictRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conflict not found"));

        c.setName(dto.getName());
        c.setStartDate(dto.getStartDate());
        c.setStatus(dto.getStatus());
        c.setDescription(dto.getDescription());

        return conflictRepository.save(c);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        conflictRepository.deleteById(id);
    }
}
