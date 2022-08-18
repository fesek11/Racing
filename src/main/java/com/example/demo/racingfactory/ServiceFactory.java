package com.example.demo.racingfactory;

import com.example.demo.participant.Participant;

import java.util.List;

public interface ServiceFactory {

    List<Participant> getParticipants();

    void addParticipant(Long idParticipant);

}
