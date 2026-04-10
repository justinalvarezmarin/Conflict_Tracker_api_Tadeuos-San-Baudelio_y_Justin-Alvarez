package daw.fullstack.Conflict_Tracker_api.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Conflict {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 1000)
    private String description;

    private String status; // Cambiado a String para evitar errores de Enum con Vue
    private LocalDate startDate;
    private String countryCode; // Para el Bonus de banderas

    public Conflict() {}

    public Conflict(String name, String description, String status, LocalDate startDate, String countryCode) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.countryCode = countryCode;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }
}