package com.mycompany.presupuestoferias.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class egresoDao {

    ConnectionMySQL cn = new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    //Registrar egreso
    public boolean registroEgresoQuery(egreso egreso_pres) {
        String query = "INSERT INTO egreso (cod_egreso, tipo, categoria, product_serv, cantidad, precio) VALUES (?,?,?,?,?,?)";
        try {
            Connection conn = cn.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, egreso_pres.getId());
            pst.setString(2, egreso_pres.getType());
            pst.setString(3, egreso_pres.getCategory());
            pst.setString(4, egreso_pres.getProductoServicio());
            pst.setInt(5, egreso_pres.getCantidad());
            pst.setDouble(6, egreso_pres.getPrecio());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar los datos del egreso: " + e);
            return false;
        }
    }

    public List listEgresoQuery() {
        List<egreso> listEgreso = new ArrayList();
        String query = "SELECT cod_egreso, tipo, categoria, product_serv, cantidad, precio FROM egreso";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                egreso egreso_pres = new egreso();
                egreso_pres.setId(rs.getString("cod_egreso"));
                egreso_pres.setType(rs.getString("tipo"));
                egreso_pres.setCategory(rs.getString("categoria"));
                egreso_pres.setProductoServicio(rs.getString("product_serv"));
                egreso_pres.setCantidad(rs.getInt("cantidad"));
                egreso_pres.setPrecio(rs.getInt("precio"));
                listEgreso.add(egreso_pres);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listEgreso;
    }

    public boolean updateEgresoQuery(egreso egreso_pres) {
        String query = "UPDATE egreso SET tipo = ?, categoria = ?, product_serv = ?, cantidad = ?, precio = ?"
                + "WHERE cod_egreso = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, egreso_pres.getType());
            pst.setString(2, egreso_pres.getCategory());
            pst.setString(3, egreso_pres.getProductoServicio());
            pst.setInt(4, egreso_pres.getCantidad());
            pst.setDouble(5, egreso_pres.getPrecio());
            pst.setString(6, egreso_pres.getId());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar los datos del egreso " + e);
            return false;
        }
    }

    public boolean deleteEgresoQuery(int id) {
        String query = "DELETE FROM egreso WHERE cod_egreso = " + id;
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No puede eliminar un egreso que tenga relacion con otra tabla " + e);
            return false;
        }
    }

    public String obtenerUltimoCodigoEgreso() {
        String ultimoCodigo = "";
        String query = "SELECT cod_egreso FROM egreso ORDER BY cod_egreso DESC LIMIT 1";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ultimoCodigo = rs.getString("cod_egreso");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el ultimo digito: " + e);
        }
        return ultimoCodigo;
    }

    public String generarCodigo() {
        String ultimoCodigo = obtenerUltimoCodigoEgreso();
        int ultimoNumero = Integer.parseInt(ultimoCodigo.substring(2));
        int nuevoNumero = ultimoNumero + 1;
        String nuevoCodigo = String.format("EG%03d", nuevoNumero);
        return nuevoCodigo;
    }

}
