package me.tostu.domain.strategies;

public class FantasyStrategy extends AbstractNameGenerationStrategy {
    
    @Override
    protected String getInstruction(String context) {
        return "Generate whimsical, fantasy-inspired names that embody the magical essence and characteristics of: " + context + 
               ". Names should evoke the mystical qualities and fantasy nature inherent in " + context + ".";
    }
    
    @Override
    protected String[] getRules() {
        return new String[]{
            "Use mystical and otherworldly sounds",
            "Include fantasy elements like -wick, -shire, -ford, -haven",
            "Combine archaic words with magical concepts",
            "Should evoke wonder and enchantment",
            "Can include apostrophes for elven-style names"
        };
    }
    
    @Override
    protected String[] getLinguisticAspects() {
        return new String[]{
            "Use Old English and Celtic phonemes for authenticity",
            "Employ liquid consonants (l, r) for flowing, ethereal quality",
            "Incorporate archaic morphemes like -wick, -shire, -ford, -haven",
            "Use diphthongs (ae, ou, ei) for mystical resonance",
            "Apply elision and apostrophes for elven linguistic aesthetics"
        };
    }
    
    @Override
    protected String[] getExamples() {
        return new String[]{"Rivendell", "Shadowfax", "Mithril", "Elderwood", "Starfall"};
    }
    
    @Override
    protected String[] getAdditionalGuidance() {
        return new String[]{
            "Identify fantasy elements within the context and amplify them in the names",
            "Draw inspiration from mythology, folklore, and classic fantasy literature",
            "Consider the cultural and historical context of the fantasy setting",
            "Think about how names would evolve in different fantasy races and cultures",
            "Ensure names fit the magical or medieval atmosphere",
            "Consider how names will sound when spoken by characters in dialogue"
        };
    }
}