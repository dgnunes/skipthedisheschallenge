/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanhackathon.javachallenge.dao;

import com.vanhackathon.javachallenge.dao.connection.JDBCConnection;
import com.vanhackathon.javachallenge.model.Store;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author douglas
 */
public class StoreDAO {

    public List<Store> searchByCousine(String id) {
        List<Store> result = new ArrayList<>();
        
        try (Connection con = JDBCConnection.getDBConnection();){
            PreparedStatement pstmt = con.prepareStatement("SELECT STOREID,STORENAME,STOREADDRESS,COUSINEID  FROM DBUSER.STORE WHERE COUSINEID = ? ");
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();
          
          while (rs.next()){
              Store store = new Store(rs.getInt("STOREID"),rs.getString("STORENAME"),rs.getString("STOREADDRESS"), rs.getInt("COUSINEID"));
              result.add(store);
          }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }

    public List<Store> listAll() {
         List<Store> result = new ArrayList<>();
        
        try (Connection con = JDBCConnection.getDBConnection();){
            PreparedStatement pstmt = con.prepareStatement("SELECT STOREID,STORENAME,STOREADDRESS,COUSINEID  FROM DBUSER.STORE");
            ResultSet rs = pstmt.executeQuery();
          
          while (rs.next()){
              Store store = new Store(rs.getInt("STOREID"),rs.getString("STORENAME"),rs.getString("STOREADDRESS"), rs.getInt("COUSINEID"));
              result.add(store);
          }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }

    public List<Store> searchByName(String text) {
        List<Store> result = new ArrayList<>();
        
        try (Connection con = JDBCConnection.getDBConnection();){
            PreparedStatement pstmt = con.prepareStatement("SELECT STOREID,STORENAME,STOREADDRESS,COUSINEID  FROM DBUSER.STORE WHERE STORENAME LIKE ? ");
            pstmt.setString(1, "%" + text.trim() + "%");
            ResultSet rs = pstmt.executeQuery();
          
          while (rs.next()){
              Store store = new Store(rs.getInt("STOREID"),rs.getString("STORENAME"),rs.getString("STOREADDRESS"), rs.getInt("COUSINEID"));
              result.add(store);
          }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }

    public Store searchById(String id) {
        Store result = new Store();
        
        try (Connection con = JDBCConnection.getDBConnection();){
            PreparedStatement pstmt = con.prepareStatement("SELECT STOREID,STORENAME,STOREADDRESS,COUSINEID  FROM DBUSER.STORE WHERE STOREID = ? ");
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();
          
          while (rs.next()){
             result = new Store(rs.getInt("STOREID"),rs.getString("STORENAME"),rs.getString("STOREADDRESS"), rs.getInt("COUSINEID"));
          }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }
    
}
