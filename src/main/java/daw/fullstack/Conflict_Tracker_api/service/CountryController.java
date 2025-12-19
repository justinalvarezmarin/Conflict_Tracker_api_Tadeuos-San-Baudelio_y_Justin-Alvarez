package daw.fullstack.Conflict_Tracker_api.service;

import daw.fullstack.Conflict_Tracker_api.dto.CountryDTO;
import daw.fullstack.Conflict_Tracker_api.model.Conflict;
import daw.fullstack.Conflict_Tracker_api.model.Country;
import daw.fullstack.Conflict_Tracker_api.repository.ConflictRepository;
import daw.fullstack.Conflict_Tracker_api.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ConflictRepository conflictRepository;

    @GetMapping
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Country getById(@PathVariable Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));
    }

    @PostMapping
    public Country create(@RequestBody CountryDTO dto) {
        Country c = new Country();
        c.setName(dto.getName());
        c.setCode(dto.getCode());
        return countryRepository.save(c);
    }

    @PutMapping("/{id}")
    public Country update(@PathVariable Long id, @RequestBody CountryDTO dto) {
        Country c = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));

        c.setName(dto.getName());
        c.setCode(dto.getCode());
        return countryRepository.save(c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        countryRepository.deleteById(id);
    }

    // ENDPOINT AVANZADO
    @GetMapping("/{code}/conflicts")
    public List<Conflict> getConflictsByCountry(@PathVariable String code) {
        return conflictRepository.findByCountries_Code(code);
    }
}
