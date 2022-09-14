package com.example.demo.racingfactory;

import com.example.demo.participant.Participant;

import java.util.List;
import java.util.Map;

public interface Racing {

    List<Participant> getSetOfParticipants();

    Map<Long, String> getScore();
}
