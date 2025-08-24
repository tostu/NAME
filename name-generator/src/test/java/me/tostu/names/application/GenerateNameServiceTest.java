package me.tostu.names.application;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import me.tostu.application.GenerateNameService;
import me.tostu.domain.NameGeneratorPort;
import me.tostu.domain.NameRequest;
import me.tostu.domain.NameSuggestion;
import me.tostu.domain.NameTemplate;
import org.junit.jupiter.api.Test;

class GenerateNameServiceTest {

    static class CapturingFakeGenerator implements NameGeneratorPort {
        NameRequest last;
        @Override
        public NameSuggestion generate(NameRequest request) {
            this.last = request;
            return new NameSuggestion(Arrays.asList("Alpha", "Beta", "Gamma"));
        }
    }

    @Test
    void defaults_and_prompt_are_applied() {
        CapturingFakeGenerator fake = new CapturingFakeGenerator();
        GenerateNameService svc = new GenerateNameService(fake);

        NameRequest req = new NameRequest(null, "solar analytics for homes", null);

        NameSuggestion result = svc.generateNames(req);

        assertNotNull(result);
        List<String> names = result.names();
        assertEquals(3, names.size());

        assertNotNull(fake.last);
        assertNotNull(fake.last.context());
        String prompt = fake.last.context();
        assertTrue(prompt.toLowerCase().contains("generate 10"));
        assertTrue(prompt.toLowerCase().contains("brand-friendly"));
        assertTrue(prompt.contains("Return ONLY a JSON array"));
    }

    @Test
    void uses_specified_template_and_count() {
        CapturingFakeGenerator fake = new CapturingFakeGenerator();
        GenerateNameService svc = new GenerateNameService(fake);

        NameRequest req = new NameRequest(NameTemplate.SHORT_AND_CATCHY, "ai fintech app", 5);

        svc.generateNames(req);

        String prompt = fake.last.context();
        assertTrue(prompt.toLowerCase().contains("generate 5"));
        assertTrue(prompt.toLowerCase().contains("short"));
    }
}
