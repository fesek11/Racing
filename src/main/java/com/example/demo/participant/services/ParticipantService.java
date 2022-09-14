package com.example.demo.participant.services;

import com.example.demo.participant.Participant;
import com.example.demo.participant.ParticipantRepository;
import com.example.demo.registration.EmailValidator;
import com.example.demo.registration.token.ConfirmationToken;
import com.example.demo.registration.token.ConfirmationTokenService;
import com.example.demo.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ParticipantService implements UserDetailsService {
    private final static String PARTICIPANT_NOT_FOUND_MSG = "Participant with email %s not found";
    private final EmailValidator emailValidator;
    private final ParticipantRepository participantRepository;
    private final PasswordEncoder passwordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    public List<Participant> getParticipants() {
        System.out.printf("    public List<Participant> getParticipants() {\n");
        return participantRepository.findAll().stream().toList();
    }


    public String signUpParticipant(Participant participant) {
        boolean participantExists = participantRepository
                .findParticipantByEmail(participant.getEmail())
                .isPresent();
        if (participantExists) {
            throw new IllegalStateException("Email already taken");
        }
        participant.setPassword(passwordEncoder.bCryptPasswordEncoder().encode(participant.getPassword()));
        participantRepository.save(participant);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                participant
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        //todo: send email
        return token;
    }

    public void deleteParticipant(Long participantId) {
        boolean exists = participantRepository.existsById(participantId);
        if (!exists) {
            throw new IllegalStateException("Participant with " + participantId + " is not exist!");
        }
        participantRepository.deleteById(participantId);
    }

    @Transactional
    public void updateParticipant(Long participantId, String firstName, String email) {
        Participant participantToUpdate = participantRepository
                .findParticipantById(participantId)
                .orElseThrow(() -> new IllegalStateException("Participant with " + participantId + " is not exist!"));
        if (firstName != null && firstName.length() > 0 &&
                !Objects.equals(participantToUpdate.getFirstName(), firstName)) {
            participantToUpdate.setFirstName(firstName);
        }
        if (emailValidator.test(email)) {
            participantToUpdate.setEmail(email);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return participantRepository.findParticipantByEmail(userName)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format(PARTICIPANT_NOT_FOUND_MSG, userName)));
    }

    public int enableParticipant(String email) {
        return participantRepository.enableParticipant(email);
    }
}
