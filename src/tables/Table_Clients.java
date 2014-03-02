/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import dao.ClientsDAO;
import dao.PharmaciensDAO;
import entities.Clients;
import entities.Pharmaciens;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HoussemEddine
 */
public class Table_Clients extends AbstractTableModel {
    List<Clients> listeClients = new ArrayList<Clients>();
    String []header = {"Id","Nom","Prénom","Login","Mot de Passe","E-Mail","Pays","Adresse","Code Postal","Supprimer","X"};
    int i=0;
    Object[][] data;
    Boolean chB=new Boolean(false);
    public Table_Clients() { //remplissage de la liste des medicaments
        listeClients=new ClientsDAO().GetAllClients();
        data=new Object[listeClients.size()][header.length];
        for(Clients p:listeClients){
            data[i][0]=p.getId_clt();
            
            data[i][1]=p.getNom_clt();    
            data[i][2]=p.getPrenom_clt();
            data[i][3]=p.getLogin_clt();
            data[i][4]=p.getPwd_clt();
            data[i][5]=p.getMail_clt();
            data[i][6]=p.getPays_clt();
            data[i][7]=p.getAdresse_clt();
            data[i][8]=p.getCode_postal_clt();
            data[i][9]="";
            data[i][10]=chB;
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
            if(col>8)
                return true;
            else
        return false;
            
    }
     @Override
     public String getColumnName(int column) { // retourne les noms des colonnes
        return header[column]; 
    }
    
    
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
          data[rowIndex][columnIndex]=value;                       
          fireTableCellUpdated(rowIndex, columnIndex);        
    }
    
}
