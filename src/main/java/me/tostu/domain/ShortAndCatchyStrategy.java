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
}