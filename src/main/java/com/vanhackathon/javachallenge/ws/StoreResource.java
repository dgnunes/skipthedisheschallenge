/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanhackathon.javachallenge.ws;

import com.vanhackathon.javachallenge.model.Product;
import com.vanhackathon.javachallenge.model.Store;
import com.vanhackathon.javachallenge.service.ProductService;
import com.vanhackathon.javachallenge.service.StoreService;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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
@Path("Store")
public class StoreResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StoreResource
     */
    public StoreResource() {
    }

    /**
     * Retrieves representation of an instance of com.vanhackathon.javachallenge.ws.StoreResource
     * @return an instance of com.vanhackathon.javachallenge.model.Store
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Store> listAll() {
        StoreService storeService = new StoreService();
        List<Store> listStore = storeService.listAll();
        
        return listStore;
    }
    
    @GET
    @Path("search/{text}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Store> searchByName(@PathParam("text") String text) {
        StoreService storeService = new StoreService();
        List<Store> listStore = storeService.searchByName(text);
        
        return listStore;
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Store searchById(@PathParam("id") String id) {
        StoreService storeService = new StoreService();
        Store store = storeService.searchById(id);
        
        return store;
    }


    @GET
    @Path("{id}/products")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> searchProducts(@PathParam("id") String id) {
        ProductService productService = new ProductService();
        List<Product> listProduct = productService.searchByStoreId(id);
        
        return listProduct;
    }
    
    /**
     * 
     * 
     * PUT method for updating or creating an instance of StoreResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Store content) {
    }
}
