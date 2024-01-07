package com.limq.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "color")
    private TeamColor color;
    @Column(name = "name")
    private String name;
    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinTable(
        name = "Team_Member",
        joinColumns = {@JoinColumn(name = "team_id")},
        inverseJoinColumns = {@JoinColumn(name = "person_id")})
    private List<Person> members;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TeamColor getColor() {
        return color;
    }

    public void setColor(TeamColor color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Team team = (Team) o;
        return Objects.equals(id, team.id) && color == team.color && Objects.equals(name, team.name) && Objects.equals(members, team.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color, name, members);
    }

    @Override
    public String toString() {
        return "Team{" +
            "id='" + id + '\'' +
            ", color=" + color +
            ", name='" + name + '\'' +
            ", members=" + members +
            '}';
    }
}
