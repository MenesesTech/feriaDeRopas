package com.mycompany.presupuestoferias.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionMySQL {

    //Definimos las variables con los datos de conexion
    private String database = "EmpresaFeriaBD";
    private String user = "hacker";
    private String password = "root";
    private String url = "jdbc:sqlserver://DESKTOP-VFCJ6Q5:1433;databaseName=" + database + ";trustServerCertificate=true";

    Connection conn = null;

    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error" + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error SQLException" + e.getMessage());
        }
        return conn;
    }
}
