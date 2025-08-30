package me.tostu.domain;

public class TechyStrategy extends AbstractNameGenerationStrategy {
    
    @Override
    protected String getInstruction(String context) {
        return "Generate modern, tech-sounding names for: " + context;
    }
    
    @Override
    protected String[] getRules() {
        return new String[]{
            "Use contemporary tech naming patterns",
            "Avoid numbers unless specifically relevant to the context",
            "Prefer compound words or portmanteau constructions",
            "Should sound innovative and forward-thinking",
            "Can include tech-related suffixes like -ly, -ify, -hub, -stack"
        };
    }
    
    @Override
    protected String[] getExamples() {
        return new String[]{"GitHub", "TypeScript", "MongoDB", "CloudFlare", "Vercel"};
    }
}