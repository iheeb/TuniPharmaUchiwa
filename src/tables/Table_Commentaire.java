/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import dao.CommentaireDAO;
import entities.Commentaire;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Iheb
 */
public class Table_Commentaire extends AbstractTableModel{
    
     List<Commentaire> listCommentaire = new ArrayList<Commentaire>();
    String []header = {"id","ID Pharmacien","ID Client","Commentaire"};

    public Table_Commentaire() { //remplissage de la liste des medicaments
        listCommentaire=new CommentaireDAO().GetAllComments ();
    }
    
    public int getRowCount() { //nombre de lignes de la table
        return listCommentaire.size();
    }

    public int getColumnCount() { //nombre de colonnes de la table
        return header.length;
    }

    //récupération de chaque élément de la table
    public Object getValueAt(int rowIndex, int columnIndex) { 
        switch (columnIndex) {// parcour par colonne
            case 0://colonne id_medicament
                return listCommentaire.get(rowIndex).getId_commentaire();
            case 1://colonne reference
                return listCommentaire.get(rowIndex).getId_ph_commentaire();
            case 2://colonne nom
                return listCommentaire.get(rowIndex).getId_clt_commentaire();
            case 3://colonne categorie
                return listCommentaire.get(rowIndex).getCommentaire();
                         
                default:
                return null;

        }
    }
    
    @Override
    public String getColumnName(int column) { // nom des colonnes
        return header[column]; 
    }
    
    
    
    
    
}
