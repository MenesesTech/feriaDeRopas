package com.mycompany.presupuestoferias.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
        String query = "SELECT*FROM empleado WHERE username = ? AND password = ?";
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
                employee_user.setEmail(rst.getString("email"));
                email_user = employee_user.getEmail();
                employee_user.setTelephone(rst.getString("telephone"));
                telephone_user = employee_user.getTelephone();
                employee_user.setRol(rst.getString("rol"));
                rol_user = employee_user.getRol();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener al usuario");
        }
        return employee_user;
    }

    //Metodo para registrar usuario
    public boolean registerUserQuery(usuario employee) {
        String query = "INSERT INTO empleado (full_name, username, password, email, telephone, rol, created, updated) VALUES (?,?,?,?,?,?,?,?)";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, employee.getFull_name());
            pst.setString(2, employee.getUsername());
            pst.setString(3, employee.getPassword());
            pst.setString(4, employee.getEmail());
            pst.setString(5, employee.getTelephone());
            pst.setString(6, employee.getRol());
            pst.setTimestamp(7, datetime);
            pst.setTimestamp(8, datetime);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar al usuario: " + e);
        }
        return false;
    }

    //Listar usuarios para el registro
    public List listUserQuery() {
        List<usuario> list_employees = new ArrayList();
        String query = "SELECT id, full_name, username, telephone, email, rol FROM empleado;";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rst = pst.executeQuery();
            while (rst.next()) {
                usuario employee = new usuario();
                employee.setId(rst.getInt("id"));
                employee.setFull_name(rst.getString("full_name"));
                employee.setUsername(rst.getString("username"));
                employee.setTelephone(rst.getString("telephone"));
                employee.setEmail(rst.getString("email"));
                employee.setRol(rst.getString("rol"));
                list_employees.add(employee);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return list_employees;
    }

    //Metodo para modificar empleado
    public boolean updateUserQuery(usuario employee) {
        String query = "UPDATE empleado SET full_name = ?, username = ?, email = ?, telephone = ?, rol = ?, updated = ?"
                + "WHERE id = ?";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, employee.getFull_name());
            pst.setString(2, employee.getUsername());
            pst.setString(3, employee.getEmail());
            pst.setString(4, employee.getTelephone());
            pst.setString(5, employee.getRol());
            pst.setTimestamp(6, datetime);
            pst.setInt(7, employee.getId());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar los datos del empleado " + e);
            return false;
        }
    }

    //Metodo para eliminar empleado
    public boolean deleteUserQuery(int id) {
        String query = "DELETE FROM empleado WHERE id = " + id;
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No puede eliminar un empleado que tenga relacion con otra tabla " + e);
            return false;
        }
    }

    //Cambiar la contraseña
    public boolean updateEmployeePassword(usuario employee) {
        String query = "UPDATE empleado SET password = ? WHERE username = '" + username_user + "'";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, employee.getPassword());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al modificar la contraseña " + e);
            return false;
        }
    }

    //Generar Captcha
    public String generarCaptcha() {
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder captcha = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            captcha.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return captcha.toString();
    }

    public String recuperarContraseña(String email) {
        String query = "SELECT password FROM empleado WHERE email = '" + email + "'";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rst = pst.executeQuery();
            if (rst.next()) {
                String password = rst.getString("password");
                return password;
            } else {
                return "No se encontró ningún empleado con ese email.";
            }
        } catch (SQLException e) {
            return "Ha ocurrido un error al recuperar la contraseña ";
        }
    }

}
