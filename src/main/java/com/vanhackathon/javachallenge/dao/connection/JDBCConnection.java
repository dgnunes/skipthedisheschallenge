/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanhackathon.javachallenge.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author douglas
 */
public class JDBCConnection {
    
    
    public static Connection getDBConnection () throws SQLException{
        
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", "dbuser");
        connectionProps.put("password", "dbuser");

        return DriverManager.getConnection("jdbc:derby://localhost:1527/vanhackathon;create=true", connectionProps);
    }
    
}
