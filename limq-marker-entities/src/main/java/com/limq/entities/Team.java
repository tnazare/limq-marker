package com.limq.entities;

import java.util.List;
import java.util.Objects;

public class Team {

    private String seasonId;
    private TeamColor teamColor;
    private String teamName;
    private List<Person> members;

    public String getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(String seasonId) {
        this.seasonId = seasonId;
    }

    public TeamColor getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(TeamColor teamColor) {
        this.teamColor = teamColor;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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
        return Objects.equals(seasonId, team.seasonId) && teamColor == team.teamColor && Objects.equals(teamName, team.teamName) && Objects.equals(members, team.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seasonId, teamColor, teamName, members);
    }

    @Override
    public String toString() {
        return "Team{" +
                "seasonId='" + seasonId + '\'' +
                ", teamColor=" + teamColor +
                ", teamName='" + teamName + '\'' +
                ", members=" + members +
                '}';
    }
}
