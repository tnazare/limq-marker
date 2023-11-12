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

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "improvisation_id", updatable = false)
    private List<ImprovisationPlayer> players;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ImprovisationPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<ImprovisationPlayer> players) {
        this.players = players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImprovisationTeam that = (ImprovisationTeam) o;
        return Objects.equals(id, that.id) && Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, players);
    }

    @Override
    public String toString() {
        return "ImprovisationTeam{" +
            "id='" + id + '\'' +
            ", players=" + players +
            '}';
    }
}
