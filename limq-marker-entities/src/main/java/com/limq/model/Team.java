package com.limq.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id", updatable = false)
    private Season season;
    @Column(name = "color")
    private TeamColor color;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", updatable = true)
    private List<Person> members;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) && Objects.equals(season, team.season) && color == team.color && Objects.equals(name, team.name) && Objects.equals(members, team.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, season, color, name, members);
    }

    @Override
    public String toString() {
        return "Team{" +
            "id='" + id + '\'' +
            ", season=" + season +
            ", color=" + color +
            ", Name='" + name + '\'' +
            ", members=" + members +
            '}';
    }
}
