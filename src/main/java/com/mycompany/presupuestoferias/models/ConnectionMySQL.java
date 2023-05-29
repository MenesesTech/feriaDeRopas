package com.mycompany.presupuestoferias.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionMySQL {
    private String database_name = "presupuestoferiasbd";
    private String user = "root";
    private String password = "Curbicode1000";
    private String url = "jdbc:mysql://localhost:3306/" + database_name;
    Connection conn = null;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error" + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error SQLException" + e.getMessage());
        }
        return conn;
    }
}
