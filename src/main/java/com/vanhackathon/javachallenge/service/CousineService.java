/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanhackathon.javachallenge.service;

import com.vanhackathon.javachallenge.dao.CousineDAO;
import com.vanhackathon.javachallenge.model.Cousine;
import java.util.List;

/**
 *
 * @author douglas
 */
public class CousineService {
    
    public List<Cousine> listAll() {
        CousineDAO dao = new CousineDAO();
        
        return dao.listAll();
    }

    public List<Cousine> searchByName(String text) {
        CousineDAO dao = new CousineDAO();
        
        return dao.searchByName(text);
    }
    
}
