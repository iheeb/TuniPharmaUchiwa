/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Iheb
 */
public class Commentaire {
    
    private int id_commentaire ;
    private int id_clt_commentaire;
    private int id_ph_commentaire;
    private String commentaire ;

    public int getId_commentaire() {
        return id_commentaire;
    }

    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public int getId_clt_commentaire() {
        return id_clt_commentaire;
    }

    public void setId_clt_commentaire(int id_clt_commentaire) {
        this.id_clt_commentaire = id_clt_commentaire;
    }

    public int getId_ph_commentaire() {
        return id_ph_commentaire;
    }

    public void setId_ph_commentaire(int id_ph_commentaire) {
        this.id_ph_commentaire = id_ph_commentaire;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
  


    
}
