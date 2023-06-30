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

public class empleadoDao {

    ConnectionMySQL cn = new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst;
    ResultSet rst;

    //Variables para enviar datos entre interfaces
    public static String id_user = "";
    public static String name_user = "";
    public static String lastname_user = "";
    public static String username_user = "";
    public static String district_user = "";
    public static String phone_user = "";
    public static String email_user = "";
    public static String rol_user = "";

    /**
     * Metodo para inicar sesion
     *
     * @param user Usuario ingresado para el inicio de sesión
     * @param password Contraseña ingresada para el inicio de sesión
     * @return Retornar objeto empleado si las credenciales son validas
     */
    public empleado loginQuery(String user, String password) {
        String query = "SELECT*FROM empleado WHERE username = ? AND password = ?";
        empleado employee_user = new empleado();
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, user);
            pst.setString(2, password);
            rst = pst.executeQuery();
            if (rst.next()) {
                employee_user.setId(rst.getString("id"));
                id_user = employee_user.getId();
                employee_user.setRol(rst.getString("rol"));
                rol_user = employee_user.getRol();
                employee_user.setUsername(rst.getString("username"));
                username_user = employee_user.getUsername();
                employee_user.setName(rst.getString("name"));
                name_user = employee_user.getName();
                employee_user.setLastName(rst.getString("lastName"));
                lastname_user = employee_user.getLastName();
                employee_user.setDistrict(rst.getString("district"));
                district_user = employee_user.getDistrict();
                employee_user.setTelephone(rst.getString("telephone"));
                phone_user = employee_user.getTelephone();
                employee_user.setEmail(rst.getString("email"));
                email_user = employee_user.getEmail();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener al usuario");
        }
        return employee_user;
    }

    /**
     * Metodo para registrar un nuevo usuario
     *
     * @param employee Objeto empleado que contiene los datos del nuevo usuario
     * @return true si el registro es exitoso, false si ocurre algún error
     */
    public boolean registerUserQuery(empleado employee) {
        String query = "INSERT INTO empleado (id, username,password,name,lastName,DNI,district,email,telephone,rol,created,updated) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, employee.getId());
            pst.setString(2, employee.getUsername());
            pst.setString(3, employee.getPassword());
            pst.setString(4, employee.getName());
            pst.setString(5, employee.getLastName());
            pst.setString(6, employee.getDNI());
            pst.setString(7, employee.getDistrict());
            pst.setString(8, employee.getEmail());
            pst.setString(9, employee.getTelephone());
            pst.setString(10, employee.getRol());
            pst.setTimestamp(11, datetime);
            pst.setTimestamp(12, datetime);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar al usuario: " + e);
        }
        return false;
    }

    /**
     * Metodo para obtener una lista de todos los usuarios registrados
     *
     * @return Lista de objetos empleado que representan a los usuarios
     * registrados
     */
    public List listUserQuery() {
        List<empleado> list_employees = new ArrayList();
        String query = "SELECT id,name,lastName,DNI,district,email,telephone,username,password,rol FROM empleado;";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rst = pst.executeQuery();
            while (rst.next()) {
                empleado employee = new empleado();
                employee.setId(rst.getString("id"));
                employee.setName(rst.getString("name"));
                employee.setLastName(rst.getString("lastName"));
                employee.setDNI(rst.getString("DNI"));
                employee.setDistrict(rst.getString("district"));
                employee.setEmail(rst.getString("email"));
                employee.setTelephone(rst.getString("telephone"));
                employee.setUsername(rst.getString("username"));
                employee.setPassword(rst.getString("password"));
                employee.setRol(rst.getString("rol"));
                list_employees.add(employee);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return list_employees;
    }

    /**
     * Actualiza los datos de un empleado en la base de datos
     *
     * @param employee Objeto empleado que contiene los nuevos datos a
     * actualizar
     * @return true si la actualizacion se realiza correctamente, false en caso
     * contrario
     */
    public boolean updateUserQuery(empleado employee) {
        String query = "UPDATE empleado SET username = ?, name = ?, lastName = ?, DNI = ?, district = ?, email = ?, telephone = ?, rol = ?, updated = ?"
                + "WHERE id = ?";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, employee.getUsername());
            pst.setString(2, employee.getName());
            pst.setString(3, employee.getLastName());
            pst.setString(4, employee.getDNI());
            pst.setString(5, employee.getDistrict());
            pst.setString(6, employee.getEmail());
            pst.setString(7, employee.getTelephone());
            pst.setString(8, employee.getRol());
            pst.setTimestamp(9, datetime);
            pst.setString(10, employee.getId());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar los datos del empleado " + e);
            return false;
        }
    }

    /**
     * Metodo para eliminar un empleado
     *
     * @param id ID del empleado a eliminar
     * @return true si el empleado se elimina correctamente, false en caso
     * contrario
     */
    public boolean deleteUserQuery(String id) {
        String query = "DELETE FROM empleado WHERE id = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No puede eliminar un empleado que tenga relacion con otra tabla " + e);
            return false;
        }
    }

    /**
     * Metodo para actualizar la contraseña
     *
     * @param employee Objeto empleado que contiene la nueva contraseña
     * @return true si se actualiza la contraseña correctamente, false en caso
     * contrario
     */
    public boolean updateEmployeePassword(empleado employee) {
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

    /**
     * Genera captcha alfanumérico de 6 caracteres
     *
     * @return Cadena de caracteres que representa el captcha generado
     */
    public String generarCaptcha() {
        //Caracteres validos para el captcha
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //Construir el captcha
        StringBuilder captcha = new StringBuilder();
        //Objeto ramdom para generar valores aleatorios
        Random random = new Random();
        // Generar cada caracter del captcha
        for (int i = 0; i < 6; i++) {
            captcha.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return captcha.toString();
    }

    /**
     * Metodo para recuperar contraseña
     * 
     * @param email Direccion del correo electronico del empleado
     * @return Contraseña del empleado si se encuentra, mensaje de error si no se encuentra o si ocurre un error
     */
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
                JOptionPane.showMessageDialog(null, "No se encontró ningún empleado con ese email.");
                return "No se encontró ningún empleado con ese email.";
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al recuperar contraseña: "+e);
            return "Ha ocurrido un error al recuperar la contraseña ";
        }
    }

    /**
     * Metodo para obtener el ultimo codigo del empleado
     * 
     * @return Ultimo codigo del empleado registrado
     */
    public String obtenerUltimoCodigoEmpleado() {
        String ultimoCodigo = "";
        String query = "SELECT id FROM empleado ORDER BY id DESC LIMIT 1";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rst = pst.executeQuery();
            while (rst.next()) {
                ultimoCodigo = rst.getString("id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el ultimo digito: " + e);
        }
        return ultimoCodigo;
    }

    /**
     * Metodo para generar un nuevo codigo de empleado
     * El codigo generado sigue el formato "PXXXX" donde XXXX es un número de 4 digitos
     * 
     * @return Nuevo codigo de empleado generado
     */
    public String generarCodigo() {
        //Obtener el ultimo codigo de empleado regitrado
        String ultimoCodigo = obtenerUltimoCodigoEmpleado();
        
        //Extraer el numero del ultimo codigo empleado
        int ultimoNumero = Integer.parseInt(ultimoCodigo.substring(1));
        
        // Incrementar el número en uno para generar el nuevo código
        int nuevoNumero = ultimoNumero + 1;
        
        // Formatear el nuevo número con ceros a la izquierda y agregar el prefijo "P"
        String nuevoCodigo = String.format("P%04d", nuevoNumero);
        
        // Retornar el nuevo código de empleado generado
        return nuevoCodigo;
    }
}
