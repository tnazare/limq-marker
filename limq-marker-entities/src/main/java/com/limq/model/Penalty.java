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
import java.util.UUID;

@Entity
@Table(name = "penalty")
public class Penalty {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", updatable = false)
    private Team team;
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", updatable = false)
    private Person person;
    @Column(name = "penalty_type")
    private PenaltyType penaltyType;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
        return Objects.equals(id, penalty.id) && Objects.equals(team, penalty.team) && Objects.equals(person, penalty.person) && penaltyType == penalty.penaltyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, team, person, penaltyType);
    }

    @Override
    public String toString() {
        return "Penalty{" +
            "id='" + id + '\'' +
            ", team=" + team +
            ", person=" + person +
            ", penaltyType=" + penaltyType +
            '}';
    }
}
