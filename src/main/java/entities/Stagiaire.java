/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Nico
 */
@Entity
public class Stagiaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    private String firstname;
    private String lastname;
    private String email;
    private String groupe;
    private boolean cdc;
    private boolean ficheVisite;
    private boolean ficheEvalEntr;
    private boolean sondageWeb;
    private boolean rapportRendu;
    private boolean soutenance;
    private boolean visitePlanif;
    private boolean visiteFaite;
    private Date debut;
    private Date fin;
    private String entreprise;
    private String maitreStage;
    private String adresse;
    private int noteCom;
    private int noteTech;
    private long userId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getMaitreStage() {
        return maitreStage;
    }

    public void setMaitreStage(String maitreStage) {
        this.maitreStage = maitreStage;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    
    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public boolean isCdc() {
        return cdc;
    }

    public void setCdc(boolean cdc) {
        this.cdc = cdc;
    }

    public boolean isFicheVisite() {
        return ficheVisite;
    }

    public void setFicheVisite(boolean ficheVisite) {
        this.ficheVisite = ficheVisite;
    }

    public boolean isFicheEvalEntr() {
        return ficheEvalEntr;
    }

    public void setFicheEvalEntr(boolean ficheEvalEntr) {
        this.ficheEvalEntr = ficheEvalEntr;
    }

    public boolean isSondageWeb() {
        return sondageWeb;
    }

    public void setSondageWeb(boolean sondageWeb) {
        this.sondageWeb = sondageWeb;
    }

    public boolean isRapportRendu() {
        return rapportRendu;
    }

    public void setRapportRendu(boolean rapportRendu) {
        this.rapportRendu = rapportRendu;
    }

    public boolean isSoutenance() {
        return soutenance;
    }

    public void setSoutenance(boolean soutenance) {
        this.soutenance = soutenance;
    }

    public boolean isVisitePlanif() {
        return visitePlanif;
    }

    public void setVisitePlanif(boolean visitePlanif) {
        this.visitePlanif = visitePlanif;
    }

    public boolean isVisiteFaite() {
        return visiteFaite;
    }

    public void setVisiteFaite(boolean visiteFaite) {
        this.visiteFaite = visiteFaite;
    }

    public int getNoteCom() {
        return noteCom;
    }

    public void setNoteCom(int noteCom) {
        this.noteCom = noteCom;
    }

    public int getNoteTech() {
        return noteTech;
    }

    public void setNoteTech(int noteTech) {
        this.noteTech = noteTech;
    }

    
    public Stagiaire(){
        this.firstname = "";
        this.lastname = "";
        this.email = "";
    }

    public Stagiaire(Long id, String firstname, String lastname, String email, String groupe, boolean cdc, boolean ficheVisite, boolean ficheEvalEntr, boolean sondageWeb, boolean rapportRendu, boolean soutenance, boolean visitePlanif, boolean visiteFaite, Date debut, Date fin, String entreprise, String maitreStage, String adresse, int noteCom, int noteTech, long userId) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.groupe = groupe;
        this.cdc = cdc;
        this.ficheVisite = ficheVisite;
        this.ficheEvalEntr = ficheEvalEntr;
        this.sondageWeb = sondageWeb;
        this.rapportRendu = rapportRendu;
        this.soutenance = soutenance;
        this.visitePlanif = visitePlanif;
        this.visiteFaite = visiteFaite;
        this.debut = debut;
        this.fin = fin;
        this.entreprise = entreprise;
        this.maitreStage = maitreStage;
        this.adresse = adresse;
        this.noteCom = noteCom;
        this.noteTech = noteTech;
        this.userId = userId;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stagiaire)) {
            return false;
        }
        Stagiaire other = (Stagiaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.User[ id=" + id + " ]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
