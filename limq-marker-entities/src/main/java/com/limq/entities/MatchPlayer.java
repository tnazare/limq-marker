package com.limq.entities;

import java.util.Objects;

public class MatchPlayer {
    private String id;
    private String matchId;
    private String teamId;
    private Person person;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
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
        MatchPlayer that = (MatchPlayer) o;
        return Objects.equals(id, that.id) && Objects.equals(matchId, that.matchId) && Objects.equals(teamId, that.teamId) && Objects.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, matchId, teamId, person);
    }

    @Override
    public String toString() {
        return "MatchPlayer{" +
                "id='" + id + '\'' +
                ", matchId='" + matchId + '\'' +
                ", teamId='" + teamId + '\'' +
                ", person=" + person +
                '}';
    }
}
