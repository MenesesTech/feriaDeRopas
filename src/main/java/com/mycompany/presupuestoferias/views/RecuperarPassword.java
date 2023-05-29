package com.mycompany.presupuestoferias.views;

import com.mycompany.presupuestoferias.models.empleado;
import com.mycompany.presupuestoferias.models.empleadoDao;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class RecuperarPassword extends javax.swing.JFrame {

    private static String emailFrom = "modernafashion23@gmail.com";
    private static String passwordFrom = "hkqkmysifsobixcl";
    private String emailTo;
    private String subject;
    private String content;
    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;
    empleado user = new empleado();
    empleadoDao userDao = new empleadoDao();

    public RecuperarPassword() {
        initComponents();
        setSize(500, 200);
        setResizable(false);
        setExtendedState(MAXIMIZED_VERT);
        setLocationRelativeTo(null);
        setTitle("Recuperación de la contraseña");
        mProperties = new Properties(); //Propiedades del sistema
    }

    private void createEmail() {
        emailTo = txt_correo_recu.getText().trim();
        subject = "Recuperacion de contraseña de Moderna Fashion";
        content = "Tu contraseña es la siguiente: " + userDao.recuperarContraseña(emailTo);
        // Simple mail transfer protocol
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        mSession = Session.getDefaultInstance(mProperties);
        
        try {
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            mCorreo.setSubject(subject);
            mCorreo.setText(content);

        } catch (AddressException ex) {
            Logger.getLogger(RecuperarPassword.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(RecuperarPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendEmail() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, passwordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();

            JOptionPane.showMessageDialog(null, "Correo enviado");
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(RecuperarPassword.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(RecuperarPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnEnviarCorreo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_correo_recu = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(4, 4, 4));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(4, 4, 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 80, -1));

        btnEnviarCorreo.setBackground(new java.awt.Color(69, 73, 74));
        btnEnviarCorreo.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        btnEnviarCorreo.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviarCorreo.setText("Recuperar");
        btnEnviarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEnviarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 110, 30));

        jLabel1.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("RECUPERACIÓN DE LA CONTRASEÑA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Correo electrónico:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        txt_correo_recu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(txt_correo_recu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 410, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarCorreoActionPerformed
        createEmail();
        sendEmail();
    }//GEN-LAST:event_btnEnviarCorreoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviarCorreo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_correo_recu;
    // End of variables declaration//GEN-END:variables
}
