/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Clients;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.MyConnection;

/**
 *
 * @author salma
 */
public class ClientsDAO {
    
    
     public List<Clients> GetAllClients (){


        List<Clients> listeclients = new ArrayList<Clients>();

        String requete = "select * from clients";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Clients client =new Clients();
                client.setId_clt(resultat.getInt(1));
                client.setNom_clt(resultat.getString(2));
                client.setPrenom_clt(resultat.getString(3));
                client.setLogin_clt(resultat.getString(4));
                client.setPwd_clt(resultat.getString(5));
                client.setMail_clt(resultat.getString(6));
                client.setPays_clt(resultat.getString(7));
                client.setAdresse_clt(resultat.getString(8));
                client.setCode_potal_clt(resultat.getInt(9));
                
                

               listeclients.add(client);
            }
            return listeclients;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement de client "+ex.getMessage());
            return null;
        }
    }
     public void deleteClient(int id){
        String requete = "delete from clients where id_clt=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Client supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
     
     public void updateClient(Clients c){
        String requete = "update clients set login=?,pwd=? where id_clt=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
        //    ps.setString(1, c.getNom_clt());
         //   ps.setString(2, c.getPrenom_clt());
       //     ps.setString(3, c.getPrenom_clt());
            ps.setString(1, c.getLogin_clt());
            ps.setString(2, c.getPwd_clt());
         //   ps.setString(6, c.getMail_clt());
         //   ps.setString(7, c.getPays_clt());
         //   ps.setString(8, c.getAdresse_clt());
        //    ps.setInt(9, c.getCode_potal_clt());
            ps.setInt(3, c.getId_clt());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
     }
}
