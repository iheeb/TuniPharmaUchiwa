/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.MedicamentsDAO;
import entities.Medicaments;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.EventObject;
import java.util.List;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author HoussemEddine
 */

public class Frame_Gestion_Medicaments extends javax.swing.JFrame {
    
    /**
     * Creates new form Frame_Gestion_Medicaments
     */
    public void RemoveMedicament(){
        
        MedicamentsDAO meddao = new MedicamentsDAO();
        //Insérer le Stock
        meddao.deleteMedicament(Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()));
        
        //Afficher un message de confirmation
        JOptionPane.showMessageDialog(this, "Suppression effectué avec succès");
        
    }
    class ButtonsPanel extends JPanel {
    public final List<JButton> buttons = Arrays.asList(new JButton("view"), new JButton("edit"));
    public ButtonsPanel() {
        super();
        setOpaque(true);
        for(JButton b: buttons) {
            b.setFocusable(false);
            b.setRolloverEnabled(false);
            add(b);
        }
    }
    }
    class ButtonsEditor extends ButtonsPanel implements TableCellEditor {
    transient protected ChangeEvent changeEvent = null;

    public ButtonsEditor(final JTable table) {
        super();
        //---->
        //DEBUG: view button click -> control key down + edit button(same cell) press -> remain selection color
        MouseListener ml = new MouseAdapter() {
            @Override public void mousePressed(MouseEvent e) {
                ButtonModel m = ((JButton)e.getSource()).getModel();
                if(m.isPressed() && table.isRowSelected(table.getEditingRow()) && e.isControlDown()) {
                    setBackground(table.getBackground());
                }
            }
        };
        buttons.get(0).addMouseListener(ml);
        buttons.get(1).addMouseListener(ml);
        //<----

        buttons.get(0).addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                RemoveMedicament();
        jTable1.setModel(new tables.Table_Medicament());
        TableColumn column = jTable1.getColumnModel().getColumn(6);
        column.setCellRenderer(new ButtonsRenderer());
        column.setCellEditor(new ButtonsEditor(jTable1));
            }
        });

        buttons.get(1).addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                //Object o = table.getModel().getValueAt(table.getSelectedRow(), 0);
                int row = table.convertRowIndexToModel(table.getEditingRow());
                Object o = table.getModel().getValueAt(row, 0);
                fireEditingStopped();
                JOptionPane.showMessageDialog(table, "Editing: "+o);
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override public void mousePressed(MouseEvent e) {
                fireEditingStopped();
            }
        });
    }
    @Override public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.setBackground(table.getSelectionBackground());
        return this;
    }
    @Override public Object getCellEditorValue() {
        return "";
    }

    //Copid from AbstractCellEditor
    //protected EventListenerList listenerList = new EventListenerList();
    //transient protected ChangeEvent changeEvent = null;
    @Override public boolean isCellEditable(EventObject e) {
        return true;
    }
    @Override public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }
    @Override public boolean stopCellEditing() {
        fireEditingStopped();
        return true;
    }
    @Override public void cancelCellEditing() {
        fireEditingCanceled();
    }
    @Override public void addCellEditorListener(CellEditorListener l) {
        listenerList.add(CellEditorListener.class, l);
    }
    @Override public void removeCellEditorListener(CellEditorListener l) {
        listenerList.remove(CellEditorListener.class, l);
    }
    public CellEditorListener[] getCellEditorListeners() {
        return listenerList.getListeners(CellEditorListener.class);
    }
    protected void fireEditingStopped() {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for(int i = listeners.length-2; i>=0; i-=2) {
            if(listeners[i]==CellEditorListener.class) {
                // Lazily create the event:
                if(changeEvent == null) {
                    changeEvent = new ChangeEvent(this);
                }
                ((CellEditorListener)listeners[i+1]).editingStopped(changeEvent);
            }
        }
    }
    
    protected void fireEditingCanceled() {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for(int i = listeners.length-2; i>=0; i-=2) {
            if(listeners[i]==CellEditorListener.class) {
                // Lazily create the event:
                if(changeEvent == null) {
                    changeEvent = new ChangeEvent(this);
                }
                ((CellEditorListener)listeners[i+1]).editingCanceled(changeEvent);
            }
        }
    }
    }
class ButtonsRenderer extends ButtonsPanel implements TableCellRenderer {
    public ButtonsRenderer() {
        super();
        setName("Table.cellRenderer");
    }
    @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.setBackground(isSelected?table.getSelectionBackground():table.getBackground());
        return this;
    }
}

    public void AddMedicament(){
        Medicaments medicament = new Medicaments();
        MedicamentsDAO meddao = new MedicamentsDAO();
        
        medicament.setReference_med(txtReference_med.getText());
        medicament.setDescription_med(taDescription.getText());
        medicament.setClasse_med(cb_Classe_med.getSelectedItem().toString());
        medicament.setNom_med(txtNom_med.getText());
        medicament.setForme_med(cbForme_med.getSelectedItem().toString());
        //Insérer le Stock
        meddao.insertMedicament(medicament);
        //Afficher un message de confirmation
        JOptionPane.showMessageDialog(this, "Ajout effectué avec succès");
    }
    
    public void ModifyMedicament(){
        Medicaments medicament = new Medicaments();
        MedicamentsDAO meddao = new MedicamentsDAO();
        
        medicament.setReference_med(txtReference_med.getText());
        medicament.setDescription_med(taDescription.getText());
        medicament.setClasse_med(cb_Classe_med.getSelectedItem().toString());
        medicament.setNom_med(txtNom_med.getText());
        medicament.setForme_med(cbForme_med.getSelectedItem().toString());
        medicament.setId_med(Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString()));
        //Insérer le Stock
        meddao.updateMedicament(medicament);
        //Afficher un message de confirmation
        JOptionPane.showMessageDialog(this, "Modification effectué avec succès");
        
    }

    public Frame_Gestion_Medicaments() {
        initComponents();
        jTable1.setRowHeight(40);
        TableColumn column = jTable1.getColumnModel().getColumn(6);
        column.setCellRenderer(new ButtonsRenderer());
        column.setCellEditor(new ButtonsEditor(jTable1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtReference_med = new javax.swing.JTextField();
        txtNom_med = new javax.swing.JTextField();
        cbForme_med = new javax.swing.JComboBox();
        cb_Classe_med = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        btnAjouter = new javax.swing.JButton();
        btnModifier = new javax.swing.JButton();
        btnSupprimer = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTable1.setModel(new tables.Table_Medicament());
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Référence :");

        jLabel2.setText("Nom : ");

        jLabel3.setText("Description : ");

        jLabel4.setText("Classe :");

        jLabel5.setText("Forme : ");

        cbForme_med.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "orales ", "injectables ", "dermiques ", "inhalées ", "rectales ", " " }));

        cb_Classe_med.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Allergologie\t", "Anesthésie", "Antalgiques", "Anti-inflammatoires", "Cancérologie et hématologie", "Cardiologie et angéiologie", "Contraception et interruption de grossesse\t", "Dermatologie", "Endocrinologie\t", "Gastro-Entéro-Hépatologie", "Gynécologie\t", "Hémostase et sang", "Immunologie\t", "Infectiologie - Parasitologie", "Métabolisme et nutrition\t", "Neurologie-psychiatrie", "Ophtalmologie\t", "Oto-rhino-laryngologie", "Pneumologie\t", "Produits diagnostiques ", "Rhumatologie\t", "Sang et dérivés", "Stomatologie\t", "Toxicologie", "Urologie néphrologie\t", "Souches Homéopathiques" }));

        taDescription.setColumns(20);
        taDescription.setRows(5);
        jScrollPane2.setViewportView(taDescription);

        btnAjouter.setText("Ajouter");
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });

        btnModifier.setText("Modifier");
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });

        btnSupprimer.setText("Supprimer");
        btnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel6.setText("Liste des Medicaments :");

        jCheckBox1.setText("jCheckBox1");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(btnAjouter)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel1)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cb_Classe_med, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbForme_med, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtReference_med)
                                            .addComponent(txtNom_med)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnModifier)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSupprimer)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnClear)))
                                .addGap(31, 31, 31))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addComponent(jCheckBox1)
                .addGap(0, 414, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtReference_med, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNom_med, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cb_Classe_med, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbForme_med, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAjouter)
                            .addComponent(btnModifier)
                            .addComponent(btnSupprimer)
                            .addComponent(btnClear)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed
            this.AddMedicament();
            jTable1.setModel(new tables.Table_Medicament());
            TableColumn column = jTable1.getColumnModel().getColumn(6);
            column.setCellRenderer(new ButtonsRenderer());
            column.setCellEditor(new ButtonsEditor(jTable1));
    }//GEN-LAST:event_btnAjouterActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        txtReference_med.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        txtNom_med.setText(jTable1.getValueAt(jTable1.getSelectedRow(),2).toString());
        cb_Classe_med.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(),3).toString());
        taDescription.setText(jTable1.getValueAt(jTable1.getSelectedRow(),4).toString());
        cbForme_med.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(),5).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtReference_med.setText("");
        txtNom_med.setText("");
        cb_Classe_med.setSelectedIndex(0);
        taDescription.setText("");
        cbForme_med.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed
            this.ModifyMedicament();
            jTable1.setModel(new tables.Table_Medicament());
    }//GEN-LAST:event_btnModifierActionPerformed

    private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerActionPerformed
        this.RemoveMedicament();
        jTable1.setModel(new tables.Table_Medicament());
    }//GEN-LAST:event_btnSupprimerActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for(int i=0;i<jTable1.getRowCount();i++){
            if(jTable1.getValueAt(i, 7).equals(true)){
                new dao.MedicamentsDAO().deleteMedicament(Integer.parseInt(jTable1.getValueAt(i, 0).toString()));
               // jTable1.setModel(new tables.Table_Medicament());
            }
            
        }
        jTable1.setModel(new tables.Table_Medicament());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_Gestion_Medicaments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Gestion_Medicaments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Gestion_Medicaments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Gestion_Medicaments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Gestion_Medicaments().setVisible(true);
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton btnSupprimer;
    private javax.swing.JComboBox cbForme_med;
    private javax.swing.JComboBox cb_Classe_med;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTextField txtNom_med;
    private javax.swing.JTextField txtReference_med;
    // End of variables declaration//GEN-END:variables
}
