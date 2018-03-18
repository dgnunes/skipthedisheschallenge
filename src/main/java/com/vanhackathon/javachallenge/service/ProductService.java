/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanhackathon.javachallenge.service;

import com.vanhackathon.javachallenge.dao.ProductDAO;
import com.vanhackathon.javachallenge.model.Product;
import java.util.List;

/**
 *
 * @author douglas
 */
public class ProductService {

    public List<Product> searchByStoreId(String id) {
       ProductDAO dao = new ProductDAO();
       
       return dao.searchByStoreId(id);
    }

    public List<Product> listAll() {
        ProductDAO dao = new ProductDAO();
       
       return dao.listAll();
    }

    public List<Product> searchByName(String text) {
        ProductDAO dao = new ProductDAO();
       
       return dao.searchByName(text);
    }

    public Product searchById(int id) {
       ProductDAO dao = new ProductDAO();
       
       return dao.searchById(id);
    }
    
}
