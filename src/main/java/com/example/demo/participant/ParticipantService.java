package com.example.demo.participant;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ParticipantService implements UserDetailsService {
    private final ParticipantRepository participantRepository;
    private final static String PARTICIPANT_NOT_FOUND_MSG = "Participant with email %s not found";



/*
    public List<Participant> getParticipants() {
        return participantRepository.findAll();
    }
*/
/*

    public void addNewParticipant(Participant participant) {
        checkUniqueEmail(participant.getEmail());
        participantRepository.save(participant);
    }
*/

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

/*
    public void deleteParticipant(Long participantId) {
        boolean exists = participantRepository.existsById(participantId);
        if (!exists) {
            throw new IllegalStateException("Participant with " + participantId + " is not exist!");
        }
        participantRepository.deleteById(participantId);

    }
*/

   /* @Transactional
    public void updateParticipant(Long id, String name, String email) {
        System.out.printf("In @Transactional Service");

        Participant participantToUpdate = participantRepository.findParticipantById(id).orElseThrow(() -> new IllegalStateException("Participant with " + id + " is not exist!"));
        if (name != null && name.length() > 0 && !Objects.equals(participantToUpdate.getUserName(), name)) {
            participantToUpdate.setUserName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(participantToUpdate.getEmail(), email)) {
            checkUniqueEmail(email);
            participantToUpdate.setEmail(email);
        }

    }*/

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return participantRepository.findParticipantByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format(PARTICIPANT_NOT_FOUND_MSG, email)));
    }
}
