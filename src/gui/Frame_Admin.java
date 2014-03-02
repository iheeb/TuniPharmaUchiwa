/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;



import compenents.ButtonsRenderer;
import compenents.ButtonsEditor;

import com.alee.laf.WebLookAndFeel;

import compenents.ButtonsPhEditor;
import compenents.ButtonsPhRenderer;

import dao.ClientsDAO;
import dao.MedicamentsDAO;
import dao.PharmacieDAO;
import entities.Clients;
import entities.Medicaments;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.EventObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
import tables.Table_Liste_Demande_Ph;
import tables.Table_Pharmacien;


/**
 *
 * @author HoussemEddine
 */
public class Frame_Admin extends javax.swing.JFrame {

    /**
     * Creates new form Frame_Admin
     */
    public void Etat(){
        for(int i=0;i<TableDemandePh.getRowCount();i++){
            if(new PharmacieDAO().RechercheRef(TableDemandePh.getValueAt(i, 3).toString()).equals(TableDemandePh.getValueAt(i, 3).toString())){
                   TableDemandePh.setValueAt("Exist", i, 7);
                   
            }
            else{
                TableDemandePh.setValueAt("n'existe pas", i, 7);
               
            }
        }
    }
    public void notification(){
        int i=new dao.PharmaciensDAO().DisplayPharmaciensAtt();
        if(i>0){
        lblnotn.setText(String.valueOf(new dao.PharmaciensDAO().DisplayPharmaciensAtt()));
        lblnotc.setVisible(true);
        lblnot.setVisible(true);
        }
        else{
        lblnotn.setText("");
        lblnotc.setVisible(false);
        lblnot.setVisible(false);
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
    public void RemoveMedicament(){
        
        MedicamentsDAO meddao = new MedicamentsDAO();
        //Insérer le Stock
        meddao.deleteMedicament(Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()));
        
        //Afficher un message de confirmation
        JOptionPane.showMessageDialog(this, "Suppression effectué avec succès");
    }
    public void refrechTable(){
        
         
        TableClients.setModel(new Table_Clients());
        TableColumn column = TableClients.getColumnModel().getColumn(9);
        column.setCellRenderer(new ButtonsRenderer());
        column.setCellEditor(new ButtonsEditor(TableClients));
       
        TableDemandePh.setModel(new Table_Liste_Demande_Ph(0));
        TableColumn columnDF = TableDemandePh.getColumnModel().getColumn(6);
        columnDF.setCellRenderer(new ButtonsDFRenderer());
        columnDF.setCellEditor(new ButtonsDFEditor(TableDemandePh));
        
        
        
        TableColumn columnMed = jTable1.getColumnModel().getColumn(6);
        columnMed.setCellRenderer(new ButtonsRenderer());
        columnMed.setCellEditor(new ButtonsEditor(jTable1));
        Etat();
        
    }
    
    public void hide() {
    TableColumn column = TableClients.getColumnModel().getColumn(0);
    column.setMinWidth(0);
    column.setMaxWidth(0);
    column.setWidth(0);
    column.setPreferredWidth(0);
    doLayout();
    TableColumn columnFi = jTable2.getColumnModel().getColumn(0);
    TableColumn columnFe = jTable2.getColumnModel().getColumn(13);
    columnFi.setMinWidth(0);
    columnFi.setMaxWidth(0);
    columnFi.setWidth(0);
    columnFi.setPreferredWidth(0);
    doLayout();
    columnFe.setMinWidth(0);
    columnFe.setMaxWidth(0);
    columnFe.setWidth(0);
    columnFe.setPreferredWidth(0);
    doLayout();
    TableColumn columnF = TableDemandePh.getColumnModel().getColumn(0);
    TableColumn columnFE = TableDemandePh.getColumnModel().getColumn(5);
    TableColumn columnFB = TableDemandePh.getColumnModel().getColumn(6);
    columnF.setMinWidth(0);
    columnF.setMaxWidth(0);
    columnF.setWidth(0);
    columnF.setPreferredWidth(0);
    doLayout();
    columnF.setMinWidth(0);
    columnF.setMaxWidth(0);
    columnF.setWidth(0);
    columnF.setPreferredWidth(0);
    doLayout();
    columnFE.setMinWidth(0);
    columnFE.setMaxWidth(0);
    columnFE.setWidth(0);
    columnFE.setPreferredWidth(0);
    doLayout();
    columnFB.setMinWidth(150);
    columnFB.setMaxWidth(150);
    columnFB.setWidth(150);
    doLayout();
    TableColumn columnimg = jTable1.getColumnModel().getColumn(8);
    columnimg.setMinWidth(0);
    columnimg.setMaxWidth(0);
    columnimg.setWidth(0);
    columnimg.setPreferredWidth(0);
    doLayout();
}
    public Frame_Admin() throws IOException {
         try {
            UIManager.setLookAndFeel(new WebLookAndFeel());
         //   Image bg = ImageIO.read(new File("/bg.jpg"));
       //     Image bgpan1 = ImageIO.read(new File("/bgpan.jpg"));
         //   Image bgpan2 = ImageIO.read(new File("/bgpan2.png"));
            initComponents();
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Frame_Authentification.class.getName()).log(Level.SEVERE, null, ex);
        }
         TableClients.setRowHeight(36);
         TableDemandePh.setRowHeight(36);
      //   TablePharmaciens.setRowHeight(36);
         jTable1.setRowHeight(40);
        jTable2.setRowHeight(40);
         refrechTable();
        hide();
        this.setSize(980, 510);
      //  TablePharmaciens.setModel(new Table_Pharmacien(1));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JTabbedPane();
        PanAcceuil = new javax.swing.JPanel();
        PanGPharmatiens = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableDemandePh = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        PanGClients = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableClients = new javax.swing.JTable();
        btnSuppSelec = new javax.swing.JButton();
        btnModifier = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtReference_med = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtNom_med = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cb_Classe_med = new javax.swing.JComboBox();
        cbForme_med = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        btnAjouter = new javax.swing.JButton();
        btnModifier1 = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtPwd1 = new javax.swing.JTextField();
        txtPwd2 = new javax.swing.JTextField();
        txtPwd3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtPwd4 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtPwd5 = new javax.swing.JTextField();
        txtPwd6 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtPwd7 = new javax.swing.JTextField();
        txtPwd8 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnEnrUpdatePhar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtPwd = new javax.swing.JTextField();
        btnAnnuler = new javax.swing.JButton();
        btnUpdateClient = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblnotn = new javax.swing.JLabel();
        lblnotc = new javax.swing.JLabel();
        lblnot = new javax.swing.JLabel();
        btnDeconnect = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Menu.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        Menu.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Menu.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                MenuComponentShown(evt);
            }
        });

        javax.swing.GroupLayout PanAcceuilLayout = new javax.swing.GroupLayout(PanAcceuil);
        PanAcceuil.setLayout(PanAcceuilLayout);
        PanAcceuilLayout.setHorizontalGroup(
            PanAcceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        PanAcceuilLayout.setVerticalGroup(
            PanAcceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );

        Menu.addTab("Acceuil", PanAcceuil);

        jTabbedPane1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Liste des Pharmaciens :");

        jTable2.setModel(new Table_Pharmacien(1));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gérer la liste des Pharmaciens", jPanel1);

        TableDemandePh.setModel(new Table_Liste_Demande_Ph(0));
        TableDemandePh.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                TableDemandePhComponentRemoved(evt);
            }
        });
        jScrollPane3.setViewportView(TableDemandePh);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Liste des Demandes d'inscrit :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(508, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jTabbedPane1.addTab("Gérer les demandes d'inscrit", jPanel2);

        javax.swing.GroupLayout PanGPharmatiensLayout = new javax.swing.GroupLayout(PanGPharmatiens);
        PanGPharmatiens.setLayout(PanGPharmatiensLayout);
        PanGPharmatiensLayout.setHorizontalGroup(
            PanGPharmatiensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        PanGPharmatiensLayout.setVerticalGroup(
            PanGPharmatiensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanGPharmatiensLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Menu.addTab("Gestion Pharmaciens", PanGPharmatiens);

        PanGClients.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Liste des Clients :");
        PanGClients.add(jLabel1);
        jLabel1.setBounds(26, 11, 147, 23);

        TableClients.setModel(new Table_Clients());
        TableClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableClientsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableClients);

        PanGClients.add(jScrollPane1);
        jScrollPane1.setBounds(0, 45, 688, 290);

        btnSuppSelec.setText("Supprimer\n La\n Selection");
        btnSuppSelec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppSelecActionPerformed(evt);
            }
        });
        PanGClients.add(btnSuppSelec);
        btnSuppSelec.setBounds(694, 45, 74, 72);

        btnModifier.setText("Modifier");
        btnModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifierActionPerformed(evt);
            }
        });
        PanGClients.add(btnModifier);
        btnModifier.setBounds(694, 128, 74, 31);
        PanGClients.add(jLabel5);
        jLabel5.setBounds(0, 0, 600, 340);
        PanGClients.add(jLabel7);
        jLabel7.setBounds(540, 0, 240, 340);

        Menu.addTab("Gestion Clients", PanGClients);

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel25.setText("Liste des Medicaments :");

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        jTable1.setModel(new tables.Table_Medicament());
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        Menu.addTab("Gestion Medicaments", jPanel4);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modifier Medicament :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 14))); // NOI18N

        jLabel26.setText("Référence :");

        jLabel27.setText("Nom : ");

        jLabel28.setText("Classe :");

        jLabel29.setText("Forme : ");

        cb_Classe_med.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Allergologie\t", "Anesthésie", "Antalgiques", "Anti-inflammatoires", "Cancérologie et hématologie", "Cardiologie et angéiologie", "Contraception et interruption de grossesse\t", "Dermatologie", "Endocrinologie\t", "Gastro-Entéro-Hépatologie", "Gynécologie\t", "Hémostase et sang", "Immunologie\t", "Infectiologie - Parasitologie", "Métabolisme et nutrition\t", "Neurologie-psychiatrie", "Ophtalmologie\t", "Oto-rhino-laryngologie", "Pneumologie\t", "Produits diagnostiques ", "Rhumatologie\t", "Sang et dérivés", "Stomatologie\t", "Toxicologie", "Urologie néphrologie\t", "Souches Homéopathiques" }));

        cbForme_med.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "orales ", "injectables ", "dermiques ", "inhalées ", "rectales ", " " }));

        jLabel30.setText("Description : ");

        taDescription.setColumns(20);
        taDescription.setRows(5);
        jScrollPane5.setViewportView(taDescription);

        btnAjouter.setText("Ajouter");
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });

        btnModifier1.setText("Modifier");
        btnModifier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifier1ActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnAjouter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(btnModifier1)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel26))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtReference_med)
                                    .addComponent(txtNom_med)
                                    .addComponent(cb_Classe_med, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbForme_med, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                        .addContainerGap(23, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtReference_med, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtNom_med, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_Classe_med, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbForme_med, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(btnModifier1)
                    .addComponent(btnAjouter))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modifier Pharmacien :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 14))); // NOI18N

        jLabel9.setText("Nom :");

        jLabel10.setText("Prenom :");

        jLabel11.setText("Login :");

        jLabel12.setText("Mot de Passe :");

        jLabel13.setText("Référence :");

        jLabel14.setText("Numéro Tel :");

        jLabel15.setText("Adresse :");

        jLabel16.setText("Code Postal :");

        btnEnrUpdatePhar.setText("jButton1");

        jLabel17.setText("jLabel17");

        jLabel18.setText("jLabel18");

        jLabel19.setText("jLabel19");

        jLabel20.setText("jLabel20");

        jLabel21.setText("jLabel21");

        jLabel22.setText("jLabel22");

        jLabel23.setText("jLabel23");

        jLabel24.setText("jLabel24");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEnrUpdatePhar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(txtPwd7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(txtPwd8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(txtPwd6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(txtPwd5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(txtPwd4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(txtPwd3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(txtPwd2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(txtPwd1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPwd1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPwd2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPwd3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtPwd4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtPwd5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPwd6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPwd7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(5, 5, 5)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtPwd8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btnEnrUpdatePhar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modifier Client :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N
        jPanel3.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mot de Passe :");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(16, 100, 99, 19);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Login :");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(31, 64, 44, 19);
        jPanel3.add(txtLogin);
        txtLogin.setBounds(133, 62, 99, 26);
        jPanel3.add(txtPwd);
        txtPwd.setBounds(133, 99, 98, 25);

        btnAnnuler.setText("Annuler");
        btnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerActionPerformed(evt);
            }
        });
        jPanel3.add(btnAnnuler);
        btnAnnuler.setBounds(30, 160, 73, 23);

        btnUpdateClient.setText("Enregistrer");
        btnUpdateClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateClientActionPerformed(evt);
            }
        });
        jPanel3.add(btnUpdateClient);
        btnUpdateClient.setBounds(133, 143, 98, 39);
        jPanel3.add(jLabel6);
        jLabel6.setBounds(10, 20, 250, 310);

        lblnotn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblnotn.setForeground(new java.awt.Color(255, 255, 255));

        lblnotc.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblnotc.setForeground(new java.awt.Color(255, 255, 255));
        lblnotc.setIcon(new javax.swing.ImageIcon("C:\\Users\\HoussemEddine\\Documents\\NetBeansProjects\\TuniPharmaUchiwa\\src\\notifnum.png")); // NOI18N

        lblnot.setIcon(new javax.swing.ImageIcon("C:\\Users\\HoussemEddine\\Documents\\NetBeansProjects\\TuniPharmaUchiwa\\src\\notif.png")); // NOI18N

        btnDeconnect.setText("Déconnecter");
        btnDeconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeconnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnDeconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(687, 687, 687)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(lblnotn, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblnot, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(lblnotc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnDeconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblnotn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblnot, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblnotc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuppSelecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppSelecActionPerformed
        for(int i=0;i<TableClients.getRowCount();i++){
            if(TableClients.getValueAt(i, 10).equals(true)){
                new ClientsDAO().deleteClient(Integer.parseInt(TableClients.getValueAt(i, 0).toString()));
            }
        }
                refrechTable();
                 hide();
    }//GEN-LAST:event_btnSuppSelecActionPerformed

    private void btnModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifierActionPerformed
        for(int i=0;i<=TableClients.getRowCount();i++){
        if(TableClients.isRowSelected(i)){
            
            txtLogin.setText(TableClients.getValueAt(i, 3).toString());
            txtPwd.setText(TableClients.getValueAt(i, 4).toString());
            this.setSize(1280, 510);
            
            break;
        }
        else if(!TableClients.isRowSelected(i)&&i==TableClients.getRowCount())
            JOptionPane.showMessageDialog(this, "Vous devez selectionner un Client !");
        
        
        }
        
    }//GEN-LAST:event_btnModifierActionPerformed

    private void btnUpdateClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateClientActionPerformed
        ModifyMedicament();
        refrechTable();
        hide();
        this.setSize(980, 510);
    }//GEN-LAST:event_btnUpdateClientActionPerformed

    private void TableClientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableClientsMouseClicked
            txtLogin.setText(TableClients.getValueAt(TableClients.getSelectedRow(), 3).toString());
            txtPwd.setText(TableClients.getValueAt(TableClients.getSelectedRow(), 4).toString());
            this.setSize(980, 510);
    }//GEN-LAST:event_TableClientsMouseClicked

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        this.setSize(980, 510);
    }//GEN-LAST:event_btnAnnulerActionPerformed

    private void MenuComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_MenuComponentShown
        this.setSize(980, 510);
        jPanel6.setVisible(false);
    }//GEN-LAST:event_MenuComponentShown

    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed
        this.AddMedicament();
        jTable1.setModel(new tables.Table_Medicament());
        TableColumn column = jTable1.getColumnModel().getColumn(6);
        column.setCellRenderer(new ButtonsRenderer());
        column.setCellEditor(new ButtonsEditor(jTable1));
    }//GEN-LAST:event_btnAjouterActionPerformed

    private void btnModifier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifier1ActionPerformed
        this.ModifyMedicament();
        jTable1.setModel(new tables.Table_Medicament());
    }//GEN-LAST:event_btnModifier1ActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtReference_med.setText("");
        txtNom_med.setText("");
        cb_Classe_med.setSelectedIndex(0);
        taDescription.setText("");
        cbForme_med.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        txtReference_med.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        txtNom_med.setText(jTable1.getValueAt(jTable1.getSelectedRow(),2).toString());
        cb_Classe_med.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(),3).toString());
        taDescription.setText(jTable1.getValueAt(jTable1.getSelectedRow(),4).toString());
        cbForme_med.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(),5).toString());
        this.setSize(1310, 510);
        jLabel31.setIcon(new javax.swing.ImageIcon(jTable1.getValueAt(jTable1.getSelectedRow(),8).toString()));
        jLabel31.setSize(116,109);
        jPanel5.setVisible(false);
        jPanel3.setVisible(false);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        notification();
        jTable2.setModel(new Table_Pharmacien(1));
        TableColumn columnlF = jTable2.getColumnModel().getColumn(15);
        columnlF.setCellRenderer(new ButtonsPhRenderer());
        columnlF.setCellEditor(new ButtonsPhEditor(jTable2));
        Etat();
    }//GEN-LAST:event_formWindowOpened

    private void TableDemandePhComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_TableDemandePhComponentRemoved
        refrechTable();
    }//GEN-LAST:event_TableDemandePhComponentRemoved

    private void btnDeconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeconnectActionPerformed
        Frame_Authentification A=new Frame_Authentification();
        A.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDeconnectActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Frame_Admin().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Frame_Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Menu;
    private javax.swing.JPanel PanAcceuil;
    private javax.swing.JPanel PanGClients;
    private javax.swing.JPanel PanGPharmatiens;
    private javax.swing.JTable TableClients;
    private javax.swing.JTable TableDemandePh;
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDeconnect;
    private javax.swing.JButton btnEnrUpdatePhar;
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton btnModifier1;
    private javax.swing.JButton btnSuppSelec;
    private javax.swing.JButton btnUpdateClient;
    private javax.swing.JComboBox cbForme_med;
    private javax.swing.JComboBox cb_Classe_med;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblnot;
    private javax.swing.JLabel lblnotc;
    private javax.swing.JLabel lblnotn;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNom_med;
    private javax.swing.JTextField txtPwd;
    private javax.swing.JTextField txtPwd1;
    private javax.swing.JTextField txtPwd2;
    private javax.swing.JTextField txtPwd3;
    private javax.swing.JTextField txtPwd4;
    private javax.swing.JTextField txtPwd5;
    private javax.swing.JTextField txtPwd6;
    private javax.swing.JTextField txtPwd7;
    private javax.swing.JTextField txtPwd8;
    private javax.swing.JTextField txtReference_med;
    // End of variables declaration//GEN-END:variables

  public class ButtonsDFPanel extends JPanel {
    
    public final List<JButton> buttons = Arrays.asList(new JButton("Accepter"),new JButton("Refuser"));
    public ButtonsDFPanel() {
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
            
    //    } catch (IOException ex) {
    //        Logger.getLogger(Frame_Admin.class.getName()).log(Level.SEVERE, null, ex);
     //   }
        
    }   
} 

 public class ButtonsDFEditor extends ButtonsDFPanel implements TableCellEditor{
    transient protected ChangeEvent changeEvent = null;

    public ButtonsDFEditor(final JTable table) {
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
     //   buttonsDF.get(1).addMouseListener(ml);
    //    buttons.get(1).addMouseListener(ml);
        //<----

        buttons.get(0).addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                int row = table.convertRowIndexToModel(table.getEditingRow());
                Object o = table.getModel().getValueAt(row, 0);
                fireEditingStopped();
                
                new dao.PharmaciensDAO().updateEtatPharmaciens((int)o);
                table.setModel(new Table_Liste_Demande_Ph(0));
                TableColumn column = table.getColumnModel().getColumn(6);
                column.setCellRenderer(new ButtonsDFRenderer());
                column.setCellEditor(new ButtonsDFEditor(table));
                TableColumn col = table.getColumnModel().getColumn(0);
                col.setMinWidth(0);
                col.setMaxWidth(0);
                col.setWidth(0);
                col.setPreferredWidth(0);
                doLayout();
                TableColumn cole = table.getColumnModel().getColumn(5);
                cole.setMinWidth(0);
                cole.setMaxWidth(0);
                cole.setWidth(0);
                cole.setPreferredWidth(0);
                doLayout();
                TableColumn columnFB = table.getColumnModel().getColumn(5);
                columnFB.setMinWidth(150);
                columnFB.setMaxWidth(150);
                columnFB.setWidth(150);
                doLayout();
                
                
        
    
              notification();
            JOptionPane.showMessageDialog(table, "Le pharmacien a été ajouté !");
             
        
                
            }
            
        });

         buttons.get(1).addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                //Object o = table.getModel().getValueAt(table.getSelectedRow(), 0);
                int row = table.convertRowIndexToModel(table.getEditingRow());
                Object o = table.getModel().getValueAt(row, 0);
                fireEditingStopped();
                new dao.PharmaciensDAO().deletePharmaciens((int)o);
                table.setModel(new Table_Liste_Demande_Ph(0));
                TableColumn column = table.getColumnModel().getColumn(6);
                column.setCellRenderer(new ButtonsDFRenderer());
                column.setCellEditor(new ButtonsDFEditor(table));
                TableColumn col = table.getColumnModel().getColumn(0);
                col.setMinWidth(0);
                col.setMaxWidth(0);
                col.setWidth(0);
                col.setPreferredWidth(0);
                doLayout();
                TableColumn cole = table.getColumnModel().getColumn(5);
                cole.setMinWidth(0);
                cole.setMaxWidth(0);
                cole.setWidth(0);
                cole.setPreferredWidth(0);
                doLayout();
                TableColumn columnFB = table.getColumnModel().getColumn(5);
                columnFB.setMinWidth(150);
                columnFB.setMaxWidth(150);
                columnFB.setWidth(150);
                doLayout();
                JOptionPane.showMessageDialog(table, "La demande a été réfusé !");
                notification();
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
public class ButtonsDFRenderer extends ButtonsDFPanel implements TableCellRenderer {
    public ButtonsDFRenderer() {
        super();
        setName("Table.cellRenderer");
    }
    @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.setBackground(isSelected?table.getSelectionBackground():table.getBackground());
        return this;
    }
    
}

    


 
}

