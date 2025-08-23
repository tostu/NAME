package me.tostu.application;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import me.tostu.domain.NameGeneratorPort;
import me.tostu.domain.NameRequest;
import me.tostu.domain.NameSuggestion;
import me.tostu.domain.NameTemplate;

@ApplicationScoped
public class GenerateNameService {

    private final NameGeneratorPort generatorPort;

    @Inject
    public GenerateNameService(NameGeneratorPort generatorPort) {
        this.generatorPort = generatorPort;
    }

    public NameSuggestion generateNames(NameRequest request) {
        // Default count
        if (request.getCount() == null || request.getCount() <= 0) {
            request.setCount(10);
        }
        if (request.getTemplate() == null) {
            request.setTemplate(NameTemplate.BRAND_FRIENDLY);
        }
        // Enrich context with selected template guidance
        String prompt = buildPrompt(request.getTemplate(), request.getContext(), request.getCount());

        NameRequest enriched = new NameRequest();
        enriched.setTemplate(request.getTemplate());
        enriched.setCount(request.getCount());
        enriched.setContext(prompt);
        return generatorPort.generate(enriched);
    }

    private String buildPrompt(NameTemplate template, String context, int count) {
        Map<NameTemplate, String> patterns = new HashMap<>();
        patterns.put(NameTemplate.BRAND_FRIENDLY, "Generate %d brand-friendly, memorable names for: %s");
        patterns.put(NameTemplate.TECHY, "Generate %d modern, tech-sounding names (avoid numbers unless relevant) for: %s");
        patterns.put(NameTemplate.FANTASY, "Generate %d whimsical, fantasy-inspired names for: %s");
        patterns.put(NameTemplate.SHORT_AND_CATCHY, "Generate %d very short (<=8 chars), catchy names for: %s");
        patterns.put(NameTemplate.PROFESSIONAL, "Generate %d professional, trustworthy names for: %s");

        String base = patterns.getOrDefault(template, patterns.get(NameTemplate.BRAND_FRIENDLY));
        String task = String.format(base, count, context == null ? "(no additional context)" : context.trim());

        // Force strict JSON array output to simplify parsing.
        return task + ". Return ONLY a JSON array of strings, no commentary, no code fences.";
    }
}
