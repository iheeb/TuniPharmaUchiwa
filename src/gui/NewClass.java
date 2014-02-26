/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author HoussemEddine
 */
public class NewClass {
    
    public static void main(String[] args){
        Object[][] data =new dao.MedicamentsDAO().DisplayAllMedicaments();
        for(int i=0;i<4;i++){
            
        System.out.println(data[i][0]);
        System.out.println(data[i][1]);
        System.out.println(data[i][2]);
        System.out.println(data[i][3]);
        System.out.println(data[i][4]);
        System.out.println(data[i][5]);
            }
        
    }
}
