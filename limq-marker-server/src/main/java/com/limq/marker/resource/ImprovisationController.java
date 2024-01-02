package com.limq.marker.resource;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import com.limq.api.ImprovisationApi;
import com.limq.model.Improvisation;
import com.limq.repositories.ImprovisationRepository;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ImprovisationController implements ImprovisationApi {

    private final ImprovisationRepository improvisationRepository;

    @Autowired
    public ImprovisationController(ImprovisationRepository improvisationRepository) {
        this.improvisationRepository = improvisationRepository;
    }

    @Override
    public ResponseEntity<Improvisation> create(Improvisation improvisation) {
        return ok(improvisationRepository.save(improvisation));
    }

    @Override
    public ResponseEntity read(UUID id) {
        Optional<Improvisation> improvisation = improvisationRepository.findById(id);
        if (improvisation.isPresent()) {
            return ok(improvisation.get());
        }
        return notFound().build();
    }

    @Override
    public ResponseEntity update(UUID id, Improvisation updatedImprovisation) {
        Optional<Improvisation> currentImprovisation = improvisationRepository.findById(id);
        if (currentImprovisation.isPresent()) {
            return ok(improvisationRepository.save(updatedImprovisation));
        }
        return notFound().build();
    }

    @Override
    public ResponseEntity delete(UUID id) {
        Optional<Improvisation> currentImprovisation = improvisationRepository.findById(id);
        if (currentImprovisation.isPresent()) {
            improvisationRepository.delete(currentImprovisation.get());
            return noContent().build();
        }
        return notFound().build();
    }

    @Override
    public ResponseEntity<Collection<Improvisation>> list() {
        return ResponseEntity.ok(improvisationRepository.findAll());
    }
}
