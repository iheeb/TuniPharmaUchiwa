/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entities.Pharmaciens;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.MyConnection;



/**
 *
 * @author user
 */
public class PharmaciensDAO {
    public void insertPharmaciens(Pharmaciens ph){

        String requete = "insert into pharmaciens (nom,prenom,reference_ph,login,pwd,mail,diplome,cin,date_naiss,num_ph,adresse,code_postal,etat) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, ph.getNom_pharmacien());
            ps.setString(2, ph.getPrenom_pharmacien());
            ps.setString(3, ph.getReference_pharmacien());
            ps.setString(4, ph.getLogin_pharmacien());
            ps.setString(5, ph.getPwd_pharmacien());
            ps.setString(6, ph.getMail_pharamacien());
            ps.setString(7, ph.getDiplome_pharmacien());
            ps.setInt(8, ph.getCin_pharmacien());
            ps.setString(9, ph.getDate_naiss_pharmacien());
            ps.setInt(10, ph.getNumtel_pahramcien());
            ps.setString(11, ph.getAdresse_pharmacien());
            ps.setInt(12, ph.getCode_postal_pharmacien());
            ps.setInt(13, ph.getEtat_pharmacien());
              
              
                    
            ps.executeUpdate();
            System.out.println("Ajout  pharmacien effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion  de pharmaciens"+ex.getMessage());
        }
    }
    
    public void updatePharmaciens(Pharmaciens ph){
        String requete = "update Pharmaciens set nom=? prenom=? cin=? diplome=? login=?  pwd=? date_naiss=? adresse=? numtel=? mail=? where id_phar=? ";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, ph.getNom_pharmacien());
            ps.setString(2, ph.getPrenom_pharmacien());
            ps.setInt(3, ph.getCin_pharmacien());
            ps.setString(4, ph.getDiplome_pharmacien());
            ps.setString(5, ph.getLogin_pharmacien());
            ps.setString(6, ph.getPwd_pharmacien());
            ps.setString(7, ph.getDate_naiss_pharmacien());
            ps.setString(8, ph.getAdresse_pharmacien());
            ps.setInt(9, ph.getNumtel_pahramcien());
            ps.setString(10, ph.getMail_pharamacien());
         
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }
     public void deletePharmaciens(int id){
        String requete = "delete from Pharmaciens where id_phar=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Pharmaciens supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
     public List<Pharmaciens> GetAllPharmaciens (){


        List<Pharmaciens> listepharmaciens = new ArrayList<Pharmaciens>();

        String requete = "select login,pwd from pharmaciens";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Pharmaciens pharmacien =new Pharmaciens();
                pharmacien.setLogin_pharmacien(resultat.getString(1));
                pharmacien.setPwd_pharmacien(resultat.getString(2));

                listepharmaciens.add(pharmacien);
            }
            return listepharmaciens;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement de pharmacien "+ex.getMessage());
            return null;
        }
    }
    public List<Pharmaciens> DisplayAllPharmaciens (){


        List<Pharmaciens> listepharmaciens = new ArrayList<Pharmaciens>();
       
        String requete = "select * from pharmaciens";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Pharmaciens pharmaciens =new Pharmaciens();
                pharmaciens.setId_pharmacien(resultat.getInt(1));
                pharmaciens.setNom_pharmacien(resultat.getString(2));
                pharmaciens.setPrenom_pharmacien(resultat.getString(3));
                pharmaciens.setReference_pharmacien(resultat.getString(4));
                pharmaciens.setLogin_pharmacien(resultat.getString(5));
                pharmaciens.setPwd_pharmacien(resultat.getString(6));
                pharmaciens.setMail_pharamacien(resultat.getString(7));
                pharmaciens.setDiplome_pharmacien(resultat.getString(8));              
                pharmaciens.setCin_pharmacien(resultat.getInt(9));
                pharmaciens.setDate_naiss_pharmacien(resultat.getString(10));
                pharmaciens.setNumtel_pahramcien(resultat.getInt(11));
                pharmaciens.setAdresse_pharmacien(resultat.getString(12));
                pharmaciens.setCode_postal_pharmacien(resultat.getInt(13));
                pharmaciens.setEtat_pharmacien(resultat.getInt(14));
               // pharmaciens.setChBox(Boolean.FALSE);
                
                
                 
                listepharmaciens.add(pharmaciens);
            }
            return listepharmaciens;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Pharmaciens "+ex.getMessage());
            return null;
        }
    }
    
    
}
