package me.tostu.domain;

public class FrierenStrategy extends AbstractNameGenerationStrategy {
    
    @Override
    protected String getInstruction(String context) {
        return "Generate names inspired by Frieren: Beyond Journey's End for: " + context;
    }
    
    @Override
    protected String[] getRules() {
        return new String[]{
            "Use German words and meanings as foundation",
            "Follow Germanic linguistic patterns",
            "Names should reflect the character's nature or abilities",
            "Can combine German roots with fantasy elements",
            "Maintain the series' naming aesthetic"
        };
    }
    
    @Override
    protected String[] getLinguisticAspects() {
        return new String[]{
            "Apply Germanic phonological patterns and morphology",
            "Use umlauts (ä, ö, ü) for authentic German character",
            "Employ consonant clusters typical of German (st, sch, pf)",
            "Include compound word formations characteristic of German",
            "Map semantic meaning to phonetic structure (harsh sounds for strength, soft for gentleness)"
        };
    }
    
    @Override
    protected String[] getExamples() {
        return new String[]{
            "Frieren (freeze/cold) - immortal elf mage",
            "Stark (strong) - warrior", 
            "Fern (distant) - human mage",
            "Heiter (cheerful) - priest"
        };
    }
}