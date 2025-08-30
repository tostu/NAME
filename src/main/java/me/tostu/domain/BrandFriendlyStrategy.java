package me.tostu.domain;

public class BrandFriendlyStrategy implements NameGenerationStrategy {
    
    @Override
    public String buildPrompt(NameRequest request) {
        int count = (request.count() == null || request.count() <= 0) ? 10 : request.count();
        String context = request.context() == null ? "(no additional context)" : request.context().trim();
        
        StringBuilder prompt = new StringBuilder();
        
        // Instruction
        prompt.append("Generate brand-friendly, memorable names for: ").append(context).append("\n\n");
        
        // Rules
        prompt.append("RULES:\n");
        prompt.append("- Names should be easy to pronounce and remember\n");
        prompt.append("- Avoid hyphens, numbers, or complex punctuation\n");
        prompt.append("- Target 2-3 syllables for optimal memorability\n");
        prompt.append("- Should work across different cultures and languages\n\n");
        
        // Examples
        prompt.append("EXAMPLES: Stripe, Slack, Zoom, Notion, Figma\n\n");
        
        // Task request
        prompt.append("Generate exactly ").append(count).append(" names. ");
        prompt.append("Return ONLY a JSON array of strings, no commentary, no code fences.");
        
        return prompt.toString();
    }
}