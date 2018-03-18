/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanhackathon.javachallenge.ws;

import com.vanhackathon.javachallenge.model.Cousine;
import com.vanhackathon.javachallenge.model.Store;
import com.vanhackathon.javachallenge.service.CousineService;
import com.vanhackathon.javachallenge.service.StoreService;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author douglas
 */
@Path("Cousine")
public class CousineResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CousineResource
     */
    public CousineResource() {
    }

    /**
     * Retrieves representation of an instance of com.vanhackathon.javachallenge.ws.CousineResource
     * @return an instance of com.vanhackathon.javachallenge.model.Cousine
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cousine> listAll() {
        CousineService cousineService = new CousineService();
        List<Cousine> listCousine = cousineService.listAll();
        
        return listCousine;
    }

    
    @GET
    @Path("search/{text}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cousine> searchByName(@PathParam("text") String text) {
        CousineService cousineService = new CousineService();
        List<Cousine> listCousine = cousineService.searchByName(text);
        
        return listCousine;
    }
    
    @GET
    @Path("{id}/stores")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Store> listStores(@PathParam("id") String id) {
        StoreService storeService = new StoreService();
        List<Store> listStore = storeService.searchByCousine(id);
        
        return listStore;
    }
    
    /**
     * PUT method for updating or creating an instance of CousineResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Cousine content) {
    }
}
