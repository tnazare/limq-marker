package com.limq.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "improvisation_player")
public class ImprovisationPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", updatable = false, insertable = false)
    private ImprovisationTeam team;
    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", updatable = false)
    private Person person;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ImprovisationTeam getTeam() {
        return team;
    }

    public void setTeam(ImprovisationTeam team) {
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImprovisationPlayer that = (ImprovisationPlayer) o;
        return Objects.equals(id, that.id) && Objects.equals(team, that.team) && Objects.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, team, person);
    }

    @Override
    public String toString() {
        return "ImprovisationPlayer{" +
            "id='" + id + '\'' +
            ", team=" + team +
            ", person=" + person +
            '}';
    }
}
