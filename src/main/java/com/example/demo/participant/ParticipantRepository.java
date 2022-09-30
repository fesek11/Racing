package com.example.demo.participant;

import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    @Query("SELECT s FROM Participant s WHERE s.email = ?1")
    Optional<Participant> findParticipantByEmail(String email);

    Optional<Participant> findParticipantById(Long participantId);

    @Override
    Optional<Participant> findById(Long aLong);

    @Modifying
    @Query("DELETE FROM Participant s WHERE s.id=:id")
    void delete(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Participant a " + "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableParticipant(String email);

}
