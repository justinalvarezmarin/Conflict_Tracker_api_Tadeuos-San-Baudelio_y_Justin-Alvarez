package daw.fullstack.Conflict_Tracker_api.mapper;

import daw.fullstack.Conflict_Tracker_api.dto.EventDTO;
import daw.fullstack.Conflict_Tracker_api.model.Conflict;
import daw.fullstack.Conflict_Tracker_api.model.Event;

public class EventMapper {

    public static Event toEntity(EventDTO dto, Conflict conflict) {
        Event event = new Event();
        event.setEventDate(dto.getEventDate());
        event.setLocation(dto.getLocation());
        event.setDescription(dto.getDescription());
        event.setConflict(conflict);
        return event;
    }

    public static EventDTO toDTO(Event event) {
        EventDTO dto = new EventDTO();
        dto.setEventDate(event.getEventDate());
        dto.setLocation(event.getLocation());
        dto.setDescription(event.getDescription());
        dto.setConflictId(event.getConflict().getId());
        return dto;
    }
}
