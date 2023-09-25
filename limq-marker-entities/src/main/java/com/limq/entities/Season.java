package com.limq.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Season {
    private String id;
    private LocalDateTime startDate;
    private List<Match> matchList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public List<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Season season = (Season) o;
        return Objects.equals(id, season.id) && Objects.equals(startDate, season.startDate) && Objects.equals(matchList, season.matchList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, matchList);
    }

    @Override
    public String toString() {
        return "Season{" +
                "id='" + id + '\'' +
                ", startDate=" + startDate +
                ", matchList=" + matchList +
                '}';
    }
}