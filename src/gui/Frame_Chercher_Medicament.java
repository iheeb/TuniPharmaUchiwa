/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.MedicamentsDAO;
import entities.Medicaments;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaston
 */
public class Frame_Chercher_Medicament extends javax.swing.JFrame {

    //  on declaration du liste des medicaments 
    
    List<Medicaments> liste;
    
    
    public Frame_Chercher_Medicament() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNom = new javax.swing.JLabel();
        lblCateg = new javax.swing.JLabel();
        txtfNom = new javax.swing.JTextField();
        comboClasse = new javax.swing.JComboBox();
        btRechercher = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_medic = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("Recherche d'un médicament");

        lblNom.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblNom.setText("Nom :");

        lblCateg.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblCateg.setText("Classe :");

        txtfNom.setName("txtNom"); // NOI18N

        comboClasse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choisir la Classe...", "Allergologie\t", "Anesthésie", "Antalgiques", "Anti-inflammatoires", "Cancérologie et hématologie", "Cardiologie et angéiologie", "Contraception et interruption de grossesse\t", "Dermatologie", "Endocrinologie\t", "Gastro-Entéro-Hépatologie", "Gynécologie\t", "Hémostase et sang", "Immunologie\t", "Infectiologie - Parasitologie", "Métabolisme et nutrition\t", "Neurologie-psychiatrie", "Ophtalmologie\t", "Oto-rhino-laryngologie", "Pneumologie\t", "Produits diagnostiques ", "Rhumatologie\t", "Sang et dérivés", "Stomatologie\t", "Toxicologie", "Urologie néphrologie\t", "Souches Homéopathiques" }));
        comboClasse.setName("comboCatégo"); // NOI18N

        btRechercher.setBackground(new java.awt.Color(126, 212, 45));
        btRechercher.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        btRechercher.setText("Recherhcer");
        btRechercher.setName("btRechMedic"); // NOI18N
        btRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRechercherActionPerformed(evt);
            }
        });

        table_medic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_medic);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNom, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(txtfNom, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(btRechercher)))
                .addGap(4, 4, Short.MAX_VALUE)
                .addComponent(lblCateg, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNom, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCateg, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfNom, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(btRechercher)
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRechercherActionPerformed
        
        
        if(txtfNom.getText().equals("")&&comboClasse.getSelectedItem().toString().trim().equals("Choisir la Classe...")){
        JOptionPane.showMessageDialog(this,"Vueillez saisir votre  choix!");
    }
        else if(txtfNom.getText().equals("")&&!comboClasse.getSelectedItem().toString().trim().equals("Choisir la Classe...")){
            table_medic.setModel(new tables.Table_Rech_Medicament(comboClasse.getSelectedItem().toString().trim()));
        table_medic.setVisible(true); 
        }
        else{
        table_medic.setModel(new tables.Table_Rech_Medicament(txtfNom.getText(), comboClasse.getSelectedItem().toString().trim()));
        table_medic.setVisible(true); }
          
        
        
    }//GEN-LAST:event_btRechercherActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        table_medic.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    
     
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame_Chercher_Medicament.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Chercher_Medicament.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Chercher_Medicament.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Chercher_Medicament.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Chercher_Medicament().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRechercher;
    private javax.swing.JComboBox comboClasse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCateg;
    private javax.swing.JLabel lblNom;
    private javax.swing.JTable table_medic;
    private javax.swing.JTextField txtfNom;
    // End of variables declaration//GEN-END:variables
}
