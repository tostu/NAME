package me.tostu.adapter.primary.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import me.tostu.application.GenerateNameService;
import me.tostu.adapter.primary.rest.dto.NameRequestDto;
import me.tostu.adapter.primary.rest.dto.NameResponseDto;
import me.tostu.adapter.primary.rest.mapper.NameMapper;

@Path("/api/v1/names")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NameResource {

    @Inject
    GenerateNameService service;

    @Inject
    NameMapper mapper;

    @POST
    public NameResponseDto generate(NameRequestDto dto) {
        var suggestion = service.generateNames(mapper.toDomain(dto));
        return mapper.toDto(suggestion);
    }
}
