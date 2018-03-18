/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanhackathon.javachallenge.dao;

import com.vanhackathon.javachallenge.dao.connection.JDBCConnection;
import com.vanhackathon.javachallenge.model.Customer;
import com.vanhackathon.javachallenge.model.Product;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author douglas
 */
public class CustomerDAO {
    
    public CustomerDAO() {
    }

    public Customer insertCustomer(Customer customer) {
        
        try(Connection con = JDBCConnection.getDBConnection();){
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO DBUSER.CUSTOMER (CUSTOMEREMAIL, CUSTOMERNAME, CUSTOMERADDRESS, CUSTOMERPASSWORD, CREATION) VALUES (?,?,?,?,?)");
            pstmt.setString(1, customer.getCustomerEmail());
            pstmt.setString(2, customer.getCustomerName());
            pstmt.setString(3, customer.getCustomerAddress());
            pstmt.setString(4,encryptPassword(customer.getCustomerPassword()));
            pstmt.setTimestamp(5,getCurrentTimeStamp());
            pstmt.executeUpdate();
            con.commit();
            
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        
        return searchByEmail(customer.getCustomerEmail()); 
    }

    public Customer searchById(String id) {
        Customer result = null;
        
        try (Connection con = JDBCConnection.getDBConnection();){
            PreparedStatement pstmt = con.prepareStatement("SELECT CUSTOMERID, CUSTOMEREMAIL, CUSTOMERNAME, CUSTOMERADDRESS, CUSTOMERPASSWORD, CREATION FROM DBUSER.CUSTOMER WHERE CUSTOMERID = ? ");
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();
          
          while (rs.next()){
              result = new Customer();
              result.setCustomerId(rs.getInt(1));
              result.setCustomerEmail(rs.getString(2));
              result.setCustomerName(rs.getString(3));
              result.setCustomerAddress(rs.getString(4));
              result.setCustomerPassword(rs.getString(5));
              result.setCustomerCreation(rs.getDate(6));
          }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }
    
    public Customer checkUser(String email, String password) {
        Customer result = null;
        try {
            Customer test = searchByEmail(email);
            
            if (test.getCustomerPassword().equalsIgnoreCase(encryptPassword(password))){
                result = test;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            result = null;
        }
        
        return result;
    }
        
    private static String encryptPassword(String password) throws NoSuchAlgorithmException{
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
             
        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	return hexString.toString();
    }
    
    private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

    }

    private Customer searchByEmail(String customerEmail) {
        Customer result = null;
        
        try (Connection con = JDBCConnection.getDBConnection();){
            PreparedStatement pstmt = con.prepareStatement("SELECT CUSTOMERID, CUSTOMEREMAIL, CUSTOMERNAME, CUSTOMERADDRESS, CUSTOMERPASSWORD, CREATION FROM DBUSER.CUSTOMER WHERE CUSTOMEREMAIL = ? ");
            pstmt.setString(1, customerEmail);
            ResultSet rs = pstmt.executeQuery();
          
          while (rs.next()){
              result = new Customer();
              result.setCustomerId(rs.getInt(1));
              result.setCustomerEmail(rs.getString(2));
              result.setCustomerName(rs.getString(3));
              result.setCustomerAddress(rs.getString(4));
              result.setCustomerPassword(rs.getString(5));
              result.setCustomerCreation(rs.getDate(6));
          }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }
}
