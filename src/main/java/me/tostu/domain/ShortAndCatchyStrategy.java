package me.tostu.domain;

public class ShortAndCatchyStrategy implements NameGenerationStrategy {
    
    @Override
    public String buildPrompt(NameRequest request) {
        int count = (request.count() == null || request.count() <= 0) ? 10 : request.count();
        String context = request.context() == null ? "(no additional context)" : request.context().trim();
        
        StringBuilder prompt = new StringBuilder();
        
        // Instruction
        prompt.append("Generate very short, catchy names for: ").append(context).append("\n\n");
        
        // Rules
        prompt.append("RULES:\n");
        prompt.append("- Maximum 8 characters in length\n");
        prompt.append("- Easy to type and remember\n");
        prompt.append("- Punchy, energetic sound\n");
        prompt.append("- Avoid complex consonant clusters\n");
        prompt.append("- Perfect for domains, handles, or app names\n\n");
        
        // Examples
        prompt.append("EXAMPLES: Bit, Hype, Flux, Zap, Vim, Git, Zip\n\n");
        
        // Task request
        prompt.append("Generate exactly ").append(count).append(" names. ");
        prompt.append("Return ONLY a JSON array of strings, no commentary, no code fences.");
        
        return prompt.toString();
    }
}