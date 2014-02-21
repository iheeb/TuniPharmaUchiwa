/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.MyConnection;
import entities.Admin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HoussemEddine
 */
public class AdminDAO {
    
    public List<Admin> GetAllAdmins (){


        List<Admin> listeadmins = new ArrayList<Admin>();

        String requete = "select login,pwd from administrateurs";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Admin admin =new Admin();
                admin.setLogin(resultat.getString(1));
                admin.setPwd(resultat.getString(2));

                listeadmins.add(admin);
            }
            return listeadmins;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement d'admins "+ex.getMessage());
            return null;
        }
    }
    
}
