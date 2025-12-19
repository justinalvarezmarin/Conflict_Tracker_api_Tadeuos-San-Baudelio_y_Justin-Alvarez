package daw.fullstack.Conflict_Tracker_api.controller;

import daw.fullstack.Conflict_Tracker_api.dto.FactionDTO;
import daw.fullstack.Conflict_Tracker_api.model.Faction;
import daw.fullstack.Conflict_Tracker_api.model.Conflict;
import daw.fullstack.Conflict_Tracker_api.model.Country;
import daw.fullstack.Conflict_Tracker_api.repository.FactionRepository;
import daw.fullstack.Conflict_Tracker_api.repository.ConflictRepository;
import daw.fullstack.Conflict_Tracker_api.repository.CountryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/factions")
public class FactionController {

    private final FactionRepository factionRepository;
    private final ConflictRepository conflictRepository;
    private final CountryRepository countryRepository;

    public FactionController(
            FactionRepository factionRepository,
            ConflictRepository conflictRepository,
            CountryRepository countryRepository) {

        this.factionRepository = factionRepository;
        this.conflictRepository = conflictRepository;
        this.countryRepository = countryRepository;
    }

    // GET /api/v1/factions
    @GetMapping
    public List<Faction> getAll() {
        return factionRepository.findAll();
    }

    // GET /api/v1/factions/{id}
    @GetMapping("/{id}")
    public Faction getById(@PathVariable Long id) {
        return factionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faction not found"));
    }

    // POST /api/v1/factions
    @PostMapping
    public Faction create(@RequestBody FactionDTO dto) {

        Conflict conflict = conflictRepository.findById(dto.conflictId)
                .orElseThrow(() -> new RuntimeException("Conflict not found"));

        Set<Country> countries = new HashSet<>();
        if (dto.countryIds != null) {
            countries.addAll(countryRepository.findAllById(dto.countryIds));
        }

        Faction faction = new Faction();
        faction.setName(dto.name);
        faction.setConflict(conflict);
        faction.setCountries(countries);

        return factionRepository.save(faction);
    }

    // PUT /api/v1/factions/{id}
    @PutMapping("/{id}")
    public Faction update(@PathVariable Long id, @RequestBody FactionDTO dto) {

        Faction faction = factionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faction not found"));

        faction.setName(dto.name);

        if (dto.conflictId != null) {
            Conflict conflict = conflictRepository.findById(dto.conflictId)
                    .orElseThrow(() -> new RuntimeException("Conflict not found"));
            faction.setConflict(conflict);
        }

        if (dto.countryIds != null) {
            Set<Country> countries = new HashSet<>(
                    countryRepository.findAllById(dto.countryIds)
            );
            faction.setCountries(countries);
        }

        return factionRepository.save(faction);
    }

    // DELETE /api/v1/factions/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        factionRepository.deleteById(id);
    }
}
