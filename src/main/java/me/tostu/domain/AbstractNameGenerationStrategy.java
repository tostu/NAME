package me.tostu.domain;

public abstract class AbstractNameGenerationStrategy implements NameGenerationStrategy {
    
    @Override
    public final String buildPrompt(NameRequest request) {
        int count = (request.count() == null || request.count() <= 0) ? 10 : request.count();
        String context = enrichContext(request.context());
        
        StringBuilder prompt = new StringBuilder();
        
        // Context Analysis & Primary Focus
        prompt.append("PRIMARY FOCUS: ").append(context.toUpperCase()).append("\n");
        prompt.append("Your generated names MUST directly relate to and incorporate elements from this context.\n\n");
        
        // Instruction
        prompt.append(getInstruction(context)).append("\n\n");
        
        // Context Integration Requirements
        prompt.append("CONTEXT INTEGRATION REQUIREMENTS:\n");
        prompt.append("- Every name must reflect key concepts, themes, or elements from: ").append(context).append("\n");
        prompt.append("- Extract meaningful keywords and concepts from the context to use as naming foundation\n");
        prompt.append("- Prioritize context relevance over generic naming patterns\n");
        prompt.append("- Names should immediately suggest their connection to: ").append(context).append("\n\n");
        
        // Rules
        prompt.append("STYLE RULES:\n");
        for (String rule : getRules()) {
            prompt.append("- ").append(rule).append("\n");
        }
        prompt.append("\n");
        
        // Linguistic Aspects
        prompt.append("LINGUISTIC ASPECTS:\n");
        for (String aspect : getLinguisticAspects()) {
            prompt.append("- ").append(aspect).append("\n");
        }
        prompt.append("\n");
        
        // Examples
        prompt.append("STYLE EXAMPLES: ").append(String.join(", ", getExamples())).append("\n\n");
        
        // Additional Guidance
        prompt.append("ADDITIONAL GUIDANCE:\n");
        for (String guidance : getAdditionalGuidance()) {
            prompt.append("- ").append(guidance).append("\n");
        }
        prompt.append("\n");
        
        // Task request
        prompt.append("Generate exactly ").append(count).append(" names. ");
        prompt.append("Return ONLY a JSON array of strings, no commentary, no code fences.");
        
        return prompt.toString();
    }
    
    private String enrichContext(String originalContext) {
        if (originalContext == null || originalContext.trim().isEmpty()) {
            return "(no additional context)";
        }
        
        String trimmed = originalContext.trim();
        
        // Add context enrichment hints
        if (trimmed.length() < 10) {
            return trimmed + " (note: brief context - consider expanding with more descriptive details)";
        }
        
        return trimmed;
    }
    
    protected abstract String getInstruction(String context);
    protected abstract String[] getRules();
    protected abstract String[] getLinguisticAspects();
    protected abstract String[] getExamples();
    protected abstract String[] getAdditionalGuidance();
}