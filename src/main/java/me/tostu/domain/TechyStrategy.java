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
    protected String[] getLinguisticAspects() {
        return new String[]{
            "Use compound words and portmanteau formations",
            "Favor sharp consonants (k, x, z) for technical precision",
            "Include tech-familiar morphemes like -hub, -stack, -ify, -ly",
            "Use camelCase or kebab-case friendly structures",
            "Avoid ambiguous pronunciations that could confuse in international contexts"
        };
    }
    
    @Override
    protected String[] getExamples() {
        return new String[]{"GitHub", "TypeScript", "MongoDB", "CloudFlare", "Vercel"};
    }
}