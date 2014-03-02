/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import dao.PharmaciensDAO;
import entities.Pharmaciens;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class Table_Liste_Demande_Ph extends AbstractTableModel implements TableModelListener{
     List<Pharmaciens> listePharmacien = new ArrayList<Pharmaciens>();
     String []header = {"Id","Nom","Prénom","Référence","E-Mail","Etat","",""};
    int i=0;
    Boolean chB=new Boolean(false);
    Object[][] data;
    
    public Table_Liste_Demande_Ph(int v) { //remplissage de la liste des medicaments
     
   
            listePharmacien=new PharmaciensDAO().DisplayDemandePharmaciens(v);
        data=new Object[listePharmacien.size()][header.length];
        for(Pharmaciens p:listePharmacien){
            data[i][0]=p.getId_pharmacien();
            data[i][1]=p.getNom_pharmacien();
            data[i][2]=p.getPrenom_pharmacien();
            data[i][3]=p.getReference_pharmacien();
            data[i][4]=p.getMail_pharamacien();
            data[i][5]=p.getEtat_pharmacien();
            data[i][6]="";           
            data[i][7]="";
            i++;
        
        }
        
    }
    
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
