package me.tostu.domain;

public class FantasyStrategy implements NameGenerationStrategy {
    
    @Override
    public String buildPrompt(NameRequest request) {
        int count = (request.count() == null || request.count() <= 0) ? 10 : request.count();
        String context = request.context() == null ? "(no additional context)" : request.context().trim();
        
        StringBuilder prompt = new StringBuilder();
        
        // Instruction
        prompt.append("Generate whimsical, fantasy-inspired names for: ").append(context).append("\n\n");
        
        // Rules
        prompt.append("RULES:\n");
        prompt.append("- Use mystical and otherworldly sounds\n");
        prompt.append("- Include fantasy elements like -wick, -shire, -ford, -haven\n");
        prompt.append("- Combine archaic words with magical concepts\n");
        prompt.append("- Should evoke wonder and enchantment\n");
        prompt.append("- Can include apostrophes for elven-style names\n\n");
        
        // Examples
        prompt.append("EXAMPLES: Rivendell, Shadowfax, Mithril, Elderwood, Starfall\n\n");
        
        // Task request
        prompt.append("Generate exactly ").append(count).append(" names. ");
        prompt.append("Return ONLY a JSON array of strings, no commentary, no code fences.");
        
        return prompt.toString();
    }
}