package org.acme.security.openid.connect.client;

import org.eclipse.microprofile.jwt.JsonWebToken;

import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Uni;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/protected")
@Authenticated
public class ProtectedResource {
    @Inject
    JsonWebToken principal;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("username")
    public Uni<String> userName() {
        return Uni.createFrom().item(principal.getName());
    }

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.TEXT_PLAIN)
    @Path("adminname")
    public Uni<String> adminName() {
        return Uni.createFrom().item(principal.getName());
    }
}
