package org.acme.security.openid.connect.client;

import org.acme.security.openid.connect.client.GoogleCalendarClient.Event;
import org.acme.security.openid.connect.client.GoogleCalendarClient.Time;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/frontend")
public class FrontendResource {
    @Inject
    @RestClient
    RestClientWithOidcClientFilter restClientWithOidcClientFilter;

    @Inject
    @RestClient
    RestClientWithTokenPropagationFilter restClientWithTokenPropagationFilter;

    @Inject
    @RestClient
    GoogleCalendarClient calendarClient;

    @GET
    @Path("user-name-with-oidc-client-token")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> getUserNameWithOidcClientToken() {
        return restClientWithOidcClientFilter.getUsername();
    }

    @GET
    @Path("admin-name-with-oidc-client-token")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> getAdminNameWithOidcClientToken() {
        return restClientWithOidcClientFilter.getAdminname();
    }

    @GET
    @Path("user-name-with-propagated-token")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> getUserNameWithPropagatedToken() {
        return restClientWithTokenPropagationFilter.getUsername();
    }

    @GET
    @Path("admin-name-with-propagated-token")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> getAdminNameWithPropagatedToken() {
        return restClientWithTokenPropagationFilter.getAdminname();
    }

    @GET
    @Path("calendar")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> calendar() {
        return calendarClient.listEvents();
    }
}
