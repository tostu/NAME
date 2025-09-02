package me.tostu.domain;

import jakarta.enterprise.context.ApplicationScoped;
import me.tostu.domain.strategies.*;
import java.util.Map;

@ApplicationScoped
public class NameGenerationStrategyFactory {
    
    private final Map<NameTemplate, NameGenerationStrategy> strategies;
    
    public NameGenerationStrategyFactory() {
        this.strategies = Map.of(
            NameTemplate.BRAND_FRIENDLY, new BrandFriendlyStrategy(),
            NameTemplate.TECHY, new TechyStrategy(),
            NameTemplate.FANTASY, new FantasyStrategy(),
            NameTemplate.SHORT_AND_CATCHY, new ShortAndCatchyStrategy(),
            NameTemplate.PROFESSIONAL, new ProfessionalStrategy(),
            NameTemplate.OLD_GERMAN, new OldGermanStrategy()
        );
    }
    
    public NameGenerationStrategy getStrategy(NameTemplate template) {
        return strategies.getOrDefault(template, strategies.get(NameTemplate.BRAND_FRIENDLY));
    }
}