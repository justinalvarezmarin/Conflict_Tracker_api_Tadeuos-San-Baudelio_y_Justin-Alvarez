package daw.fullstack.Conflict_Tracker_api.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Conflict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate startDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(length = 2000)
    private String description;

    @ManyToMany
    private List<Country> countries = new ArrayList<>();

    @OneToMany(mappedBy = "conflict", cascade = CascadeType.ALL)
    private List<Faction> factions = new ArrayList<>();

    @OneToMany(mappedBy = "conflict", cascade = CascadeType.ALL)
    private List<Event> events = new ArrayList<>();

    // getters/setters
}


