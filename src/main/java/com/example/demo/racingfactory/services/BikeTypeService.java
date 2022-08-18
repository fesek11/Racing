package com.example.demo.racingfactory.services;

import com.example.demo.participant.Participant;
import com.example.demo.participant.ParticipantRepository;
import com.example.demo.racingfactory.RacingRepository;
import com.example.demo.racingfactory.ServiceFactory;
import com.example.demo.racingfactory.impl.BikeRacing;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BikeTypeService implements ServiceFactory {
    private BikeRacing bikeRacing;
    private RacingRepository racingRepository;
    private ParticipantRepository participantRepository;


    @Override
    public List<Participant> getParticipants() {
        return bikeRacing.getParticipants();
    }

    @Override
    public void addParticipant(Long idParticipant) {
        bikeRacing.addToList(idParticipant);
        System.out.println("Participant " + participantRepository.findParticipantById(idParticipant).
                get().getFirstName() + " " + participantRepository.findParticipantById(idParticipant).
                get().getLastName() + " is in our racing list! "
        );
    }
}
