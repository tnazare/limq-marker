package com.limq.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "improvisation_team")
public class ImprovisationTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinTable(
        name = "ImprovisationTeam_ImprovisationPlayer",
        joinColumns = {@JoinColumn(name = "improvisation_team_id")},
        inverseJoinColumns = {@JoinColumn(name = "person_id")})
    private List<Person> improvisationPlayers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Person> getImprovisationPlayers() {
        return improvisationPlayers;
    }

    public void setImprovisationPlayers(List<Person> improvisationPlayers) {
        this.improvisationPlayers = improvisationPlayers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImprovisationTeam that = (ImprovisationTeam) o;
        return Objects.equals(id, that.id) && Objects.equals(improvisationPlayers, that.improvisationPlayers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, improvisationPlayers);
    }

    @Override
    public String toString() {
        return "ImprovisationTeam{" +
            "id='" + id + '\'' +
            ", improvisationPlayers=" + improvisationPlayers +
            '}';
    }
}
