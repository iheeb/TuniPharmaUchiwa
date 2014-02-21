/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import dao.PharmaciensDAO;
import entities.Pharmaciens;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */

public class Table_Liste_Pharmacien extends AbstractTableModel{
     List<Pharmaciens> listePharmacien = new ArrayList<Pharmaciens>();
    String []header = {"id","Nom","Prénom","CIN","Diplome","Login","Mot de passe","Date de naissance","Adress","numtel","mail"};

    public Table_Liste_Pharmacien() { //remplissage de la liste des medicaments
        listePharmacien=new PharmaciensDAO().DisplayAllPharmaciens();
    }
    
    @Override
    public int getRowCount() { //nombre de lignes de la table
        return listePharmacien.size();
    }

    @Override
    public int getColumnCount() { //nombre de colonnes de la table
        return header.length;
    }

    //récupération de chaque élément de la table
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) { 
        switch (columnIndex) {// parcour par colonne
            case 0://colonne id_medicament
                return listePharmacien.get(rowIndex).getId_pharmacien();
            case 1://colonne id_medicament
                return listePharmacien.get(rowIndex).getNom_pharmacien();
            case 2://colonne reference
                return listePharmacien.get(rowIndex).getPrenom_pharmacien();
            case 3://colonne nom
                return listePharmacien.get(rowIndex).getCin_pharmacien();
            case 4://colonne categorie
                return listePharmacien.get(rowIndex).getDiplome_pharmacien();
            case 5://colonne description
                return listePharmacien.get(rowIndex).getLogin_pharmacien();
            case 6://colonne forme
                return listePharmacien.get(rowIndex).getPwd_pharmacien();
            case 7://colonne forme
                return listePharmacien.get(rowIndex).getDate_naiss_pharmacien();
            case 8://colonne forme
                return listePharmacien.get(rowIndex).getAdresse_pharmacien();
            case 9://colonne forme
                return listePharmacien.get(rowIndex).getNumtel_pahramcien();
            case 10://colonne forme
                return listePharmacien.get(rowIndex).getMail_pharamacien();
                                
                
                
                
                
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) { // nom des colonnes
        return header[column]; 
    }
    
}
