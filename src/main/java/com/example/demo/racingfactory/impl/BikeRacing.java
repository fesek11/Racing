package com.example.demo.racingfactory.impl;

import com.example.demo.participant.Participant;
import com.example.demo.participant.ParticipantRepository;
import com.example.demo.racingfactory.RacingI;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
public class BikeRacing implements RacingI {
    @SequenceGenerator(name = "bikeRacing_sequence", sequenceName = "bikeRacing_sequence", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bikeRacing_sequence")
    private Long id;

    @Column
    @OneToMany(mappedBy = "bikeRacing")
    private List<Participant> participants = new ArrayList<>();


    @Override
    public List<Participant> getList() {
        return participants.stream().toList();
    }

    public void addToList(Long id) {
        ParticipantRepository participantRepository = null;
        assert false;
        participants.add(participantRepository.findParticipantById(id).get());
    }

    @Override
    public Map<Long, String> getScore() {
        return null;
    }

}
