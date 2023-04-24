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
    public static String address_user = "";
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
            if (rst.next()) {
                employee_user.setId(rst.getInt("id"));
                id_user = employee_user.getId();
                employee_user.setFull_name(rst.getString("full_name"));
                full_name_user = employee_user.getFull_name();
                employee_user.setUsername(rst.getString("username"));
                username_user = employee_user.getUsername();
                employee_user.setAddress(rst.getString("address"));
                address_user = employee_user.getAddress();
                employee_user.setTelephone(rst.getString("telephone"));
                telephone_user = employee_user.getTelephone();
                employee_user.setEmail(rst.getString("email"));
                email_user = employee_user.getEmail();
                employee_user.setRol(rst.getString("rol"));
                rol_user = employee_user.getRol();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener al usuario");
        }
        return employee_user;
    }
}
