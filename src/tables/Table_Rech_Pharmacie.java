/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;
import dao.PharmacieDAO;
import entities.Pharmacies;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gaston
 */
public class Table_Rech_Pharmacie extends AbstractTableModel implements TableModelListener{
    

List<Pharmacies> listPharmacie = new ArrayList<Pharmacies>();
    String []header = {"id","Ref","Nom_ph","Adresse_ph","Num_tel","Longitude","Altitude","Type_ph","Gouvernorat","Delegation","Localite",""};
  int i=0;
    Boolean chB=new Boolean(false);
    Object[][] data;
    
     public Table_Rech_Pharmacie(String gouvernorat,String delegation,String localite) { //remplissage de la liste des pharmacies
    listPharmacie= new PharmacieDAO().RechercheParGouvernorat_Delegation_Localite(gouvernorat, delegation, localite);
    data=new Object[listPharmacie.size()][header.length];
        for(Pharmacies p:listPharmacie){
            data[i][0]=p.getId_ph();
            data[i][1]=p.getRef_ph();
            data[i][2]=p.getNom_ph();
            data[i][3]=p.getAdresse_ph();    
            data[i][4]=p.getNum_tel();  
            data[i][5]=p.getLongitude();
            data[i][6]=p.getAltitude();
            data[i][7]=p.getType_ph();
            data[i][8]=p.getGouvernorat();
            data[i][9]=p.getDelegation();
            data[i][10]=p.getLocalite();
            data[i][11]="";
            i++;           
        }
       
    }
     
     public Table_Rech_Pharmacie(String gouvernorat) { //remplissage de la liste des pharmacies
    listPharmacie= new PharmacieDAO().RechercheParGouvernorat(gouvernorat);
    data=new Object[listPharmacie.size()][header.length];
        for(Pharmacies p:listPharmacie){
            data[i][0]=p.getId_ph();
            data[i][1]=p.getRef_ph();
            data[i][2]=p.getNom_ph();
            data[i][3]=p.getAdresse_ph();    
            data[i][4]=p.getNum_tel();  
            data[i][5]=p.getLongitude();
            data[i][6]=p.getAltitude();
            data[i][7]=p.getType_ph();
            data[i][8]=p.getGouvernorat();
            data[i][9]=p.getDelegation();
            data[i][10]=p.getLocalite();
            data[i][11]="";
            i++;           
        }
       
    }
     public Table_Rech_Pharmacie(String gouvernorat,String delegation) { //remplissage de la liste des pharmacies
    listPharmacie= new PharmacieDAO().RechercheParGouvernorat_Delegation(gouvernorat, delegation);
    data=new Object[listPharmacie.size()][header.length];
        for(Pharmacies p:listPharmacie){
            data[i][0]=p.getId_ph();
            data[i][1]=p.getRef_ph();
            data[i][2]=p.getNom_ph();
            data[i][3]=p.getAdresse_ph();    
            data[i][4]=p.getNum_tel();  
            data[i][5]=p.getLongitude();
            data[i][6]=p.getAltitude();
            data[i][7]=p.getType_ph();
            data[i][8]=p.getGouvernorat();
            data[i][9]=p.getDelegation();
            data[i][10]=p.getLocalite();
            data[i][11]="";
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
    

