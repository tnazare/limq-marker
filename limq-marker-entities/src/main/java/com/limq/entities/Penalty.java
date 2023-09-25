package com.limq.entities;

import java.util.Objects;

public class Penalty {
    private String id;
    private String improvisationId;
    private String teamId;

    private String personId;
    private PenaltyType penaltyType;

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

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public PenaltyType getPenaltyType() {
        return penaltyType;
    }

    public void setPenaltyType(PenaltyType penaltyType) {
        this.penaltyType = penaltyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Penalty penalty = (Penalty) o;
        return Objects.equals(improvisationId, penalty.improvisationId) && Objects.equals(teamId, penalty.teamId) && Objects.equals(personId, penalty.personId) && penaltyType == penalty.penaltyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(improvisationId, teamId, personId, penaltyType);
    }

    @Override
    public String toString() {
        return "Penalty{" +
                "improvisationId='" + improvisationId + '\'' +
                ", teamId='" + teamId + '\'' +
                ", personId='" + personId + '\'' +
                ", penaltyType=" + penaltyType +
                '}';
    }
}
