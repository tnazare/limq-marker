package com.limq.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "date")
    private LocalDateTime date;

    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinTable(
        name = "Match_Host",
        joinColumns = {@JoinColumn(name = "improvisation_id")},
        inverseJoinColumns = {@JoinColumn(name = "person_id")})
    private List<Person> hosts;
    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinTable(
        name = "Match_Judge",
        joinColumns = {@JoinColumn(name = "improvisation_team_id")},
        inverseJoinColumns = {@JoinColumn(name = "person_id")})    private List<Person> judges;
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "referee_id", updatable = false)
    private Person referee;
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "statistician_id", updatable = false)
    private Person statistician;
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "improvisation_id", updatable = false)
    private List<Improvisation> improvisations;
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "improvisation_id", updatable = false)
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

    public List<Person> getJudges() {
        return judges;
    }

    public void setJudges(List<Person> judges) {
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

    public List<MatchPlayer> getMatchPlayers() {
        return matchPlayers;
    }

    public void setMatchPlayers(List<MatchPlayer> matchPlayers) {
        this.matchPlayers = matchPlayers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Match match = (Match) o;
        return Objects.equals(id, match.id) && Objects.equals(date, match.date) && Objects.equals(hosts, match.hosts) && Objects.equals(judges, match.judges) && Objects.equals(referee, match.referee) && Objects.equals(statistician, match.statistician) && Objects.equals(improvisations, match.improvisations) && Objects.equals(matchPlayers, match.matchPlayers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, hosts, judges, referee, statistician, improvisations, matchPlayers);
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
            ", matchPlayers=" + matchPlayers +
            '}';
    }
}
