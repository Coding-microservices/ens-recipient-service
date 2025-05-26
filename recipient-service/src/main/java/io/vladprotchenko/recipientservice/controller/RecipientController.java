package io.vladprotchenko.recipientservice.controller;

import io.vladprotchenko.recipientapi.model.dto.RecipientRequestDto;
import io.vladprotchenko.recipientapi.model.dto.RecipientResponseDto;
import io.vladprotchenko.recipientservice.service.RecipientService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recipient")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RecipientController {

    RecipientService recipientService;

    @PostMapping()
    public ResponseEntity<RecipientResponseDto> createRecipient(@RequestBody RecipientRequestDto recipientRequestDto) {
        RecipientResponseDto responseDto = recipientService.createRecipient(recipientRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipientResponseDto> getRecipientById(@PathVariable Long id) {
        RecipientResponseDto responseDto = recipientService.getRecipientById(id);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping()
    public ResponseEntity<List<RecipientResponseDto>> getAllRecipients() {
        return ResponseEntity.ok(recipientService.getAllRecipients());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RecipientResponseDto> updateRecipient(
            @PathVariable Long id,
            @RequestBody RecipientRequestDto recipientRequestDto
    ) {
        RecipientResponseDto responseDto = recipientService.updateRecipient(id, recipientRequestDto);
        return ResponseEntity.ok(responseDto);
    }
}
