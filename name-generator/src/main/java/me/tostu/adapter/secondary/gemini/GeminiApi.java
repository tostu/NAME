package me.tostu.adapter.secondary.gemini;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import me.tostu.adapter.secondary.gemini.model.GeminiRequest;
import me.tostu.adapter.secondary.gemini.model.GeminiResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/v1beta/models")
@RegisterRestClient(configKey = "gemini")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface GeminiApi {

    @POST
    @Path("/{model}:generateContent")
    GeminiResponse generateContent(@PathParam("model") String model,
                                   @QueryParam("key") String apiKey,
                                   GeminiRequest request);
}
