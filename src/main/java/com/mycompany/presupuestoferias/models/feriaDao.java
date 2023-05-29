package com.mycompany.presupuestoferias.models;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class feriaDao {

    ConnectionMySQL cn = new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    //Registrar feria
    public boolean registroFeriaQuery(feria feria_ropa) {
        String query = "INSERT INTO feria (id_feria, name, district, aforo, category, status, monto, fecha_inicio, fecha_final) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = cn.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, feria_ropa.getId());
            pst.setString(2, feria_ropa.getName());
            pst.setString(3, feria_ropa.getDistrict());
            pst.setInt(4, feria_ropa.getAforo());
            pst.setString(5, feria_ropa.getCategory());
            pst.setString(6, feria_ropa.getStatus());
            pst.setDouble(7, feria_ropa.getMonto());
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
        String query = "SELECT id_feria, name, district, category, aforo, fecha_inicio, fecha_final, monto, status FROM feria";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                feria fair = new feria();
                fair.setId(rs.getString("id_feria"));
                fair.setName(rs.getString("name"));
                fair.setDistrict(rs.getString("district"));
                fair.setCategory(rs.getString("category"));
                fair.setAforo(rs.getInt("aforo"));
                fair.setDateInicio(rs.getDate("fecha_inicio"));
                fair.setDateFin(rs.getDate("fecha_final"));
                fair.setMonto(rs.getDouble("monto"));
                fair.setStatus(rs.getString("status"));
                listFerias.add(fair);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listFerias;
    }
    
    public boolean updateFairQuery(feria feria_ropa) {
        String query = "UPDATE feria SET name = ?, district = ?, aforo = ?, category = ?, status = ?, monto = ?, fecha_inicio = ?, fecha_final = ?"
                + "WHERE id_feria = ?";
        Timestamp datetime = new Timestamp(new Date().getTime());
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, feria_ropa.getName());
            pst.setString(2, feria_ropa.getDistrict());
            pst.setInt(3, feria_ropa.getAforo());
            pst.setString(4, feria_ropa.getCategory());
            pst.setString(5, feria_ropa.getStatus());
            pst.setDouble(6, feria_ropa.getMonto());
            pst.setDate(7, feria_ropa.getDateInicio());
            pst.setDate(8, feria_ropa.getDateFin());
            pst.setString(9, feria_ropa.getId());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar los datos de la feria " + e);
            return false;
        }
    }
    
    public boolean deleteFairQuery(String id) {
        String query = "DELETE FROM feria WHERE id_feria = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No puede eliminar una feria que tenga relacion con otra tabla " + e);
            return false;
        }
    }
    
    public String obtenerUltimoCodigoFeria() {
        String ultimoCodigo = "";
        String query = "SELECT id_feria FROM feria ORDER BY id_feria DESC LIMIT 1";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ultimoCodigo = rs.getString("id_feria");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el ultimo digito: " + e);
        }
        return ultimoCodigo;
    }

    public String generarCodigo() {
        String ultimoCodigo = obtenerUltimoCodigoFeria();
        int ultimoNumero = Integer.parseInt(ultimoCodigo.substring(1));
        int nuevoNumero = ultimoNumero + 1;
        String nuevoCodigo = String.format("F%04d", nuevoNumero);
        return nuevoCodigo;
    }
}
