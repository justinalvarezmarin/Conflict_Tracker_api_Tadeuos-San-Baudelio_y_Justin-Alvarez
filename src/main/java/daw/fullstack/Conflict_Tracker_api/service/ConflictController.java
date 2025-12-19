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

    private final ConflictService conflictService;

    public ConflictController(ConflictService conflictService) {
        this.conflictService = conflictService;
    }

    @GetMapping
    public List<Conflict> getAll() {
        return conflictService.findAll();
    }

    @PostMapping
    public Conflict create(@RequestBody ConflictDTO dto) {
        Conflict c = new Conflict();
        c.setName(dto.name);
        c.setStartDate(dto.startDate);
        c.setStatus(Conflict.Status.valueOf(String.valueOf(dto.status)));
        c.setDescription(dto.description);
        return conflictService.save(c);
    }

    @PutMapping("/{id}")
    public Conflict update(@PathVariable Long id, @RequestBody ConflictDTO dto) {
        Conflict c = conflictService.findById(id)
                .orElseThrow(() -> new RuntimeException("Conflict not found"));

        c.setName(dto.name);
        c.setStartDate(dto.startDate);
        c.setStatus(Conflict.Status.valueOf(String.valueOf(dto.status)));
        c.setDescription(dto.description);

        return conflictService.save(c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        conflictService.deleteById(id);
    }
}

