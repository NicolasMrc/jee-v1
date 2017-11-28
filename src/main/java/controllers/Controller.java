/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Stagiaire;
import entities.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.StagiaireRepository;
import repositories.UserRepository;

/**
 *
 * @author Nico
 */
public class Controller extends HttpServlet {

   
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if(action != null){
            switch (action){
                case "logout":
                    request.setAttribute("logout", true);
                    request.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
                    break;
                case "addIntern":
                    this.addIntern(request, response);
                    break;
            }
        } else {
            if(request.getSession().getAttribute("username") == null){
                request.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
            } else {
                request.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
            }
            
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if(action != null){
            switch (action){
                case "login":
                    this.login(request, response);
                    break;
            }
        }
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("login");
        String password = request.getParameter("password");
        
        if(request.getParameter("login").equals("")  || request.getParameter("password").equals("")){
            request.setAttribute("error", "Veuillez renseigner les deux champs");
            request.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);    
        } else {
            UserRepository userRepository = new UserRepository();
            User user = userRepository.getUserByUsernameAndPassword(request.getParameter("login"), request.getParameter("password"));
            if(user == null){
                request.setAttribute("error", "Erreur de connection");
                request.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);    
            } else {
                request.getSession().setAttribute("user", user);
                StagiaireRepository stagiaireRepository = new StagiaireRepository();
                ArrayList<Stagiaire> stagiaires = stagiaireRepository.getStagiaireByUser(user);
                request.getSession().setAttribute("stagiaires", stagiaires);
                request.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);    
            }
        }
    }
    
    private void addIntern(HttpServletRequest request, HttpServletResponse response) {
        StagiaireRepository stagiaireRepository = new StagiaireRepository();
        if(request.getParameter("id") == null){
            ArrayList<Stagiaire> stagiaires = stagiaireRepository.getStagiaireByUserNull();
            request.setAttribute("stagiaires", stagiaires);
            try {       
                request.getServletContext().getRequestDispatcher("/WEB-INF/views/addIntern.jsp").forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                long id = Long.valueOf(request.getParameter("id"));
                Stagiaire stagiaireToAdd = stagiaireRepository.getStagiaireById(id); 
                if(stagiaireToAdd != null){
                    User currentUser = (User)request.getSession().getAttribute("user");
                    stagiaireToAdd.setUserId(currentUser.getId());
                    stagiaireRepository.updateStagiaire(stagiaireToAdd);
                    ArrayList<Stagiaire> stagiaires = stagiaireRepository.getStagiaireByUser(currentUser);
                    request.getSession().setAttribute("stagiaires", stagiaires);
                   
                }
                request.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
