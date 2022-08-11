package com.example.demo.racingfactory.impl;

import com.example.demo.participant.Participant;
import com.example.demo.racingfactory.RacingI;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Map;

@Component
public class CarRacing implements RacingI {

    @SequenceGenerator(name = "carRacing_sequence", sequenceName = "carRacing_sequence", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carRacing_sequence")
    private Long id;


    @Override
    public void takeAPart(Participant participant) {

    }

    @Override
    public Map<Long, Participant> getScore() {
        return null;
    }
}
