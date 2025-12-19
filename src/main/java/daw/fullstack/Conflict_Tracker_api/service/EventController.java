package daw.fullstack.Conflict_Tracker_api.service;

import daw.fullstack.Conflict_Tracker_api.dto.EventDTO;
import daw.fullstack.Conflict_Tracker_api.model.Conflict;
import daw.fullstack.Conflict_Tracker_api.model.Event;
import daw.fullstack.Conflict_Tracker_api.repository.ConflictRepository;
import daw.fullstack.Conflict_Tracker_api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ConflictRepository conflictRepository;

    @GetMapping
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    @GetMapping("/{id}")
    public Event getById(@PathVariable Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @PostMapping
    public Event create(@RequestBody EventDTO dto) {

        Event e = new Event();
        e.setEventDate(dto.getEventDate());
        e.setLocation(dto.getLocation());
        e.setDescription(dto.getDescription());

        Conflict conflict = conflictRepository.findById(dto.getConflictId())
                .orElseThrow(() -> new RuntimeException("Conflict not found"));
        e.setConflict(conflict);

        return eventRepository.save(e);
    }

    @PutMapping("/{id}")
    public Event update(@PathVariable Long id, @RequestBody EventDTO dto) {

        Event e = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        e.setEventDate(dto.getEventDate());
        e.setLocation(dto.getLocation());
        e.setDescription(dto.getDescription());

        Conflict conflict = conflictRepository.findById(dto.getConflictId())
                .orElseThrow(() -> new RuntimeException("Conflict not found"));
        e.setConflict(conflict);

        return eventRepository.save(e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        eventRepository.deleteById(id);
    }
}

