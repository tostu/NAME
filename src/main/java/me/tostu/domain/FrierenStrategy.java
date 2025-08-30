package me.tostu.domain;

public class FrierenStrategy implements NameGenerationStrategy {
    
    @Override
    public String buildPrompt(NameRequest request) {
        int count = (request.count() == null || request.count() <= 0) ? 10 : request.count();
        String context = request.context() == null ? "(no additional context)" : request.context().trim();
        
        StringBuilder prompt = new StringBuilder();
        
        // Instruction
        prompt.append("Generate names inspired by Frieren: Beyond Journey's End for: ").append(context).append("\n\n");
        
        // Rules
        prompt.append("RULES:\n");
        prompt.append("- Use German words and meanings as foundation\n");
        prompt.append("- Follow Germanic linguistic patterns\n");
        prompt.append("- Names should reflect the character's nature or abilities\n");
        prompt.append("- Can combine German roots with fantasy elements\n");
        prompt.append("- Maintain the series' naming aesthetic\n\n");
        
        // Examples
        prompt.append("EXAMPLES:\n");
        prompt.append("- Frieren (freeze/cold) - immortal elf mage\n");
        prompt.append("- Stark (strong) - warrior\n");
        prompt.append("- Fern (distant) - human mage\n");
        prompt.append("- Heiter (cheerful) - priest\n\n");
        
        // Task request
        prompt.append("Generate exactly ").append(count).append(" names following these patterns. ");
        prompt.append("Return ONLY a JSON array of strings, no commentary, no code fences.");
        
        return prompt.toString();
    }
}