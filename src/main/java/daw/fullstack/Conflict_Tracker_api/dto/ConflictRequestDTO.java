package daw.fullstack.Conflict_Tracker_api.dto;

import daw.fullstack.Conflict_Tracker_api.model.Status;
import java.time.LocalDate;

public class ConflictRequestDTO {

    private String name;
    private LocalDate startDate;
    private Status status;
    private String description;

    // getters y setters
}
