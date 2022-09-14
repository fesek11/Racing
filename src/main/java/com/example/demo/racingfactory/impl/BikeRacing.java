package com.example.demo.racingfactory.impl;

import com.example.demo.participant.Participant;
import com.example.demo.participant.ParticipantRepository;
import com.example.demo.racingfactory.Racing;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
public class BikeRacing implements Racing {
    @SequenceGenerator(name = "bikeRacing_sequence", sequenceName = "bikeRacing_sequence", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bikeRacing_sequence")
    private Long id;

    @ManyToMany(mappedBy = "racingPart")
    private Set<Participant> participants;



    @Override
    public List<Participant> getSetOfParticipants() {
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
