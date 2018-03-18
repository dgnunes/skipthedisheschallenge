/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanhackathon.javachallenge.dao;

import com.vanhackathon.javachallenge.dao.connection.JDBCConnection;
import com.vanhackathon.javachallenge.model.Cousine;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author douglas
 */
public class CousineDAO {

    public List<Cousine> listAll() {
        List<Cousine> result = new ArrayList<>();
        
        try (Connection con = JDBCConnection.getDBConnection();){
          PreparedStatement pstmt = con.prepareStatement("SELECT COUSINEID, COUSINENAME FROM DBUSER.COUSINE");
          ResultSet rs = pstmt.executeQuery();
          
          while (rs.next()){
              Cousine cousine = new Cousine(rs.getInt("COUSINEID"),rs.getString("COUSINENAME"));
              result.add(cousine);
          }
   
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        return result;
    }

    public List<Cousine> searchByName(String text) {
        List<Cousine> result = new ArrayList<>();
        
        System.out.println(text);
        try (Connection con = JDBCConnection.getDBConnection();){
          PreparedStatement pstmt = con.prepareStatement("SELECT COUSINEID, COUSINENAME FROM DBUSER.COUSINE WHERE COUSINENAME LIKE ? ");
          pstmt.setString(1,"%" + text.trim() + "%");
         
                  
          ResultSet rs = pstmt.executeQuery();
          
          while (rs.next()){
              Cousine cousine = new Cousine(rs.getInt("COUSINEID"),rs.getString("COUSINENAME"));
              result.add(cousine);
          }
   
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        return result;
    }
    
}
