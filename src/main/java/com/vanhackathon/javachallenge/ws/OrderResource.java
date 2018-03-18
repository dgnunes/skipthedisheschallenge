/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanhackathon.javachallenge.ws;

import com.vanhackathon.javachallenge.model.Customer;
import com.vanhackathon.javachallenge.model.Order;
import com.vanhackathon.javachallenge.service.AuthenticationService;
import com.vanhackathon.javachallenge.service.OrderService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author douglas
 */
@Path("Order")
public class OrderResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OrderResource
     */
    public OrderResource() {
    }

    /**
     * Retrieves representation of an instance of com.vanhackathon.javachallenge.ws.OrderResource
     * @return an instance of com.vanhackathon.javachallenge.model.Order
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order searchById(@HeaderParam("token") String token, @PathParam("id") int id){
        
        if (AuthenticationService.validateToken(token)){
            OrderService orderService = new OrderService();
            return orderService.searchById(id);
        }
        else {
            return null;
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Order placeOrder(Order order){
        
        
        
    }
    
    @GET
    @Path("customer")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer searchById(@HeaderParam("token") String token){
        
        if (AuthenticationService.validateToken(token)){
            return AuthenticationService.parseJWTId(token);
        }
        else {
            return null;
        }
    }
    
    /**
     * PUT method for updating or creating an instance of OrderResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Order content) {
    }
}
