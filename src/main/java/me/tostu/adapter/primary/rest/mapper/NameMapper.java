package me.tostu.adapter.primary.rest.mapper;

import me.tostu.domain.NameRequest;
import me.tostu.domain.NameSuggestion;
import me.tostu.adapter.primary.rest.dto.NameRequestDto;
import me.tostu.adapter.primary.rest.dto.NameResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface NameMapper {

    default NameRequest toDomain(NameRequestDto dto) {
        if (dto == null) {
            return null;
        }
        return new NameRequest(dto.getTemplate(), dto.getContext(), dto.getCount());
    }

    default NameResponseDto toDto(NameSuggestion suggestion) {
        if (suggestion == null) {
            return null;
        }
        NameResponseDto dto = new NameResponseDto();
        dto.setNames(suggestion.names());
        return dto;
    }
}
