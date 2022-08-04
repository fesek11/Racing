package com.example.demo.participant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    @Query("SELECT s FROM Participant s WHERE s.email = ?1")
    Optional<Participant> findParticipantByEmail(String email);

    Optional<Participant> findParticipantById(Long participantId);

    @Transactional
    @Modifying
    @Query("UPDATE Participant a " + "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableParticipant(String email);

}
