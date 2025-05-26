package io.vladprotchenko.recipientapi;

import io.vladprotchenko.recipientapi.config.FeignClientConfiguration;
import io.vladprotchenko.recipientapi.model.dto.RecipientRequestDto;
import io.vladprotchenko.recipientapi.model.dto.RecipientResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "recipient-service",
        path = "api/v1/recipient",
        configuration = FeignClientConfiguration.class
)
public interface RecipientServiceApi {

    @PostMapping("/")
    ResponseEntity<RecipientResponseDto> createRecipient(@RequestBody RecipientRequestDto recipientRequestDto);

    @GetMapping("/{id}")
    ResponseEntity<RecipientResponseDto> getRecipientById(@PathVariable Long id);

}
