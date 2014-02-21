/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Commentaire;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.MyConnection;

/**
 *
 * @author Iheb
 */
public class CommentaireDAO {
    
    public List<Commentaire> GetAllComments (){


        List<Commentaire> listeCommentaire = new ArrayList<Commentaire>();

        String requete = "select * from commentaires";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Commentaire commentaire =new Commentaire();
                commentaire.setId_commentaire(resultat.getInt(1));
                commentaire.setId_ph_commentaire(resultat.getInt(2));
                commentaire.setId_clt_commentaire(resultat.getInt(3));
                commentaire.setCommentaire(resultat.getString(4));

                listeCommentaire.add(commentaire);
            }
            return listeCommentaire;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement d'admins "+ex.getMessage());
            return null;
        }
    }
    

    
    
}
