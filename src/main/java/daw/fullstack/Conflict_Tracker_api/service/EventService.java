package daw.fullstack.Conflict_Tracker_api.service;

import daw.fullstack.Conflict_Tracker_api.dto.EventDTO;
import daw.fullstack.Conflict_Tracker_api.mapper.EventMapper;
import daw.fullstack.Conflict_Tracker_api.model.Conflict;
import daw.fullstack.Conflict_Tracker_api.model.Event;
import daw.fullstack.Conflict_Tracker_api.repository.ConflictRepository;
import daw.fullstack.Conflict_Tracker_api.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final ConflictRepository conflictRepository;

    public EventService(EventRepository eventRepository, ConflictRepository conflictRepository) {
        this.eventRepository = eventRepository;
        this.conflictRepository = conflictRepository;
    }

    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll()
                .stream()
                .map(EventMapper::toDTO)
                .toList();
    }

    public EventDTO createEvent(EventDTO dto) {
        Conflict conflict = conflictRepository.findById(dto.getConflictId())
                .orElseThrow(() -> new RuntimeException("Conflict not found"));

        Event event = EventMapper.toEntity(dto, conflict);
        return EventMapper.toDTO(eventRepository.save(event));
    }
}
