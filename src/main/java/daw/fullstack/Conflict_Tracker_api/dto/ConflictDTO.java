package daw.fullstack.Conflict_Tracker_api.dto;

import java.time.LocalDate;
import daw.fullstack.Conflict_Tracker_api.model.Conflict;

public class ConflictDTO {

    public String name;
    public LocalDate startDate;
    public Conflict.Status status;
    public String description;


}
