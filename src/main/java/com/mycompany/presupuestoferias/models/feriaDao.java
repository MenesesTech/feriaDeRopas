package com.mycompany.presupuestoferias.models;

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.Date;

/*
import java.util.ArrayList;
import java.util.List;
 */
import javax.swing.JOptionPane;

public class feriaDao {

    ConnectionMySQL cn = new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    //Registrar feria
    public boolean registroFeriaQuery(feria feria_ropa) {
        String query = "INSERT INTO feria (name, address, category, estado, start_date, end_date) VALUES (?,?,?,?,?,?);";
        try {
            Connection conn = cn.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, feria_ropa.getName());
            pst.setString(2, feria_ropa.getAddress());
            pst.setString(3, feria_ropa.getCategory());
            pst.setString(4, feria_ropa.getStatus());
            pst.setDate(5, new java.sql.Date(feria_ropa.getDateInicio().getTime())); 
            pst.setDate(6, new java.sql.Date(feria_ropa.getDateFin().getTime())); 
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar los datos de la feria: " + e);
            return false;
        }
    }

    /*Listar feria para el registro
    public List listFeriaQuery() {
        // Crear una lista para almacenar las ferias obtenidas de la consulta
        List<feria> listFerias = new ArrayList();
        // Consulta SQL para obtener los datos de la feria
        String query = "SELECT name, address, category, estado, inicio, fin FROM feria;";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            // Iterar a través del resultado y crear objetos feria para cada fila
            while (rs.next()) {
                feria feria_ropa = new feria();
                feria_ropa.setName(rs.getString("name"));
                feria_ropa.setAddress(rs.getString("address"));
                feria_ropa.setCategory(rs.getString("category"));
                feria_ropa.setStatus(rs.getString("estado"));
                feria_ropa.setDateInicio(rs.getString("inicio"));
                feria_ropa.setDateFin(rs.getString("fin"));
                // Agregar el objeto feria_ropa a la lista de ferias
                listFerias.add(feria_ropa);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return listFerias;
    }
    //Listar feria para las opciones
    public List listAllFeria() {
        // Crear una lista para almacenar las ferias obtenidas de la consulta
        List<feria> listFerias = new ArrayList();
        // Consulta SQL para obtener los datos de la feria
        String query = "SELECT name, address, inicio, fin, organizador, telephone,email, category, estado FROM feria;";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            // Iterar a través del resultado y crear objetos feria para cada fila
            while (rs.next()) {
                feria feria_ropa = new feria();
                feria_ropa.setName(rs.getString("name"));
                feria_ropa.setAddress(rs.getString("address"));
                feria_ropa.setDateInicio(rs.getString("inicio"));
                feria_ropa.setDateFin(rs.getString("fin"));
                feria_ropa.setOrganizador(rs.getString("organizador"));
                feria_ropa.setTelephone(rs.getString("telephone"));
                feria_ropa.setEmail(rs.getString("email"));
                feria_ropa.setCategory(rs.getString("category"));
                feria_ropa.setStatus(rs.getString("estado"));
                // Agregar el objeto feria_ropa a la lista de ferias
                listFerias.add(feria_ropa);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return listFerias;
    }*/
}
