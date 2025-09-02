package me.tostu.domain;

public class FrierenStrategy extends AbstractNameGenerationStrategy {

    @Override
    protected String getInstruction(String context) {
        return "Generate simple German words for: " + context;
    }

    @Override
    protected String[] getRules() {
        return new String[]{
                "Use simple, direct German words",
                "Generate single words only - avoid compound words like EVENTPLATZ, MEETINGROOM",
                "Words should be short and functional (3-8 letters)",
                "Focus on practical, everyday German vocabulary",
                "Prioritize clarity and directness over creativity",
                "Use common German terms that directly relate to the context"
        };
    }

    @Override
    protected String[] getLinguisticAspects() {
        return new String[]{
                "Use short German words (3-8 letters)",
                "Draw from modern, practical German vocabulary",
                "Prefer simple, clear pronunciation",
                "Use uppercase format for brand-style naming"
        };
    }

    @Override
    protected String[] getExamples() {
        return new String[]{
                "TREFFEN (meeting)", "EVENT (event)", "PLATZ (place)",
                "ZEIT (time)", "RAUM (space)", "BUCH (book)"
        };
    }

    @Override
    protected String[] getAdditionalGuidance() {
        return new String[]{
                "Focus on the provided context when selecting appropriate German words",
                "Choose words that directly translate or relate to the concept",
                "Prefer straightforward, functional German terms over creative variations"
        };
    }
}
