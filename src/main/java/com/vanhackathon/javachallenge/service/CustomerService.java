/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanhackathon.javachallenge.service;

import com.vanhackathon.javachallenge.dao.CustomerDAO;
import com.vanhackathon.javachallenge.model.Customer;
import javax.ws.rs.ForbiddenException;

/**
 *
 * @author douglas
 */
public class CustomerService {

    public String authenticate(String email, String password) {
        CustomerDAO dao = new CustomerDAO();
        
        Customer customer = dao.checkUser(email,password);
        
        if (customer != null){
            return AuthenticationService.createToken(customer);
        }
        
        throw new ForbiddenException("Invalid Password");
    }

    public Customer insertCustomer(Customer customer) {
        CustomerDAO dao = new CustomerDAO();
        
        return dao.insertCustomer(customer);
    }
    
}
