/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.presupuestoferias.controllers;

import com.mycompany.presupuestoferias.models.usuario;
import com.mycompany.presupuestoferias.models.usuarioDao;
import com.mycompany.presupuestoferias.views.LoginView;
import com.mycompany.presupuestoferias.views.SystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Haisenberg
 */
public class loginUsuarioController implements ActionListener {

    private usuario user_employee;
    private usuarioDao userDao;
    private LoginView loginView;

    public loginUsuarioController(usuario user_employee, usuarioDao userDao, LoginView loginView) {
        this.user_employee = user_employee;
        this.userDao = userDao;
        this.loginView = loginView;
        this.loginView.btnEnter.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = loginView.txtUsername.getText().trim();
        String pass = String.valueOf(loginView.txtPassword.getPassword());
        if (e.getSource() == loginView.btnEnter) {
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
        }
    }

}
