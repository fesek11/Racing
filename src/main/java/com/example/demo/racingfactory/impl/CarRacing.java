package com.example.demo.racingfactory.impl;

import com.example.demo.participant.Participant;
import com.example.demo.racingfactory.Racing;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
public class CarRacing extends Racing {

    @SequenceGenerator(name = "carRacing_sequence", sequenceName = "carRacing_sequence", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carRacing_sequence")
    private Long id;


    public List<Participant> getSetOfParticipants() {
        return null;
    }

    protected List<Participant> participants() {
        return null;
    }

    public Map<Long, String> getScore() {
        return null;
    }
}
