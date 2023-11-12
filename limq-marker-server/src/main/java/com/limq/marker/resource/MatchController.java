package com.limq.marker.resource;

import com.limq.api.MatchApi;
import com.limq.model.Match;
import com.limq.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.*;

@Component
public class MatchController implements MatchApi {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public ResponseEntity<Match> create(Match match) {
        return ok(matchRepository.save(match));
    }

    @Override
    public ResponseEntity read(UUID id) {
        Optional<Match> match = matchRepository.findById(id);
        if (match.isPresent()){
            return ok(match.get());
        }
        return notFound().build();
    }

    @Override
    public ResponseEntity update(UUID id, Match updatedMatch) {
        Optional<Match> currentMatch = matchRepository.findById(id);
        if (currentMatch.isPresent()){
            return ok(matchRepository.save(updatedMatch));
        }
        return notFound().build();
    }

    @Override
    public ResponseEntity delete(UUID id) {
        Optional<Match> currentMatch = matchRepository.findById(id);
        if (currentMatch.isPresent()){
            matchRepository.delete(currentMatch.get());
            return noContent().build();
        }
        return notFound().build();
    }

    @Override
    public ResponseEntity<Collection<Match>> list() {
        return ResponseEntity.ok(matchRepository.findAll());
    }
}
