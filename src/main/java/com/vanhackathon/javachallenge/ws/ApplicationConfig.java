/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanhackathon.javachallenge.ws;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author douglas
 */
@javax.ws.rs.ApplicationPath("api/v1")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.vanhackathon.javachallenge.ws.CousineResource.class);
        resources.add(com.vanhackathon.javachallenge.ws.CustomerResource.class);
        resources.add(com.vanhackathon.javachallenge.ws.OrderResource.class);
        resources.add(com.vanhackathon.javachallenge.ws.ProductResource.class);
        resources.add(com.vanhackathon.javachallenge.ws.StoreResource.class);
    }
    
}
