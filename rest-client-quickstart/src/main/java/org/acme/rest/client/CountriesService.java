package org.acme.rest.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.Set;

@Path("/all")
@RegisterRestClient
public interface CountriesService {

    @GET
    Set<Country> getByRegion(@QueryParam String region);
}