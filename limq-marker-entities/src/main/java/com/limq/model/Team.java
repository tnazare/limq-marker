package com.limq.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "color")
    private TeamColor color;
    @Column(name = "name")
    private String name;
    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", updatable = true)
    private List<Person> members;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
            ", Name='" + name + '\'' +
            ", members=" + members +
            '}';
    }
}
