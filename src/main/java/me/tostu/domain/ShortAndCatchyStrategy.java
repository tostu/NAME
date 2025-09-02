package me.tostu.domain;

public class ShortAndCatchyStrategy extends AbstractNameGenerationStrategy {
    
    @Override
    protected String getInstruction(String context) {
        return "Generate very short, catchy names that instantly capture the core appeal and energy of: " + context + 
               ". Names must be punchy abbreviations or distillations of what makes " + context + " exciting and memorable.";
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
    protected String[] getLinguisticAspects() {
        return new String[]{
            "Maximize consonant-vowel alternation for rhythm",
            "Use high-frequency phonemes for quick recognition",
            "Employ monosyllabic or bisyllabic structures only",
            "Favor fricatives (f, s, sh) and plosives (p, t, k) for punch",
            "Avoid vowel clusters that slow pronunciation"
        };
    }
    
    @Override
    protected String[] getExamples() {
        return new String[]{"Bit", "Hype", "Flux", "Zap", "Vim", "Git", "Zip"};
    }
    
    @Override
    protected String[] getAdditionalGuidance() {
        return new String[]{
            "Extract the most essential 1-2 concepts from the context and compress them into the name",
            "Prioritize memorability over cleverness - simple is better",
            "Test typing speed and accuracy on mobile keyboards",
            "Consider social media handle availability across platforms",
            "Ensure the name looks good in all caps and lowercase",
            "Think about how it will appear in app store listings and search results"
        };
    }
}