package io.vladprotchenko.recipientservice.service;

import io.vladprotchenko.recipientapi.model.dto.RecipientRequestDto;
import io.vladprotchenko.recipientapi.model.dto.RecipientResponseDto;
import io.vladprotchenko.recipientservice.model.entity.Recipient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecipientMapper {

    RecipientResponseDto toResponseDto(Recipient recipient);

    RecipientRequestDto toRequestDto(Recipient recipient);

    Recipient toEntity(RecipientRequestDto dto);

    List<RecipientResponseDto> toResponseDtoList(List<Recipient> recipients);
    List<RecipientRequestDto> toRequestDtoList(List<Recipient> recipients);
    List<Recipient> toEntityList(List<RecipientRequestDto> dtoList);
}
