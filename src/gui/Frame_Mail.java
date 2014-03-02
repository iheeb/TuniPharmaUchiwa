/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Pharmaciens;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import mail.Mail;
import mail.MailConstruction;


/**
 *
 * @author salma
 */
public class Frame_Mail extends javax.swing.JFrame {

    /**
     * Creates new form Mail
     */
    String subject;
    URL url;
    Mail mail = new Mail();
    public Frame_Mail() {
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

        Login_Pwd_oublier = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        tf_ref_ph_oub = new javax.swing.JTextField();
        tf_mail_ph_oub = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        btn_envoyer_ph = new javax.swing.JButton();
        erreur_ph_oub = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Login_Pwd_oublier.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Login_Pwd_oublier.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                Login_Pwd_oublierComponentShown(evt);
            }
        });

        jLabel24.setText("Votre référence de pharmacie :");

        jLabel25.setText("Votre e-mail :");

        btn_envoyer_ph.setText("Envoyer");
        btn_envoyer_ph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_envoyer_phActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Login_Pwd_oublierLayout = new javax.swing.GroupLayout(Login_Pwd_oublier);
        Login_Pwd_oublier.setLayout(Login_Pwd_oublierLayout);
        Login_Pwd_oublierLayout.setHorizontalGroup(
            Login_Pwd_oublierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Login_Pwd_oublierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Login_Pwd_oublierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(erreur_ph_oub, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_envoyer_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Login_Pwd_oublierLayout.createSequentialGroup()
                        .addGroup(Login_Pwd_oublierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Login_Pwd_oublierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_ref_ph_oub, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(tf_mail_ph_oub))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        Login_Pwd_oublierLayout.setVerticalGroup(
            Login_Pwd_oublierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Login_Pwd_oublierLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(Login_Pwd_oublierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_ref_ph_oub, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Login_Pwd_oublierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_mail_ph_oub, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(erreur_ph_oub, javax.swing.GroupLayout.DEFAULT_SIZE, 13, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_envoyer_ph, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(Login_Pwd_oublier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(Login_Pwd_oublier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_envoyer_phActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_envoyer_phActionPerformed
        
        String subject="Demande login Mot de Passe";
        List<String> l=new ArrayList<String>();
        l=new dao.PharmaciensDAO().sendMailPharmaciens(tf_mail_ph_oub.getText(), tf_ref_ph_oub.getText());
        
        if(!l.isEmpty()){
        mail.setMailAddressRecipient(tf_mail_ph_oub.getText());
        mail.setPwd("tunipharma3a20");
        mail.setMailAddressSender("tunipharmauchiwa@gmail.com");
        mail.setMailSubject(subject);
        //System.out.println(jTextArearObject.getToolTipText());
        mail.setMailObject("Cher/Chére "+l.get(0)+" "+l.get(1)+" ,\nVotre Login est : "+l.get(2)+",\nLe Mot de Passe est : "+l.get(3));
        MailConstruction mc = new MailConstruction();
        mc.getMailProperties();
        
        
        mc.getMailMessage(mail);
        mc.SendMessage(); 
        dispose();}
        else JOptionPane.showMessageDialog(this, "Verifier votre Référence et Mail!");
    }//GEN-LAST:event_btn_envoyer_phActionPerformed

    private void Login_Pwd_oublierComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_Login_Pwd_oublierComponentShown
       
    }//GEN-LAST:event_Login_Pwd_oublierComponentShown

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
            java.util.logging.Logger.getLogger(Frame_Mail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Mail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Mail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Mail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Mail().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Login_Pwd_oublier;
    private javax.swing.JButton btn_envoyer_ph;
    private javax.swing.JLabel erreur_ph_oub;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JTextField tf_mail_ph_oub;
    private javax.swing.JTextField tf_ref_ph_oub;
    // End of variables declaration//GEN-END:variables
}
