package com.mycompany.presupuestoferias.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class feriaDao {

    ConnectionMySQL cn = new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    //Registrar feria
    public boolean registroFeriaQuery(feria feria_ropa) {
        String query = "INSERT INTO feria (name, address, category, estado, organizador, telephone, email, rol, inicio, fin) VALUES (?,?,?,?,?,?,?,?,?,?);";
        // Obtener la fecha y hora actual

        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, feria_ropa.getName());
            pst.setString(2, feria_ropa.getAddress());
            pst.setString(3, feria_ropa.getCategory());
            pst.setString(4, feria_ropa.getStatus());
            pst.setString(5, feria_ropa.getOrganizador());
            pst.setString(6, feria_ropa.getTelephone());
            pst.setString(7, feria_ropa.getEmail());
            pst.setString(8, feria_ropa.getRol());
            pst.setTimestamp(9, datetime);
            pst.setTimestamp(10, datetime);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar los datos de la feria: " + e);
            return false;
        }
    }

    //Listar incidencias
    public List listFeriaQuery() {
        List<feria> listFerias = new ArrayList();
        String query = "SELECT name, address, category, estado, inicio, fin FROM feria;";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                feria feria_ropa = new feria();
                feria_ropa.setName(rs.getString("name"));
                feria_ropa.setAddress(rs.getString("address"));
                feria_ropa.setCategory(rs.getString("category"));
                feria_ropa.setStatus(rs.getString("estado"));
                feria_ropa.setDateInicio(rs.getString("inicio"));
                feria_ropa.setDateFin(rs.getString("fin"));
                listFerias.add(feria_ropa);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return listFerias;
    }

}
