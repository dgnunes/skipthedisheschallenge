/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanhackathon.javachallenge.service;

import com.vanhackathon.javachallenge.dao.StoreDAO;
import com.vanhackathon.javachallenge.model.Store;
import java.util.List;

/**
 *
 * @author douglas
 */
public class StoreService {

    public List<Store> searchByCousine(String id) {
        StoreDAO dao = new StoreDAO();
        
        return dao.searchByCousine(id);
    }

    public List<Store> listAll() {
        StoreDAO dao = new StoreDAO();
        
        return dao.listAll();
    }

    public List<Store> searchByName(String text) {
        StoreDAO dao = new StoreDAO();
        
        return dao.searchByName(text);
    }

    public Store searchById(String id) {
        StoreDAO dao = new StoreDAO();
        
        return dao.searchById(id);
    }
    
}
