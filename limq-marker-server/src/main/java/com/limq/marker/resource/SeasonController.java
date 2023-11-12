package com.limq.marker.resource;

import com.limq.api.SeasonApi;
import com.limq.model.Person;
import com.limq.model.Season;
import com.limq.model.Team;
import com.limq.repositories.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.*;

@Component
public class SeasonController implements SeasonApi {

    private final SeasonRepository seasonRepository;

    @Autowired
    public SeasonController(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @Override
    public ResponseEntity<Season> create(Season season) {
        return ok(seasonRepository.save(season));
    }

    @Override
    public ResponseEntity read(UUID id) {
        Optional<Season> season = seasonRepository.findById(id);
        if (season.isPresent()){
            return ok(season.get());
        }
        return notFound().build();
    }

    @Override
    public ResponseEntity update(UUID id, Season updatedSeason) {
        Optional<Season> currentSeason = seasonRepository.findById(id);
        if (currentSeason.isPresent()){
            return ok(seasonRepository.save(updatedSeason));
        }
        return notFound().build();
    }

    @Override
    public ResponseEntity delete(UUID id) {
        Optional<Season> currentSeason = seasonRepository.findById(id);
        if (currentSeason.isPresent()){
            seasonRepository.delete(currentSeason.get());
            return noContent().build();
        }
        return notFound().build();
    }

    @Override
    public ResponseEntity<Collection<Season>> list() {
        return ResponseEntity.ok(seasonRepository.findAll());
    }
}
