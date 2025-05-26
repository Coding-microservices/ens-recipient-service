package io.vladprotchenko.recipientapi.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.vladprotchenko.notificationapi.model.enums.NotificationType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecipientRequestDto {
    Long id;
    String firstName;
    String lastName;
    String organization;
    Map<NotificationType, String> contactData;
}

