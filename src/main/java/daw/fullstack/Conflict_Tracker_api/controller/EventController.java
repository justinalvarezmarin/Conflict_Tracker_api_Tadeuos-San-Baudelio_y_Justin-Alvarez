package daw.fullstack.Conflict_Tracker_api.controller;

import daw.fullstack.Conflict_Tracker_api.dto.EventDTO;
import daw.fullstack.Conflict_Tracker_api.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping
    public List<EventDTO> getAll() {
        return service.getAllEvents();
    }

    @PostMapping
    public EventDTO create(@RequestBody EventDTO dto) {
        return service.createEvent(dto);
    }
}
