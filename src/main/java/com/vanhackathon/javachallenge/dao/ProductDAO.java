/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanhackathon.javachallenge.dao;

import com.vanhackathon.javachallenge.dao.connection.JDBCConnection;
import com.vanhackathon.javachallenge.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author douglas
 */
public class ProductDAO {

    public List<Product> searchByStoreId(String id) {
        List<Product> result = new ArrayList<>();
        
        try (Connection con = JDBCConnection.getDBConnection();){
            PreparedStatement pstmt = con.prepareStatement("SELECT STOREID,PRODUCTID,PRODUCTNAME,PRODUCTPRICE,PRODUCTDESCRIPTION FROM DBUSER.PRODUCT WHERE STOREID = ? ");
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();
          
          while (rs.next()){
              Product product = new Product(rs.getInt("PRODUCTID"),rs.getInt("STOREID"),rs.getString("PRODUCTNAME"), rs.getString("PRODUCTDESCRIPTION"), rs.getDouble("PRODUCTPRICE"));
              result.add(product);
          }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }

    public List<Product> listAll() {
       List<Product> result = new ArrayList<>();
        
        try (Connection con = JDBCConnection.getDBConnection();){
            PreparedStatement pstmt = con.prepareStatement("SELECT STOREID,PRODUCTID,PRODUCTNAME,PRODUCTPRICE,PRODUCTDESCRIPTION FROM DBUSER.PRODUCT");
            ResultSet rs = pstmt.executeQuery();
          
          while (rs.next()){
              Product product = new Product(rs.getInt("PRODUCTID"),rs.getInt("STOREID"),rs.getString("PRODUCTNAME"), rs.getString("PRODUCTDESCRIPTION"), rs.getDouble("PRODUCTPRICE"));
              result.add(product);
          }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }

    public List<Product> searchByName(String text) {
              List<Product> result = new ArrayList<>();
        
        try (Connection con = JDBCConnection.getDBConnection();){
            PreparedStatement pstmt = con.prepareStatement("SELECT STOREID,PRODUCTID,PRODUCTNAME,PRODUCTPRICE,PRODUCTDESCRIPTION FROM DBUSER.PRODUCT WHERE PRODUCTNAME LIKE ? ");
            pstmt.setString(1, "%" + text.trim() + "%");
            ResultSet rs = pstmt.executeQuery();
          
          while (rs.next()){
              Product product = new Product(rs.getInt("PRODUCTID"),rs.getInt("STOREID"),rs.getString("PRODUCTNAME"), rs.getString("PRODUCTDESCRIPTION"), rs.getDouble("PRODUCTPRICE"));
              result.add(product);
          }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }

    public Product searchById(int id) {
        Product result = new Product();
        
        try (Connection con = JDBCConnection.getDBConnection();){
            PreparedStatement pstmt = con.prepareStatement("SELECT STOREID,PRODUCTID,PRODUCTNAME,PRODUCTPRICE,PRODUCTDESCRIPTION FROM DBUSER.PRODUCT WHERE PRODUCTID = ? ");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
          
          while (rs.next()){
              result = new Product(rs.getInt("PRODUCTID"),rs.getInt("STOREID"),rs.getString("PRODUCTNAME"), rs.getString("PRODUCTDESCRIPTION"), rs.getDouble("PRODUCTPRICE"));
          }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }
    
}
