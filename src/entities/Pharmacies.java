/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Gaston
 */
public class Pharmacies {
    
    private int id_ph;
    private String ref_ph;
    private String nom_ph;
    private String adresse_ph;
    private int num_tel;
    private float longitude;
    private float altitude;
    private String type_ph;
    private String gouvernorat;
    private String delegation;
    private String localite;

    public String getRef_ph() {
        return ref_ph;
    }

    public void setRef_ph(String ref_ph) {
        this.ref_ph = ref_ph;
    }
    


    // getters et setters 
    public int getId_ph() {
        return id_ph;
    }

    public String getNom_ph() {
        return nom_ph;
    }

    public String getAdresse_ph() {
        return adresse_ph;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getAltitude() {
        return altitude;
    }

    public String getType_ph() {
        return type_ph;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public String getDelegation() {
        return delegation;
    }

    public String getLocalite() {
        return localite;
    }

    public void setId_ph(int id_ph) {
        this.id_ph = id_ph;
    }

    public void setNom_ph(String nom_ph) {
        this.nom_ph = nom_ph;
    }

    public void setAdresse_ph(String adresse_ph) {
        this.adresse_ph = adresse_ph;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public void setType_ph(String type_ph) {
        this.type_ph = type_ph;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public void setDelegation(String delegation) {
        this.delegation = delegation;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    



}
