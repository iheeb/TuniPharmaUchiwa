/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import dao.MedicamentsDAO;
import dao.PharmacieDAO;
import entities.Medicaments;
import entities.Pharmacies;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gaston
 */
public class Table_Pharmacie extends AbstractTableModel{
    
    
     List<Pharmacies> listPharmacie = new ArrayList<Pharmacies>();
    String []header = {"id","Nom_ph","Adresse_ph","Num_tel","Longitude","Altitude","Type_ph","Gouvernorat","Delegation","Localite"};

    public Table_Pharmacie() { //remplissage de la liste des Pharmacies
        listPharmacie=new PharmacieDAO().DisplayAllPharmacies();
    }

    
    public int getRowCount() {       // retourne le nbr de la ligne de la table
        return listPharmacie.size();  
    }

   
    public int getColumnCount() {  //retourne nombre de colonnes de la table
        return header.length;
    }

    
    
    
    //récupération de chaque élément de la table
    
    public Object getValueAt(int rowIndex, int columnIndex) 
            
       {
        
        
        switch (columnIndex) {// parcour par colonne
            case 0://colonne id du pharmacie 
                return listPharmacie.get(rowIndex).getId_ph();
            case 1://colonne nom
                return listPharmacie.get(rowIndex).getNom_ph();
            case 2://colonne adresse
                return listPharmacie.get(rowIndex).getAdresse_ph();
            case 3://colonne numero de telephone 
                return listPharmacie.get(rowIndex).getNum_tel();
            case 4://colonne longitude
                return listPharmacie.get(rowIndex).getLongitude();
            case 5://colonne altitude
                return listPharmacie.get(rowIndex).getAltitude();
            case 6://colonne type de pharmacie
                return listPharmacie.get(rowIndex).getType_ph();
            case 7://colonne gouvernorat
                return listPharmacie.get(rowIndex).getGouvernorat();
             case 8://colonne delegation
                return listPharmacie.get(rowIndex).getDelegation();
             case 9://colonne localité
                return listPharmacie.get(rowIndex).getLocalite();
                                
            default:
                return null;
        }
        
    }
    
    
    public String getColumnName(int column) { // retourne les noms des colonnes
        return header[column]; 
    }

    
}
