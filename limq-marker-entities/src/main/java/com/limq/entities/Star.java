package com.limq.entities;

import java.util.Objects;

public class Star {
    private String matchId;
    private String personId;
    private StarRank starRank;

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public StarRank getStarRank() {
        return starRank;
    }

    public void setStarRank(StarRank starRank) {
        this.starRank = starRank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Star star = (Star) o;
        return Objects.equals(matchId, star.matchId) && Objects.equals(personId, star.personId) && starRank == star.starRank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchId, personId, starRank);
    }

    @Override
    public String toString() {
        return "Star{" +
                "matchId='" + matchId + '\'' +
                ", personId='" + personId + '\'' +
                ", starRank=" + starRank +
                '}';
    }
}
