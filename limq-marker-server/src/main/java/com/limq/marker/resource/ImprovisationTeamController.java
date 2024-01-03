package com.limq.marker.resource;

import com.limq.api.ImprovisationTeamApi;
import com.limq.model.Improvisation;
import com.limq.model.ImprovisationTeam;
import com.limq.repositories.ImprovisationRepository;
import com.limq.repositories.ImprovisationTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.*;

@Component
public class ImprovisationTeamController implements ImprovisationTeamApi {

    private final ImprovisationTeamRepository improvisationTeamRepository;

    @Autowired
    public ImprovisationTeamController(ImprovisationTeamRepository improvisationTeamRepository) {
        this.improvisationTeamRepository = improvisationTeamRepository;
    }

    @Override
    public ResponseEntity<ImprovisationTeam> create(ImprovisationTeam improvisationTeam) {
        return ok(improvisationTeamRepository.save(improvisationTeam));
    }

    @Override
    public ResponseEntity read(UUID id) {
        Optional<ImprovisationTeam> improvisationTeam = improvisationTeamRepository.findById(id);
        if (improvisationTeam.isPresent()) {
            return ok(improvisationTeam.get());
        }
        return notFound().build();
    }

    @Override
    public ResponseEntity update(UUID id, ImprovisationTeam updatedImprovisationTeam) {
        Optional<ImprovisationTeam> currentImprovisationTeam = improvisationTeamRepository.findById(id);
        if (currentImprovisationTeam.isPresent()) {
            return ok(improvisationTeamRepository.save(updatedImprovisationTeam));
        }
        return notFound().build();
    }

    @Override
    public ResponseEntity delete(UUID id) {
        Optional<ImprovisationTeam> currentImprovisationTeam = improvisationTeamRepository.findById(id);
        if (currentImprovisationTeam.isPresent()) {
            improvisationTeamRepository.delete(currentImprovisationTeam.get());
            return noContent().build();
        }
        return notFound().build();
    }

    @Override
    public ResponseEntity<Collection<ImprovisationTeam>> list() {
        return ResponseEntity.ok(improvisationTeamRepository.findAll());
    }
}
