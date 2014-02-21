/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Clients;
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

        String requete = "select login,pwd from clients";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Clients client =new Clients();
               client.setLogin_clt(resultat.getString(1));
                client.setPwd_clt(resultat.getString(2));

               listeclients.add(client);
            }
            return listeclients;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement de client "+ex.getMessage());
            return null;
        }
    }
}
