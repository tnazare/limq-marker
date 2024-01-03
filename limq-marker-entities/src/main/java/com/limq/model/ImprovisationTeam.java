package com.limq.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "improvisation_team")
public class ImprovisationTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "improvisation_team_id", updatable = false)
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
