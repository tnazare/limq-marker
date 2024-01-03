package com.limq.repositories;

import com.limq.model.Improvisation;
import com.limq.model.ImprovisationTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImprovisationTeamRepository extends JpaRepository<ImprovisationTeam, UUID> {
}
