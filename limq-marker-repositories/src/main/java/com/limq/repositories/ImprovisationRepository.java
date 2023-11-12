package com.limq.repositories;

import com.limq.model.Improvisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImprovisationRepository extends JpaRepository<Improvisation, UUID> {
}
