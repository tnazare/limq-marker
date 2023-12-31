package com.limq.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@Table(name = "penalty")
public class Penalty {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "improvisation_id", updatable = false)
    private Improvisation improvisation;
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", updatable = false)
    private Team team;
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", updatable = false)
    private Person person;
    @Column(name = "penalty_type")
    private PenaltyType penaltyType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Improvisation getImprovisation() {
        return improvisation;
    }

    public void setImprovisation(Improvisation improvisation) {
        this.improvisation = improvisation;
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

    public PenaltyType getPenaltyType() {
        return penaltyType;
    }

    public void setPenaltyType(PenaltyType penaltyType) {
        this.penaltyType = penaltyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Penalty penalty = (Penalty) o;
        return Objects.equals(id, penalty.id) && Objects.equals(improvisation, penalty.improvisation) && Objects.equals(team, penalty.team) && Objects.equals(person, penalty.person) && penaltyType == penalty.penaltyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, improvisation, team, person, penaltyType);
    }

    @Override
    public String toString() {
        return "Penalty{" +
            "id='" + id + '\'' +
            ", improvisation=" + improvisation +
            ", team=" + team +
            ", person=" + person +
            ", penaltyType=" + penaltyType +
            '}';
    }
}
