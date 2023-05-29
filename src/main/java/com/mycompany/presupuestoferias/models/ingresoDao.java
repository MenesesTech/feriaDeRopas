
package com.mycompany.presupuestoferias.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ingresoDao {
    
    ConnectionMySQL cn = new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    //Registrar egreso
    public boolean registroIngresoQuery(ingreso ingreso_pres) {
    String query = "INSERT INTO ingreso (cod_ingreso, tipo, categoria, product_serv, cantidad, precio) VALUES (?,?,?,?,?,?)";
    try {
        pst = conn.prepareStatement(query);
        pst.setString(1, ingreso_pres.getId());
        pst.setString(2, ingreso_pres.getType());
        pst.setString(3, ingreso_pres.getCategory());
        pst.setString(4, ingreso_pres.getProductoServicio());
        pst.setInt(5, ingreso_pres.getCantidad());
        pst.setDouble(6, ingreso_pres.getPrecio());
        pst.executeUpdate();
        return true;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al registrar los datos del ingreso: " + e);
        return false;
    }
}


    public List listIngresoQuery() {
        List<ingreso> listIngreso = new ArrayList();
        String query = "SELECT cod_ingreso, tipo, categoria, product_serv, cantidad, precio FROM ingreso";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ingreso ingreso_pres = new ingreso();
                ingreso_pres.setId(rs.getString("cod_ingreso"));
                ingreso_pres.setType(rs.getString("tipo"));
                ingreso_pres.setCategory(rs.getString("categoria"));
                ingreso_pres.setProductoServicio(rs.getString("product_serv"));
                ingreso_pres.setCantidad(rs.getInt("cantidad"));
                ingreso_pres.setPrecio(rs.getInt("precio"));
                listIngreso.add(ingreso_pres);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listIngreso;
    }

    public boolean updateIngresoQuery(ingreso ingreso_pres) {
        String query = "UPDATE ingreso SET tipo = ?, categoria = ?, product_serv = ?, cantidad = ?, precio = ?"
                + "WHERE cod_ingreso = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, ingreso_pres.getType());
            pst.setString(2, ingreso_pres.getCategory());
            pst.setString(3, ingreso_pres.getProductoServicio());
            pst.setInt(4, ingreso_pres.getCantidad());
            pst.setDouble(5, ingreso_pres.getPrecio());
            pst.setString(6, ingreso_pres.getId());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar los datos del egreso " + e);
            return false;
        }
    }

    public boolean deleteIngresoQuery(int id) {
        String query = "DELETE FROM ingreso WHERE cod_ingreso = " + id;
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

    public String obtenerUltimoCodigoIngreso() {
        String ultimoCodigo = "";
        String query = "SELECT cod_ingreso FROM ingreso ORDER BY cod_ingreso DESC LIMIT 1";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                ultimoCodigo = rs.getString("cod_ingreso");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el ultimo digito: " + e);
        }
        return ultimoCodigo;
    }

    public String generarCodigo() {
    String ultimoCodigo = obtenerUltimoCodigoIngreso();
    int ultimoNumero = Integer.parseInt(ultimoCodigo.substring(2));
    int nuevoNumero = ultimoNumero + 1;
    String nuevoCodigo = String.format("IN%03d", nuevoNumero);
    return nuevoCodigo;
}


}
