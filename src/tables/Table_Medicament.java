/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import dao.MedicamentsDAO;
import entities.Medicaments;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HoussemEddine
 */
public class Table_Medicament extends AbstractTableModel {
    
    List<Medicaments> listMedicament = new ArrayList<Medicaments>();
    
    String []header = {"id","Référence","Nom","Classe","Description","Forme"};

    public Table_Medicament() { //remplissage de la liste des medicaments
        listMedicament=new MedicamentsDAO().DisplayAllMedicaments();
    }
    
    public int getRowCount() { //nombre de lignes de la table
        return listMedicament.size();
    }

    public int getColumnCount() { //nombre de colonnes de la table
        return header.length;
    }

    //récupération de chaque élément de la table
    public Object getValueAt(int rowIndex, int columnIndex) { 
        switch (columnIndex) {// parcour par colonne
            case 0://colonne id_medicament
                return listMedicament.get(rowIndex).getId_med();
            case 1://colonne reference
                return listMedicament.get(rowIndex).getReference_med();
            case 2://colonne nom
                return listMedicament.get(rowIndex).getNom_med();
            case 3://colonne categorie
                return listMedicament.get(rowIndex).getClasse_med();
            case 4://colonne description
                return listMedicament.get(rowIndex).getDescription_med();
            case 5://colonne forme
                return listMedicament.get(rowIndex).getForme_med();
            default:
                return null;
        }
    }
    
   
     @Override
        public boolean isCellEditable(int row, int col) {
                    return true;
            
        } 

    
}
