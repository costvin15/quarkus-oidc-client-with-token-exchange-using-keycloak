package org.acme.security.openid.connect.client;

import org.jboss.resteasy.reactive.ClientWebApplicationException;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class FrontendExceptionMapper implements ExceptionMapper<ClientWebApplicationException> {
    @Override
    public Response toResponse(ClientWebApplicationException exception) {
        return Response.status(exception.getResponse().getStatus()).build();
    }    
}
