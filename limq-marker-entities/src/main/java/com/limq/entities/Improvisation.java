package com.limq.entities;

import java.util.List;
import java.util.Objects;

public class Improvisation {
    private String id;

    private String matchId;
    private int period;
    private int improvisationNumber;
    private ImprovisationType improvisationType;
    private List<ImprovisationPlayer> improvisationPlayers;
    private List<Penalty> penaltyList;
    private String winningTeamId;
    private boolean isExAequo;

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

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getImprovisationNumber() {
        return improvisationNumber;
    }

    public void setImprovisationNumber(int improvisationNumber) {
        this.improvisationNumber = improvisationNumber;
    }

    public ImprovisationType getImprovisationType() {
        return improvisationType;
    }

    public void setImprovisationType(ImprovisationType improvisationType) {
        this.improvisationType = improvisationType;
    }

    public List<ImprovisationPlayer> getImprovisationPlayers() {
        return improvisationPlayers;
    }

    public void setImprovisationPlayers(List<ImprovisationPlayer> improvisationPlayers) {
        this.improvisationPlayers = improvisationPlayers;
    }

    public List<Penalty> getPenaltyList() {
        return penaltyList;
    }

    public void setPenaltyList(List<Penalty> penaltyList) {
        this.penaltyList = penaltyList;
    }

    public String getWinningTeamId() {
        return winningTeamId;
    }

    public void setWinningTeamId(String winningTeamId) {
        this.winningTeamId = winningTeamId;
    }

    public boolean isExAequo() {
        return isExAequo;
    }

    public void setExAequo(boolean exAequo) {
        isExAequo = exAequo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Improvisation that = (Improvisation) o;
        return period == that.period && improvisationNumber == that.improvisationNumber && isExAequo == that.isExAequo && Objects.equals(id, that.id) && Objects.equals(matchId, that.matchId) && improvisationType == that.improvisationType && Objects.equals(improvisationPlayers, that.improvisationPlayers) && Objects.equals(penaltyList, that.penaltyList) && Objects.equals(winningTeamId, that.winningTeamId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, matchId, period, improvisationNumber, improvisationType, improvisationPlayers, penaltyList, winningTeamId, isExAequo);
    }

    @Override
    public String toString() {
        return "Improvisation{" +
                "id='" + id + '\'' +
                ", matchId='" + matchId + '\'' +
                ", period=" + period +
                ", improvisationNumber=" + improvisationNumber +
                ", improvisationType=" + improvisationType +
                ", improvisationPlayers=" + improvisationPlayers +
                ", penaltyList=" + penaltyList +
                ", winningTeamId='" + winningTeamId + '\'' +
                ", isExAequo=" + isExAequo +
                '}';
    }
}
