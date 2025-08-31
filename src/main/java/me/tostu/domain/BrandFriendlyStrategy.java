package me.tostu.domain;

public class BrandFriendlyStrategy extends AbstractNameGenerationStrategy {
    
    @Override
    protected String getInstruction(String context) {
        return "Generate brand-friendly, memorable names for: " + context;
    }
    
    @Override
    protected String[] getRules() {
        return new String[]{
            "Names should be easy to pronounce and remember",
            "Avoid hyphens, numbers, or complex punctuation",
            "Target 2-3 syllables for optimal memorability",
            "Should work across different cultures and languages"
        };
    }
    
    @Override
    protected String[] getLinguisticAspects() {
        return new String[]{
            "Favor consonant-vowel patterns for smooth pronunciation",
            "Use plosive sounds (p, b, t, d, k, g) for impact and memorability",
            "Avoid consonant clusters that are hard to pronounce across languages",
            "Consider phonetic similarity to positive words",
            "Prefer open vowel sounds (a, o) for warmth and approachability"
        };
    }
    
    @Override
    protected String[] getExamples() {
        return new String[]{"Stripe", "Slack", "Zoom", "Notion", "Figma"};
    }
}