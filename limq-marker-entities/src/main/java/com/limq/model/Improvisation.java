package com.limq.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "improvisation")
public class Improvisation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "period")
    private int period;
    @Column(name = "improvisation_number")
    private int improvisationNumber;
    @Column(name = "improvisation_type")
    private ImprovisationType improvisationType;
    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "improvisation_team_left_id", updatable = false)
    private ImprovisationTeam improvisationTeamLeft;
    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "improvisation_team_right_id", updatable = false)
    private ImprovisationTeam improvisationTeamRight;
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "improvisation_id", updatable = false)
    private List<Penalty> penaltyList;
    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "winning_team_id", updatable = false)
    private ImprovisationTeam winningTeam;
    @Column(name = "isExAequo")
    private boolean isExAequo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public ImprovisationTeam getImprovisationTeamLeft() {
        return improvisationTeamLeft;
    }

    public void setImprovisationTeamLeft(ImprovisationTeam improvisationTeamLeft) {
        this.improvisationTeamLeft = improvisationTeamLeft;
    }

    public ImprovisationTeam getImprovisationTeamRight() {
        return improvisationTeamRight;
    }

    public void setImprovisationTeamRight(ImprovisationTeam improvisationTeamRight) {
        this.improvisationTeamRight = improvisationTeamRight;
    }

    public List<Penalty> getPenaltyList() {
        return penaltyList;
    }

    public void setPenaltyList(List<Penalty> penaltyList) {
        this.penaltyList = penaltyList;
    }

    public ImprovisationTeam getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(ImprovisationTeam winningTeam) {
        this.winningTeam = winningTeam;
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
        return period == that.period && improvisationNumber == that.improvisationNumber && isExAequo == that.isExAequo && Objects.equals(id, that.id) && improvisationType == that.improvisationType && Objects.equals(improvisationTeamLeft, that.improvisationTeamLeft) && Objects.equals(improvisationTeamRight, that.improvisationTeamRight) && Objects.equals(penaltyList, that.penaltyList) && Objects.equals(winningTeam, that.winningTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, period, improvisationNumber, improvisationType, improvisationTeamLeft, improvisationTeamRight, penaltyList, winningTeam, isExAequo);
    }

    @Override
    public String toString() {
        return "Improvisation{" + "id='" + id + '\'' + ", period=" + period + ", improvisationNumber=" + improvisationNumber + ", improvisationType=" + improvisationType + ", improvisationTeamLeft=" + improvisationTeamLeft + ", improvisationTeamRight=" + improvisationTeamRight + ", penaltyList=" + penaltyList + ", winningTeam=" + winningTeam + ", isExAequo=" + isExAequo + '}';
    }
}
