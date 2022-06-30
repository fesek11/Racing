package com.example.demo.participant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Optional<Participant> participantByEmail = participantRepository.findParticipantByEmail(participant.getEmail());
        if (participantByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        participantRepository.save(participant);
    }

    public void deleteParticipant(Long participantId) {
        boolean exists = participantRepository.existsById(participantId);
        if (!exists) {
            throw new IllegalStateException("student with " + participantId + " is not exist!");
        }
        participantRepository.deleteById(participantId);

    }

    public void updateParticipant(Long participantId, Participant participant) {
        System.out.printf("In @Transactional Service");

        Optional<Participant> participantById = participantRepository.findById(participantId);
        if (participantById.isEmpty()) {
            throw new IllegalStateException("student with " + participantId + " is not exist!");
        }

        Participant updatedParticipant = participantRepository.getReferenceById(participantId);
        updatedParticipant.setAge(participant.getAge());
        updatedParticipant.setEmail(participant.getEmail());
        updatedParticipant.setName(participant.getName());
    }
}
