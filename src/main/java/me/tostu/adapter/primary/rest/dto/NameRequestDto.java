package me.tostu.adapter.primary.rest.dto;

import lombok.Data;
import me.tostu.domain.NameTemplate;

@Data
public class NameRequestDto {
    private NameTemplate template;
    private String context;
    private Integer count;
}
