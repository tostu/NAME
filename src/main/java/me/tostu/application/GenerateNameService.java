package me.tostu.application;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import me.tostu.domain.NameGeneratorPort;
import me.tostu.domain.NameRequest;
import me.tostu.domain.NameSuggestion;
import me.tostu.domain.NameTemplate;
import me.tostu.domain.NameGenerationStrategy;
import me.tostu.domain.NameGenerationStrategyFactory;

@ApplicationScoped
public class GenerateNameService {

    private final NameGeneratorPort generatorPort;
    private final NameGenerationStrategyFactory strategyFactory;

    @Inject
    public GenerateNameService(NameGeneratorPort generatorPort, NameGenerationStrategyFactory strategyFactory) {
        this.generatorPort = generatorPort;
        this.strategyFactory = strategyFactory;
    }

    public NameSuggestion generateNames(NameRequest request) {
        NameTemplate template = request.template() == null ? NameTemplate.BRAND_FRIENDLY : request.template();
        NameGenerationStrategy strategy = strategyFactory.getStrategy(template);
        
        String prompt = strategy.buildPrompt(request);
        
        NameRequest enriched = new NameRequest(template, prompt, request.count());
        return generatorPort.generate(enriched);
    }
}
