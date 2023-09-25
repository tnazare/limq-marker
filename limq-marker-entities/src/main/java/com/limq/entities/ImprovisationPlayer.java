package com.limq.entities;

import java.util.Objects;

public class ImprovisationPlayer {
    private String id;
    private String improvisationId;
    private String teamId;
    private Person person;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImprovisationId() {
        return improvisationId;
    }

    public void setImprovisationId(String improvisationId) {
        this.improvisationId = improvisationId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
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
        return Objects.equals(improvisationId, that.improvisationId) && Objects.equals(teamId, that.teamId) && Objects.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(improvisationId, teamId, person);
    }

    @Override
    public String toString() {
        return "ImprovisationPlayer{" +
                "improvisationId='" + improvisationId + '\'' +
                ", teamId='" + teamId + '\'' +
                ", person=" + person +
                '}';
    }
}
