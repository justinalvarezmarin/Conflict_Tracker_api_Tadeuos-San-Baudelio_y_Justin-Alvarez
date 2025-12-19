package daw.fullstack.Conflict_Tracker_api.controller;

import daw.fullstack.Conflict_Tracker_api.dto.EventDTO;
import daw.fullstack.Conflict_Tracker_api.model.Event;
import daw.fullstack.Conflict_Tracker_api.model.Conflict;
import daw.fullstack.Conflict_Tracker_api.repository.EventRepository;
import daw.fullstack.Conflict_Tracker_api.repository.ConflictRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    private final EventRepository eventRepository;
    private final ConflictRepository conflictRepository;

    public EventController(EventRepository eventRepository,
                           ConflictRepository conflictRepository) {
        this.eventRepository = eventRepository;
        this.conflictRepository = conflictRepository;
    }

    // GET /api/v1/events
    @GetMapping
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    // GET /api/v1/events/{id}
    @GetMapping("/{id}")
    public Event getById(@PathVariable Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    // POST /api/v1/events
    @PostMapping
    public Event create(@RequestBody EventDTO dto) {

        Conflict conflict = conflictRepository.findById(dto.conflictId)
                .orElseThrow(() -> new RuntimeException("Conflict not found"));

        Event event = new Event();
        event.setEventDate(dto.eventDate);
        event.setLocation(dto.location);
        event.setDescription(dto.description);
        event.setConflict(conflict);

        return eventRepository.save(event);
    }

    // PUT /api/v1/events/{id}
    @PutMapping("/{id}")
    public Event update(@PathVariable Long id, @RequestBody EventDTO dto) {

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        event.setEventDate(dto.eventDate);
        event.setLocation(dto.location);
        event.setDescription(dto.description);

        if (dto.conflictId != null) {
            Conflict conflict = conflictRepository.findById(dto.conflictId)
                    .orElseThrow(() -> new RuntimeException("Conflict not found"));
            event.setConflict(conflict);
        }

        return eventRepository.save(event);
    }

    // DELETE /api/v1/events/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        eventRepository.deleteById(id);
    }
}
