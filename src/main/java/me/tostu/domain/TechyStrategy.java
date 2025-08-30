package me.tostu.domain;

public class TechyStrategy implements NameGenerationStrategy {
    
    @Override
    public String buildPrompt(NameRequest request) {
        int count = (request.count() == null || request.count() <= 0) ? 10 : request.count();
        String context = request.context() == null ? "(no additional context)" : request.context().trim();
        
        StringBuilder prompt = new StringBuilder();
        
        // Instruction
        prompt.append("Generate modern, tech-sounding names for: ").append(context).append("\n\n");
        
        // Rules
        prompt.append("RULES:\n");
        prompt.append("- Use contemporary tech naming patterns\n");
        prompt.append("- Avoid numbers unless specifically relevant to the context\n");
        prompt.append("- Prefer compound words or portmanteau constructions\n");
        prompt.append("- Should sound innovative and forward-thinking\n");
        prompt.append("- Can include tech-related suffixes like -ly, -ify, -hub, -stack\n\n");
        
        // Examples
        prompt.append("EXAMPLES: GitHub, TypeScript, MongoDB, CloudFlare, Vercel\n\n");
        
        // Task request
        prompt.append("Generate exactly ").append(count).append(" names. ");
        prompt.append("Return ONLY a JSON array of strings, no commentary, no code fences.");
        
        return prompt.toString();
    }
}