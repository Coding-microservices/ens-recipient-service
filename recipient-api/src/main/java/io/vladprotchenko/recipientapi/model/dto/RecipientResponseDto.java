package io.vladprotchenko.recipientapi.model.dto;


import io.vladprotchenko.notificationapi.model.enums.NotificationType;

import java.time.Instant;
import java.util.Map;

public record RecipientResponseDto(
        Long id,
        String firstName,
        String lastName,
        String organization,
        Map<NotificationType, String> contactData,
        Instant createdAt,
        Instant updatedAt
) {
}
