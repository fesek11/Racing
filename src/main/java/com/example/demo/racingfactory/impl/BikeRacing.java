package com.example.demo.racingfactory.impl;

import com.example.demo.participant.Participant;
import com.example.demo.racingfactory.RacingI;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Map;

@Component
@Entity
@Getter
@Setter
public class BikeRacing implements RacingI {
    @SequenceGenerator(name = "bikeRacing_sequence", sequenceName = "bikeRacing_sequence", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bikeRacing_sequence")
    private Long id;


    @Override
    public void takeAPart(Participant participant) {

    }

    @Override
    public Map<Long, Participant> getScore() {
        return null;
    }
}
