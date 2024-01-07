package com.limq.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "improvisation_team")
public class ImprovisationTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinTable(
        name = "ImprovisationTeam_ImprovisationPlayer",
        joinColumns = {@JoinColumn(name = "improvisation_team_id")},
        inverseJoinColumns = {@JoinColumn(name = "person_id")})
    private List<Person> improvisationPlayers;
    @Column(name = "is_winning_team")
    private boolean isWinningTeam;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Person> getImprovisationPlayers() {
        return improvisationPlayers;
    }

    public void setImprovisationPlayers(List<Person> improvisationPlayers) {
        this.improvisationPlayers = improvisationPlayers;
    }

    public boolean isWinningTeam() {
        return isWinningTeam;
    }

    public void setWinningTeam(boolean winningTeam) {
        this.isWinningTeam = winningTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImprovisationTeam that = (ImprovisationTeam) o;
        return isWinningTeam == that.isWinningTeam && Objects.equals(id, that.id) && Objects.equals(improvisationPlayers, that.improvisationPlayers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, improvisationPlayers, isWinningTeam);
    }

    @Override
    public String toString() {
        return "ImprovisationTeam{" +
            "id='" + id + '\'' +
            ", improvisationPlayers=" + improvisationPlayers +
            ", isWinningTeam=" + isWinningTeam +
            '}';
    }
}
