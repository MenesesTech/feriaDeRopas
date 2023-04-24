package com.mycompany.presupuestoferias.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class usuarioDao {

    ConnectionMySQL cn = new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst;
    ResultSet rst;

    //Variables para enviar datos entre interfaces
    public static int id_user = 0;
    public static String full_name_user = "";
    public static String username_user = "";
    public static String telephone_user = "";
    public static String email_user = "";
    public static String rol_user = "";

    public usuario loginQuery(String user, String password) {
        String query = "SELECT*FROM employee WHERE username = ? AND password = ?";
        usuario employee_user = new usuario();
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, user);
            pst.setString(2, password);
            rst = pst.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener al usuario");
        }
        return employee_user;

    }
}
