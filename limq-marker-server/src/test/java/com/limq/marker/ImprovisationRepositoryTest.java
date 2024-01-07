package com.limq.marker;

import com.limq.model.Improvisation;
import com.limq.model.ImprovisationTeam;
import com.limq.repositories.ImprovisationRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ImprovisationRepositoryTest {
    @Autowired
    private ImprovisationRepository improvisationRepository;

    @Test
    @Transactional
    void save() {
        Improvisation improvisation = new Improvisation();

        ImprovisationTeam improvisationTeam = new ImprovisationTeam();
        improvisationTeam.setWinningTeam(true);
        improvisation.setImprovisationTeams(List.of(improvisationTeam));

        improvisationRepository.save(improvisation);

        Assertions.assertThat(improvisationRepository.findById(improvisation.getId())).hasValue(improvisation);
        Assertions.assertThat(improvisationRepository.findById(improvisation.getId()).get().getImprovisationTeams()).isNotEmpty();
    }
}
