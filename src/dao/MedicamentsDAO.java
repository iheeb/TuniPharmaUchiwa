/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Medicaments;
import util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HoussemEddine
 */
public class MedicamentsDAO {
    
    public void insertMedicament(Medicaments m){

        String requete = "insert into medicaments (reference,nom,classe,description,forme) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);      
            ps.setString(1, m.getReference_med());
            ps.setString(2, m.getNom_med());
            ps.setString(3, m.getClasse_med());
            ps.setString(4, m.getDescription_med());
            ps.setString(5, m.getForme_med());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }


    public void updateMedicament(Medicaments m){
        String requete = "update medicaments set reference=?,nom=?,classe=?,description=?,forme=? where id_med=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, m.getReference_med());
            ps.setString(2, m.getNom_med());
            ps.setString(3, m.getClasse_med());
            ps.setString(4, m.getDescription_med());
            ps.setString(5, m.getForme_med());
            ps.setInt(6, m.getId_med());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }

    public void deleteMedicament(int id){
        String requete = "delete from medicaments where id_med=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Medicament supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }

  
    public List<Medicaments> DisplayAllMedicaments (){


        List<Medicaments> listemedicaments = new ArrayList<Medicaments>();

        String requete = "select * from medicaments";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Medicaments medicaments =new Medicaments();
                medicaments.setId_med(resultat.getInt(1));
                medicaments.setReference_med(resultat.getString(2));
                medicaments.setNom_med(resultat.getString(3));
                medicaments.setClasse_med(resultat.getString(4));
                medicaments.setDescription_med(resultat.getString(5));
                medicaments.setForme_med(resultat.getString(6));

                listemedicaments.add(medicaments);
            }
            return listemedicaments;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des medicaments "+ex.getMessage());
            return null;
        }
    }
    
}
