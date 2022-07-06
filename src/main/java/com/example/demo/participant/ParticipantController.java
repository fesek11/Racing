package com.example.demo.participant;

import com.example.demo.registration.RegistrationRequest;
import com.example.demo.registration.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class ParticipantController {

    private RegistrationService registrationService;
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
    public void registerNewParticipant(@RequestBody RegistrationRequest registrationRequest) {
        registrationRequest.register(registrationRequest);
    }

    @DeleteMapping(path = "{participantId}")
    public void deleteParticipant(@PathVariable("participantId") Long participantId) {
        participantService.deleteParticipant(participantId);

    }

    @PostMapping(path = "{participantId}")
    public void updateParticipant(@PathVariable Long participantId,
                                  @RequestParam(required = false) String name,
                                  @RequestParam(required = false) String email) {

        System.out.printf("In @Transactional Controller");
        participantService.updateParticipant(participantId, name, email);
    }

}
