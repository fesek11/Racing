package com.example.demo.racingfactory.services;

import com.example.demo.participant.Participant;
import com.example.demo.participant.ParticipantRepository;
import com.example.demo.racingfactory.RacingConfiguration;
import com.example.demo.racingfactory.RacingRepository;
import com.example.demo.racingfactory.ServiceFactory;
import com.example.demo.racingfactory.impl.BikeRacing;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Slf4j
public class BikeTypeService implements ServiceFactory {
    private BikeRacing bikeRacing;
    private RacingRepository racingRepository;
    private ParticipantRepository participantRepository;


    @Override
    public List<Participant> getParticipants() {
        log.info("BikeService get participants");
        return RacingConfiguration.serviceFactoryMap.get("bike-racing").getParticipants();
    }

    @Override
    public void addParticipant(Long idParticipant) {
        RacingConfiguration.serviceFactoryMap.get("bike-racing").addParticipant(idParticipant);
        System.out.println("Participant " + participantRepository.findParticipantById(idParticipant).
                get().getFirstName() + " " + participantRepository.findParticipantById(idParticipant).
                get().getLastName() + " is in our racing list! "
        );
    }
}
