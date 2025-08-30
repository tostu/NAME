package me.tostu.adapter.primary.rest.mapper;

import me.tostu.domain.NameRequest;
import me.tostu.domain.NameSuggestion;
import me.tostu.adapter.primary.rest.dto.NameRequestDto;
import me.tostu.adapter.primary.rest.dto.NameResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface NameMapper {

    NameRequest toDomain(NameRequestDto dto);

    NameResponseDto toDto(NameSuggestion suggestion);
}
