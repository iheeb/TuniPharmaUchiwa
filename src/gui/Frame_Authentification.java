/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

        
import com.alee.laf.WebLookAndFeel;
import dao.AdminDAO;
import dao.ClientsDAO;
import dao.PharmaciensDAO;
import entities.Admin;
import entities.Clients;
import entities.Pharmaciens;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author HoussemEddine
 */
public class Frame_Authentification extends javax.swing.JFrame {
    
    String[] to;
    String subject;

    String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
    AdminDAO admindao=new AdminDAO();
    PharmaciensDAO pharmaciendao= new PharmaciensDAO();
    ClientsDAO clientdao=new ClientsDAO();
    List<Admin> l;
    List<Pharmaciens> lp;
    List<Clients> lc;
     Frame_Admin f;
     //verifier les champs de confirmation login w pwd admin
      public boolean VerifierChamps_admin(){
        // controle saisie  login
        if(tfLogin_Admin.getText().equals("")||tfLogin_Admin.getText().equals("                 "))
        { Erreur_Admin.setText("Veuillez _entrer votre identifiant!");
            return false;}
         //controle de saisie mot de passe
         if(pfPwd_Admin.getText().equals("")||pfPwd_Admin.getText().equals("                  "))
        { Erreur_Admin.setText("Veuillez entrer votre mot de passe!");
         return false;}
         
        else return true;}
      
       //verifier les champs de confirmation login w pwd pharmacien inscri
      public boolean VerifierChamps_login_pwd_pharmacien(){
        // controle saisie  login
        if(tfLogin_Ph.getText().equals("")||tfLogin_Ph.getText().equals("                 "))
        { Erreur_ph.setText("Veuillez _entrer votre identifiant!");
            return false;}
         //controle de saisie mot de passe
         if(pfPwd_Ph.getText().equals("")||pfPwd_Ph.getText().equals("                  "))
        { Erreur_ph.setText("Veuillez entrer votre mot de passe!");
         return false;}
         
        else return true;}
      
      
      
       //verifier les champs de formulaire d'inscription pharmacien
    public boolean VerifierChamps_formulaire_ph(){
        // controle saisie  nom
        if(tf_Nom_ph.getText().equals("")||tf_Nom_ph.getText().equals("                 "))
        { err_nom_ph.setText("Veuillez entrer votre nom!");
            return false;}
            // controle saisie prenom
        if(tf_Prenom_pf.getText().equals("")||tf_Prenom_pf.getText().equals("                  "))
        { err_prenom_ph.setText("Veuillez entrer votre prénom!");
            return false;}
        
       // controle saisie cin
        if(tf_CIN_ph.getText().equals("") )
        { err_cin_ph.setText("\nVeuillez entrer votre cin!");
        return false;
        }
       /*
        if (tf_CIN_ph.getText().length()!=8 || ((((Integer.parseInt(tf_CIN_ph.getText()))% 1 )!=0)))
        {
            err_cin_ph.setText("\n Votre cin est invaide!");
            return false;
        }*/
       // controle saisie reference
         if(tf_Reference_ph.getText().equals("")||tf_Reference_ph.getText().equals("                "))
        { err_reference_ph.setText("Veuillez entrer votre réference de pharmacie!");
            return false;}
         // controle saisie mail
          Pattern pattern = Pattern.compile(masque);
         Matcher controler = pattern.matcher(tf_Email_ph.getText());
         if (!(controler.matches())){
         // c'est pas bon
         err_email_ph.setText("Veuillez entrer votre mail de la forme de toto@toto.com !");
          return false;

           }
        
          // controle saisie numero
           /*  if(!(tf_Num_ph.getText().equals(""))){
          do{
              err_Num_ph.setText("Votre numéro de pharmacie doit etre en entier!");
            return false;
          }while(tf_Num_ph.getText().length()!=8 || (((Integer.parseInt(tf_Num_ph.getText())) < 0)));
        
        }
         
          // controle saisie code postal
         if(tf_CodeP_ph.getText().equals("")||tf_CodeP_ph.getText().equals("                  "))
        { err_codep_ph.setText("\nVeuillez entrer votre code postal!");
            return false;}
         
         else if(tf_CodeP_ph.getText().length()!=4 || ((((Integer.parseInt(tf_CodeP_ph.getText()))% 1 )>0))){
             err_codep_ph.setText("\n Votre code postal est invalid!");
             return false;
         }*/
          // controle saisie adresse
         
          if(tf_Adresse_ph.getText().equals("")||tf_Adresse_ph.getText().equals("                  "))
        { err_adresse_ph.setText("Veuillez entrer votre adresse!");
        return false;}
         
         else
        return true ;
           
    }
    
    
    //verifier la confirmation login w pwd pharmacien
     public boolean VerifierChamps_login_pwd_ph(){
        // controle saisie  identifiant client
        if(tf_Identifiant_ph.getText().equals("")||tf_Identifiant_ph.getText().equals("                 "))
        { err_identifiant_ph.setText("Veuillez _entrer votre identifiant!");
            return false;}
         //controle de saisie mot de passe
         if(pf_MDP_ph.getText().equals("")||pf_MDP_ph.getText().equals("                  "))
        { err_MDP_ph.setText("Veuillez entrer votre mot de passe!");
         return false;}
         if(!(pf_MDP2_ph.getText().equals(pf_MDP2_ph.getText())))
        { err_MDP2_ph.setText("Votre mot de passe est incorrecte!");
         return false;}
        else return true;}
     
     
       //verifier les champs de confirmation login w pwd client inscri
     public boolean VerifierChamps_login_pwd_clt(){
        // controle saisie  identifiant client
        if(tfLogin_Clt.getText().equals("")||tfLogin_Clt.getText().equals("                 "))
        { Erreur_clt.setText("Veuillez _entrer votre identifiant!");
            return false;}
         //controle de saisie mot de passe
         if(pfPwd_Clt.getText().equals("")||pfPwd_Clt.getText().equals("                  "))
        { Erreur_clt.setText("Veuillez entrer votre mot de passe!");
         return false;}
         
        else return true;}
     
     //verifier les champs du formulaire client
    public boolean VerifierChamps_clt(){
        // controle saisie  nom client
        if(tf_nom_clt.getText().equals("")||tf_nom_clt.getText().equals("                 "))
        { err_nom_clt.setText("Veuillez _entrer votre nom!");
            return false;}
        
            // controle saisie prenom client
        if(tf_prenom_clt.getText().equals("")||tf_prenom_clt.getText().equals("                  "))
        { err_prenom_clt.setText("Veuillez entrer votre prénom!");
            return false;}
        
        // controle de saisie identifiant
         if(tf_identifiant_clt.getText().equals("")||tf_identifiant_clt.getText().equals("                  "))
        { err_identifiant_clt.setText("Veuillez entrer votre identifiant!");
            return false;}
         
         //controle de saisie mot de passe
         if(pf_mdp_clt.getText().equals("")||pf_mdp_clt.getText().equals("                  "))
        { err_mdp_clt.setText("Veuillez entrer votre mot de passe!");
         return false;}
         if(!(pf_mdp2_clt.getText().equals(pf_mdp2_clt.getText()))){ 
         err_mdp2_clt.setText("Votre mot de passe est incorrecte!");
         return false;}
          // controle saisie code postal
         /* if(!(tf_codep_clt.getText().equals("")))
        { do {
            err_codep_ph.setText("\n Votre code postal est invalid!");
                 return false;
            } while (tf_codep_clt.getText().length()!=4 || ((((Integer.parseInt(tf_codep_clt.getText()))% 1 )>0)));
            
        }*/
         
       else
        return true ;
     }
     
    
    public Frame_Authentification() {
        try {
            UIManager.setLookAndFeel(new WebLookAndFeel());
            initComponents();
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Frame_Authentification.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        Panel_Admin = new javax.swing.JPanel();
        tfLogin_Admin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnConnect_Admin = new javax.swing.JButton();
        pfPwd_Admin = new javax.swing.JPasswordField();
        Erreur_Admin = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Panel_Ph = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        tfLogin_Ph = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        pfPwd_Ph = new javax.swing.JPasswordField();
        btnConnect_Ph = new javax.swing.JButton();
        lblInscrit_Ph = new javax.swing.JLabel();
        Erreur_ph = new javax.swing.JLabel();
        lbl_mdp_oublier = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Panel_Clt = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        tfLogin_Clt = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        pfPwd_Clt = new javax.swing.JPasswordField();
        btnConnect_Clt = new javax.swing.JButton();
        lblInscrit_Clt = new javax.swing.JLabel();
        Erreur_clt = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        FormulairePh_Suiv = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tf_Identifiant_ph = new javax.swing.JTextField();
        btnInscrit_Ph = new javax.swing.JButton();
        btnPreced = new javax.swing.JButton();
        pf_MDP_ph = new javax.swing.JPasswordField();
        pf_MDP2_ph = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        err_MDP2_ph = new javax.swing.JLabel();
        err_identifiant_ph = new javax.swing.JLabel();
        err_MDP_ph = new javax.swing.JLabel();
        FormulairePh = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jd_date_de_naiss = new com.toedter.calendar.JDateChooser();
        tf_Nom_ph = new javax.swing.JTextField();
        tf_Num_ph = new javax.swing.JTextField();
        tf_Prenom_pf = new javax.swing.JTextField();
        tf_CIN_ph = new javax.swing.JTextField();
        tf_Diplome_ph = new javax.swing.JTextField();
        tf_Reference_ph = new javax.swing.JTextField();
        tf_Email_ph = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        tf_CodeP_ph = new javax.swing.JTextField();
        tf_Adresse_ph = new javax.swing.JTextField();
        btn_suivant_ph = new javax.swing.JButton();
        err_nom_ph = new javax.swing.JLabel();
        err_adresse_ph = new javax.swing.JLabel();
        err_prenom_ph = new javax.swing.JLabel();
        err_cin_ph = new javax.swing.JLabel();
        err_reference_ph = new javax.swing.JLabel();
        err_email_ph = new javax.swing.JLabel();
        err_Num_ph = new javax.swing.JLabel();
        err_codep_ph = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        FormulaireClt = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        tf_nom_clt = new javax.swing.JTextField();
        tf_codep_clt = new javax.swing.JTextField();
        tf_prenom_clt = new javax.swing.JTextField();
        tf_identifiant_clt = new javax.swing.JTextField();
        tf_email_clt = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        tf_adresse_clt = new javax.swing.JTextField();
        btnInscrit_Clt = new javax.swing.JButton();
        cb_region_clt = new javax.swing.JComboBox();
        err_codep_clt = new javax.swing.JLabel();
        err_nom_clt = new javax.swing.JLabel();
        err_prenom_clt = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        err_identifiant_clt = new javax.swing.JLabel();
        err_mdp_clt = new javax.swing.JLabel();
        err_mdp2_clt = new javax.swing.JLabel();
        err_mail_clt = new javax.swing.JLabel();
        pf_mdp_clt = new javax.swing.JPasswordField();
        pf_mdp2_clt = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setName("S'authentifier"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        Panel_Admin.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                Panel_AdminComponentShown(evt);
            }
        });

        tfLogin_Admin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfLogin_AdminKeyTyped(evt);
            }
        });

        jLabel8.setText("Identifiant :");

        jLabel9.setText("Mot de Passe :");

        btnConnect_Admin.setText("Se Connecter");
        btnConnect_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnect_AdminActionPerformed(evt);
            }
        });

        pfPwd_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfPwd_AdminActionPerformed(evt);
            }
        });
        pfPwd_Admin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pfPwd_AdminKeyTyped(evt);
            }
        });

        Erreur_Admin.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        Erreur_Admin.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout Panel_AdminLayout = new javax.swing.GroupLayout(Panel_Admin);
        Panel_Admin.setLayout(Panel_AdminLayout);
        Panel_AdminLayout.setHorizontalGroup(
            Panel_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_AdminLayout.createSequentialGroup()
                .addContainerGap(180, Short.MAX_VALUE)
                .addGroup(Panel_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Erreur_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Panel_AdminLayout.createSequentialGroup()
                        .addGroup(Panel_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(Panel_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConnect_Admin, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(tfLogin_Admin)
                            .addComponent(pfPwd_Admin))))
                .addGap(51, 51, 51))
        );
        Panel_AdminLayout.setVerticalGroup(
            Panel_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_AdminLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(Panel_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panel_AdminLayout.createSequentialGroup()
                        .addGroup(Panel_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfLogin_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addComponent(pfPwd_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(Erreur_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnConnect_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        Menu.addTab("Espace Administrateur", Panel_Admin);

        Panel_Ph.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                Panel_PhComponentShown(evt);
            }
        });

        jLabel22.setText("Identifiant :");

        tfLogin_Ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfLogin_PhKeyTyped(evt);
            }
        });

        jLabel23.setText("Mot de Passe :");

        pfPwd_Ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pfPwd_PhKeyTyped(evt);
            }
        });

        btnConnect_Ph.setText("Se Connecter");
        btnConnect_Ph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnect_PhActionPerformed(evt);
            }
        });

        lblInscrit_Ph.setIcon(new javax.swing.ImageIcon("C:\\Users\\HoussemEddine\\Documents\\NetBeansProjects\\TuniPharmaUchiwa\\src\\gui\\btns.png")); // NOI18N
        lblInscrit_Ph.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInscrit_PhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblInscrit_PhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblInscrit_PhMouseExited(evt);
            }
        });

        Erreur_ph.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        Erreur_ph.setForeground(new java.awt.Color(255, 0, 0));

        lbl_mdp_oublier.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        lbl_mdp_oublier.setText("J'ai oublier mon mot de passe");
        lbl_mdp_oublier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_mdp_oublierMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_mdp_oublierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_mdp_oublierMouseExited(evt);
            }
        });
        lbl_mdp_oublier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbl_mdp_oublierKeyPressed(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\HoussemEddine\\Documents\\NetBeansProjects\\TuniPharmaUchiwa\\src\\gui\\btnfb.png")); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });
        jLabel13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel13KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout Panel_PhLayout = new javax.swing.GroupLayout(Panel_Ph);
        Panel_Ph.setLayout(Panel_PhLayout);
        Panel_PhLayout.setHorizontalGroup(
            Panel_PhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_PhLayout.createSequentialGroup()
                .addGroup(Panel_PhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_PhLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(Panel_PhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Panel_PhLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(tfLogin_Ph, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(Panel_PhLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addGroup(Panel_PhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_PhLayout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(pfPwd_Ph, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Panel_PhLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_PhLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(lbl_mdp_oublier, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_PhLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(Erreur_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_PhLayout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(lblInscrit_Ph, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Panel_PhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConnect_Ph, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        Panel_PhLayout.setVerticalGroup(
            Panel_PhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_PhLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(Panel_PhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(tfLogin_Ph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(Panel_PhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pfPwd_Ph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_mdp_oublier)
                .addGap(24, 24, 24)
                .addComponent(Erreur_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(Panel_PhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblInscrit_Ph, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConnect_Ph, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(23, 23, 23))
        );

        Menu.addTab("Espace Pharmacien", Panel_Ph);

        Panel_Clt.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                Panel_CltComponentShown(evt);
            }
        });

        jLabel20.setText("Identifiant :");

        tfLogin_Clt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfLogin_CltKeyTyped(evt);
            }
        });

        jLabel21.setText("Mot de Passe :");

        pfPwd_Clt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pfPwd_CltKeyTyped(evt);
            }
        });

        btnConnect_Clt.setText("Se Connecter");
        btnConnect_Clt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnect_CltActionPerformed(evt);
            }
        });

        lblInscrit_Clt.setIcon(new javax.swing.ImageIcon("C:\\Users\\HoussemEddine\\Documents\\NetBeansProjects\\TuniPharmaUchiwa\\src\\gui\\btns.png")); // NOI18N
        lblInscrit_Clt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInscrit_CltMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblInscrit_CltMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblInscrit_CltMouseExited(evt);
            }
        });

        Erreur_clt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        Erreur_clt.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout Panel_CltLayout = new javax.swing.GroupLayout(Panel_Clt);
        Panel_Clt.setLayout(Panel_CltLayout);
        Panel_CltLayout.setHorizontalGroup(
            Panel_CltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_CltLayout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addGroup(Panel_CltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Erreur_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Panel_CltLayout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pfPwd_Clt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_CltLayout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfLogin_Clt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_CltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_CltLayout.createSequentialGroup()
                            .addComponent(lblInscrit_Clt, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnConnect_Clt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );
        Panel_CltLayout.setVerticalGroup(
            Panel_CltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_CltLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(Panel_CltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLogin_Clt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Panel_CltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pfPwd_Clt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addComponent(Erreur_clt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Panel_CltLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConnect_Clt, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(lblInscrit_Clt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(89, 89, 89))
        );

        Menu.addTab("Espace Client", Panel_Clt);

        getContentPane().add(Menu);
        Menu.setBounds(10, 130, 430, 330);

        FormulairePh_Suiv.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fomulaire", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        FormulairePh_Suiv.setLayout(null);

        jLabel14.setText("Identifiant :");
        FormulairePh_Suiv.add(jLabel14);
        jLabel14.setBounds(20, 40, 57, 14);

        jLabel15.setText("Mot de Passe :");
        FormulairePh_Suiv.add(jLabel15);
        jLabel15.setBounds(20, 80, 71, 14);

        jLabel19.setText("Confirmer votre Mot de Passe :");
        FormulairePh_Suiv.add(jLabel19);
        jLabel19.setBounds(20, 120, 150, 14);

        tf_Identifiant_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_Identifiant_phKeyTyped(evt);
            }
        });
        FormulairePh_Suiv.add(tf_Identifiant_ph);
        tf_Identifiant_ph.setBounds(180, 30, 140, 30);

        btnInscrit_Ph.setText("S'inscrire");
        btnInscrit_Ph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscrit_PhActionPerformed(evt);
            }
        });
        FormulairePh_Suiv.add(btnInscrit_Ph);
        btnInscrit_Ph.setBounds(350, 210, 116, 32);

        btnPreced.setText("Précedent");
        btnPreced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrecedActionPerformed(evt);
            }
        });
        FormulairePh_Suiv.add(btnPreced);
        btnPreced.setBounds(20, 220, 99, 23);

        pf_MDP_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pf_MDP_phKeyTyped(evt);
            }
        });
        FormulairePh_Suiv.add(pf_MDP_ph);
        pf_MDP_ph.setBounds(180, 70, 140, 30);

        pf_MDP2_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pf_MDP2_phKeyTyped(evt);
            }
        });
        FormulairePh_Suiv.add(pf_MDP2_ph);
        pf_MDP2_ph.setBounds(180, 110, 140, 30);

        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("*");
        FormulairePh_Suiv.add(jLabel10);
        jLabel10.setBounds(320, 30, 10, 10);

        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("*");
        FormulairePh_Suiv.add(jLabel11);
        jLabel11.setBounds(320, 70, 10, 10);

        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*");
        FormulairePh_Suiv.add(jLabel12);
        jLabel12.setBounds(320, 110, 10, 10);

        err_MDP2_ph.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        err_MDP2_ph.setForeground(new java.awt.Color(255, 0, 0));
        FormulairePh_Suiv.add(err_MDP2_ph);
        err_MDP2_ph.setBounds(330, 110, 130, 30);

        err_identifiant_ph.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        err_identifiant_ph.setForeground(new java.awt.Color(255, 0, 0));
        FormulairePh_Suiv.add(err_identifiant_ph);
        err_identifiant_ph.setBounds(330, 30, 130, 30);

        err_MDP_ph.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        err_MDP_ph.setForeground(new java.awt.Color(255, 0, 0));
        FormulairePh_Suiv.add(err_MDP_ph);
        err_MDP_ph.setBounds(330, 70, 130, 30);

        getContentPane().add(FormulairePh_Suiv);
        FormulairePh_Suiv.setBounds(450, 160, 490, 260);

        FormulairePh.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fomulaire", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        FormulairePh.setLayout(null);

        jLabel1.setText("Nom :");
        FormulairePh.add(jLabel1);
        jLabel1.setBounds(30, 30, 80, 14);

        jLabel2.setText("Prénom :");
        FormulairePh.add(jLabel2);
        jLabel2.setBounds(30, 70, 100, 14);

        jLabel3.setText("CIN :");
        FormulairePh.add(jLabel3);
        jLabel3.setBounds(30, 110, 90, 14);

        jLabel4.setText("Référence :");
        FormulairePh.add(jLabel4);
        jLabel4.setBounds(30, 150, 100, 14);

        jLabel5.setText("E-Mail :");
        FormulairePh.add(jLabel5);
        jLabel5.setBounds(30, 190, 90, 14);

        jLabel6.setText("Diplome :");
        FormulairePh.add(jLabel6);
        jLabel6.setBounds(30, 230, 90, 14);

        jLabel7.setText("Date de Naissance :");
        FormulairePh.add(jLabel7);
        jLabel7.setBounds(30, 270, 110, 14);
        FormulairePh.add(jd_date_de_naiss);
        jd_date_de_naiss.setBounds(160, 260, 150, 30);

        tf_Nom_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_Nom_phKeyTyped(evt);
            }
        });
        FormulairePh.add(tf_Nom_ph);
        tf_Nom_ph.setBounds(160, 20, 150, 30);

        tf_Num_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_Num_phKeyTyped(evt);
            }
        });
        FormulairePh.add(tf_Num_ph);
        tf_Num_ph.setBounds(160, 300, 150, 30);

        tf_Prenom_pf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_Prenom_pfKeyTyped(evt);
            }
        });
        FormulairePh.add(tf_Prenom_pf);
        tf_Prenom_pf.setBounds(160, 60, 150, 30);

        tf_CIN_ph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_CIN_phActionPerformed(evt);
            }
        });
        tf_CIN_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_CIN_phKeyTyped(evt);
            }
        });
        FormulairePh.add(tf_CIN_ph);
        tf_CIN_ph.setBounds(160, 100, 150, 30);
        FormulairePh.add(tf_Diplome_ph);
        tf_Diplome_ph.setBounds(160, 220, 150, 30);

        tf_Reference_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_Reference_phKeyTyped(evt);
            }
        });
        FormulairePh.add(tf_Reference_ph);
        tf_Reference_ph.setBounds(160, 140, 150, 30);

        tf_Email_ph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_Email_phActionPerformed(evt);
            }
        });
        tf_Email_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_Email_phKeyTyped(evt);
            }
        });
        FormulairePh.add(tf_Email_ph);
        tf_Email_ph.setBounds(160, 180, 150, 30);

        jLabel16.setText("Numéro du Pharmacie :");
        FormulairePh.add(jLabel16);
        jLabel16.setBounds(30, 310, 150, 14);

        jLabel17.setText("Code Postal :");
        FormulairePh.add(jLabel17);
        jLabel17.setBounds(30, 350, 100, 14);

        jLabel18.setText("Adresse :");
        FormulairePh.add(jLabel18);
        jLabel18.setBounds(30, 390, 100, 14);

        tf_CodeP_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_CodeP_phKeyTyped(evt);
            }
        });
        FormulairePh.add(tf_CodeP_ph);
        tf_CodeP_ph.setBounds(160, 340, 150, 30);

        tf_Adresse_ph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_Adresse_phKeyTyped(evt);
            }
        });
        FormulairePh.add(tf_Adresse_ph);
        tf_Adresse_ph.setBounds(160, 380, 150, 30);

        btn_suivant_ph.setText("Suivant");
        btn_suivant_ph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suivant_phActionPerformed(evt);
            }
        });
        FormulairePh.add(btn_suivant_ph);
        btn_suivant_ph.setBounds(390, 430, 81, 23);

        err_nom_ph.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        err_nom_ph.setForeground(new java.awt.Color(255, 0, 0));
        FormulairePh.add(err_nom_ph);
        err_nom_ph.setBounds(320, 20, 120, 30);

        err_adresse_ph.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        err_adresse_ph.setForeground(new java.awt.Color(255, 0, 0));
        FormulairePh.add(err_adresse_ph);
        err_adresse_ph.setBounds(320, 380, 120, 30);

        err_prenom_ph.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        err_prenom_ph.setForeground(new java.awt.Color(255, 0, 0));
        FormulairePh.add(err_prenom_ph);
        err_prenom_ph.setBounds(320, 60, 120, 30);

        err_cin_ph.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        err_cin_ph.setForeground(new java.awt.Color(255, 0, 0));
        FormulairePh.add(err_cin_ph);
        err_cin_ph.setBounds(320, 100, 120, 30);

        err_reference_ph.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        err_reference_ph.setForeground(new java.awt.Color(255, 0, 0));
        FormulairePh.add(err_reference_ph);
        err_reference_ph.setBounds(320, 140, 120, 30);

        err_email_ph.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        err_email_ph.setForeground(new java.awt.Color(255, 0, 0));
        FormulairePh.add(err_email_ph);
        err_email_ph.setBounds(320, 180, 120, 30);

        err_Num_ph.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        err_Num_ph.setForeground(new java.awt.Color(255, 0, 0));
        FormulairePh.add(err_Num_ph);
        err_Num_ph.setBounds(310, 300, 120, 30);

        err_codep_ph.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        err_codep_ph.setForeground(new java.awt.Color(255, 0, 0));
        FormulairePh.add(err_codep_ph);
        err_codep_ph.setBounds(320, 340, 120, 30);

        jLabel28.setForeground(new java.awt.Color(255, 0, 0));
        jLabel28.setText("*");
        FormulairePh.add(jLabel28);
        jLabel28.setBounds(310, 20, 10, 14);

        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setText("*");
        FormulairePh.add(jLabel29);
        jLabel29.setBounds(310, 60, 10, 14);

        jLabel39.setForeground(new java.awt.Color(255, 0, 0));
        jLabel39.setText("*");
        FormulairePh.add(jLabel39);
        jLabel39.setBounds(310, 100, 10, 10);

        jLabel40.setForeground(new java.awt.Color(255, 0, 0));
        jLabel40.setText("*");
        FormulairePh.add(jLabel40);
        jLabel40.setBounds(310, 140, 10, 10);

        jLabel41.setForeground(new java.awt.Color(255, 0, 0));
        jLabel41.setText("*");
        FormulairePh.add(jLabel41);
        jLabel41.setBounds(310, 180, 10, 10);

        jLabel42.setForeground(new java.awt.Color(255, 0, 0));
        jLabel42.setText("*");
        FormulairePh.add(jLabel42);
        jLabel42.setBounds(310, 340, 10, 10);

        jLabel43.setForeground(new java.awt.Color(255, 0, 0));
        jLabel43.setText("*");
        FormulairePh.add(jLabel43);
        jLabel43.setBounds(310, 380, 10, 10);

        getContentPane().add(FormulairePh);
        FormulairePh.setBounds(450, 30, 490, 470);

        FormulaireClt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fomulaire", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        FormulaireClt.setLayout(null);

        jLabel30.setText("Nom :");
        FormulaireClt.add(jLabel30);
        jLabel30.setBounds(40, 40, 100, 14);

        jLabel31.setText("Prénom :");
        FormulaireClt.add(jLabel31);
        jLabel31.setBounds(40, 80, 110, 14);

        jLabel32.setText("Identifiant :");
        FormulaireClt.add(jLabel32);
        jLabel32.setBounds(40, 120, 110, 14);

        jLabel33.setText("Mot de Passe :");
        FormulaireClt.add(jLabel33);
        jLabel33.setBounds(40, 160, 120, 14);

        jLabel34.setText("Retaper Mot de Passe :");
        FormulaireClt.add(jLabel34);
        jLabel34.setBounds(40, 200, 160, 14);

        jLabel35.setText("E-Mail :");
        FormulaireClt.add(jLabel35);
        jLabel35.setBounds(40, 240, 120, 14);

        jLabel36.setText("Région :");
        FormulaireClt.add(jLabel36);
        jLabel36.setBounds(40, 280, 120, 14);

        tf_nom_clt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_nom_cltKeyTyped(evt);
            }
        });
        FormulaireClt.add(tf_nom_clt);
        tf_nom_clt.setBounds(170, 30, 150, 30);

        tf_codep_clt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_codep_cltKeyTyped(evt);
            }
        });
        FormulaireClt.add(tf_codep_clt);
        tf_codep_clt.setBounds(170, 310, 150, 30);

        tf_prenom_clt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_prenom_cltKeyTyped(evt);
            }
        });
        FormulaireClt.add(tf_prenom_clt);
        tf_prenom_clt.setBounds(170, 70, 150, 30);

        tf_identifiant_clt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_identifiant_cltActionPerformed(evt);
            }
        });
        tf_identifiant_clt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_identifiant_cltKeyTyped(evt);
            }
        });
        FormulaireClt.add(tf_identifiant_clt);
        tf_identifiant_clt.setBounds(170, 110, 150, 30);

        tf_email_clt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_email_cltKeyTyped(evt);
            }
        });
        FormulaireClt.add(tf_email_clt);
        tf_email_clt.setBounds(170, 230, 150, 30);

        jLabel37.setText("Code Postal :");
        FormulaireClt.add(jLabel37);
        jLabel37.setBounds(40, 320, 110, 14);

        jLabel38.setText("Adresse :");
        FormulaireClt.add(jLabel38);
        jLabel38.setBounds(40, 360, 130, 14);
        FormulaireClt.add(tf_adresse_clt);
        tf_adresse_clt.setBounds(170, 350, 150, 30);

        btnInscrit_Clt.setText("S'inscrire");
        btnInscrit_Clt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscrit_CltActionPerformed(evt);
            }
        });
        FormulaireClt.add(btnInscrit_Clt);
        btnInscrit_Clt.setBounds(350, 410, 117, 36);

        cb_region_clt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ariana", "beja", "Ben Arous", "Bizerte", "Gabes", "Gafsa", "Jendouba", "Kairaouan", "kasserine", "kbeli", "Le Kef", "Mahdia", "Mannouba", "Medenine", "Monastir", "Nabeul", "Sfax", "Sidi-bouzid", "Siliana", "Sousse", "Tataouine", "Touzeur", "Tunis", "Zaghouane" }));
        FormulaireClt.add(cb_region_clt);
        cb_region_clt.setBounds(170, 270, 150, 30);

        err_codep_clt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        err_codep_clt.setForeground(new java.awt.Color(255, 0, 0));
        FormulaireClt.add(err_codep_clt);
        err_codep_clt.setBounds(330, 310, 130, 30);

        err_nom_clt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        err_nom_clt.setForeground(new java.awt.Color(255, 0, 0));
        FormulaireClt.add(err_nom_clt);
        err_nom_clt.setBounds(330, 30, 130, 30);

        err_prenom_clt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        err_prenom_clt.setForeground(new java.awt.Color(255, 0, 0));
        FormulaireClt.add(err_prenom_clt);
        err_prenom_clt.setBounds(330, 70, 130, 30);

        jLabel26.setForeground(new java.awt.Color(255, 0, 0));
        jLabel26.setText("*");
        FormulaireClt.add(jLabel26);
        jLabel26.setBounds(320, 30, 10, 14);

        jLabel27.setForeground(new java.awt.Color(255, 0, 0));
        jLabel27.setText("*");
        FormulaireClt.add(jLabel27);
        jLabel27.setBounds(320, 70, 10, 14);

        jLabel44.setForeground(new java.awt.Color(255, 0, 0));
        jLabel44.setText("*");
        FormulaireClt.add(jLabel44);
        jLabel44.setBounds(320, 110, 10, 14);

        jLabel45.setForeground(new java.awt.Color(255, 0, 0));
        jLabel45.setText("*");
        FormulaireClt.add(jLabel45);
        jLabel45.setBounds(320, 150, 10, 14);

        jLabel46.setForeground(new java.awt.Color(255, 0, 0));
        jLabel46.setText("*");
        FormulaireClt.add(jLabel46);
        jLabel46.setBounds(320, 190, 10, 14);

        jLabel47.setForeground(new java.awt.Color(255, 0, 0));
        jLabel47.setText("*");
        FormulaireClt.add(jLabel47);
        jLabel47.setBounds(320, 230, 10, 14);

        err_identifiant_clt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        err_identifiant_clt.setForeground(new java.awt.Color(255, 0, 0));
        FormulaireClt.add(err_identifiant_clt);
        err_identifiant_clt.setBounds(330, 110, 130, 30);

        err_mdp_clt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        err_mdp_clt.setForeground(new java.awt.Color(255, 0, 0));
        FormulaireClt.add(err_mdp_clt);
        err_mdp_clt.setBounds(330, 150, 130, 30);

        err_mdp2_clt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        err_mdp2_clt.setForeground(new java.awt.Color(255, 0, 0));
        FormulaireClt.add(err_mdp2_clt);
        err_mdp2_clt.setBounds(330, 190, 130, 30);

        err_mail_clt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        err_mail_clt.setForeground(new java.awt.Color(255, 0, 0));
        FormulaireClt.add(err_mail_clt);
        err_mail_clt.setBounds(330, 230, 130, 30);

        pf_mdp_clt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pf_mdp_cltKeyTyped(evt);
            }
        });
        FormulaireClt.add(pf_mdp_clt);
        pf_mdp_clt.setBounds(170, 150, 150, 30);

        pf_mdp2_clt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pf_mdp2_cltKeyTyped(evt);
            }
        });
        FormulaireClt.add(pf_mdp2_clt);
        pf_mdp2_clt.setBounds(170, 190, 150, 30);

        getContentPane().add(FormulaireClt);
        FormulaireClt.setBounds(450, 30, 490, 470);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       lc=new ArrayList<Clients>();
       lp = new ArrayList<Pharmaciens>();
       l=new ArrayList<Admin>();
       
        
        l=admindao.GetAllAdmins();
        lp=pharmaciendao.GetAllPharmaciens();
        lc=clientdao.GetAllClients();
        
        
        this.setSize(464, 466);
       
        FormulairePh_Suiv.setVisible(false);
        FormulairePh.setVisible(false);
        FormulaireClt.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void lblInscrit_PhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInscrit_PhMouseClicked
        this.setSize(980, 540);
        FormulairePh.setVisible(true);
    }//GEN-LAST:event_lblInscrit_PhMouseClicked

    private void btnPrecedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrecedActionPerformed
        FormulairePh_Suiv.setVisible(false);
        FormulairePh.setVisible(true);
    }//GEN-LAST:event_btnPrecedActionPerformed

    private void btnInscrit_PhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscrit_PhActionPerformed
        if(VerifierChamps_login_pwd_ph()==true){
            
           this.setSize(464, 466);
        FormulairePh_Suiv.setVisible(false);
    
         Pharmaciens pharmacien=new Pharmaciens();
        pharmacien.setNom_pharmacien(tf_Nom_ph.getText());
        pharmacien.setPrenom_pharmacien(tf_Prenom_pf.getText());
        pharmacien.setLogin_pharmacien(tf_Identifiant_ph.getText());
        pharmacien.setCin_pharmacien(Integer.parseInt(tf_CIN_ph.getText()));
        pharmacien.setDiplome_pharmacien(tf_Diplome_ph.getText());
        pharmacien.setMail_pharamacien(tf_Email_ph.getText());
        pharmacien.setPwd_pharmacien(pf_MDP_ph.getText());
        pharmacien.setNumtel_pahramcien(Integer.parseInt(tf_Num_ph.getText()));
        pharmacien.setDate_naiss_pharmacien(jd_date_de_naiss.getComponents().toString());
        pharmacien.setEtat_pharmacien(0);
        pharmacien.setReference_pharmacien(tf_Reference_ph.getText());
        pharmacien.setCode_postal_pharmacien(Integer.parseInt(tf_CodeP_ph.getText()));
        pharmacien.setAdresse_pharmacien(tf_Adresse_ph.getText());
        
        new dao.PharmaciensDAO().insertPharmaciens(pharmacien);
            JOptionPane.showMessageDialog(this, "Bienvenue à TUNIPHARMA !");
        }
        
    }//GEN-LAST:event_btnInscrit_PhActionPerformed

    private void btn_suivant_phActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suivant_phActionPerformed

        if(VerifierChamps_formulaire_ph()==true){
        FormulairePh.setVisible(false);
        FormulairePh_Suiv.setVisible(true);
        }
    }//GEN-LAST:event_btn_suivant_phActionPerformed

    private void btnInscrit_CltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscrit_CltActionPerformed
 if(VerifierChamps_clt()==true){
     this.setSize(464, 466);
        FormulaireClt.setVisible(false);
       
        Clients client=new Clients();
        client.setNom_clt(tf_nom_clt.getText());
        client.setPrenom_clt(tf_prenom_clt.getText());
        client.setLogin_clt(tf_identifiant_clt.getText());
        client.setMail_clt(tf_email_clt.getText());
        client.setPwd_clt(pf_mdp_clt.getText());
        client.setPays_clt(cb_region_clt.getSelectedItem().toString());
        client.setCode_postal_clt(Integer.parseInt(tf_codep_clt.getText()));
        client.setAdresse_clt(tf_adresse_clt.getText());
         new dao.ClientsDAO().insertClients(client);
        JOptionPane.showMessageDialog(this, "Bienvenue à TUNIPHARMA !");
       
 }
    }//GEN-LAST:event_btnInscrit_CltActionPerformed

    private void lblInscrit_CltMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInscrit_CltMouseClicked
        this.setSize(980, 540);
        FormulaireClt.setVisible(true);
    }//GEN-LAST:event_lblInscrit_CltMouseClicked

    private void Panel_AdminComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_Panel_AdminComponentShown
        this.setSize(464, 466);
        
        FormulairePh_Suiv.setVisible(false);
        FormulairePh.setVisible(false);
        FormulaireClt.setVisible(false);
    }//GEN-LAST:event_Panel_AdminComponentShown

    private void Panel_PhComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_Panel_PhComponentShown
        this.setSize(464, 466);
        
        FormulairePh_Suiv.setVisible(false);
        FormulairePh.setVisible(false);
        FormulaireClt.setVisible(false);
    }//GEN-LAST:event_Panel_PhComponentShown

    private void Panel_CltComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_Panel_CltComponentShown
        this.setSize(464, 466);
         
        FormulairePh_Suiv.setVisible(false);
        FormulairePh.setVisible(false);
        FormulaireClt.setVisible(false);
    }//GEN-LAST:event_Panel_CltComponentShown

    private void pfPwd_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfPwd_AdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfPwd_AdminActionPerformed

    private void tfLogin_AdminKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLogin_AdminKeyTyped
        Erreur_Admin.setText("");
    }//GEN-LAST:event_tfLogin_AdminKeyTyped

    private void pfPwd_AdminKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfPwd_AdminKeyTyped
         Erreur_Admin.setText("");
    }//GEN-LAST:event_pfPwd_AdminKeyTyped

    private void tfLogin_PhKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLogin_PhKeyTyped
         Erreur_ph.setText("");
    }//GEN-LAST:event_tfLogin_PhKeyTyped

    private void pfPwd_PhKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfPwd_PhKeyTyped
         Erreur_ph.setText("");
    }//GEN-LAST:event_pfPwd_PhKeyTyped

    private void lblInscrit_PhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInscrit_PhMouseEntered
        lblInscrit_Ph.setIcon(new javax.swing.ImageIcon("src/gui/btns2.png"));
    }//GEN-LAST:event_lblInscrit_PhMouseEntered

    private void lblInscrit_PhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInscrit_PhMouseExited
       lblInscrit_Ph.setIcon(new javax.swing.ImageIcon("src/gui/btns.png"));
    }//GEN-LAST:event_lblInscrit_PhMouseExited

    private void tf_CIN_phActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_CIN_phActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_CIN_phActionPerformed

    private void tf_Email_phActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_Email_phActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_Email_phActionPerformed

    private void btnConnect_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnect_AdminActionPerformed
       
        if(VerifierChamps_admin()==true){  
          for(Admin a:l){
            if(a.getLogin().equals(tfLogin_Admin.getText()) && a.getPwd().equals(pfPwd_Admin.getText())){
                
                JOptionPane.showMessageDialog(this, "Bienvenue à TUNIPHARMA vous ete connecté !");
                try {
                    f = new Frame_Admin();
                } catch (IOException ex) {
                    Logger.getLogger(Frame_Authentification.class.getName()).log(Level.SEVERE, null, ex);
                }   
                 f.setVisible(true);
                 this.dispose();
                break;
            }
          }
          }
            else
            Erreur_Admin.setText("verifiez votre identifiant et votre mot de passe");
        
     
    }//GEN-LAST:event_btnConnect_AdminActionPerformed

    private void btnConnect_PhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnect_PhActionPerformed
         
        if(VerifierChamps_login_pwd_pharmacien()==true){
             for(Pharmaciens a:lp){
            if(a.getLogin_pharmacien().equals(tfLogin_Ph.getText()) && a.getPwd_pharmacien().equals(pfPwd_Ph.getText())){
               
                 JOptionPane.showMessageDialog(this, "Bienvenue à TUNIPHARMA vous ete connecté !");
                break;
            }
            else
            Erreur_ph.setText("verifiez votre identifiant et votre mot de passe");
        }
         }
    }//GEN-LAST:event_btnConnect_PhActionPerformed

    private void btnConnect_CltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnect_CltActionPerformed
         if(VerifierChamps_login_pwd_clt()){
        for(Clients a:lc){
            if(a.getLogin_clt().equals(tfLogin_Clt.getText()) && a.getPwd_clt().equals(pfPwd_Clt.getText())){
               
               
                 JOptionPane.showMessageDialog(this, "Bienvenue à TUNIPHARMA vous ete connecté ");
                break;
            }
            else
            Erreur_clt.setText("verifiez votre identifiant et votre mot de passe !");
        }
       }
    }//GEN-LAST:event_btnConnect_CltActionPerformed

    private void lblInscrit_CltMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInscrit_CltMouseEntered
          lblInscrit_Clt.setIcon(new javax.swing.ImageIcon("src/gui/btns2.png"));
    }//GEN-LAST:event_lblInscrit_CltMouseEntered

    private void lblInscrit_CltMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInscrit_CltMouseExited
          lblInscrit_Clt.setIcon(new javax.swing.ImageIcon("src/gui/btns.png"));
    }//GEN-LAST:event_lblInscrit_CltMouseExited

    private void tf_identifiant_cltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_identifiant_cltActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_identifiant_cltActionPerformed

    private void lbl_mdp_oublierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_mdp_oublierMouseEntered
       lbl_mdp_oublier.setForeground(Color.BLUE);
    }//GEN-LAST:event_lbl_mdp_oublierMouseEntered

    private void lbl_mdp_oublierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_mdp_oublierMouseExited
        lbl_mdp_oublier.setForeground(Color.BLACK);
    }//GEN-LAST:event_lbl_mdp_oublierMouseExited

    private void lbl_mdp_oublierKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_mdp_oublierKeyPressed
   
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_mdp_oublierKeyPressed

    private void tf_nom_cltKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_nom_cltKeyTyped
        err_nom_clt.setText("");
    }//GEN-LAST:event_tf_nom_cltKeyTyped

    private void tf_prenom_cltKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_prenom_cltKeyTyped
       err_prenom_clt.setText("");
    }//GEN-LAST:event_tf_prenom_cltKeyTyped

    private void tf_identifiant_cltKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_identifiant_cltKeyTyped
        err_identifiant_clt.setText("");
    }//GEN-LAST:event_tf_identifiant_cltKeyTyped

    private void pf_mdp_cltKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pf_mdp_cltKeyTyped
       err_mdp_clt.setText("");
    }//GEN-LAST:event_pf_mdp_cltKeyTyped

    private void pf_mdp2_cltKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pf_mdp2_cltKeyTyped
        err_mdp2_clt.setText("");
    }//GEN-LAST:event_pf_mdp2_cltKeyTyped

    private void tf_email_cltKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_email_cltKeyTyped
        err_mail_clt.setText("");
    }//GEN-LAST:event_tf_email_cltKeyTyped

    private void tf_codep_cltKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_codep_cltKeyTyped
        err_codep_clt.setText("");
    }//GEN-LAST:event_tf_codep_cltKeyTyped

    private void tfLogin_CltKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLogin_CltKeyTyped
        Erreur_clt.setText("");
    }//GEN-LAST:event_tfLogin_CltKeyTyped

    private void pfPwd_CltKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfPwd_CltKeyTyped
        Erreur_clt.setText("");
    }//GEN-LAST:event_pfPwd_CltKeyTyped

    private void tf_Identifiant_phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_Identifiant_phKeyTyped
        err_identifiant_clt.setText("");
    }//GEN-LAST:event_tf_Identifiant_phKeyTyped

    private void pf_MDP_phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pf_MDP_phKeyTyped
       err_mdp_clt.setText("");
    }//GEN-LAST:event_pf_MDP_phKeyTyped

    private void pf_MDP2_phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pf_MDP2_phKeyTyped
        err_mdp2_clt.setText("");
    }//GEN-LAST:event_pf_MDP2_phKeyTyped

    private void tf_Nom_phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_Nom_phKeyTyped
        err_nom_ph.setText("");
    }//GEN-LAST:event_tf_Nom_phKeyTyped

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
       jLabel13.setIcon(new javax.swing.ImageIcon("src/gui/btnfb.png"));
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        jLabel13.setIcon(new javax.swing.ImageIcon("src/gui/btnfb2.png"));
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel13KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13KeyPressed

    private void lbl_mdp_oublierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_mdp_oublierMouseClicked
        
        //this.setVisible(false);
       // Menu.setVisible(false);
        Frame_Mail m=new Frame_Mail();
        m.setVisible(true);
        /* Login_Pwd_oublier.setVisible(true);
         FormulairePh_Suiv.setVisible(false);
        FormulairePh.setVisible(false);
        FormulaireClt.setVisible(false);*/
    }//GEN-LAST:event_lbl_mdp_oublierMouseClicked

    private void tf_Prenom_pfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_Prenom_pfKeyTyped
        err_prenom_ph.setText("");
    }//GEN-LAST:event_tf_Prenom_pfKeyTyped

    private void tf_CIN_phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_CIN_phKeyTyped
        err_cin_ph.setText("");
    }//GEN-LAST:event_tf_CIN_phKeyTyped

    private void tf_Reference_phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_Reference_phKeyTyped
        err_reference_ph.setText("");
    }//GEN-LAST:event_tf_Reference_phKeyTyped

    private void tf_Email_phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_Email_phKeyTyped
        err_email_ph.setText("");
    }//GEN-LAST:event_tf_Email_phKeyTyped

    private void tf_Num_phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_Num_phKeyTyped
        err_Num_ph.setText("");
    }//GEN-LAST:event_tf_Num_phKeyTyped

    private void tf_CodeP_phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_CodeP_phKeyTyped
        err_codep_ph.setText("");
    }//GEN-LAST:event_tf_CodeP_phKeyTyped

    private void tf_Adresse_phKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_Adresse_phKeyTyped
       err_adresse_ph.setText("");
    }//GEN-LAST:event_tf_Adresse_phKeyTyped

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
            java.util.logging.Logger.getLogger(Frame_Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Authentification().setVisible(true);
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Erreur_Admin;
    private javax.swing.JLabel Erreur_clt;
    private javax.swing.JLabel Erreur_ph;
    private javax.swing.JPanel FormulaireClt;
    private javax.swing.JPanel FormulairePh;
    private javax.swing.JPanel FormulairePh_Suiv;
    private javax.swing.JTabbedPane Menu;
    private javax.swing.JPanel Panel_Admin;
    private javax.swing.JPanel Panel_Clt;
    private javax.swing.JPanel Panel_Ph;
    private javax.swing.JButton btnConnect_Admin;
    private javax.swing.JButton btnConnect_Clt;
    private javax.swing.JButton btnConnect_Ph;
    private javax.swing.JButton btnInscrit_Clt;
    private javax.swing.JButton btnInscrit_Ph;
    private javax.swing.JButton btnPreced;
    private javax.swing.JButton btn_suivant_ph;
    private javax.swing.JComboBox cb_region_clt;
    private javax.swing.JLabel err_MDP2_ph;
    private javax.swing.JLabel err_MDP_ph;
    private javax.swing.JLabel err_Num_ph;
    private javax.swing.JLabel err_adresse_ph;
    private javax.swing.JLabel err_cin_ph;
    private javax.swing.JLabel err_codep_clt;
    private javax.swing.JLabel err_codep_ph;
    private javax.swing.JLabel err_email_ph;
    private javax.swing.JLabel err_identifiant_clt;
    private javax.swing.JLabel err_identifiant_ph;
    private javax.swing.JLabel err_mail_clt;
    private javax.swing.JLabel err_mdp2_clt;
    private javax.swing.JLabel err_mdp_clt;
    private javax.swing.JLabel err_nom_clt;
    private javax.swing.JLabel err_nom_ph;
    private javax.swing.JLabel err_prenom_clt;
    private javax.swing.JLabel err_prenom_ph;
    private javax.swing.JLabel err_reference_ph;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private com.toedter.calendar.JDateChooser jd_date_de_naiss;
    private javax.swing.JLabel lblInscrit_Clt;
    private javax.swing.JLabel lblInscrit_Ph;
    private javax.swing.JLabel lbl_mdp_oublier;
    private javax.swing.JPasswordField pfPwd_Admin;
    private javax.swing.JPasswordField pfPwd_Clt;
    private javax.swing.JPasswordField pfPwd_Ph;
    private javax.swing.JPasswordField pf_MDP2_ph;
    private javax.swing.JPasswordField pf_MDP_ph;
    private javax.swing.JPasswordField pf_mdp2_clt;
    private javax.swing.JPasswordField pf_mdp_clt;
    private javax.swing.JTextField tfLogin_Admin;
    private javax.swing.JTextField tfLogin_Clt;
    private javax.swing.JTextField tfLogin_Ph;
    private javax.swing.JTextField tf_Adresse_ph;
    private javax.swing.JTextField tf_CIN_ph;
    private javax.swing.JTextField tf_CodeP_ph;
    private javax.swing.JTextField tf_Diplome_ph;
    private javax.swing.JTextField tf_Email_ph;
    private javax.swing.JTextField tf_Identifiant_ph;
    private javax.swing.JTextField tf_Nom_ph;
    private javax.swing.JTextField tf_Num_ph;
    private javax.swing.JTextField tf_Prenom_pf;
    private javax.swing.JTextField tf_Reference_ph;
    private javax.swing.JTextField tf_adresse_clt;
    private javax.swing.JTextField tf_codep_clt;
    private javax.swing.JTextField tf_email_clt;
    private javax.swing.JTextField tf_identifiant_clt;
    private javax.swing.JTextField tf_nom_clt;
    private javax.swing.JTextField tf_prenom_clt;
    // End of variables declaration//GEN-END:variables
}
