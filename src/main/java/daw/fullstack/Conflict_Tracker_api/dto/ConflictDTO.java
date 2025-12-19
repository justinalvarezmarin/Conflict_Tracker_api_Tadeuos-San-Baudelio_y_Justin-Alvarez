package daw.fullstack.Conflict_Tracker_api.dto;

import java.time.LocalDate;
import daw.fullstack.Conflict_Tracker_api.model.Conflict;

public class ConflictDTO {

    private String name;
    private LocalDate startDate;
    private Conflict.Status status;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Conflict.Status getStatus() {
        return status;
    }

    public void setStatus(Conflict.Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
