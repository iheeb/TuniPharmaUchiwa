/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.alee.laf.WebLookAndFeel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.EventObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import tables.Table_Clients;
import tables.Table_Medicament;
import tables.Table_Pharmacie;

/**
 *
 * @author Gaston
 */
public class Frame_Client extends javax.swing.JFrame {

    /**
     * Creates new form Frame_Client
     */
    public void hide(){
        TableColumn collong=Tab_Pharma.getColumnModel().getColumn(4);
        collong.setMinWidth(0);
        collong.setMaxWidth(0);
        collong.setPreferredWidth(0);
        collong.setWidth(0);
        doLayout();
        TableColumn colalt=Tab_Pharma.getColumnModel().getColumn(5);
        colalt.setMinWidth(0);
        colalt.setMaxWidth(0);
        colalt.setPreferredWidth(0);
        colalt.setWidth(0);
        doLayout();
        TableColumn colid=Tab_Pharma.getColumnModel().getColumn(0);
        colid.setMinWidth(0);
        colid.setMaxWidth(0);
        colid.setPreferredWidth(0);
        colid.setWidth(0);
        doLayout();
        TableColumn colc=Tab_Pharma.getColumnModel().getColumn(10);
        colc.setMinWidth(100);
        colc.setMaxWidth(100);
        colc.setPreferredWidth(100);
        colc.setWidth(100);
        doLayout();
        TableColumn col1=jTable2.getColumnModel().getColumn(0);
        col1.setMinWidth(0);
        col1.setMaxWidth(0);
        col1.setPreferredWidth(0);
        col1.setWidth(0);
        doLayout();
        TableColumn col2=jTable2.getColumnModel().getColumn(1);
        col2.setMinWidth(0);
        col2.setMaxWidth(0);
        col2.setPreferredWidth(0);
        col2.setWidth(0);
        doLayout();
        TableColumn col3=jTable2.getColumnModel().getColumn(6);
        col3.setMinWidth(0);
        col3.setMaxWidth(0);
        col3.setPreferredWidth(0);
        col3.setWidth(0);
        doLayout();
        TableColumn col4=jTable2.getColumnModel().getColumn(7);
        col4.setMinWidth(0);
        col4.setMaxWidth(0);
        col4.setPreferredWidth(0);
        col4.setWidth(0);
        doLayout();
        TableColumn col5=jTable2.getColumnModel().getColumn(9);
        col5.setMinWidth(0);
        col5.setMaxWidth(0);
        col5.setPreferredWidth(0);
        col5.setWidth(0);
        doLayout();
        
    }
    public Frame_Client() {
        try {
            UIManager.setLookAndFeel(new WebLookAndFeel());
         //   Image bg = ImageIO.read(new File("/bg.jpg"));
       //     Image bgpan1 = ImageIO.read(new File("/bgpan.jpg"));
         //   Image bgpan2 = ImageIO.read(new File("/bgpan2.png"));
            initComponents();
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Frame_Authentification.class.getName()).log(Level.SEVERE, null, ex);
        }
        Tab_Pharma.setRowHeight(30);
      //  hide();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Acceuil = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboGouver = new javax.swing.JComboBox();
        comboDeleg = new javax.swing.JComboBox();
        combLocal = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tab_Pharma = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        ImageMedicament = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taDesc = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        Acceuil.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        Acceuil.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );

        Acceuil.addTab("Acceuil", jPanel1);

        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setText("Recherche d'une Pharmacie :");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 11, 273, 32);

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
        jPanel2.add(comboGouver);
        comboGouver.setBounds(10, 53, 158, 20);

        comboDeleg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sélectionner une délégation", "La Marsa ", "zaghwain", "Soukra", "Bizert", "Tunis", " " }));
        comboDeleg.setName("comboDeleg"); // NOI18N
        comboDeleg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboDelegItemStateChanged(evt);
            }
        });
        jPanel2.add(comboDeleg);
        comboDeleg.setBounds(178, 53, 158, 20);

        combLocal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sélectionner une localité", "rue essaada", "rue el fath", "rue Jaber", "rue des fleures", "rue el kasba " }));
        combLocal.setName("comboLocal"); // NOI18N
        combLocal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combLocalItemStateChanged(evt);
            }
        });
        jPanel2.add(combLocal);
        combLocal.setBounds(361, 53, 141, 20);

        Tab_Pharma.setModel(new Table_Pharmacie());
        Tab_Pharma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tab_PharmaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tab_Pharma);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(0, 120, 760, 100);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setText("Liste des pharmacies :");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 91, 158, 19);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setText("Liste des médicaments :");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 245, 168, 19);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setText("Nom :");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(206, 245, 47, 19);

        txtNom.setName("tf_nom"); // NOI18N
        jPanel2.add(txtNom);
        txtNom.setBounds(263, 246, 118, 20);

        jButton2.setText("Chercher");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(399, 245, 100, 23);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Info Medicament :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 14))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel10.setText("Description :");

        taDesc.setColumns(20);
        taDesc.setRows(5);
        jScrollPane3.setViewportView(taDesc);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(ImageMedicament, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(ImageMedicament, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(520, 250, 240, 270);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(500, 100, 100, 100);

        jTable2.setModel(new Table_Medicament());
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable2);

        jPanel2.add(jScrollPane4);
        jScrollPane4.setBounds(0, 280, 500, 220);

        Acceuil.addTab("Recherche Pharmacie", jPanel2);

        getContentPane().add(Acceuil);
        Acceuil.setBounds(20, 40, 940, 530);
        Acceuil.getAccessibleContext().setAccessibleName("Acceuil");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboGouverItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboGouverItemStateChanged
        if(comboDeleg.getSelectedItem().toString().equals("Sélectionner une délégation")&& combLocal.getSelectedItem().toString().equals("Sélectionner une localité")){
            Tab_Pharma.setModel(new tables.Table_Rech_Pharmacie(comboGouver.getSelectedItem().toString()));
            comboDeleg.setVisible(true);
            Tab_Pharma.setVisible(true);
          //  Pn2_Pharma.setVisible(true);
            TableColumn column = Tab_Pharma.getColumnModel().getColumn(10);
        column.setCellRenderer(new ButtonsRenderer());
        column.setCellEditor(new ButtonsEditor(Tab_Pharma));
        hide();
        }
        
        else if( combLocal.getSelectedItem().toString().equals("Sélectionner une localité")){
            Tab_Pharma.setModel(new tables.Table_Rech_Pharmacie(comboGouver.getSelectedItem().toString(), comboDeleg.getSelectedItem().toString()));
            comboDeleg.setVisible(true);
            Tab_Pharma.setVisible(true);
        //    Pn2_Pharma.setVisible(true);
            TableColumn column = Tab_Pharma.getColumnModel().getColumn(10);
        column.setCellRenderer(new ButtonsRenderer());
        column.setCellEditor(new ButtonsEditor(Tab_Pharma));
        hide();
        }
        else
        Tab_Pharma.setModel(new tables.Table_Rech_Pharmacie(comboGouver.getSelectedItem().toString(), comboDeleg.getSelectedItem().toString(), combLocal.getSelectedItem().toString()));
        comboDeleg.setVisible(true);
        Tab_Pharma.setVisible(true);
     //   Pn2_Pharma.setVisible(true);
        hide();
        
        TableColumn column = Tab_Pharma.getColumnModel().getColumn(10);
        column.setCellRenderer(new ButtonsRenderer());
        column.setCellEditor(new ButtonsEditor(Tab_Pharma));
    }//GEN-LAST:event_comboGouverItemStateChanged

    private void comboGouverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGouverActionPerformed

    }//GEN-LAST:event_comboGouverActionPerformed

    private void comboDelegItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboDelegItemStateChanged

        if(comboDeleg.getSelectedItem().toString().equals("Sélectionner une délégation")&& combLocal.getSelectedItem().toString().equals("Sélectionner une localité")){
            Tab_Pharma.setModel(new tables.Table_Rech_Pharmacie(comboGouver.getSelectedItem().toString()));
            hide();
            TableColumn column = Tab_Pharma.getColumnModel().getColumn(10);
        column.setCellRenderer(new ButtonsRenderer());
        column.setCellEditor(new ButtonsEditor(Tab_Pharma));

        }
        else if( combLocal.getSelectedItem().toString().equals("Sélectionner une localité")){
            Tab_Pharma.setModel(new tables.Table_Rech_Pharmacie(comboGouver.getSelectedItem().toString(), comboDeleg.getSelectedItem().toString()));
TableColumn column = Tab_Pharma.getColumnModel().getColumn(10);
        column.setCellRenderer(new ButtonsRenderer());
        column.setCellEditor(new ButtonsEditor(Tab_Pharma));
        hide();
        }
        else
        Tab_Pharma.setModel(new tables.Table_Rech_Pharmacie(comboGouver.getSelectedItem().toString(), comboDeleg.getSelectedItem().toString(), combLocal.getSelectedItem().toString()));

        Tab_Pharma.setModel(new tables.Table_Rech_Pharmacie(comboGouver.getSelectedItem().toString(), comboDeleg.getSelectedItem().toString()));
        combLocal.setVisible(true);
hide();

        TableColumn column = Tab_Pharma.getColumnModel().getColumn(10);
        column.setCellRenderer(new ButtonsRenderer());
        column.setCellEditor(new ButtonsEditor(Tab_Pharma));
    }//GEN-LAST:event_comboDelegItemStateChanged

    private void combLocalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combLocalItemStateChanged

        if(comboDeleg.getSelectedItem().toString().equals("Sélectionner une délégation")&& combLocal.getSelectedItem().toString().equals("Sélectionner une localité")){
            Tab_Pharma.setModel(new tables.Table_Rech_Pharmacie(comboGouver.getSelectedItem().toString()));
TableColumn column = Tab_Pharma.getColumnModel().getColumn(10);
        column.setCellRenderer(new ButtonsRenderer());
        column.setCellEditor(new ButtonsEditor(Tab_Pharma));
        hide();
        }
        else if( combLocal.getSelectedItem().toString().equals("Sélectionner une localité")){
            Tab_Pharma.setModel(new tables.Table_Rech_Pharmacie(comboGouver.getSelectedItem().toString(), comboDeleg.getSelectedItem().toString()));
TableColumn column = Tab_Pharma.getColumnModel().getColumn(10);
        column.setCellRenderer(new ButtonsRenderer());
        column.setCellEditor(new ButtonsEditor(Tab_Pharma));
        hide();
        }
        else
        Tab_Pharma.setModel(new tables.Table_Rech_Pharmacie(comboGouver.getSelectedItem().toString(), comboDeleg.getSelectedItem().toString(), combLocal.getSelectedItem().toString()));
hide();

        TableColumn column = Tab_Pharma.getColumnModel().getColumn(10);
        column.setCellRenderer(new ButtonsRenderer());
        column.setCellEditor(new ButtonsEditor(Tab_Pharma));
    }//GEN-LAST:event_combLocalItemStateChanged

    private void Tab_PharmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tab_PharmaMouseClicked
        jTable2.setModel(new Table_Medicament(Integer.parseInt(Tab_Pharma.getValueAt(Tab_Pharma.getSelectedRow(), 0).toString())));
        hide();
    }//GEN-LAST:event_Tab_PharmaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTable2.setModel(new Table_Medicament(Integer.parseInt(Tab_Pharma.getValueAt(Tab_Pharma.getSelectedRow(), 0).toString()),txtNom.getText()));
        hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
       
    }//GEN-LAST:event_formWindowOpened

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        ImageMedicament.setIcon(new javax.swing.ImageIcon(jTable2.getValueAt(jTable2.getSelectedRow(), 9).toString()));
        taDesc.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_jTable2MouseClicked

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
            java.util.logging.Logger.getLogger(Frame_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Client().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Acceuil;
    private javax.swing.JLabel ImageMedicament;
    private javax.swing.JTable Tab_Pharma;
    private javax.swing.JComboBox combLocal;
    private javax.swing.JComboBox comboDeleg;
    private javax.swing.JComboBox comboGouver;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea taDesc;
    private javax.swing.JTextField txtNom;
    // End of variables declaration//GEN-END:variables
public class ButtonsEditor extends ButtonsPanel implements TableCellEditor {
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
     //   buttonsDF.get(0).addMouseListener(ml);
     //   buttonsDF.get(1).addMouseListener(ml);
    //    buttons.get(1).addMouseListener(ml);
        //<----

        buttons.get(0).addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                int row = table.convertRowIndexToModel(table.getEditingRow());
                Object o = table.getModel().getValueAt(row, 0);
                fireEditingStopped();
                
              
                
                TableColumn column = table.getColumnModel().getColumn(10);
                column.setCellRenderer(new ButtonsRenderer());
                column.setCellEditor(new ButtonsEditor(table));
                TableColumn col = table.getColumnModel().getColumn(0);
                col.setMinWidth(0);
                col.setMaxWidth(0);
                col.setWidth(0);
                col.setPreferredWidth(0);
                doLayout();
                Frame_Commentaire c=new Frame_Commentaire();
                c.setVisible(true);         
        }
        });

     /*   buttons.get(1).addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                //Object o = table.getModel().getValueAt(table.getSelectedRow(), 0);
                int row = table.convertRowIndexToModel(table.getEditingRow());
                Object o = table.getModel().getValueAt(row, 0);
                fireEditingStopped();
                JOptionPane.showMessageDialog(table, "Editing: "+o);
            }
        });
*/
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
public class ButtonsPanel extends JPanel {
    public final List<JButton> buttons = Arrays.asList(new JButton("Commenter"),new JButton("Evaluer"));
 //   public final List<JButton> buttonsDF = Arrays.asList(new JButton("Accepter"),new JButton("Refuser"));
    public ButtonsPanel() {
        super();
        setOpaque(true);
        
      //  try {
         //   Image img = ImageIO.read(getClass().getResource("/gui/delete.jpg"));
            for(JButton b: buttons) {
            b.setFocusable(false);
            b.setRolloverEnabled(false);
        //    b.setIcon(new ImageIcon(img));
  
            add(b);
        }
   /*         for(JButton b: buttonsDF) {
            b.setFocusable(false);
            b.setRolloverEnabled(false);
        //    b.setIcon(new ImageIcon(img));
  
            add(b);
        }*/
            
    //    } catch (IOException ex) {
    //        Logger.getLogger(Frame_Admin.class.getName()).log(Level.SEVERE, null, ex);
     //   }
        
    }
}  
public class ButtonsRenderer extends ButtonsPanel implements TableCellRenderer {
    public ButtonsRenderer() {
        super();
        setName("Table.cellRenderer");
    }
    @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.setBackground(isSelected?table.getSelectionBackground():table.getBackground());
        return this;
    }
}

}