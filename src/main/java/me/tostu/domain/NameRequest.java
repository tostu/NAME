package me.tostu.domain;

public record NameRequest(NameTemplate template, String context, Integer count) {
}
