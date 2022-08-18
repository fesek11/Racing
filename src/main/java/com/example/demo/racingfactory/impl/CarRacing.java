package com.example.demo.racingfactory.impl;

import com.example.demo.participant.Participant;
import com.example.demo.racingfactory.RacingI;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
public class CarRacing implements RacingI {

    @SequenceGenerator(name = "carRacing_sequence", sequenceName = "carRacing_sequence", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carRacing_sequence")
    private Long id;


    @Override
    public List<Participant> getList() {
        return null;
    }

    @Override
    public Map<Long, String> getScore() {
        return null;
    }
}
