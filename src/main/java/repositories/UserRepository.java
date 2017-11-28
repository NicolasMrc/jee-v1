package repositories;


import entities.User;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import utils.DBConnection;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nico
 */
public class UserRepository {
    
   /**
    * permet de recuperer la liste de tout les utilisateurs
    * @return 
    *       l ArrayList d'utilisateur
    */
    public ArrayList<User> getUsers() {
        Statement stmt = null;
        Connection conn = DBConnection.getConnection();
        ArrayList<User> users = new ArrayList<>();
        
        try{
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, username, password FROM user";
            ResultSet rs = stmt.executeQuery(sql);
      
        while(rs.next()){
            Long id  = rs.getLong("id");
            String username = rs.getString("username");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String password = rs.getString("password");

            User user = new User(id, username, password, firstname, lastname);
            users.add(user);
        }
        rs.close();
        stmt.close();
        conn.close();
        } catch (Exception e ){
            e.printStackTrace();
        }
        return users;
    }
    
    /**
     * permet de recuperer un utilisateur en fonction de son username et son mot de passe
     * @param usernameInput
     *      l'username de l'utilisateur
     * @param passwordInput
     *      le mot de passe de lutilisateur
     * @return 
     *      l'utilisateur correspondant
     */
    public User getUserByUsernameAndPassword(String usernameInput, String passwordInput){
        User user = null;
        Statement stmt = null;
        
        Connection conn = DBConnection.getConnection();
        
       try {
            
            String sql;
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, username, password, firstname, lastname FROM user WHERE username = ?");
            pstmt.setString(1, usernameInput);
            ResultSet rs = pstmt.executeQuery();
      
            while(rs.next()){
                Long id  = rs.getLong("id");
                String username = rs.getString("username");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String password = rs.getString("password");

                if(password.equals(passwordInput)){
                    user = new User(id, username, password, firstname, lastname);
                }
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
    
    /**
     * permet de creer un utilisateur en base de donnée
     * @param user
     *      l'utilisateur a ajouter
     * @return 
     *      l'utilisateur crée
     */
    public User createUser(User user){
        Statement stmt = null;
        Connection conn = DBConnection.getConnection();
        
        try {
            String sql;
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user (username, password) VALUES (?, ?)");
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.executeUpdate();
            
            stmt.close();
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return this.getUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
   
