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
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "improvisation")
public class Improvisation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "period")
    private int period;
    @Column(name = "improvisation_number")
    private int improvisationNumber;
    @Column(name = "improvisation_type")
    private ImprovisationType improvisationType;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImprovisationTeam> improvisationTeams;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Penalty> penaltyList;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public List<ImprovisationTeam> getImprovisationTeams() {
        return improvisationTeams;
    }

    public void setImprovisationTeams(List<ImprovisationTeam> improvisationTeams) {
        this.improvisationTeams = improvisationTeams;
    }

    public List<Penalty> getPenaltyList() {
        return penaltyList;
    }

    public void setPenaltyList(List<Penalty> penaltyList) {
        this.penaltyList = penaltyList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Improvisation that = (Improvisation) o;
        return period == that.period && improvisationNumber == that.improvisationNumber && Objects.equals(id, that.id) && improvisationType == that.improvisationType && Objects.equals(improvisationTeams, that.improvisationTeams) && Objects.equals(penaltyList, that.penaltyList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, period, improvisationNumber, improvisationType, improvisationTeams, penaltyList);
    }

    @Override
    public String toString() {
        return "Improvisation{" + "id='" + id + '\'' + ", period=" + period + ", improvisationNumber=" + improvisationNumber + ", improvisationType=" + improvisationType + ", improvisationTeams=" + improvisationTeams + ", penaltyList=" + penaltyList  + '}';
    }
}
