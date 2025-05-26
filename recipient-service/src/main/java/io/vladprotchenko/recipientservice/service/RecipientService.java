package io.vladprotchenko.recipientservice.service;

import io.vladprotchenko.ensstartercore.security.service.AuthenticationFacade;
import io.vladprotchenko.recipientapi.model.dto.RecipientRequestDto;
import io.vladprotchenko.recipientapi.model.dto.RecipientResponseDto;
import io.vladprotchenko.recipientservice.model.entity.Recipient;
import io.vladprotchenko.recipientservice.repository.RecipientRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RecipientService {

    RecipientRepository recipientRepository;
    RecipientMapper recipientMapper;
    AuthenticationFacade authenticationFacade;

    @Transactional
    public RecipientResponseDto createRecipient(RecipientRequestDto recipientRequestDto) {
        Recipient recipient = recipientMapper.toEntity(recipientRequestDto);
        recipient.setCreatorId(authenticationFacade.getAccountIdFromAuthentication());
        Recipient saved = recipientRepository.save(recipient);
        return recipientMapper.toResponseDto(saved);
    }

    @Transactional(readOnly = true)
    public RecipientResponseDto getRecipientById(Long id) {
        Recipient recipient = recipientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipient not found with id: " + id));
        return recipientMapper.toResponseDto(recipient);
    }

    @Transactional(readOnly = true)
    public List<RecipientResponseDto> getAllRecipients() {
        return recipientMapper.toResponseDtoList(recipientRepository.findAll());
    }

    @Transactional
    public RecipientResponseDto updateRecipient(Long id, RecipientRequestDto recipientRequestDto) {
        Recipient existing = recipientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipient not found with id: " + id));

        existing.setFirstName(recipientRequestDto.getFirstName());
        existing.setLastName(recipientRequestDto.getLastName());
        existing.setOrganization(recipientRequestDto.getOrganization());
        existing.setContactData(recipientRequestDto.getContactData());

        Recipient updated = recipientRepository.save(existing);
        return recipientMapper.toResponseDto(updated);
    }
}
