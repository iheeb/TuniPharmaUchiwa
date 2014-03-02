/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import dao.MedicamentsDAO;
import entities.Medicaments;
import entities.Pharmaciens;
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
    int i=0;
    Boolean chB=new Boolean(false);
    Object[][] data;
    String []header = {"id","Référence","Nom","Classe","Description","Forme","X","","Quantité","image"};
    
    

    public Table_Medicament() { //remplissage de la liste des medicaments
        listMedicament= new MedicamentsDAO().DisplayAllMedicaments();
        data=new Object[listMedicament.size()][header.length];
        for(Medicaments p:listMedicament){
            data[i][0]=p.getId_med();
            data[i][1]=p.getReference_med();
            data[i][2]=p.getNom_med();    
            data[i][3]=p.getClasse_med();  
            data[i][4]=p.getDescription_med();
            data[i][5]=p.getForme_med();
            data[i][6]=chB;
            data[i][7]="";
            data[i][8]=p.getQte();
            data[i][9]=p.getImage_med();
            i++;           
        }
    }
    public Table_Medicament(int id) { //remplissage de la liste des medicaments
        listMedicament= new MedicamentsDAO().DisplayMedicamentsPharmacie(id);
        data=new Object[listMedicament.size()][header.length];
        for(Medicaments p:listMedicament){
            data[i][0]=p.getId_med();
            data[i][1]=p.getReference_med();
            data[i][2]=p.getNom_med();    
            data[i][3]=p.getClasse_med();  
            data[i][4]=p.getDescription_med();
            data[i][5]=p.getForme_med();
            data[i][6]=chB;
            data[i][7]="";
            data[i][8]=p.getQte();
            data[i][9]=p.getImage_med();
            i++;           
        }
    }
  public Table_Medicament(int id,String nom) { //remplissage de la liste des medicaments
        listMedicament= new MedicamentsDAO().DisplayMedicamentsPharmacie_parNom(id, nom);
        data=new Object[listMedicament.size()][header.length];
        for(Medicaments p:listMedicament){
            data[i][0]=p.getId_med();
            data[i][1]=p.getReference_med();
            data[i][2]=p.getNom_med();    
            data[i][3]=p.getClasse_med();  
            data[i][4]=p.getDescription_med();
            data[i][5]=p.getForme_med();
            data[i][6]=chB;
            data[i][7]="";
            data[i][8]=p.getQte();
            data[i][9]=p.getImage_med();
            i++;           
        }
    }

    //récupération de chaque élément de la table
   
    
   @Override
    public int getRowCount() { //nombre de lignes de la table
        return data.length;
    }

    @Override
    public int getColumnCount() { //nombre de colonnes de la table
        return header.length;
    }
     
    public Class getColumnClass(int columnIndex) {
         
        return getValueAt(0, columnIndex).getClass();
    }

    //récupération de chaque élément de la table
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) { 
        return data[rowIndex][columnIndex];     
    }
    
     @Override
    public boolean isCellEditable(int row, int col) {   
            if(col>5)
                return true;
            else
        return false;    
    }
     @Override
     public String getColumnName(int column) { // retourne les noms des colonnes
        return header[column]; 
    }
    @Override
    public void tableChanged(TableModelEvent e) {
        
    }
    
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = value;    
        fireTableCellUpdated(rowIndex, columnIndex);        
    }
    
   
}

