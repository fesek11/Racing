package com.example.demo.participant;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ParticipantRepository {
//    @Query("SELECT s FROM Participant s WHERE s.email = ?1")
    Optional<Participant> findParticipantByEmail(String email);
    Optional<Participant> findParticipantById(Long id);

}
