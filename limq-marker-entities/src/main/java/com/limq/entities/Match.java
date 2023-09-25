package com.limq.entities;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Match {
    private String id;
    private LocalDateTime date;
    private List<Person> hosts;
    private List<String> judges;
    private Person referee;
    private Person statistician;
    private List<Improvisation> improvisations;

    private List<MatchPlayer> matchPlayers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Person> getHosts() {
        return hosts;
    }

    public void setHosts(List<Person> hosts) {
        this.hosts = hosts;
    }

    public List<String> getJudges() {
        return judges;
    }

    public void setJudges(List<String> judges) {
        this.judges = judges;
    }

    public Person getReferee() {
        return referee;
    }

    public void setReferee(Person referee) {
        this.referee = referee;
    }

    public Person getStatistician() {
        return statistician;
    }

    public void setStatistician(Person statistician) {
        this.statistician = statistician;
    }

    public List<Improvisation> getImprovisations() {
        return improvisations;
    }

    public void setImprovisations(List<Improvisation> improvisations) {
        this.improvisations = improvisations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(id, match.id) && Objects.equals(date, match.date) && Objects.equals(hosts, match.hosts) && Objects.equals(judges, match.judges) && Objects.equals(referee, match.referee) && Objects.equals(statistician, match.statistician) && Objects.equals(improvisations, match.improvisations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, hosts, judges, referee, statistician, improvisations);
    }

    @Override
    public String toString() {
        return "Match{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", hosts=" + hosts +
                ", judges=" + judges +
                ", referee=" + referee +
                ", statistician=" + statistician +
                ", improvisations=" + improvisations +
                '}';
    }
}
