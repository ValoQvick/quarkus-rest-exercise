package org.acme.rest.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.Set;

@Path("/all")
@RegisterRestClient
public interface CountriesService {

    @GET
    @Transactional
    Set<Country> getByCountry();
}