package com.example.demo.participant;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/participant")
public class ParticipantController {

    private final ParticipantService participantService;


    @GetMapping(path = "/participants")
    public List<Participant> getParticipants() {
        return participantService.getParticipants();
    }


    @DeleteMapping(path = "{participantId}")
    public void deleteParticipant(@PathVariable("participantId") Long participantId) {
        participantService.deleteParticipant(participantId);

    }

    @PostMapping(path = "{participantId}")
    public void updateParticipant(@PathVariable Long participantId,
                                  @RequestParam(required = false) String firstName,
                                  @RequestParam(required = false) String email) {

     participantService.updateParticipant(participantId, firstName, email);
    }

}
