/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanhackathon.javachallenge.ws;

import com.vanhackathon.javachallenge.model.Product;
import com.vanhackathon.javachallenge.service.ProductService;
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
@Path("Product")
public class ProductResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductResource
     */
    public ProductResource() {
    }

    /**
     * Retrieves representation of an instance of com.vanhackathon.javachallenge.ws.ProductResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> listAll() {
        ProductService productService = new ProductService();
        
        return productService.listAll();
    }

    @GET
    @Path("search/{text}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> searchByName(@PathParam("text") String text) {
       ProductService productService = new ProductService();
        
        return productService.searchByName(text);
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product searchById(@PathParam("id") int id) {
       ProductService productService = new ProductService();
        
       return productService.searchById(id);
    }
    
    /**
     * PUT method for updating or creating an instance of ProductResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
