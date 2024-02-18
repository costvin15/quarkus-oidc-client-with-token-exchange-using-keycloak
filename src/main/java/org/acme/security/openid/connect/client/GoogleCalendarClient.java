package org.acme.security.openid.connect.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.oidc.token.propagation.AccessToken;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.NoArgsConstructor;

@RegisterRestClient
@AccessToken
@Path("/calendars/primary")
public interface GoogleCalendarClient {
    @POST
    @Path("events")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<String> addEvent(Event event);

    @GET
    @Path("events")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<String> listEvents();

    public static class Event {
        public String summary;
        public String kind = "calendar#event";
        public Time start;
        public Time end;
    }

    @NoArgsConstructor
    public static class Time {
        public String dateTime;
        public String timeZone = "Europe/CET";

        public Time(String value) {
            dateTime = value;
        }
    }
}
