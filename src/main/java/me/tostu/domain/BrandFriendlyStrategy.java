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
    protected String[] getExamples() {
        return new String[]{"Stripe", "Slack", "Zoom", "Notion", "Figma"};
    }
}