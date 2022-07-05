package com.example.demo.participant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ParticipantService {
    private final ParticipantRepository participantRepository;

    @Autowired
    public ParticipantService(ParticipantRepository participantService) {
        this.participantRepository = participantService;
    }


    public List<Participant> getParticipants() {
        return participantRepository.findAll();
    }

    public void addNewParticipant(Participant participant) {
        checkUniqueEmail(participant.getEmail());
        participantRepository.save(participant);
    }

    private void checkUniqueEmail(String email) {
        String regex = "^[\\w.+\\-]+@gmail\\.com$";
        if (regex.matches(email)) {
            throw new IllegalStateException("Email " + email + " is not valid");
        }
        Optional<Participant> participantByEmail = participantRepository.findParticipantByEmail(email);
        if (participantByEmail.isPresent()) {
            throw new IllegalStateException("Email " + email + " is taken");
        }
    }

    public void deleteParticipant(Long participantId) {
        boolean exists = participantRepository.existsById(participantId);
        if (!exists) {
            throw new IllegalStateException("Participant with " + participantId + " is not exist!");
        }
        participantRepository.deleteById(participantId);

    }

    @Transactional
    public void updateParticipant(Long id, String name, String email) {
        System.out.printf("In @Transactional Service");

        Participant participantToUpdate = participantRepository.findById(id).orElseThrow(() -> new IllegalStateException("Participant with " + id + " is not exist!"));
        if (name != null && name.length() > 0 && !Objects.equals(participantToUpdate.getName(), name)) {
            participantToUpdate.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(participantToUpdate.getEmail(), email)) {
            checkUniqueEmail(email);
            participantToUpdate.setEmail(email);
        }

    }
}
