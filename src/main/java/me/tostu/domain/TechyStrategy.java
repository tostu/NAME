package me.tostu.domain;

public class TechyStrategy extends AbstractNameGenerationStrategy {
    
    @Override
    protected String getInstruction(String context) {
        return "Generate modern, tech-sounding names that directly reflect the technical nature and purpose of: " + context + 
               ". Names should immediately communicate the technology, function, or innovation behind " + context + ".";
    }
    
    @Override
    protected String[] getRules() {
        return new String[]{
            "Use contemporary tech naming patterns",
            "Avoid numbers unless specifically relevant to the context",
            "Prefer compound words or portmanteau constructions",
            "Should sound innovative and forward-thinking",
            "Can include tech-related suffixes like -ly, -ify, -hub, -stack"
        };
    }
    
    @Override
    protected String[] getLinguisticAspects() {
        return new String[]{
            "Use compound words and portmanteau formations",
            "Favor sharp consonants (k, x, z) for technical precision",
            "Include tech-familiar morphemes like -hub, -stack, -ify, -ly",
            "Use camelCase or kebab-case friendly structures",
            "Avoid ambiguous pronunciations that could confuse in international contexts"
        };
    }
    
    @Override
    protected String[] getExamples() {
        return new String[]{"GitHub", "TypeScript", "MongoDB", "CloudFlare", "Vercel"};
    }
    
    @Override
    protected String[] getAdditionalGuidance() {
        return new String[]{
            "Break down the context into technical components and use them as naming building blocks",
            "Consider how the name will appear in code imports and package names",
            "Ensure compatibility with programming language naming conventions",
            "Think about API endpoint and service naming implications",
            "Verify the name doesn't conflict with existing tech terminology",
            "Consider how it will work with common tech suffixes (.js, .py, .io)"
        };
    }
}