package me.tostu.domain;

import lombok.Data;

@Data
public class NameRequest {
    private NameTemplate template;
    private String context; // description, keywords, industry, etc.
    private Integer count;  // number of suggestions requested
}
