/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import dao.MedicamentsDAO;
import entities.Medicaments;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HoussemEddine
 */
public class Table_Medicament extends AbstractTableModel implements TableModelListener {
    
    List<Medicaments> listMedicament = new ArrayList<Medicaments>();
    
    String []header = {"id","Référence","Nom","Classe","Description","Forme","knk","bouton"};
    
    

    public Table_Medicament() { //remplissage de la liste des medicaments
        listMedicament= new MedicamentsDAO().DisplayAllMedicaments();
        this.addTableModelListener(this);
    }
    
    public int getRowCount() { //nombre de lignes de la table
        return listMedicament.size();
    }

    public int getColumnCount() { //nombre de colonnes de la table
        return header.length;
    }
   
    public Class getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    //récupération de chaque élément de la table
    public Object getValueAt(int rowIndex, int columnIndex) { 
        switch (columnIndex) {// parcour par colonne
            case 0://colonne id du pharmacie 
                return listMedicament.get(rowIndex).getId_med();
            case 1://colonne nom
                return listMedicament.get(rowIndex).getReference_med();
            case 2://colonne adresse
                return listMedicament.get(rowIndex).getNom_med();
            case 3://colonne numero de telephone 
                return listMedicament.get(rowIndex).getClasse_med();          
            case 4://colonne altitude
                return listMedicament.get(rowIndex).getDescription_med();
            case 5://colonne type de pharmacie
                return listMedicament.get(rowIndex).getForme_med();
            case 6:
                
                   //  return   this.get(rowIndex);
            case 7://colonne type de pharmacie
                return listMedicament.get(rowIndex).getChBox(); 
            default:
                return null;
        }
    }
    
   public boolean isCellEditable(int row, int col) {   
            return true;    
    }
     public String getColumnName(int column) { // retourne les noms des colonnes
        return header[column]; 
    }
    @Override
    public void tableChanged(TableModelEvent e) {
        
    }
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        switch (columnIndex) {// parcour par colonne
            case 0://colonne id du pharmacie 
                listMedicament.get(rowIndex).setId_med((int) value);      
            case 1://colonne nom
                listMedicament.get(rowIndex).setReference_med((String) value);         
            case 2://colonne adresse
                listMedicament.get(rowIndex).setNom_med((String) value);        
            case 3://colonne numero de telephone 
                listMedicament.get(rowIndex).setClasse_med((String) value);       
            case 4://colonne altitude
                listMedicament.get(rowIndex).setDescription_med((String) value);       
            case 5://colonne type de pharmacie
                listMedicament.get(rowIndex).setForme_med((String) value);        
            case 7://colonne type de pharmacie
                if(value.toString().equals("true"))
               listMedicament.get(rowIndex).setChBox(true); 
                else
                    listMedicament.get(rowIndex).setChBox(false);                 
        }
       
        fireTableCellUpdated(rowIndex, columnIndex);        
    }
    
   
}

