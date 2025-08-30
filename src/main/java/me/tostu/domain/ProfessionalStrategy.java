package me.tostu.domain;

public class ProfessionalStrategy implements NameGenerationStrategy {
    
    @Override
    public String buildPrompt(NameRequest request) {
        int count = (request.count() == null || request.count() <= 0) ? 10 : request.count();
        String context = request.context() == null ? "(no additional context)" : request.context().trim();
        
        StringBuilder prompt = new StringBuilder();
        
        // Instruction
        prompt.append("Generate professional, trustworthy names for: ").append(context).append("\n\n");
        
        // Rules
        prompt.append("RULES:\n");
        prompt.append("- Convey competence and reliability\n");
        prompt.append("- Use established business naming patterns\n");
        prompt.append("- Avoid trendy or overly casual language\n");
        prompt.append("- Should work in formal business contexts\n");
        prompt.append("- Can include suffixes like -Corp, -Group, -Partners, -Solutions\n\n");
        
        // Examples
        prompt.append("EXAMPLES: Goldman Sachs, McKinsey, Deloitte, Accenture, IBM\n\n");
        
        // Task request
        prompt.append("Generate exactly ").append(count).append(" names. ");
        prompt.append("Return ONLY a JSON array of strings, no commentary, no code fences.");
        
        return prompt.toString();
    }
}