package me.tostu.domain;

public interface NameGenerationStrategy {
    String buildPrompt(NameRequest request);
}
