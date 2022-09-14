package com.example.demo.racingfactory.services;

import com.example.demo.participant.Participant;
import com.example.demo.racingfactory.ServiceFactory;
import com.example.demo.racingfactory.impl.CarRacing;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarTypeService implements ServiceFactory {
    private CarRacing carRacing;
    @Override
    public List<Participant> getParticipants() {
        return carRacing.getSetOfParticipants();
    }

    @Override
    public void addParticipant(Long idParticipant) {

    }
}
