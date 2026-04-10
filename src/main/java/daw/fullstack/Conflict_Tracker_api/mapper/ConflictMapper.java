package daw.fullstack.Conflict_Tracker_api.mapper;

import daw.fullstack.Conflict_Tracker_api.dto.ConflictResponseDTO;
import daw.fullstack.Conflict_Tracker_api.model.Conflict;
import org.springframework.stereotype.Component;

@Component
public class ConflictMapper {

    public ConflictResponseDTO toResponseDTO(Conflict conflict) {
        if (conflict == null) return null;

        ConflictResponseDTO dto = new ConflictResponseDTO();
        dto.setId(conflict.getId());
        dto.setName(conflict.getName());
        dto.setDescription(conflict.getDescription());
        dto.setStatus(conflict.getStatus());
        dto.setStartDate(conflict.getStartDate());
        dto.setCountryCode(conflict.getCountryCode());
        return dto;
    }
}