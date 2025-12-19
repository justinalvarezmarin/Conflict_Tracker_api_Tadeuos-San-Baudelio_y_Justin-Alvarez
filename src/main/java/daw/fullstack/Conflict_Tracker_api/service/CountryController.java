package daw.fullstack.Conflict_Tracker_api.controller;

import daw.fullstack.Conflict_Tracker_api.dto.CountryDTO;
import daw.fullstack.Conflict_Tracker_api.model.Country;
import daw.fullstack.Conflict_Tracker_api.repository.CountryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    // GET /api/v1/countries
    @GetMapping
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    // GET /api/v1/countries/{id}
    @GetMapping("/{id}")
    public Country getById(@PathVariable Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));
    }

    // POST /api/v1/countries
    @PostMapping
    public Country create(@RequestBody CountryDTO dto) {
        Country country = new Country();
        country.setName(dto.name);
        country.setCode(dto.code);
        return countryRepository.save(country);
    }

    // PUT /api/v1/countries/{id}
    @PutMapping("/{id}")
    public Country update(@PathVariable Long id, @RequestBody CountryDTO dto) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));

        country.setName(dto.name);
        country.setCode(dto.code);

        return countryRepository.save(country);
    }

    // DELETE /api/v1/countries/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        countryRepository.deleteById(id);
    }
}
