package com.mycompany.presupuestoferias.models;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class feriaDao {

    ConnectionMySQL cn = new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    //Registrar feria
    public boolean registroFeriaQuery(feria feria_ropa) {
        String query = "INSERT INTO feria (name, address, category, estado, organizer_fullname, organizer_email, organizer_telephone, start_date, end_date) VALUES (?,?,?,?,?,?,?,?,?);";
        try {
            Connection conn = cn.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, feria_ropa.getName());
            pst.setString(2, feria_ropa.getAddress());
            pst.setString(3, feria_ropa.getCategory());
            pst.setString(4, feria_ropa.getStatus());
            pst.setString(5, feria_ropa.getOrganizador());
            pst.setString(6, feria_ropa.getTelephone());
            pst.setString(7, feria_ropa.getEmail());
            pst.setDate(8, feria_ropa.getDateInicio());
            pst.setDate(9, feria_ropa.getDateFin());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar los datos de la feria: " + e);
            return false;
        }
    }

    //Lista secundaria de Ferias
    public List listFeriaQuery() {
        List<feria> listFerias = new ArrayList();
        String query = "SELECT name, address, category, estado, start_date, end_date FROM feria;";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                feria fair = new feria();
                fair.setName(rs.getString("name"));
                fair.setAddress(rs.getString("address"));
                fair.setCategory(rs.getString("category"));
                fair.setStatus(rs.getString("estado"));
                fair.setDateInicio(rs.getDate("start_date"));
                fair.setDateFin(rs.getDate("end_date"));
                listFerias.add(fair);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listFerias;
    }
    
    //Lista Principal de Ferias
    public List listFeriaPrincipalQuery() {
        List<feria> listFerias = new ArrayList();
        String query = "SELECT name,address,category,estado,start_date,organizer_fullname,organizer_email,organizer_telephone,end_date FROM feria;";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                feria fair = new feria();
                fair.setName(rs.getString("name"));
                fair.setAddress(rs.getString("address"));
                fair.setCategory(rs.getString("category"));
                fair.setStatus(rs.getString("estado"));
                fair.setDateInicio(rs.getDate("start_date"));
                fair.setDateFin(rs.getDate("end_date"));
                fair.setOrganizador(rs.getString("organizer_fullname"));
                fair.setEmail(rs.getString("organizer_email"));
                fair.setTelephone(rs.getString("organizer_telephone"));
                listFerias.add(fair);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listFerias;
    }
}
