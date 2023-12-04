package org.acme.rest.client;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

import java.util.Set;
import java.util.List;

@Path("/countries")
public class CountriesResource {

    @Inject
    @RestClient
    CountriesService countriesService;

    @GET
    @Transactional
    @Path("/initialize")
    public List<Country> countries() {
        Set<Country> countries = countriesService.getByCountry();
        Country.persist(countries);

        List<Country> savedCountries = Country.findAll().list();

        return savedCountries;
    }

    @GET
    @Transactional
    public List<Country> list() {
        return Country.listAll();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Country add(Country country) {
        System.out.println(country);
        Country.persist(country);
        return country;
    }

    @DELETE
    @Transactional
    @Path("{id}")
    public void deleteById(@PathParam("id") Long id) {
        Country.deleteById(id);
    }

    @GET
    @Transactional
    @Path("{id}")
    public Country findById(@PathParam("id") Long id) {
        return Country.findById(id);
    }

}