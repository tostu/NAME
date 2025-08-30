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
    protected String[] getExamples() {
        return new String[]{
            "Frieren (freeze/cold) - immortal elf mage",
            "Stark (strong) - warrior", 
            "Fern (distant) - human mage",
            "Heiter (cheerful) - priest"
        };
    }
}