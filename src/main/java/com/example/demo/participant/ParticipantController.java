package com.example.demo.participant;

import com.example.demo.participant.services.ParticipantService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/participant")
public class ParticipantController {

    private final ParticipantService participantService;


    @GetMapping(path = "/participants")
    public List<Participant> getParticipants() {

        return participantService.getParticipants();
    }

    @GetMapping(path = "/participants/{username}")
    public UserDetails getParticipant(@PathVariable String username) {
        return participantService.loadUserByUsername(username);
    }

    @DeleteMapping(path = "/{participantId}")
    public String deleteParticipant(@PathVariable("participantId") Long participantId) {
        participantService.deleteParticipant(participantId);
        return "Delete Done!";

    }

    @PostMapping(path = "/update/{participantId}")
    public void updateParticipant(@PathVariable Long participantId, @RequestParam(required = false) String firstName, @RequestParam(required = false) String email) {

        participantService.updateParticipant(participantId, firstName, email);
    }

}
