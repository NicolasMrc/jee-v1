/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Nico
 */
public class DBConnection {
    
    private static final String PROPRIETESFILE = "utils/database.properties";
    
    public static Connection getConnection(){
        
        Connection conn = null;
       
        Properties properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream config = classLoader.getResourceAsStream("/utils/database.properties");
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            properties.load(config);
            String dbUrl = properties.getProperty("dburl");
            String dbUsername = properties.getProperty("dbusername");
            String dbPassword = properties.getProperty("dbpassword");
            
            conn = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
            System.err.println(e.getMessage());
        }
        return conn;
    }
}
