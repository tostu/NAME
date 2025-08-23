package me.tostu.domain;

public interface NameGeneratorPort {
    NameSuggestion generate(NameRequest request);
}
