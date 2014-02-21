/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author HoussemEddine
 */
public class Medicaments {
    
    private int id_med;
    private String reference_med;
    private String nom_med;
    private String categorie_med;
    private String description_med;
    private String forme_med;

    public int getId_med() {
        return id_med;
    }

    public void setId_med(int id_med) {
        this.id_med = id_med;
    }

    
    public String getReference_med() {
        return reference_med;
    }

    public void setReference_med(String reference_med) {
        this.reference_med = reference_med;
    }

    public String getNom_med() {
        return nom_med;
    }

    public void setNom_med(String nom_med) {
        this.nom_med = nom_med;
    }

    public String getCategorie_med() {
        return categorie_med;
    }

    public void setCategorie_med(String categorie_med) {
        this.categorie_med = categorie_med;
    }

    public String getDescription_med() {
        return description_med;
    }

    public void setDescription_med(String description_med) {
        this.description_med = description_med;
    }

    public String getForme_med() {
        return forme_med;
    }

    public void setForme_med(String forme_med) {
        this.forme_med = forme_med;
    }
   
}
