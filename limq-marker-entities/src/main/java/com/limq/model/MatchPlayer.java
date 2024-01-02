package com.limq.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "match_player")
public class MatchPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id", updatable = false)
    private Match match;
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", updatable = false)
    private Team team;
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", updatable = false)
    private Person person;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MatchPlayer that = (MatchPlayer) o;
        return Objects.equals(id, that.id) && Objects.equals(match, that.match) && Objects.equals(team, that.team) && Objects.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, match, team, person);
    }

    @Override
    public String toString() {
        return "MatchPlayer{" +
            "id='" + id + '\'' +
            ", match=" + match +
            ", team=" + team +
            ", person=" + person +
            '}';
    }
}
