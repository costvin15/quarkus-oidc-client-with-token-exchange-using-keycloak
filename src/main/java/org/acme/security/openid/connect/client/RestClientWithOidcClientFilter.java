package org.acme.security.openid.connect.client;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.oidc.client.reactive.filter.OidcClientRequestReactiveFilter;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient
@RegisterProvider(OidcClientRequestReactiveFilter.class)
@Path("/")
public interface RestClientWithOidcClientFilter {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("username")
    Uni<String> getUsername();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("adminname")
    Uni<String> getAdminname();
}
