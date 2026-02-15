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

    public Country() {}

    // GETTERS
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCode() { return code; }

    // SETTERS
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCode(String code) { this.code = code; }
}

