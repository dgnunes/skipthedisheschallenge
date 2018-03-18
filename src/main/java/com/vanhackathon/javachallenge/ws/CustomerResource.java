/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanhackathon.javachallenge.ws;

import com.vanhackathon.javachallenge.model.Customer;
import com.vanhackathon.javachallenge.service.CustomerService;
import java.util.function.Consumer;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;

/**
 * REST Web Service
 *
 * @author douglas
 */
@Path("Customer")
public class CustomerResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CustomerResource
     */
    public CustomerResource() {
    }

    /**
     * Retrieves representation of an instance of com.vanhackathon.javachallenge.ws.CustomerResource
     * @return an instance of com.vanhackathon.javachallenge.model.Customer
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer insertCustomer(Customer customer) {
        CustomerService customerService = new CustomerService();
        
        return customerService.insertCustomer(customer);
    }

    @POST
    @Path("auth")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String authenticate(@HeaderParam("email") String email, @HeaderParam("password") String password) {
        CustomerService customerService = new CustomerService();
        
        return customerService.authenticate(email, password);
    }
    
}
