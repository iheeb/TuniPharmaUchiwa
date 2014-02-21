/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import dao.MedicamentsDAO;
import entities.Medicaments;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gaston
 */
public class Table_Rech_Medicament extends AbstractTableModel {
    List<Medicaments> listMedicament = new ArrayList<Medicaments>();
    String []header = {"id","Référence","Nom","Catégorie","Description","Forme"};

    public Table_Rech_Medicament(String nom,String classe) { //remplissage de la liste des medicaments
        listMedicament=new MedicamentsDAO().RechercheParNom_Classe(nom, classe);
    }
    public Table_Rech_Medicament(String classe) { //remplissage de la liste des medicaments
        listMedicament=new MedicamentsDAO().RecherchePar_Classe(classe);
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
    public String getColumnName(int column) { // nom des colonnes
        return header[column]; 
    }
    
}
