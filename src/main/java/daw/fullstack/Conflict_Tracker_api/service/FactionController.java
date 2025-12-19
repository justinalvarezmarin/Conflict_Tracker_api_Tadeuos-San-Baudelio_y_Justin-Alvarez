package daw.fullstack.Conflict_Tracker_api.service;

import daw.fullstack.Conflict_Tracker_api.dto.FactionDTO;
import daw.fullstack.Conflict_Tracker_api.model.Conflict;
import daw.fullstack.Conflict_Tracker_api.model.Faction;
import daw.fullstack.Conflict_Tracker_api.repository.ConflictRepository;
import daw.fullstack.Conflict_Tracker_api.repository.CountryRepository;
import daw.fullstack.Conflict_Tracker_api.repository.FactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/api/v1/factions")
public class FactionController {

    @Autowired
    private FactionRepository factionRepository;

    @Autowired
    private ConflictRepository conflictRepository;

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public List<Faction> getAll() {
        return factionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Faction getById(@PathVariable Long id) {
        return factionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faction not found"));
    }

    @PostMapping
    public Faction create(@RequestBody FactionDTO dto) {

        Faction f = new Faction();
        f.setName(dto.getName());

        Conflict conflict = conflictRepository.findById(dto.getConflictId())
                .orElseThrow(() -> new RuntimeException("Conflict not found"));
        f.setConflict(conflict);

        f.setCountries(new HashSet<>(
                countryRepository.findAllById(dto.getCountryIds())
        ));

        return factionRepository.save(f);
    }

    @PutMapping("/{id}")
    public Faction update(@PathVariable Long id, @RequestBody FactionDTO dto) {

        Faction f = factionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faction not found"));

        f.setName(dto.getName());

        Conflict conflict = conflictRepository.findById(dto.getConflictId())
                .orElseThrow(() -> new RuntimeException("Conflict not found"));
        f.setConflict(conflict);

        f.setCountries(new HashSet<>(
                countryRepository.findAllById(dto.getCountryIds())
        ));

        return factionRepository.save(f);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        factionRepository.deleteById(id);
    }
}


