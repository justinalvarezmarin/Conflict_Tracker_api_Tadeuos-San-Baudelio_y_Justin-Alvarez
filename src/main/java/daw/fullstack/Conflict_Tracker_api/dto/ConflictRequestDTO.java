package daw.fullstack.Conflict_Tracker_api.dto;

import daw.fullstack.Conflict_Tracker_api.model.Status;
import java.time.LocalDate;

public class ConflictRequestDTO {

    private String name;
    private LocalDate startDate;
    private Status status;
    private String description;

    // getters y setters
    public ConflictRequestDTO() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

