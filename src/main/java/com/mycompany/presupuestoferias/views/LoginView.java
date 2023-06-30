
package com.mycompany.presupuestoferias.views;

import com.mycompany.presupuestoferias.controllers.loginUsuarioController;
import com.mycompany.presupuestoferias.models.empleado;
import com.mycompany.presupuestoferias.models.empleadoDao;

public class LoginView extends javax.swing.JFrame {

    empleado user = new empleado();
    empleadoDao userDao = new empleadoDao();

    public LoginView() {
        initComponents();
        setSize(950, 475);
        setResizable(false);
        setExtendedState(MAXIMIZED_VERT);
        setLocationRelativeTo(null);
        loginUsuarioController loginController = new loginUsuarioController(user, userDao, this);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnValidarCaptcha = new javax.swing.JButton();
        btnNewCaptcha = new javax.swing.JButton();
        txt_Username = new javax.swing.JTextField();
        txt_Password = new javax.swing.JPasswordField();
        txtCaptcha = new javax.swing.JTextField();
        lblCerrar = new javax.swing.JLabel();
        btnEnter = new javax.swing.JButton();
        lblForgetPass = new javax.swing.JLabel();
        lblConfirmCaptcha = new javax.swing.JLabel();
        pnlCaptchaGenerator = new javax.swing.JPanel();
        lblCaptchaGenerator = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(208, 208, 208));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnValidarCaptcha.setBackground(new java.awt.Color(4, 4, 4));
        btnValidarCaptcha.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnValidarCaptcha.setForeground(new java.awt.Color(208, 208, 208));
        btnValidarCaptcha.setText("Validar captcha");
        jPanel1.add(btnValidarCaptcha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 120, 30));

        btnNewCaptcha.setBackground(new java.awt.Color(4, 4, 4));
        jPanel1.add(btnNewCaptcha, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 325, 50, 50));

        txt_Username.setBackground(new java.awt.Color(249, 246, 241));
        txt_Username.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txt_Username.setForeground(new java.awt.Color(124, 124, 124));
        txt_Username.setText("Ingrese su nombre de usuario");
        txt_Username.setBorder(null);
        txt_Username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_UsernameMousePressed(evt);
            }
        });
        txt_Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UsernameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 310, 25));

        txt_Password.setBackground(new java.awt.Color(249, 246, 241));
        txt_Password.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txt_Password.setForeground(new java.awt.Color(124, 124, 124));
        txt_Password.setText("**********");
        txt_Password.setBorder(null);
        txt_Password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_PasswordMousePressed(evt);
            }
        });
        jPanel1.add(txt_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 310, 25));

        txtCaptcha.setFont(new java.awt.Font("Cambria Math", 2, 24)); // NOI18N
        jPanel1.add(txtCaptcha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 120, 40));

        lblCerrar.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lblCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCerrar.setText("X");
        jPanel1.add(lblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 50, 50));

        btnEnter.setBackground(new java.awt.Color(4, 4, 4));
        btnEnter.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        btnEnter.setForeground(new java.awt.Color(208, 208, 208));
        btnEnter.setText("Log in");
        jPanel1.add(btnEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 310, 35));

        lblForgetPass.setBackground(new java.awt.Color(52, 52, 52));
        lblForgetPass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblForgetPass.setForeground(new java.awt.Color(116, 116, 116));
        lblForgetPass.setText("Olvidaste tu contraseña?");
        jPanel1.add(lblForgetPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, -1, -1));

        lblConfirmCaptcha.setFont(new java.awt.Font("Roboto Condensed Light", 0, 14)); // NOI18N
        jPanel1.add(lblConfirmCaptcha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 290, 20));

        pnlCaptchaGenerator.setBackground(new java.awt.Color(191, 184, 180));

        lblCaptchaGenerator.setFont(new java.awt.Font("Cambria Math", 2, 24)); // NOI18N
        lblCaptchaGenerator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaptchaGenerator.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnlCaptchaGeneratorLayout = new javax.swing.GroupLayout(pnlCaptchaGenerator);
        pnlCaptchaGenerator.setLayout(pnlCaptchaGeneratorLayout);
        pnlCaptchaGeneratorLayout.setHorizontalGroup(
            pnlCaptchaGeneratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCaptchaGenerator, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        pnlCaptchaGeneratorLayout.setVerticalGroup(
            pnlCaptchaGeneratorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCaptchaGeneratorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblCaptchaGenerator, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(pnlCaptchaGenerator, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 325, 130, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/M_login.jpg"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_PasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_PasswordMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PasswordMousePressed

    private void txt_UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_UsernameActionPerformed

    private void txt_UsernameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_UsernameMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_UsernameMousePressed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEnter;
    public javax.swing.JButton btnNewCaptcha;
    public javax.swing.JButton btnValidarCaptcha;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblCaptchaGenerator;
    public javax.swing.JLabel lblCerrar;
    public javax.swing.JLabel lblConfirmCaptcha;
    public javax.swing.JLabel lblForgetPass;
    private javax.swing.JPanel pnlCaptchaGenerator;
    public javax.swing.JTextField txtCaptcha;
    public javax.swing.JPasswordField txt_Password;
    public javax.swing.JTextField txt_Username;
    // End of variables declaration//GEN-END:variables
}
