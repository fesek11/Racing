package com.example.demo.racingfactory;

import com.example.demo.participant.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacingRepository extends JpaRepository<Participant, Long> {

}
