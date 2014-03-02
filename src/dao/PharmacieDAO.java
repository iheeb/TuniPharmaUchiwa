/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entities.Pharmacies;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.MyConnection;

/**
 *
 * @author Gaston
 */
public class PharmacieDAO {
    
     public void insertPharmacie(Pharmacies ph){
    String requete = "insert into pharmacies(ref,nom_ph,adresse_ph,num_tel,longitude,attitude,type_ph,gouvernorat,delegation,localite) values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            
            ps.setString(1, ph.getRef_ph());
            ps.setString(2, ph.getNom_ph());
            ps.setString(3, ph.getAdresse_ph());
            ps.setInt(4, ph.getNum_tel());
            ps.setFloat(5, ph.getLongitude());
            ps.setFloat(6, ph.getAltitude());
            ps.setString(7, ph.getType_ph());
            ps.setString(8, ph.getGouvernorat());
            ps.setString(9, ph.getDelegation());
            ps.setString(10, ph.getLocalite());
            
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        } 
    
    
     }
     
     
      public void updatePharmacie(Pharmacies ph){
        String requete = "update Pharmacies set ref=?  nom_ph=?,adresse_ph= ?,num_tel=?,longitude=?,attitude=?,type_ph=?,gouvernorat=?,delegation=?,localite=? where id_ph =?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
             
            ps.setString(1, ph.getRef_ph());
            ps.setString(2, ph.getNom_ph());
            ps.setString(3, ph.getAdresse_ph());
            ps.setInt(4, ph.getNum_tel());
            ps.setFloat(5, ph.getLongitude());
            ps.setFloat(6, ph.getAltitude());
            ps.setString(7, ph.getType_ph());
            ps.setString(8, ph.getGouvernorat());
            ps.setString(9, ph.getDelegation());
            ps.setString(10, ph.getLocalite());
            ps.setInt(11, ph.getId_ph());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }
     
     
       public void deletePharmacie(int id){
        String requete = "delete from pharmacies where id_ph=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Pharmacie supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }

     public List<Pharmacies> DisplayAllPharmacies (){


        List<Pharmacies> listepharmacies = new ArrayList<Pharmacies>();

        String requete = "select * from pharmacies";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Pharmacies pharmacies =new Pharmacies();
                pharmacies.setId_ph(resultat.getInt(1));
                pharmacies.setRef_ph(resultat.getString(2));
                pharmacies.setNom_ph(resultat.getString(3));
                pharmacies.setAdresse_ph(resultat.getString(4));
                pharmacies.setNum_tel(resultat.getInt(5));
                pharmacies.setLongitude(resultat.getFloat(6));
                pharmacies.setAltitude(resultat.getFloat(7));
                pharmacies.setType_ph(resultat.getString(8));
                pharmacies.setGouvernorat(resultat.getString(9));
                pharmacies.setDelegation(resultat.getString(10));
                pharmacies.setLocalite(resultat.getString(11));
                
                listepharmacies.add(pharmacies);
            }
            return listepharmacies;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des pharmacies "+ex.getMessage());
            return null;
        }
    }
     
    
     
     //  methode 
       public List<Pharmacies> RechercheParGouvernorat_Delegation_Localite (String gouvernorat,String delegation,String localite ){
        
           List<Pharmacies> listepharmacies = new ArrayList<Pharmacies>();

        String requete = "select * from pharmacies where gouvernorat ='"+gouvernorat+"' AND delegation='"+delegation+"' AND localite='"+localite+"'";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                 Pharmacies pharmacies =new Pharmacies();
                pharmacies.setId_ph(resultat.getInt(1));
                pharmacies.setRef_ph(resultat.getString(2));
                pharmacies.setNom_ph(resultat.getString(3));
                pharmacies.setAdresse_ph(resultat.getString(4));
                pharmacies.setNum_tel(resultat.getInt(5));
                pharmacies.setLongitude(resultat.getFloat(6));
                pharmacies.setAltitude(resultat.getFloat(7));
                pharmacies.setType_ph(resultat.getString(8));
                pharmacies.setGouvernorat(resultat.getString(9));
                pharmacies.setDelegation(resultat.getString(10));
                pharmacies.setLocalite(resultat.getString(11));
                
                listepharmacies.add(pharmacies);
            }
            return listepharmacies;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des medicaments "+ex.getMessage());
            return null;
        }

       }
       
       public List<Pharmacies> RechercheParGouvernorat (String gouvernorat ){
        
           List<Pharmacies> listepharmacies = new ArrayList<Pharmacies>();

        String requete = "select * from pharmacies where gouvernorat ='"+gouvernorat+"'";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                 Pharmacies pharmacies =new Pharmacies();
                pharmacies.setId_ph(resultat.getInt(1));
                pharmacies.setRef_ph(resultat.getString(2));
                pharmacies.setNom_ph(resultat.getString(3));
                pharmacies.setAdresse_ph(resultat.getString(4));
                pharmacies.setNum_tel(resultat.getInt(5));
                pharmacies.setLongitude(resultat.getFloat(6));
                pharmacies.setAltitude(resultat.getFloat(7));
                pharmacies.setType_ph(resultat.getString(8));
                pharmacies.setGouvernorat(resultat.getString(9));
                pharmacies.setDelegation(resultat.getString(10));
                pharmacies.setLocalite(resultat.getString(11));
                
                listepharmacies.add(pharmacies);
            }
            return listepharmacies;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des medicaments "+ex.getMessage());
            return null;
        }
        
        

       }
       public List<Pharmacies> RechercheParGouvernorat_Delegation (String gouvernorat,String delegation ){
        
           List<Pharmacies> listepharmacies = new ArrayList<Pharmacies>();

        String requete = "select * from pharmacies where gouvernorat ='"+gouvernorat+"' AND delegation='"+delegation+"'";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                 Pharmacies pharmacies =new Pharmacies();
                pharmacies.setId_ph(resultat.getInt(1));
                pharmacies.setRef_ph(resultat.getString(2));
                pharmacies.setNom_ph(resultat.getString(3));
                pharmacies.setAdresse_ph(resultat.getString(4));
                pharmacies.setNum_tel(resultat.getInt(5));
                pharmacies.setLongitude(resultat.getFloat(6));
                pharmacies.setAltitude(resultat.getFloat(7));
                pharmacies.setType_ph(resultat.getString(8));
                pharmacies.setGouvernorat(resultat.getString(9));
                pharmacies.setDelegation(resultat.getString(10));
                pharmacies.setLocalite(resultat.getString(11));
                
                listepharmacies.add(pharmacies);
            }
            return listepharmacies;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des medicaments "+ex.getMessage());
            return null;
        }

       }
       
       public String RechercheRef (String ref ){
        
           String refer="";

        String requete = "select ref from pharmacies where ref ='"+ref+"'";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                 
                refer=resultat.getString(1);
               
            }
            return refer;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des medicaments "+ex.getMessage());
            return null;
        }
       }

     
}
