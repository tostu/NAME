package me.tostu.adapter.primary.web;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import me.tostu.application.GenerateNameService;
import me.tostu.domain.NameRequest;
import me.tostu.domain.NameSuggestion;
import me.tostu.domain.NameTemplate;
import org.jboss.resteasy.reactive.RestForm;

@Path("/")
public class PageResource {

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance index(NameTemplate[] templates);
        public static native TemplateInstance results(List<String> names);
    }

    @Inject
    GenerateNameService service;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance index() {
        return Templates.index(NameTemplate.values());
    }

    @POST
    @Path("ui/generate")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance generate(
            @RestForm NameTemplate template,
            @RestForm String context,
            @RestForm Integer count) {
        NameRequest req = new NameRequest(template, context, count);

        NameSuggestion suggestion = service.generateNames(req);
        List<String> names = (suggestion != null && suggestion.names() != null) ? suggestion.names() : java.util.List.of();
        return Templates.results(names);
    }
}
