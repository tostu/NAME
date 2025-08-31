package me.tostu.domain;

public class ProfessionalStrategy extends AbstractNameGenerationStrategy {
    
    @Override
    protected String getInstruction(String context) {
        return "Generate professional, trustworthy names for: " + context;
    }
    
    @Override
    protected String[] getRules() {
        return new String[]{
            "Convey competence and reliability",
            "Use established business naming patterns",
            "Avoid trendy or overly casual language",
            "Should work in formal business contexts",
            "Can include suffixes like -Corp, -Group, -Partners, -Solutions"
        };
    }
    
    @Override
    protected String[] getLinguisticAspects() {
        return new String[]{
            "Use formal Latin and Greek roots for gravitas",
            "Employ clear syllable boundaries for professional enunciation",
            "Include established business suffixes (-Corp, -Group, -Associates)",
            "Favor voiceless consonants for authoritative sound",
            "Use balanced stress patterns for confident delivery"
        };
    }
    
    @Override
    protected String[] getExamples() {
        return new String[]{"Goldman Sachs", "McKinsey", "Deloitte", "Accenture", "IBM"};
    }
}