package me.tostu.adapter.secondary.gemini.model;

import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeminiRequest {
    private List<Content> contents;

    public static GeminiRequest fromText(String text) {
        Part part = new Part(text);
        Content content = new Content(Collections.singletonList(part));
        return new GeminiRequest(Collections.singletonList(content));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Content {
        private List<Part> parts;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Part {
        private String text;
    }
}
