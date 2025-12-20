package daw.fullstack.Conflict_Tracker_api.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;

    @ManyToMany(mappedBy = "countries")
    @JsonIgnore
    private Set<Conflict> conflicts = new HashSet<>();

    @ManyToMany(mappedBy = "countries")
    @JsonIgnore
    private Set<Faction> factions = new HashSet<>();

    // Getters y setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<Conflict> getConflicts() {
        return conflicts;
    }

    public void setConflicts(Set<Conflict> conflicts) {
        this.conflicts = conflicts;
    }

    public Set<Faction> getFactions() {
        return factions;
    }

    public void setFactions(Set<Faction> factions) {
        this.factions = factions;
    }

}
