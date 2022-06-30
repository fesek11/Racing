package com.example.demo.participant;

import org.hibernate.annotations.common.util.impl.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class ParticipantController {

    private final ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping(path = "/participant")
    public List<Participant> getParticipants() {
        return participantService.getParticipants();
    }

    @PostMapping
    public void registerNewParticipant(@RequestBody Participant participant) {
        participantService.addNewParticipant(participant);
    }

    @DeleteMapping(path = "{participantId}")
    public void deleteParticipant(@PathVariable ("participantId") Long participantId) {
        participantService.deleteParticipant(participantId);

    }

    @Transactional
    public void updateParticipant(@RequestBody Long participantId,@RequestBody Participant participant) {
        System.out.printf("In @Transactional Controller");
        participantService.updateParticipant(participantId, participant);
    }

}
