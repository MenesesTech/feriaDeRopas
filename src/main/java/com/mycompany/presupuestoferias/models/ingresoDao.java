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

    /**
     * Registra un ingreso en la base de datos.
     *
     * @param ingreso_pres El objeto de tipo ingreso a registrar.
     * @return true si el registro es exitoso, false si ocurre algún error.
     */
    public boolean registroIngresoQuery(ingreso ingreso_pres) {
        String query = "INSERT INTO ingreso (cod_ingreso, tipo, categoria, product_serv, cantidad, precio, id_feria) VALUES (?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, ingreso_pres.getId());
            pst.setString(2, ingreso_pres.getType());
            pst.setString(3, ingreso_pres.getCategory());
            pst.setString(4, ingreso_pres.getProductoServicio());
            pst.setInt(5, ingreso_pres.getCantidad());
            pst.setDouble(6, ingreso_pres.getPrecio());
            pst.setString(7, ingreso_pres.getIdFeria());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar los datos del ingreso: " + e);
            return false;
        }
    }

    /**
     * Obtiene una lista de ingresos de la base de datos.
     *
     * @param idFeria El ID de la feria para la cual se obtienen los ingresos.
     * @return Una lista de objetos ingreso que representan los registros de
     * ingreso.
     */
    public List<ingreso> listIngresoQuery(String idFeria) {
        List<ingreso> listIngreso = new ArrayList();
        String query = "SELECT cod_ingreso, tipo, categoria, product_serv, cantidad, precio FROM ingreso WHERE id_feria = ?";

        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, idFeria); // Establecer el valor del parámetro
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

    /**
     * Actualiza los datos de un registro de ingreso en la base de datos.
     *
     * @param ingreso_pres El objeto ingreso con los datos actualizados.
     * @return true si la actualización se realiza correctamente, false en caso
     * contrario.
     */
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

    /**
     * Elimina un registro de ingreso de la base de datos.
     *
     * @param id El ID del ingreso a eliminar.
     * @return true si el ingreso se elimina correctamente, false en caso
     * contrario.
     */
    public boolean deleteIngresoQuery(String id) {
        String query = "DELETE FROM ingreso WHERE cod_ingreso = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar un ingreso que tenga relación con otra tabla: " + e);
            return false;
        }
    }

    /**
     * Obtiene el último código de ingreso registrado en la base de datos.
     *
     * @return El último código de ingreso.
     */
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
            JOptionPane.showMessageDialog(null, "Error al obtener el último código de ingreso: " + e);
        }
        return ultimoCodigo;
    }

    /**
     * Genera un nuevo código de ingreso basado en el último código registrado
     * en la base de datos.
     *
     * @return El nuevo código de ingreso generado.
     */
    public String generarCodigo() {
        String ultimoCodigo = obtenerUltimoCodigoIngreso();
        int ultimoNumero = Integer.parseInt(ultimoCodigo.substring(2));
        int nuevoNumero = ultimoNumero + 1;
        String nuevoCodigo = String.format("IN%03d", nuevoNumero);
        return nuevoCodigo;
    }

    /**
     * Obtiene una lista de ingresos que cumplen con ciertas condiciones (ID de
     * feria, tipo de ingreso y categoría de ingreso).
     *
     * @param idFeria El ID de la feria.
     * @param tipoIngreso El tipo de ingreso.
     * @param categoriaIngreso La categoría de ingreso.
     * @return La lista de ingresos que cumplen con las condiciones
     * especificadas.
     */
    public List<ingreso> listStatusIngresoQuery(String idFeria, String tipoIngreso, String categoriaIngreso) {
        List<ingreso> listStatusIngreso = new ArrayList<>();
        String query = "SELECT cod_ingreso, product_serv, cantidad, precio FROM ingreso WHERE id_feria = ? AND tipo = ? AND categoria = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, idFeria);
            pst.setString(2, tipoIngreso);
            pst.setString(3, categoriaIngreso);
            rs = pst.executeQuery();

            while (rs.next()) {
                ingreso ingreso_pres = new ingreso();
                ingreso_pres.setId(rs.getString("cod_ingreso"));
                ingreso_pres.setProductoServicio(rs.getString("product_serv"));
                ingreso_pres.setCantidad(rs.getInt("cantidad"));
                ingreso_pres.setPrecio(rs.getInt("precio"));
                listStatusIngreso.add(ingreso_pres);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el estado del Ingreso");
        }
        return listStatusIngreso;
    }
}
