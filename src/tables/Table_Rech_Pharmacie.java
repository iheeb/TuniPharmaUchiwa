/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;
import dao.PharmacieDAO;
import entities.Pharmacies;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gaston
 */
public class Table_Rech_Pharmacie extends AbstractTableModel{
    

List<Pharmacies> listPharmacie = new ArrayList<Pharmacies>();
    String []header = {"id","Nom_ph","Adresse_ph","Num_tel","Longitude","Altitude","Type_ph","Gouvernorat","Delegation","Localite"};
  
    
     public Table_Rech_Pharmacie(String gouvernorat,String delegation,String localite) { //remplissage de la liste des pharmacies
    listPharmacie= new PharmacieDAO().RechercheParGouvernorat_Delegation_Localite(gouvernorat, delegation, localite);
       
    }
     
     public Table_Rech_Pharmacie(String gouvernorat) { //remplissage de la liste des pharmacies
    listPharmacie= new PharmacieDAO().RechercheParGouvernorat(gouvernorat);
       
    }
     public Table_Rech_Pharmacie(String gouvernorat,String delegation) { //remplissage de la liste des pharmacies
    listPharmacie= new PharmacieDAO().RechercheParGouvernorat_Delegation(gouvernorat, delegation);
       
    }
    
    public int getRowCount() {
       //nombre de lignes de la table
        return listPharmacie.size();
    }

    @Override
    public int getColumnCount() {
        //nombre de colonnes de la table
        return header.length;
    }

    @Override
   
        
          //récupération de chaque élément de la table
    public Object getValueAt(int rowIndex, int columnIndex) { 
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
    
    @Override
    public String getColumnName(int column) { // nom des colonnes
        return header[column]; 
    }
    
    }
    

