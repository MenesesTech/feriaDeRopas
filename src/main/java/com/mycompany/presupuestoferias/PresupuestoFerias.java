package com.mycompany.presupuestoferias;

import com.mycompany.presupuestoferias.models.ConnectionMySQL;
import com.mycompany.presupuestoferias.views.LoginView;

public class PresupuestoFerias {

    public static void main(String[] args) {
        ConnectionMySQL conn = new ConnectionMySQL();
        conn.getConnection();
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
    }
}
