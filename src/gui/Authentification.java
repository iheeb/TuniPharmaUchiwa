/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.AdminDAO;
import dao.ClientsDAO;
import dao.PharmaciensDAO;
import entities.Admin;
import entities.Clients;
import entities.Pharmaciens;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import javax.swing.JOptionPane;

/**
 *
 * @author salma
 */
public class Authentification extends javax.swing.JFrame {
String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
    AdminDAO admindao=new AdminDAO();
    PharmaciensDAO pharmaciendao= new PharmaciensDAO();
    ClientsDAO clientdao=new ClientsDAO();
    List<Admin> l;
    List<Pharmaciens> lp;
    List<Clients> lc;
    
    
     //verifier les champs de confirmation login w pwd admin
      public boolean VerifierChampsadmin(){
        // controle saisie  login
        if(txtLogin.getText().equals("")||txtLogin.getText().equals("                 "))
        { Erreur.setText("Veuillez _entrer votre identifiant!");
            return false;}
         //controle de saisie mot de passe
         if(txtPwd.getText().equals("")||txtPwd.getText().equals("                  "))
        { Erreur.setText("Veuillez entrer votre mot de passe!");
         return false;}
         
        else return true;}
    //verifier les champs de formulaire d'inscription
    public boolean VerifierChamps_ph(){
        // controle saisie  nom
        if(txtNom_ph.getText().equals("")||txtNom_ph.getText().equals("                 "))
        { erreur_nom_ph.setText("Veuillez entrer votre nom!");
            return false;}
            // controle saisie prenom
        if(txtPrenom_ph.getText().equals("")||txtPrenom_ph.getText().equals("                  "))
        { Erreur_prenom_ph.setText("Veuillez entrer votre prénom!");
            return false;}
        
       // controle saisie cin
        if(txtCin_ph.getText().equals("") )
        { err_cin_ph.setText("\nVeuillez entrer votre cin!");
        return false;
        }
       
        if (txtCin_ph.getText().length()!=8 || ((((Integer.parseInt(txtCin_ph.getText()))% 1 )!=0)))
        {
            err_cin_ph.setText("\n Votre cin est invaide!");
            return false;
        }
       // controle saisie reference
         if(txtReference_ph.getText().equals("")||txtReference_ph.getText().equals("                "))
        { erreur_ref_ph.setText("Veuillez entrer votre réference de pharmacie!");
            return false;}
         // controle saisie mail
          Pattern pattern = Pattern.compile(masque);
         Matcher controler = pattern.matcher(txtMail_ph.getText());
         if (!(controler.matches())){
         // c'est pas bon
         erreur_mail_ph.setText("Veuillez entrer votre mail de la forme de toto@toto.com !");
          return false;

           }
        
          // controle saisie numero
             if(!(txtNum_ph.getText().equals(""))){
          do{
              err_num_ph.setText("Votre numéro de pharmacie doit etre en entier!");
            return false;
          }while(txtNum_ph.getText().length()!=8 || (((Integer.parseInt(txtNum_ph.getText())) < 0)));
        
        }
         
          // controle saisie code postal
         if(txtCodePostal_ph.getText().equals("")||txtCodePostal_ph.getText().equals("                  "))
        { err_codepostal_ph.setText("\nVeuillez entrer votre code postal!");
            return false;}
         
         else if(txtCodePostal_ph.getText().length()!=4 || ((((Integer.parseInt(txtCodePostal_ph.getText()))% 1 )>0))){
             err_codepostal_ph.setText("\n Votre code postal est invalid!");
             return false;
         }
          // controle saisie adresse
         
          if(txtAdresse_ph.getText().equals("")||txtAdresse_ph.getText().equals("                  "))
        { Erreur_Adr_ph.setText("Veuillez entrer votre adresse!");
        return false;}
         
         else
        return true ;
           
    }
    
    
    //verifier la confirmation login w pwd pharmacien
     public boolean VerifierChamps_login_pwd_ph(){
        // controle saisie  identifiant client
        if(txtIdentifiant_ph.getText().equals("")||txtIdentifiant_ph.getText().equals("                 "))
        { err_Identifiant_ph.setText("Veuillez _entrer votre identifiant!");
            return false;}
         //controle de saisie mot de passe
         if(txtPwd1_ph.getText().equals("")||txtPwd1_ph.getText().equals("                  "))
        { err_Identifiant_ph.setText("Veuillez entrer votre mot de passe!");
         return false;}
         if(!(txtPwd1_ph.getText().equals(txtPwd2_ph.getText())))
        { err_Identifiant_ph.setText("Votre mot de passe est incorrecte!");
         return false;}
        else return true;}
     
    
     //verifier les champs de confirmation login w pwd pharmacien inscri
      public boolean VerifierChamps_login_pwd_pharmacien(){
        // controle saisie  login
        if(txtlogin_ph.getText().equals("")||txtlogin_ph.getText().equals("                 "))
        { Erreur_ph.setText("Veuillez _entrer votre identifiant!");
            return false;}
         //controle de saisie mot de passe
         if(txtPwd_ph.getText().equals("")||txtPwd_ph.getText().equals("                  "))
        { Erreur_ph.setText("Veuillez entrer votre mot de passe!");
         return false;}
         
        else return true;}
      
      
      //verifier les champs de confirmation login w pwd client inscri
     public boolean VerifierChamps_login_pwd_clt(){
        // controle saisie  identifiant client
        if(txtLogin_clt.getText().equals("")||txtLogin_clt.getText().equals("                 "))
        { Erreur_clt.setText("Veuillez _entrer votre identifiant!");
            return false;}
         //controle de saisie mot de passe
         if(txtPwd_clt.getText().equals("")||txtPwd_clt.getText().equals("                  "))
        { Erreur_clt.setText("Veuillez entrer votre mot de passe!");
         return false;}
         
        else return true;}
     
     
     
     //verifier les champs de confirmation login w pwd client
     public boolean VerifierChamps_clt(){
        // controle saisie  nom client
        if(txtNom_clt.getText().equals("")||txtNom_clt.getText().equals("                 "))
        { err_nom_clt.setText("Veuillez _entrer votre nom!");
            return false;}
        
            // controle saisie prenom client
        if(txtPrenom_clt.getText().equals("")||txtPrenom_clt.getText().equals("                  "))
        { err_prenom_clt.setText("Veuillez entrer votre prénom!");
            return false;}
        
        // controle de saisie identifiant
         if(txtIdentifiant_clt.getText().equals("")||txtIdentifiant_clt.getText().equals("                  "))
        { err_identifiant_clt.setText("Veuillez entrer votre identifiant!");
            return false;}
         
         //controle de saisie mot de passe
         if(txtPwd1_clt.getText().equals("")||txtPwd1_clt.getText().equals("                  "))
        { err_Pwd1_clt.setText("Veuillez entrer votre mot de passe!");
         return false;}
         if(!(txtPwd1_clt.getText().equals(txtPwd2_clt.getText()))){ 
         err_Pwd2_clt.setText("Votre mot de passe est incorrecte!");
         return false;}
          // controle saisie code postal
         if(txtCodePostal_clt.getText().equals(""))
        { err_codepostal_ph.setText("\nVeuillez entrer votre code postal!");
            return false;}
         
         else if(txtCodePostal_clt.getText().length()!=4 || ((((Integer.parseInt(txtCodePostal_clt.getText()))% 1 )>0))){
             err_codepostal_ph.setText("\n Votre code postal est invalid!");
             return false;
         }
          // controle saisie adresse
         
          if(txtAdresse_clt.getText().equals("")||txtAdresse_clt.getText().equals("                  "))
        { Erreur_Adr_ph.setText("Veuillez entrer votre adresse!");
        return false;}
       else
        return true ;
     }
     
     //verifier les champs de 
    public Authentification() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        Admin = new javax.swing.JPanel();
        PanelAdmin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        btnConnect = new javax.swing.JButton();
        txtPwd = new javax.swing.JPasswordField();
        Erreur = new javax.swing.JLabel();
        Client = new javax.swing.JPanel();
        PanelClientConnect = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtLogin_clt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnConnect_clt = new javax.swing.JButton();
        Sinscrire_clt = new javax.swing.JLabel();
        txtPwd_clt = new javax.swing.JPasswordField();
        Erreur_clt = new javax.swing.JLabel();
        PanelClientSinscrire = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnSinscrire_clt = new javax.swing.JButton();
        txtNom_clt = new javax.swing.JTextField();
        txtMail_clt = new javax.swing.JTextField();
        txtPrenom_clt = new javax.swing.JTextField();
        txtCodePostal_clt = new javax.swing.JTextField();
        txtIdentifiant_clt = new javax.swing.JTextField();
        txtAdresse_clt = new javax.swing.JTextField();
        txtPwd2_clt = new javax.swing.JPasswordField();
        txtPwd1_clt = new javax.swing.JPasswordField();
        comboxPays_clt = new javax.swing.JComboBox();
        err_identifiant_clt = new javax.swing.JLabel();
        err_prenom_clt = new javax.swing.JLabel();
        err_nom_clt = new javax.swing.JLabel();
        err_mail_clt = new javax.swing.JLabel();
        err_Pwd1_clt = new javax.swing.JLabel();
        err_Pwd2_clt = new javax.swing.JLabel();
        Pharmacien = new javax.swing.JPanel();
        PanelPharmacienConnet = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtlogin_ph = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnConnect_ph = new javax.swing.JButton();
        txtPwd_ph = new javax.swing.JPasswordField();
        Erreur_ph = new javax.swing.JLabel();
        Sinscrire_ph = new javax.swing.JLabel();
        PanelPharmacienSinscrire = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNom_ph = new javax.swing.JTextField();
        txtPrenom_ph = new javax.swing.JTextField();
        txtCin_ph = new javax.swing.JTextField();
        txtReference_ph = new javax.swing.JTextField();
        txtMail_ph = new javax.swing.JTextField();
        txtDiplome_ph = new javax.swing.JTextField();
        txtCodePostal_ph = new javax.swing.JTextField();
        erreur_nom_ph = new javax.swing.JLabel();
        Erreur_prenom_ph = new javax.swing.JLabel();
        erreur_ref_ph = new javax.swing.JLabel();
        Erreur_Adr_ph = new javax.swing.JLabel();
        err_cin_ph = new javax.swing.JLabel();
        err_codepostal_ph = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtNum_ph = new javax.swing.JTextField();
        txtAdresse_ph = new javax.swing.JTextField();
        err_diplome_ph = new javax.swing.JLabel();
        btn_suivant_ph = new javax.swing.JButton();
        erreur_mail_ph = new javax.swing.JLabel();
        jCalendar3 = new com.toedter.calendar.JCalendar();
        jLabel12 = new javax.swing.JLabel();
        err_num_ph = new javax.swing.JLabel();
        panelPharmacieSinscrire2 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        btnSinscrire_ph = new javax.swing.JButton();
        txtIdentifiant_ph = new javax.swing.JTextField();
        btn_precedent_ph = new javax.swing.JButton();
        txtPwd1_ph = new javax.swing.JPasswordField();
        txtPwd2_ph = new javax.swing.JPasswordField();
        err_Identifiant_ph = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        Admin.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                AdminComponentShown(evt);
            }
        });

        PanelAdmin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Identifiant :");

        jLabel2.setText("Mot de passe :");

        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLoginKeyTyped(evt);
            }
        });

        btnConnect.setText("Se connecter");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        txtPwd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPwdKeyTyped(evt);
            }
        });

        Erreur.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout PanelAdminLayout = new javax.swing.GroupLayout(PanelAdmin);
        PanelAdmin.setLayout(PanelAdminLayout);
        PanelAdminLayout.setHorizontalGroup(
            PanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAdminLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(Erreur, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addGap(173, 173, 173))
            .addGroup(PanelAdminLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(PanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPwd)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        PanelAdminLayout.setVerticalGroup(
            PanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAdminLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Erreur, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AdminLayout = new javax.swing.GroupLayout(Admin);
        Admin.setLayout(AdminLayout);
        AdminLayout.setHorizontalGroup(
            AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(352, Short.MAX_VALUE))
        );
        AdminLayout.setVerticalGroup(
            AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(PanelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(265, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Admin", Admin);

        PanelClientConnect.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Identifiant :");

        txtLogin_clt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLogin_cltKeyTyped(evt);
            }
        });

        jLabel6.setText("Mot de passe :");

        btnConnect_clt.setText("Se connecter");
        btnConnect_clt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnect_cltActionPerformed(evt);
            }
        });

        Sinscrire_clt.setText("S'inscrire");
        Sinscrire_clt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Sinscrire_cltMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Sinscrire_cltMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Sinscrire_cltMouseExited(evt);
            }
        });

        txtPwd_clt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPwd_cltKeyTyped(evt);
            }
        });

        Erreur_clt.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout PanelClientConnectLayout = new javax.swing.GroupLayout(PanelClientConnect);
        PanelClientConnect.setLayout(PanelClientConnectLayout);
        PanelClientConnectLayout.setHorizontalGroup(
            PanelClientConnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientConnectLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelClientConnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelClientConnectLayout.createSequentialGroup()
                        .addComponent(btnConnect_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addGroup(PanelClientConnectLayout.createSequentialGroup()
                        .addGroup(PanelClientConnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPwd_clt)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLogin_clt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelClientConnectLayout.createSequentialGroup()
                .addGroup(PanelClientConnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Erreur_clt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelClientConnectLayout.createSequentialGroup()
                        .addContainerGap(98, Short.MAX_VALUE)
                        .addComponent(Sinscrire_clt)))
                .addGap(18, 18, 18))
        );
        PanelClientConnectLayout.setVerticalGroup(
            PanelClientConnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientConnectLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLogin_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPwd_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(Erreur_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConnect_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Sinscrire_clt)
                .addGap(4, 4, 4))
        );

        PanelClientSinscrire.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setText("Nom :");

        jLabel16.setText("Prénom :");

        jLabel17.setText("Identifiant :");

        jLabel18.setText("Mot de passe :");

        jLabel19.setText("Retapez votre mot de passe :");

        jLabel20.setText("Mail :");

        jLabel21.setText("Pays :");

        jLabel22.setText("Adresse :");

        jLabel23.setText("Code postal :");

        btnSinscrire_clt.setText("S'inscrire");
        btnSinscrire_clt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSinscrire_cltActionPerformed(evt);
            }
        });

        txtNom_clt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNom_cltKeyTyped(evt);
            }
        });

        txtMail_clt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMail_cltKeyTyped(evt);
            }
        });

        txtPrenom_clt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrenom_cltKeyTyped(evt);
            }
        });

        txtIdentifiant_clt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentifiant_cltKeyTyped(evt);
            }
        });

        txtPwd2_clt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPwd2_cltKeyTyped(evt);
            }
        });

        txtPwd1_clt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPwd1_cltKeyTyped(evt);
            }
        });

        comboxPays_clt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tunis", "Ariana", "Manouba" }));

        err_identifiant_clt.setForeground(new java.awt.Color(255, 0, 0));

        err_prenom_clt.setForeground(new java.awt.Color(255, 0, 0));

        err_nom_clt.setForeground(new java.awt.Color(255, 0, 0));

        err_mail_clt.setForeground(new java.awt.Color(255, 0, 0));

        err_Pwd1_clt.setForeground(new java.awt.Color(255, 0, 0));

        err_Pwd2_clt.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout PanelClientSinscrireLayout = new javax.swing.GroupLayout(PanelClientSinscrire);
        PanelClientSinscrire.setLayout(PanelClientSinscrireLayout);
        PanelClientSinscrireLayout.setHorizontalGroup(
            PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientSinscrireLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15))
                .addGap(94, 94, 94)
                .addGroup(PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelClientSinscrireLayout.createSequentialGroup()
                        .addGroup(PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMail_clt)
                            .addComponent(txtNom_clt)
                            .addComponent(txtPrenom_clt)
                            .addComponent(txtIdentifiant_clt)
                            .addComponent(txtPwd2_clt)
                            .addComponent(comboxPays_clt, 0, 207, Short.MAX_VALUE)
                            .addComponent(txtPwd1_clt, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(err_nom_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(err_identifiant_clt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(err_Pwd1_clt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(err_Pwd2_clt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(err_prenom_clt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(err_mail_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtCodePostal_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelClientSinscrireLayout.createSequentialGroup()
                        .addComponent(txtAdresse_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(btnSinscrire_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PanelClientSinscrireLayout.setVerticalGroup(
            PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientSinscrireLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(txtNom_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(err_nom_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(err_prenom_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(txtPrenom_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(txtIdentifiant_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(err_identifiant_clt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(err_Pwd1_clt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(txtPwd1_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelClientSinscrireLayout.createSequentialGroup()
                        .addGroup(PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtPwd2_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(PanelClientSinscrireLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(err_Pwd2_clt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(txtMail_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(err_mail_clt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(comboxPays_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodePostal_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(6, 6, 6)
                .addGroup(PanelClientSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdresse_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(15, 15, 15)
                .addComponent(btnSinscrire_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout ClientLayout = new javax.swing.GroupLayout(Client);
        Client.setLayout(ClientLayout);
        ClientLayout.setHorizontalGroup(
            ClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(PanelClientConnect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelClientSinscrire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        ClientLayout.setVerticalGroup(
            ClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelClientSinscrire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelClientConnect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 159, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Client", Client);

        PanelPharmacienConnet.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Identifiant :");

        txtlogin_ph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlogin_phActionPerformed(evt);
            }
        });
        txtlogin_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtlogin_phKeyTyped(evt);
            }
        });

        jLabel4.setText("Mot de passe :");

        btnConnect_ph.setText("Se connecter");
        btnConnect_ph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnect_phActionPerformed(evt);
            }
        });

        txtPwd_ph.setToolTipText("");

        Erreur_ph.setForeground(new java.awt.Color(255, 0, 0));

        Sinscrire_ph.setText("S'inscrire");
        Sinscrire_ph.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Sinscrire_phMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Sinscrire_phMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Sinscrire_phMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelPharmacienConnetLayout = new javax.swing.GroupLayout(PanelPharmacienConnet);
        PanelPharmacienConnet.setLayout(PanelPharmacienConnetLayout);
        PanelPharmacienConnetLayout.setHorizontalGroup(
            PanelPharmacienConnetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPharmacienConnetLayout.createSequentialGroup()
                .addGroup(PanelPharmacienConnetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPharmacienConnetLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPharmacienConnetLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtlogin_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPharmacienConnetLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPharmacienConnetLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtPwd_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPharmacienConnetLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Erreur_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPharmacienConnetLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnConnect_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPharmacienConnetLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(Sinscrire_ph)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        PanelPharmacienConnetLayout.setVerticalGroup(
            PanelPharmacienConnetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPharmacienConnetLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(txtlogin_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(txtPwd_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(Erreur_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnConnect_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Sinscrire_ph))
        );

        PanelPharmacienSinscrire.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setText("Nom :");

        jLabel8.setText("Prenom :");

        jLabel9.setText("CIN :");

        jLabel10.setText("Mail :");

        jLabel11.setText("Date de naissance :");

        jLabel13.setText("Code Postal :");

        jLabel14.setText("Reference :");

        txtNom_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNom_phKeyTyped(evt);
            }
        });

        txtPrenom_ph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrenom_phActionPerformed(evt);
            }
        });
        txtPrenom_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrenom_phKeyTyped(evt);
            }
        });

        txtCin_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCin_phKeyTyped(evt);
            }
        });

        txtReference_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtReference_phKeyTyped(evt);
            }
        });

        txtMail_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMail_phKeyTyped(evt);
            }
        });

        txtDiplome_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiplome_phKeyTyped(evt);
            }
        });

        txtCodePostal_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodePostal_phKeyTyped(evt);
            }
        });

        erreur_nom_ph.setForeground(new java.awt.Color(255, 0, 0));

        Erreur_prenom_ph.setForeground(new java.awt.Color(255, 0, 0));

        erreur_ref_ph.setForeground(new java.awt.Color(255, 0, 0));

        Erreur_Adr_ph.setForeground(new java.awt.Color(255, 0, 0));

        err_cin_ph.setForeground(new java.awt.Color(255, 0, 0));

        err_codepostal_ph.setForeground(new java.awt.Color(255, 0, 0));

        jLabel25.setText("Diplome :");

        jLabel26.setText("Numero de pharmacie :");

        txtNum_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNum_phKeyTyped(evt);
            }
        });

        txtAdresse_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAdresse_phKeyTyped(evt);
            }
        });

        err_diplome_ph.setForeground(new java.awt.Color(255, 0, 0));

        btn_suivant_ph.setText("Suivant");
        btn_suivant_ph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suivant_phActionPerformed(evt);
            }
        });

        erreur_mail_ph.setForeground(new java.awt.Color(255, 0, 0));

        jLabel12.setText("Adresse :");

        err_num_ph.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout PanelPharmacienSinscrireLayout = new javax.swing.GroupLayout(PanelPharmacienSinscrire);
        PanelPharmacienSinscrire.setLayout(PanelPharmacienSinscrireLayout);
        PanelPharmacienSinscrireLayout.setHorizontalGroup(
            PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPharmacienSinscrireLayout.createSequentialGroup()
                .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelPharmacienSinscrireLayout.createSequentialGroup()
                        .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCin_ph, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtReference_ph, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNom_ph, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelPharmacienSinscrireLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPrenom_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPharmacienSinscrireLayout.createSequentialGroup()
                        .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDiplome_ph)
                            .addComponent(txtAdresse_ph, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(txtCodePostal_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelPharmacienSinscrireLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMail_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPharmacienSinscrireLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCalendar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPharmacienSinscrireLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNum_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPharmacienSinscrireLayout.createSequentialGroup()
                        .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPharmacienSinscrireLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(err_cin_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelPharmacienSinscrireLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(erreur_ref_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Erreur_prenom_ph, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                        .addComponent(erreur_nom_ph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(PanelPharmacienSinscrireLayout.createSequentialGroup()
                        .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPharmacienSinscrireLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(erreur_mail_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelPharmacienSinscrireLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(err_diplome_ph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Erreur_Adr_ph, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(btn_suivant_ph, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(err_num_ph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(err_codepostal_ph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(PanelPharmacienSinscrireLayout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelPharmacienSinscrireLayout.setVerticalGroup(
            PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPharmacienSinscrireLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNom_ph, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(erreur_nom_ph, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPrenom_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Erreur_prenom_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(err_cin_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCin_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReference_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(erreur_ref_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMail_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(erreur_mail_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiplome_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(err_diplome_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jCalendar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPharmacienSinscrireLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(err_num_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(txtNum_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelPharmacienSinscrireLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(err_codepostal_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Erreur_Adr_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPharmacienSinscrireLayout.createSequentialGroup()
                        .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelPharmacienSinscrireLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCodePostal_ph, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelPharmacienSinscrireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAdresse_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_suivant_ph)
                .addGap(6, 6, 6))
        );

        panelPharmacieSinscrire2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel27.setText("Identifiant :");

        jLabel28.setText("Mot de passe :");

        jLabel29.setText("Confirmer votre mot de passe :");

        btnSinscrire_ph.setText("s'inscrire");
        btnSinscrire_ph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSinscrire_phActionPerformed(evt);
            }
        });

        btn_precedent_ph.setText("Precédent");
        btn_precedent_ph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_precedent_phActionPerformed(evt);
            }
        });

        err_Identifiant_ph.setForeground(new java.awt.Color(255, 0, 0));
        err_Identifiant_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                err_Identifiant_phKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelPharmacieSinscrire2Layout = new javax.swing.GroupLayout(panelPharmacieSinscrire2);
        panelPharmacieSinscrire2.setLayout(panelPharmacieSinscrire2Layout);
        panelPharmacieSinscrire2Layout.setHorizontalGroup(
            panelPharmacieSinscrire2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPharmacieSinscrire2Layout.createSequentialGroup()
                .addGroup(panelPharmacieSinscrire2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPharmacieSinscrire2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelPharmacieSinscrire2Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(panelPharmacieSinscrire2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel29)
                                .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelPharmacieSinscrire2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtIdentifiant_ph, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addComponent(txtPwd1_ph)
                                .addComponent(txtPwd2_ph)))
                        .addGroup(panelPharmacieSinscrire2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btn_precedent_ph)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                            .addComponent(btnSinscrire_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelPharmacieSinscrire2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(err_Identifiant_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPharmacieSinscrire2Layout.setVerticalGroup(
            panelPharmacieSinscrire2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPharmacieSinscrire2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelPharmacieSinscrire2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtIdentifiant_ph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(panelPharmacieSinscrire2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtPwd1_ph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPharmacieSinscrire2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtPwd2_ph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(err_Identifiant_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPharmacieSinscrire2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSinscrire_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_precedent_ph))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout PharmacienLayout = new javax.swing.GroupLayout(Pharmacien);
        Pharmacien.setLayout(PharmacienLayout);
        PharmacienLayout.setHorizontalGroup(
            PharmacienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PharmacienLayout.createSequentialGroup()
                .addGroup(PharmacienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PharmacienLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelPharmacieSinscrire2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PharmacienLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(PanelPharmacienConnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(PanelPharmacienSinscrire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PharmacienLayout.setVerticalGroup(
            PharmacienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PharmacienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelPharmacienConnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelPharmacieSinscrire2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(PharmacienLayout.createSequentialGroup()
                .addComponent(PanelPharmacienSinscrire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Pharmacien", Pharmacien);

        getContentPane().add(jTabbedPane2);
        jTabbedPane2.setBounds(10, 0, 848, 662);
        jTabbedPane2.getAccessibleContext().setAccessibleName("Admin");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtlogin_phActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlogin_phActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlogin_phActionPerformed

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
      if(VerifierChampsadmin()==true){  
          for(Admin a:l){
            if(a.getLogin().equals(txtLogin.getText()) && a.getPwd().equals(txtPwd.getText())){
                //Frame_Gestion_Medicaments f=new Frame_Gestion_Medicaments();
                JOptionPane.showMessageDialog(this, "Bienvenue à TUNIPHARMA vous ete connecté !");
                //this.setVisible(false);
                //f.setVisible(true);
                break;
            }
            else
            Erreur.setText("verifiez votre identifiant et votre mot de passe");
        }
      }
    }//GEN-LAST:event_btnConnectActionPerformed

    private void AdminComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_AdminComponentShown
         
        
    }//GEN-LAST:event_AdminComponentShown

    private void Sinscrire_phMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sinscrire_phMouseClicked
        PanelPharmacienSinscrire.setVisible(true);
        PanelPharmacienConnet.setVisible(false);
    }//GEN-LAST:event_Sinscrire_phMouseClicked

    private void Sinscrire_phMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sinscrire_phMouseEntered
        Sinscrire_ph.setForeground(Color.BLUE);
    }//GEN-LAST:event_Sinscrire_phMouseEntered

    private void Sinscrire_phMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sinscrire_phMouseExited
        Sinscrire_ph.setForeground(Color.BLACK);
    }//GEN-LAST:event_Sinscrire_phMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       lc=new ArrayList<Clients>();
       lp = new ArrayList<Pharmaciens>();
       l=new ArrayList<Admin>();
       
        
        l=admindao.GetAllAdmins();
        lp=pharmaciendao.GetAllPharmaciens();
        lc=clientdao.GetAllClients();
        
        PanelPharmacienConnet.setVisible(true);
        PanelPharmacienSinscrire.setVisible(false);
        PanelClientSinscrire.setVisible(false);
        panelPharmacieSinscrire2.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void txtDiplome_phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiplome_phKeyTyped
        Erreur_Adr_ph.setText("");
    }//GEN-LAST:event_txtDiplome_phKeyTyped

    private void txtReference_phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReference_phKeyTyped
        erreur_ref_ph.setText("");
    }//GEN-LAST:event_txtReference_phKeyTyped

    private void txtPrenom_phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrenom_phKeyTyped
        Erreur_prenom_ph.setText("");
    }//GEN-LAST:event_txtPrenom_phKeyTyped

    private void txtPrenom_phActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrenom_phActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrenom_phActionPerformed

    private void txtNom_phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNom_phKeyTyped
        erreur_nom_ph.setText("");
    }//GEN-LAST:event_txtNom_phKeyTyped

    private void Sinscrire_cltMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sinscrire_cltMouseClicked
        PanelClientSinscrire.setVisible(true);
        PanelClientConnect.setVisible(false);
        panelPharmacieSinscrire2.setVisible(false);
    }//GEN-LAST:event_Sinscrire_cltMouseClicked

    private void Sinscrire_cltMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sinscrire_cltMouseEntered
         Sinscrire_clt.setForeground(Color.BLUE);
    }//GEN-LAST:event_Sinscrire_cltMouseEntered

    private void Sinscrire_cltMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sinscrire_cltMouseExited
        Sinscrire_clt.setForeground(Color.BLACK);
    }//GEN-LAST:event_Sinscrire_cltMouseExited

    private void btn_suivant_phActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suivant_phActionPerformed
       
        
        if(VerifierChamps_ph()==true){
        PanelPharmacienSinscrire.setVisible(false);
        PanelPharmacienConnet.setVisible(false);
        panelPharmacieSinscrire2.setVisible(true);
    }
    }//GEN-LAST:event_btn_suivant_phActionPerformed

    private void btn_precedent_phActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_precedent_phActionPerformed
       PanelPharmacienSinscrire.setVisible(true);
        PanelPharmacienConnet.setVisible(false);
        panelPharmacieSinscrire2.setVisible(false);
    }//GEN-LAST:event_btn_precedent_phActionPerformed

    private void btnSinscrire_cltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSinscrire_cltActionPerformed
        if(VerifierChamps_clt()==true){
            
           PanelClientSinscrire.setVisible(false);
        PanelClientConnect.setVisible(true);
        JOptionPane.showMessageDialog(this, "Bienvenue à TUNIPHARMA !");
        }
    }//GEN-LAST:event_btnSinscrire_cltActionPerformed

    private void btnConnect_cltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnect_cltActionPerformed
       if(VerifierChamps_login_pwd_clt()){
        for(Clients a:lc){
            if(a.getLogin_clt().equals(txtLogin_clt.getText()) && a.getPwd_clt().equals(txtPwd_clt.getText())){
               
                //Frame_Gestion_Medicaments f=new Frame_Gestion_Medicaments();
               // this.setVisible(false);
               // f.setVisible(true);
                 JOptionPane.showMessageDialog(this, "Bienvenue à TUNIPHARMA vous ete connecté !");
                break;
            }
            else
            Erreur_clt.setText("verifiez votre identifiant et votre mot de passe");
        }
       }
    }//GEN-LAST:event_btnConnect_cltActionPerformed

    private void btnConnect_phActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnect_phActionPerformed
         if(VerifierChamps_login_pwd_pharmacien()==true){
             for(Pharmaciens a:lp){
            if(a.getLogin_pharmacien().equals(txtlogin_ph.getText()) && a.getPwd_pharmacien().equals(txtPwd_ph.getText())){
               // Frame_Gestion_Medicaments f=new Frame_Gestion_Medicaments();
               // this.setVisible(false);
               // f.setVisible(true);
                 JOptionPane.showMessageDialog(this, "Bienvenue à TUNIPHARMA vous ete connecté !");
                break;
            }
            else
            Erreur_ph.setText("verifiez votre identifiant et votre mot de passe");
        }
         }
        
    }//GEN-LAST:event_btnConnect_phActionPerformed

    private void btnSinscrire_phActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSinscrire_phActionPerformed
        if(VerifierChamps_login_pwd_ph()==true){
        Pharmaciens pharmacien=new Pharmaciens();
        pharmacien.setNom_pharmacien(txtNom_ph.getText());
        pharmacien.setPrenom_pharmacien(txtPrenom_ph.getText());
        pharmacien.setLogin_pharmacien(txtIdentifiant_ph.getText());
        pharmacien.setCin_pharmacien(Integer.parseInt(txtCin_ph.getText()));
        pharmacien.setDiplome_pharmacien(txtDiplome_ph.getText());
        pharmacien.setMail_pharamacien(txtMail_ph.getText());
        pharmacien.setPwd_pharmacien(txtPwd1_ph.getText());
        pharmacien.setNumtel_pahramcien(Integer.parseInt(txtNum_ph.getText()));
        pharmacien.setDate_naiss_pharmacien(jCalendar3.getDate().toString());
        pharmacien.setEtat_pharmacien(0);
        pharmacien.setReference_pharmacien(txtReference_ph.getText());
        pharmacien.setCode_postal_pharmacien(Integer.parseInt(txtCodePostal_ph.getText()));
        pharmacien.setAdresse_pharmacien(txtAdresse_ph.getText());
        
        new dao.PharmaciensDAO().insertPharmaciens(pharmacien);
         JOptionPane.showMessageDialog(this, "Bienvenue à TUNIPHARMA votre demande d'inscription a etais envoyer avec succés !");
        }
        
    }//GEN-LAST:event_btnSinscrire_phActionPerformed

    private void txtCin_phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCin_phKeyTyped
        err_cin_ph.setText("");
    }//GEN-LAST:event_txtCin_phKeyTyped

    private void txtMail_phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMail_phKeyTyped
erreur_mail_ph.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_txtMail_phKeyTyped

    private void txtCodePostal_phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodePostal_phKeyTyped
err_codepostal_ph.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodePostal_phKeyTyped

    private void txtNum_phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNum_phKeyTyped
err_num_ph.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_txtNum_phKeyTyped

    private void txtAdresse_phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdresse_phKeyTyped
Erreur_Adr_ph.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdresse_phKeyTyped

    private void txtNom_cltKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNom_cltKeyTyped
      err_nom_clt.setText("");
    }//GEN-LAST:event_txtNom_cltKeyTyped

    private void txtPrenom_cltKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrenom_cltKeyTyped
        err_prenom_clt.setText("");
    }//GEN-LAST:event_txtPrenom_cltKeyTyped

    private void txtIdentifiant_cltKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentifiant_cltKeyTyped
        err_identifiant_clt.setText("");
    }//GEN-LAST:event_txtIdentifiant_cltKeyTyped

    private void txtPwd1_cltKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPwd1_cltKeyTyped
       err_Pwd1_clt.setText("");
    }//GEN-LAST:event_txtPwd1_cltKeyTyped

    private void txtPwd2_cltKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPwd2_cltKeyTyped
       err_Pwd2_clt.setText("");
    }//GEN-LAST:event_txtPwd2_cltKeyTyped

    private void txtMail_cltKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMail_cltKeyTyped
        err_mail_clt.setText("");
    }//GEN-LAST:event_txtMail_cltKeyTyped

    private void err_Identifiant_phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_err_Identifiant_phKeyTyped
       err_Identifiant_ph.setText("");
    }//GEN-LAST:event_err_Identifiant_phKeyTyped

    private void txtPwdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPwdKeyTyped
       Erreur.setText("");
    }//GEN-LAST:event_txtPwdKeyTyped

    private void txtLoginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyTyped
         Erreur.setText("");
    }//GEN-LAST:event_txtLoginKeyTyped

    private void txtlogin_phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtlogin_phKeyTyped
        Erreur_ph.setText("");
    }//GEN-LAST:event_txtlogin_phKeyTyped

    private void txtLogin_cltKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLogin_cltKeyTyped
        Erreur_clt.setText("");
    }//GEN-LAST:event_txtLogin_cltKeyTyped

    private void txtPwd_cltKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPwd_cltKeyTyped
        Erreur_clt.setText("");
    }//GEN-LAST:event_txtPwd_cltKeyTyped

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
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Authentification().setVisible(true);
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Admin;
    private javax.swing.JPanel Client;
    private javax.swing.JLabel Erreur;
    private javax.swing.JLabel Erreur_Adr_ph;
    private javax.swing.JLabel Erreur_clt;
    private javax.swing.JLabel Erreur_ph;
    private javax.swing.JLabel Erreur_prenom_ph;
    private javax.swing.JPanel PanelAdmin;
    private javax.swing.JPanel PanelClientConnect;
    private javax.swing.JPanel PanelClientSinscrire;
    private javax.swing.JPanel PanelPharmacienConnet;
    private javax.swing.JPanel PanelPharmacienSinscrire;
    private javax.swing.JPanel Pharmacien;
    private javax.swing.JLabel Sinscrire_clt;
    private javax.swing.JLabel Sinscrire_ph;
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnConnect_clt;
    private javax.swing.JButton btnConnect_ph;
    private javax.swing.JButton btnSinscrire_clt;
    private javax.swing.JButton btnSinscrire_ph;
    private javax.swing.JButton btn_precedent_ph;
    private javax.swing.JButton btn_suivant_ph;
    private javax.swing.JComboBox comboxPays_clt;
    private javax.swing.JLabel err_Identifiant_ph;
    private javax.swing.JLabel err_Pwd1_clt;
    private javax.swing.JLabel err_Pwd2_clt;
    private javax.swing.JLabel err_cin_ph;
    private javax.swing.JLabel err_codepostal_ph;
    private javax.swing.JLabel err_diplome_ph;
    private javax.swing.JLabel err_identifiant_clt;
    private javax.swing.JLabel err_mail_clt;
    private javax.swing.JLabel err_nom_clt;
    private javax.swing.JLabel err_num_ph;
    private javax.swing.JLabel err_prenom_clt;
    private javax.swing.JLabel erreur_mail_ph;
    private javax.swing.JLabel erreur_nom_ph;
    private javax.swing.JLabel erreur_ref_ph;
    private com.toedter.calendar.JCalendar jCalendar3;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel panelPharmacieSinscrire2;
    private javax.swing.JTextField txtAdresse_clt;
    private javax.swing.JTextField txtAdresse_ph;
    private javax.swing.JTextField txtCin_ph;
    private javax.swing.JTextField txtCodePostal_clt;
    private javax.swing.JTextField txtCodePostal_ph;
    private javax.swing.JTextField txtDiplome_ph;
    private javax.swing.JTextField txtIdentifiant_clt;
    private javax.swing.JTextField txtIdentifiant_ph;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtLogin_clt;
    private javax.swing.JTextField txtMail_clt;
    private javax.swing.JTextField txtMail_ph;
    private javax.swing.JTextField txtNom_clt;
    private javax.swing.JTextField txtNom_ph;
    private javax.swing.JTextField txtNum_ph;
    private javax.swing.JTextField txtPrenom_clt;
    private javax.swing.JTextField txtPrenom_ph;
    private javax.swing.JPasswordField txtPwd;
    private javax.swing.JPasswordField txtPwd1_clt;
    private javax.swing.JPasswordField txtPwd1_ph;
    private javax.swing.JPasswordField txtPwd2_clt;
    private javax.swing.JPasswordField txtPwd2_ph;
    private javax.swing.JPasswordField txtPwd_clt;
    private javax.swing.JPasswordField txtPwd_ph;
    private javax.swing.JTextField txtReference_ph;
    private javax.swing.JTextField txtlogin_ph;
    // End of variables declaration//GEN-END:variables
}
