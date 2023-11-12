package com.limq.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "season")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "improvisation_id", updatable = false)
    private List<Team> teams;
    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "improvisation_id", updatable = false)
    private List<Match> matches;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Season season = (Season) o;
        return Objects.equals(id, season.id) && Objects.equals(startDate, season.startDate) && Objects.equals(teams, season.teams) && Objects.equals(matches, season.matches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, teams, matches);
    }

    @Override
    public String toString() {
        return "Season{" +
            "id='" + id + '\'' +
            ", startDate=" + startDate +
            ", teams=" + teams +
            ", matches=" + matches +
            '}';
    }
}
