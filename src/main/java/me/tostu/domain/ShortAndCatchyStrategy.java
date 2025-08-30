package me.tostu.domain;

public class ShortAndCatchyStrategy extends AbstractNameGenerationStrategy {
    
    @Override
    protected String getInstruction(String context) {
        return "Generate very short, catchy names for: " + context;
    }
    
    @Override
    protected String[] getRules() {
        return new String[]{
            "Maximum 8 characters in length",
            "Easy to type and remember",
            "Punchy, energetic sound",
            "Avoid complex consonant clusters",
            "Perfect for domains, handles, or app names"
        };
    }
    
    @Override
    protected String[] getExamples() {
        return new String[]{"Bit", "Hype", "Flux", "Zap", "Vim", "Git", "Zip"};
    }
}