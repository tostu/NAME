package me.tostu.adapter.secondary.gemini;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.tostu.domain.NameGeneratorPort;
import me.tostu.domain.NameRequest;
import me.tostu.domain.NameSuggestion;
import me.tostu.adapter.secondary.gemini.model.GeminiRequest;
import me.tostu.adapter.secondary.gemini.model.GeminiResponse;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

@ApplicationScoped
public class GeminiNameGeneratorAdapter implements NameGeneratorPort {

    private static final Logger LOG = Logger.getLogger(GeminiNameGeneratorAdapter.class);

    @Inject
    @RestClient
    GeminiApi api;

    @Inject
    ObjectMapper objectMapper;

    @ConfigProperty(name = "gemini.api.key", defaultValue = "")
    String apiKey;

    @ConfigProperty(name = "gemini.model", defaultValue = "gemini-1.5-flash")
    String model;

    @Override
    public NameSuggestion generate(NameRequest request) {
        if (apiKey == null || apiKey.isBlank()) {
            LOG.warn("Gemini API key missing. Returning empty suggestions.");
            return new NameSuggestion(Collections.emptyList());
        }
        String prompt = request.context();
        try {
            GeminiRequest gemReq = GeminiRequest.fromText(prompt);
            GeminiResponse response = api.generateContent(model, apiKey, gemReq);
            List<String> names = extractNames(response);
            // Trim to requested count if needed
            if (request.count() != null && request.count() > 0 && names.size() > request.count()) {
                names = names.subList(0, request.count());
            }
            return new NameSuggestion(names);
        } catch (Exception e) {
            LOG.error("Failed to generate names via Gemini", e);
            return new NameSuggestion(Collections.emptyList());
        }
    }

    private List<String> extractNames(GeminiResponse resp) {
        if (resp == null || resp.getCandidates() == null || resp.getCandidates().isEmpty()) {
            return Collections.emptyList();
        }
        StringBuilder sb = new StringBuilder();
        resp.getCandidates().stream()
                .filter(c -> c.getContent() != null && c.getContent().getParts() != null)
                .flatMap(c -> c.getContent().getParts().stream())
                .forEach(p -> {
                    if (p.getText() != null) sb.append(p.getText());
                });
        String text = sb.toString().trim();
        if (text.isEmpty()) {
            return Collections.emptyList();
        }
        // Expected to be a JSON array of strings per our prompt
        try {
            List<String> arr = objectMapper.readValue(text, new TypeReference<List<String>>(){});
            // Normalize entries
            List<String> cleaned = new ArrayList<>();
            for (String s : arr) {
                if (s != null) {
                    String v = s.trim();
                    if (!v.isEmpty()) cleaned.add(v);
                }
            }
            return cleaned;
        } catch (Exception ex) {
            // Fallback: split by lines or commas
            LOG.debug("Gemini output not a strict JSON array; applying fallback parsing.");
            String normalized = text.replace("\r", "");
            String[] parts = normalized.contains("\n") ? normalized.split("\n") : normalized.split(",");
            List<String> items = new ArrayList<>();
            for (String p : parts) {
                String v = p.trim();
                if (v.startsWith("-") || v.startsWith("*") || v.matches("\\d+\\.\\s+.*")) {
                    v = v.replaceFirst("^[-*]\\s*", "");
                    v = v.replaceFirst("^\\d+\\.\\s*", "");
                }
                if (!v.isEmpty()) items.add(v);
            }
            return items;
        }
    }
}
