/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Pharmacies;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaston
 */
public class Frame_Chercher_Pharmacie extends javax.swing.JFrame {

    
    
    List<Pharmacies> liste;
    
    
    public Frame_Chercher_Pharmacie() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        RBgarde = new javax.swing.JRadioButton();
        RBnuit = new javax.swing.JRadioButton();
        RBjour = new javax.swing.JRadioButton();
        comboGouver = new javax.swing.JComboBox();
        comboDeleg = new javax.swing.JComboBox();
        combLocal = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtA_pharma = new javax.swing.JTextArea();
        Pn2_Pharma = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tab_Pharma = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("Recherche d'une pharmacie");

        buttonGroup1.add(RBgarde);
        RBgarde.setText("Pharmacie de garde");
        RBgarde.setName("rbtnGarde"); // NOI18N
        RBgarde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBgardeActionPerformed(evt);
            }
        });

        buttonGroup1.add(RBnuit);
        RBnuit.setText("Pharmacie de nuit");
        RBnuit.setName("rbtnNuit"); // NOI18N

        buttonGroup1.add(RBjour);
        RBjour.setText("Pharmacie du jour");
        RBjour.setName("rbtnJour"); // NOI18N
        RBjour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBjourActionPerformed(evt);
            }
        });

        comboGouver.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sélectionner le gouvernorat", "La marsa", "zaghwain", "Soukra", "Bizert", "Tunis", " ", " " }));
        comboGouver.setName("comboGouver"); // NOI18N
        comboGouver.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboGouverItemStateChanged(evt);
            }
        });
        comboGouver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboGouverActionPerformed(evt);
            }
        });

        comboDeleg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sélectionner une délégation", "La Marsa ", "zaghwain", "Soukra", "Bizert", "Tunis", " " }));
        comboDeleg.setName("comboDeleg"); // NOI18N
        comboDeleg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboDelegItemStateChanged(evt);
            }
        });

        combLocal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sélectionner une localité", "rue essaada", "rue el fath", "rue Jaber", "rue des fleures", "rue el kasba " }));
        combLocal.setName("comboLocal"); // NOI18N
        combLocal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combLocalItemStateChanged(evt);
            }
        });

        txtA_pharma.setEditable(false);
        txtA_pharma.setColumns(20);
        txtA_pharma.setRows(5);
        txtA_pharma.setText("Cher client,\nTunipharma met à votre disposition un moteur de recherche vous permettant d'obtenir la pharmacie disponible\nde la localité souhaitée.\nSelon votre choix, la recherche s'effectue par gouvernorat, par délégation ou par localité :  ");
        jScrollPane2.setViewportView(txtA_pharma);

        Tab_Pharma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tab_Pharma);

        javax.swing.GroupLayout Pn2_PharmaLayout = new javax.swing.GroupLayout(Pn2_Pharma);
        Pn2_Pharma.setLayout(Pn2_PharmaLayout);
        Pn2_PharmaLayout.setHorizontalGroup(
            Pn2_PharmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pn2_PharmaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Pn2_PharmaLayout.setVerticalGroup(
            Pn2_PharmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pn2_PharmaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(comboGouver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(comboDeleg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(combLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 881, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(Pn2_Pharma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(RBjour)
                                .addGap(159, 159, 159)
                                .addComponent(RBnuit)
                                .addGap(80, 80, 80)
                                .addComponent(RBgarde)))))
                .addContainerGap(461, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboGouver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDeleg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RBnuit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RBjour, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RBgarde, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(Pn2_Pharma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(578, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RBgardeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBgardeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBgardeActionPerformed

    private void comboGouverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGouverActionPerformed
       
    }//GEN-LAST:event_comboGouverActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        comboDeleg.setVisible(false);
        combLocal.setVisible(false);
        Pn2_Pharma.setVisible(false);
        
    }//GEN-LAST:event_formWindowOpened

    private void comboGouverItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboGouverItemStateChanged
        if(comboDeleg.getSelectedItem().toString().equals("Sélectionner une délégation")&& combLocal.getSelectedItem().toString().equals("Sélectionner une localité")){
         Tab_Pharma.setModel(new tables.Table_Rech_Pharmacie(comboGouver.getSelectedItem().toString()));   
         comboDeleg.setVisible(true);
        Tab_Pharma.setVisible(true);
        Pn2_Pharma.setVisible(true);
        }
        else if( combLocal.getSelectedItem().toString().equals("Sélectionner une localité")){
       Tab_Pharma.setModel(new tables.Table_Rech_Pharmacie(comboGouver.getSelectedItem().toString(), comboDeleg.getSelectedItem().toString()));
        comboDeleg.setVisible(true);
        Tab_Pharma.setVisible(true);
        Pn2_Pharma.setVisible(true);
        }
        else
            Tab_Pharma.setModel(new tables.Table_Rech_Pharmacie(comboGouver.getSelectedItem().toString(), comboDeleg.getSelectedItem().toString(), combLocal.getSelectedItem().toString()));
        comboDeleg.setVisible(true);
        Tab_Pharma.setVisible(true);
        Pn2_Pharma.setVisible(true);
    }//GEN-LAST:event_comboGouverItemStateChanged

    private void comboDelegItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboDelegItemStateChanged
      
          if(comboDeleg.getSelectedItem().toString().equals("Sélectionner une délégation")&& combLocal.getSelectedItem().toString().equals("Sélectionner une localité")){
         Tab_Pharma.setModel(new tables.Table_Rech_Pharmacie(comboGouver.getSelectedItem().toString()));   
        
        }
        else if( combLocal.getSelectedItem().toString().equals("Sélectionner une localité")){
       Tab_Pharma.setModel(new tables.Table_Rech_Pharmacie(comboGouver.getSelectedItem().toString(), comboDeleg.getSelectedItem().toString()));
        
        }
        else
            Tab_Pharma.setModel(new tables.Table_Rech_Pharmacie(comboGouver.getSelectedItem().toString(), comboDeleg.getSelectedItem().toString(), combLocal.getSelectedItem().toString()));
        
          Tab_Pharma.setModel(new tables.Table_Rech_Pharmacie(comboGouver.getSelectedItem().toString(), comboDeleg.getSelectedItem().toString()));
        combLocal.setVisible(true);
        
        
      
    }//GEN-LAST:event_comboDelegItemStateChanged

    private void RBjourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBjourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBjourActionPerformed

    private void combLocalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combLocalItemStateChanged
       
         if(comboDeleg.getSelectedItem().toString().equals("Sélectionner une délégation")&& combLocal.getSelectedItem().toString().equals("Sélectionner une localité")){
         Tab_Pharma.setModel(new tables.Table_Rech_Pharmacie(comboGouver.getSelectedItem().toString()));   
        
        }
        else if( combLocal.getSelectedItem().toString().equals("Sélectionner une localité")){
       Tab_Pharma.setModel(new tables.Table_Rech_Pharmacie(comboGouver.getSelectedItem().toString(), comboDeleg.getSelectedItem().toString()));
        
        }
        else
            Tab_Pharma.setModel(new tables.Table_Rech_Pharmacie(comboGouver.getSelectedItem().toString(), comboDeleg.getSelectedItem().toString(), combLocal.getSelectedItem().toString()));
        
        
       
    }//GEN-LAST:event_combLocalItemStateChanged

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Frame_Chercher_Pharmacie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Chercher_Pharmacie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Chercher_Pharmacie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Chercher_Pharmacie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Chercher_Pharmacie().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pn2_Pharma;
    private javax.swing.JRadioButton RBgarde;
    private javax.swing.JRadioButton RBjour;
    private javax.swing.JRadioButton RBnuit;
    private javax.swing.JTable Tab_Pharma;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox combLocal;
    private javax.swing.JComboBox comboDeleg;
    private javax.swing.JComboBox comboGouver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtA_pharma;
    // End of variables declaration//GEN-END:variables
}
