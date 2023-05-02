/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.presupuestoferias.controllers;

import com.mycompany.presupuestoferias.models.usuario;
import com.mycompany.presupuestoferias.models.usuarioDao;
import com.mycompany.presupuestoferias.views.LoginView;
import com.mycompany.presupuestoferias.views.SystemView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Haisenberg
 */
public class loginUsuarioController implements ActionListener, MouseListener {

    private usuario user_employee;
    private usuarioDao userDao;
    private LoginView loginView;

    public loginUsuarioController(usuario user_employee, usuarioDao userDao, LoginView loginView) {
        this.user_employee = user_employee;
        this.userDao = userDao;
        this.loginView = loginView;
        this.loginView.btnEnter.addActionListener(this);
        this.loginView.btnValidarCaptcha.addActionListener(this);
        this.loginView.txt_Username.addMouseListener(this);
        this.loginView.txt_Password.addMouseListener(this);
        this.loginView.lblForgetPass.addMouseListener(this);
        this.loginView.lblCerrar.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = loginView.txt_Username.getText().trim();
        String pass = String.valueOf(loginView.txt_Password.getPassword());
        String captchaText = loginView.txtCaptcha.getText();
        if (e.getSource() == loginView.btnValidarCaptcha) {
            if (captchaText.equals(loginView.lblCaptchaGenerator.getText())) {
                loginView.lblConfirmCaptcha.setForeground(new Color(0, 153, 0));
                loginView.lblConfirmCaptcha.setText("*Correcto");
            } else {
                loginView.lblConfirmCaptcha.setForeground(new Color(255, 0, 51));
                loginView.lblConfirmCaptcha.setText("*No has introducido bien la palabra del Captcha");
            }
        } else if (e.getSource() == loginView.btnEnter) {
            if (captchaText.equals(loginView.lblCaptchaGenerator.getText())) {
                if (!user.equals("") || !pass.equals("")) {
                    user_employee = userDao.loginQuery(user, pass);
                    if (user_employee.getUsername() != null) {
                        SystemView admin = new SystemView();
                        admin.setVisible(true);
                        this.loginView.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Los campos estan vacios");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El captcha es obligatorio");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == loginView.lblCerrar) {
            System.exit(0);
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
        }else if (e.getSource() == loginView.lblCerrar) {
            loginView.lblCerrar.setForeground(Color.red);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == loginView.lblForgetPass) {
            loginView.lblForgetPass.setForeground(new Color(116, 116, 116));
        }else if (e.getSource() == loginView.lblCerrar) {
            loginView.lblCerrar.setForeground(new Color(187,187,187));
        }
    }
}
