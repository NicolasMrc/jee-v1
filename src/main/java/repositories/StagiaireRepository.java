/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Stagiaire;
import entities.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBConnection;


/**
 *
 * @author Nico
 */
public class StagiaireRepository {

    public ArrayList<Stagiaire> getStagiaireByUser(User user) {
        Connection conn = DBConnection.getConnection();
        
        ArrayList<Stagiaire> stagiaires = new ArrayList<>();
        
        try{
            String sql;
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, firstname, "
                    + "lastname, email, groupe, cdc, fiche_visite, fiche_eval_entr, "
                    + "sondage_web, rendu_rapport, soutenance, visite_planif, debut, fin,"
                    + "entreprise, maitre_stage, adresse,"
                    + "visite_faite, note_com, note_tech, user_id"
                    + " FROM stagiaire WHERE user_id = ?");
            pstmt.setLong(1, user.getId());
            ResultSet rs = pstmt.executeQuery();
      
            while(rs.next()){
                Long id  = rs.getLong("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String groupe = rs.getString("groupe");
                boolean cdc = rs.getBoolean("cdc");
                boolean ficheVisite = rs.getBoolean("fiche_visite");
                boolean ficheEvalEntr = rs.getBoolean("fiche_eval_entr");
                boolean sondageWeb = rs.getBoolean("sondage_web");
                boolean renduRapport = rs.getBoolean("rendu_rapport");
                boolean soutenance = rs.getBoolean("soutenance");
                boolean visitePlanif = rs.getBoolean("visite_planif");
                boolean visiteFaite = rs.getBoolean("visite_faite");
                Date debut = rs.getDate("debut");
                Date fin = rs.getDate("fin");
                String entreprise = rs.getString("entreprise");
                String maitreStage = rs.getString("maitre_stage");
                String adresse  = rs.getString("adresse");
                int noteCom = rs.getInt("note_com");
                int noteTech = rs.getInt("note_tech");
                long userId = rs.getLong("user_id");

                Stagiaire stagiaire = new Stagiaire(id, firstname, lastname, email, groupe, cdc, ficheVisite, ficheEvalEntr, sondageWeb, renduRapport, soutenance, visitePlanif, visiteFaite, debut, fin, entreprise, maitreStage, adresse, noteCom, noteTech, userId);
                stagiaires.add(stagiaire);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e ){
            String message = e.getMessage();
            System.out.println("m");
        }
        return stagiaires;
    }
    
    
    public ArrayList<Stagiaire> getStagiaireByUserNull() {
        Connection conn = DBConnection.getConnection();
        
        ArrayList<Stagiaire> stagiaires = new ArrayList<>();
        
        try{
            String sql;
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, firstname, "
                    + "lastname, email, groupe, cdc, fiche_visite, fiche_eval_entr, "
                    + "sondage_web, rendu_rapport, soutenance, visite_planif, debut, fin,"
                    + "entreprise, maitre_stage, adresse,"
                    + "visite_faite, note_com, note_tech, user_id"
                    + " FROM stagiaire WHERE user_id IS NULL");
            
            ResultSet rs = pstmt.executeQuery();
      
            while(rs.next()){
                Long id  = rs.getLong("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String groupe = rs.getString("groupe");
                boolean cdc = rs.getBoolean("cdc");
                boolean ficheVisite = rs.getBoolean("fiche_visite");
                boolean ficheEvalEntr = rs.getBoolean("fiche_eval_entr");
                boolean sondageWeb = rs.getBoolean("sondage_web");
                boolean renduRapport = rs.getBoolean("rendu_rapport");
                boolean soutenance = rs.getBoolean("soutenance");
                boolean visitePlanif = rs.getBoolean("visite_planif");
                boolean visiteFaite = rs.getBoolean("visite_faite");
                Date debut = rs.getDate("debut");
                Date fin = rs.getDate("fin");
                String entreprise = rs.getString("entreprise");
                String maitreStage = rs.getString("maitre_stage");
                String adresse  = rs.getString("adresse");
                int noteCom = rs.getInt("note_com");
                int noteTech = rs.getInt("note_tech");
                long userId = rs.getLong("user_id");

                Stagiaire stagiaire = new Stagiaire(id, firstname, lastname, email, groupe, cdc, ficheVisite, ficheEvalEntr, sondageWeb, soutenance, renduRapport, visitePlanif, visiteFaite, debut, fin, entreprise, maitreStage, adresse, noteCom, noteTech, userId);
                stagiaires.add(stagiaire);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e ){
            String message = e.getMessage();
            System.out.println("m");
        }
        return stagiaires;
    }

    public Stagiaire getStagiaireById(long idInput) {
        Stagiaire stagiaire = null;
        try {
            Connection conn = DBConnection.getConnection();
            String sql;
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, firstname, "
                    + "lastname, email, groupe, cdc, fiche_visite, fiche_eval_entr, "
                    + "sondage_web, rendu_rapport, soutenance, visite_planif, debut, fin,"
                    + "entreprise, maitre_stage, adresse,"
                    + "visite_faite, note_com, note_tech, user_id"
                    + " FROM stagiaire WHERE id = ?");
            pstmt.setLong(1, idInput);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Long id  = rs.getLong("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String groupe = rs.getString("groupe");
                boolean cdc = rs.getBoolean("cdc");
                boolean ficheVisite = rs.getBoolean("fiche_visite");
                boolean ficheEvalEntr = rs.getBoolean("fiche_eval_entr");
                boolean sondageWeb = rs.getBoolean("sondage_web");
                boolean renduRapport = rs.getBoolean("rendu_rapport");
                boolean soutenance = rs.getBoolean("soutenance");
                boolean visitePlanif = rs.getBoolean("visite_planif");
                boolean visiteFaite = rs.getBoolean("visite_faite");
                Date debut = rs.getDate("debut");
                Date fin = rs.getDate("fin");
                String entreprise = rs.getString("entreprise");
                String maitreStage = rs.getString("maitre_stage");
                String adresse  = rs.getString("adresse");
                int noteCom = rs.getInt("note_com");
                int noteTech = rs.getInt("note_tech");
                long userId = rs.getLong("user_id");
                
                stagiaire = new Stagiaire(id, firstname, lastname, email, groupe, cdc, ficheVisite, ficheEvalEntr, sondageWeb, soutenance, renduRapport, visitePlanif, visiteFaite, debut, fin, entreprise, maitreStage, adresse, noteCom, noteTech, userId);
            }
            
            rs.close();
            pstmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(StagiaireRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return stagiaire;
    }

    public void updateStagiaire(Stagiaire stagiaire) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql;
            PreparedStatement pstmt = conn.prepareStatement("UPDATE stagiaire SET firstname = ?, "
                    + "lastname = ?, email = ?, groupe = ?, cdc = ?, fiche_visite = ?, fiche_eval_entr = ?, "
                    + "sondage_web = ?, rendu_rapport = ?, soutenance = ?, visite_planif = ?, debut = ?, fin = ?,"
                    + "entreprise = ?, maitre_stage = ?, adresse = ?,"
                    + "visite_faite = ?, note_com = ?, note_tech = ?, user_id = ? "
                    + "WHERE id = ?");
            pstmt.setString(1, stagiaire.getFirstname());
            pstmt.setString(2, stagiaire.getLastname());
            pstmt.setString(3, stagiaire.getEmail());
            pstmt.setString(4, stagiaire.getGroupe());
            pstmt.setBoolean(5, stagiaire.isCdc());
            pstmt.setBoolean(6, stagiaire.isFicheVisite());
            pstmt.setBoolean(7, stagiaire.isFicheEvalEntr());
            pstmt.setBoolean(8, stagiaire.isSondageWeb());
            pstmt.setBoolean(9, stagiaire.isRapportRendu());
            pstmt.setBoolean(10, stagiaire.isSoutenance());
            pstmt.setBoolean(11, stagiaire.isVisitePlanif());
            pstmt.setDate(12, stagiaire.getDebut());
            pstmt.setDate(13, stagiaire.getFin());
            pstmt.setString(14, stagiaire.getEntreprise());
            pstmt.setString(15, stagiaire.getMaitreStage());
            pstmt.setString(16, stagiaire.getAdresse());
            pstmt.setBoolean(17, stagiaire.isVisiteFaite());
            pstmt.setInt(18, stagiaire.getNoteCom());
            pstmt.setInt(19, stagiaire.getNoteTech());
            pstmt.setLong(20, stagiaire.getUserId());
            pstmt.setLong(21, stagiaire.getId());
            
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(StagiaireRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
