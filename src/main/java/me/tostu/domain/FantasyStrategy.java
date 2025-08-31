package me.tostu.domain;

public class FantasyStrategy extends AbstractNameGenerationStrategy {
    
    @Override
    protected String getInstruction(String context) {
        return "Generate whimsical, fantasy-inspired names for: " + context;
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
}