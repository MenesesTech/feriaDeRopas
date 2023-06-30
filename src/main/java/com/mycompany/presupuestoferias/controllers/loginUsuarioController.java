package com.mycompany.presupuestoferias.controllers;

import com.mycompany.presupuestoferias.models.empleado;
import com.mycompany.presupuestoferias.models.empleadoDao;
import com.mycompany.presupuestoferias.views.LoginView;
import com.mycompany.presupuestoferias.views.RecuperarPassword;
import com.mycompany.presupuestoferias.views.SystemView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class loginUsuarioController implements ActionListener, MouseListener {

    private empleado user_employee;
    private empleadoDao userDao;
    private LoginView loginView;
    private int loginAttempts = 0;

    public loginUsuarioController(empleado user_employee, empleadoDao userDao, LoginView loginView) {
        this.user_employee = user_employee;
        this.userDao = userDao;
        this.loginView = loginView;
        this.loginView.btnEnter.addActionListener(this);
        this.loginView.btnValidarCaptcha.addActionListener(this);
        this.loginView.txt_Username.addMouseListener(this);
        this.loginView.txt_Password.addMouseListener(this);
        this.loginView.lblForgetPass.addMouseListener(this);
        this.loginView.lblCerrar.addMouseListener(this);
        this.loginView.btnNewCaptcha.addMouseListener(this);
        this.loginView.lblCaptchaGenerator.setText(userDao.generarCaptcha());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = loginView.txt_Username.getText().trim();
        String pass = String.valueOf(loginView.txt_Password.getPassword());
        String captchaText = loginView.txtCaptcha.getText();
        // Boton Validar Captcha
        if (e.getSource() == loginView.btnValidarCaptcha) {
            if (captchaText.equals(loginView.lblCaptchaGenerator.getText())) {
                // Si el texto del Captcha ingresado es igual al texto generado
                loginView.lblConfirmCaptcha.setForeground(new Color(0, 153, 0));
                loginView.lblConfirmCaptcha.setText("*Correcto");
            } else {
                // Si el texto del Captcha ingresado no coincide con el texto generado
                loginView.lblConfirmCaptcha.setForeground(new Color(255, 0, 51));
                loginView.lblConfirmCaptcha.setText("*No has introducido bien la palabra del Captcha");
            }
            //Boton Ingresar
        } else if (e.getSource() == loginView.btnEnter) {
            if (captchaText.equals(loginView.lblCaptchaGenerator.getText())) {
                // Si el texto del Captcha ingresado es igual al texto generado
                if (!user.equals("") || !pass.equals("")) {
                    // Si el usuario o la contraseña no están vacíos
                    user_employee = userDao.loginQuery(user, pass);
                    if (user_employee.getUsername() != null) {
                        // Si se encontró un empleado con el usuario y contraseña proporcionados
                        SystemView admin = new SystemView();
                        admin.setVisible(true);
                        this.loginView.dispose();
                    } else {
                        // Si no se encontró un empleado con el usuario y contraseña proporcionados
                        loginAttempts++; // Incrementar el contador de intentos
                        if (loginAttempts >= 3) {
                            JOptionPane.showMessageDialog(null, "Se ha excedido el número máximo de intentos. La sesión se cerrará.");
                            System.exit(0); // Otra acción que desees tomar al exceder el número de intentos
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta. Intento " + loginAttempts + " de 3.");
                        }
                    }
                } else {
                    // Si los campos de usuario y contraseña están vacíos
                    JOptionPane.showMessageDialog(null, "Los campos están vacíos");
                }
            } else {
                // Si el texto del Captcha ingresado no coincide con el texto generado
                JOptionPane.showMessageDialog(null, "El captcha es obligatorio");
            }
        }

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == loginView.lblCerrar) {
            System.exit(0);
        } else if (e.getSource() == loginView.lblForgetPass) {
            RecuperarPassword recuPass = new RecuperarPassword();
            recuPass.setVisible(true);
        }else if(e.getSource() == loginView.btnNewCaptcha){
            loginView.lblCaptchaGenerator.setText(userDao.generarCaptcha());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == loginView.txt_Username) {
            loginView.txt_Username.setText("");
            loginView.txt_Username.setForeground(Color.BLACK);
        } else if (e.getSource() == loginView.txt_Password) {
            loginView.txt_Password.setText("");
            loginView.txt_Password.setForeground(Color.BLACK);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == loginView.lblForgetPass) {
            loginView.lblForgetPass.setForeground(new Color(255, 102, 102));
        } else if (e.getSource() == loginView.lblCerrar) {
            loginView.lblCerrar.setForeground(Color.red);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == loginView.lblForgetPass) {
            loginView.lblForgetPass.setForeground(new Color(116, 116, 116));
        } else if (e.getSource() == loginView.lblCerrar) {
            loginView.lblCerrar.setForeground(new Color(187, 187, 187));
        }
    }
}
