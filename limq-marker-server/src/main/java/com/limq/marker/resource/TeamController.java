package com.limq.marker.resource;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import com.limq.api.TeamApi;
import com.limq.model.Team;
import com.limq.repositories.TeamRepository;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class TeamController implements TeamApi {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public ResponseEntity<Team> create(Team team) {
        return ResponseEntity.ok(teamRepository.save(team));
    }

    @Override
    public ResponseEntity read(UUID id) {
        Optional<Team> team = teamRepository.findById(id);
        if (team.isPresent()) {
            return ok(team.get());
        }
        return notFound().build();
    }

    @Override
    public ResponseEntity update(UUID id, Team updatedTeam) {
        Optional<Team> currentTeam = teamRepository.findById(id);
        if (currentTeam.isPresent()) {
            return ok(teamRepository.save(updatedTeam));
        }
        return notFound().build();
    }

    @Override
    public ResponseEntity delete(UUID id) {
        Optional<Team> currentTeam = teamRepository.findById(id);
        if (currentTeam.isPresent()) {
            teamRepository.delete(currentTeam.get());
            return noContent().build();
        }
        return notFound().build();
    }

    @Override
    public ResponseEntity<Collection<Team>> list() {
        return ResponseEntity.ok(teamRepository.findAll());
    }
}
