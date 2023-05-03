package com.mycompany.presupuestoferias.views;

import com.mycompany.presupuestoferias.models.usuario;
import com.mycompany.presupuestoferias.models.usuarioDao;
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

    private static String emailFrom = "saeutppruebajava23@gmail.com";
    private static String passwordFrom = "sdgujanfwlkdwjqj";
    private String emailTo;
    private String subject;
    private String content;
    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;
    usuario user = new usuario();
    usuarioDao userDao = new usuarioDao();

    public RecuperarPassword() {
        initComponents();
        setSize(500, 200);
        mProperties = new Properties(); //Propiedades del sistema

    }

    private void createEmail() {
        emailTo = txt_correo_recu.getText().trim();
        subject = "Recuperacion de contraseña de Moderna Fashion";
        content = "Tu contraseña es la siguiente: "+userDao.recuperarContraseña(emailTo);
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

        txt_correo_recu = new javax.swing.JTextField();
        btnEnviarCorreo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txt_correo_recu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 410, 40));

        btnEnviarCorreo.setText("Recuperar");
        btnEnviarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarCorreoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 90, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarCorreoActionPerformed
        createEmail();
        sendEmail();
    }//GEN-LAST:event_btnEnviarCorreoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviarCorreo;
    private javax.swing.JTextField txt_correo_recu;
    // End of variables declaration//GEN-END:variables
}
