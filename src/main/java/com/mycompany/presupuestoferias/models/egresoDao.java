package com.mycompany.presupuestoferias.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class egresoDao {

    ConnectionMySQL cn = new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    /**
     * Registra un egreso en la base de datos.
     *
     * @param egreso_pres El objeto de tipo "egreso" que contiene los datos del
     * egreso a registrar.
     * @return true si el egreso se registra correctamente, false en caso
     * contrario.
     */
    public boolean registroEgresoQuery(egreso egreso_pres) {
        String query = "INSERT INTO egreso (cod_egreso, tipo, categoria, product_serv, cantidad, precio, id_feria) VALUES (?,?,?,?,?,?,?)";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, egreso_pres.getId());
            pst.setString(2, egreso_pres.getType());
            pst.setString(3, egreso_pres.getCategory());
            pst.setString(4, egreso_pres.getProductoServicio());
            pst.setInt(5, egreso_pres.getCantidad());
            pst.setDouble(6, egreso_pres.getPrecio());
            pst.setString(7, egreso_pres.getIdFeria());
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar los datos del egreso: " + e);
            return false;
        }
    }

    /**
     * Obtiene una lista de egresos relacionados a las ferias desde la base de
     * datos.
     *
     * @param idFeria El ID de la feria para la cual se obtienen los egresos.
     * @return La lista de egresos relacionados a las ferias.
     */
    public List<egreso> listEgresoQuery(String idFeria) {
        List<egreso> listEgreso = new ArrayList<>();
        String query = "SELECT cod_egreso, tipo, categoria, product_serv, cantidad, precio FROM egreso WHERE id_feria = ?";

        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, idFeria); // Establecer el valor del parámetro
            rs = pst.executeQuery();

            // Obtener el total de egresos una vez antes del bucle
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

    /**
     * Actualiza un registro de egreso en la base de datos.
     *
     * @param egreso_pres El objeto egreso con los datos a actualizar.
     * @return true si la actualización se realiza correctamente, false en caso
     * contrario.
     */
    public boolean updateEgresoQuery(egreso egreso_pres) {
        String query = "UPDATE egreso SET tipo = ?, categoria = ?, product_serv = ?, cantidad = ?, precio = ? "
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
            JOptionPane.showMessageDialog(null, "Error al modificar los datos del egreso: " + e);
            return false;
        }
    }

    /**
     * Elimina un registro de egreso de la base de datos.
     *
     * @param id El ID del egreso a eliminar.
     * @return true si el egreso se elimina correctamente, false en caso
     * contrario.
     */
    public boolean deleteEgresoQuery(String id) {
        String query = "DELETE FROM egreso WHERE cod_egreso = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            pst.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar un egreso que tenga relación con otra tabla: " + e);
            System.out.println(e);
            return false;
        }
    }

    /**
     * Obtiene el último código de egreso registrado en la base de datos.
     *
     * @return El último código de egreso.
     */
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
            JOptionPane.showMessageDialog(null, "Error al obtener el último código de egreso: " + e);
        }
        return ultimoCodigo;
    }

    /**
     * Genera un nuevo código de egreso incrementando el último número de código
     * registrado.
     *
     * @return El nuevo código de egreso generado.
     */
    public String generarCodigo() {
        String ultimoCodigo = obtenerUltimoCodigoEgreso();
        int ultimoNumero = Integer.parseInt(ultimoCodigo.substring(2));
        int nuevoNumero = ultimoNumero + 1;
        String nuevoCodigo = String.format("EG%03d", nuevoNumero);
        return nuevoCodigo;
    }

    /**
     * Obtiene la cantidad total de egresos relacionados con el personal de
     * seguridad en una feria específica.
     *
     * @param id El ID de la feria.
     * @return La cantidad total de personal de seguridad registrado como egreso
     * en la feria.
     */
    public int cantSeguridad(String id) {
        int totalCantidad = 0;
        String query = "SELECT cantidad FROM egreso WHERE product_serv = 'Personal de seguridad' AND id_feria = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                int cant = rs.getInt("cantidad");
                totalCantidad += cant;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la cantidad de seguridad: " + e);
        }
        return totalCantidad;
    }
//

    /**
     * Obtiene una lista de egresos que cumplen con ciertas condiciones (id de
     * feria, tipo de egreso y categoría de egreso).
     *
     * @param idFeria El ID de la feria.
     * @param tipoEgreso El tipo de egreso.
     * @param categoriaEgreso La categoría de egreso.
     * @return La lista de egresos que cumplen con las condiciones
     * especificadas.
     */
    public List<egreso> listStatusEgresoQuery(String idFeria, String tipoEgreso, String categoriaEgreso) {
        List<egreso> listStatusEgreso = new ArrayList<>();
        String query = "SELECT cod_egreso, product_serv, cantidad, precio FROM egreso WHERE id_feria = ? AND tipo = ? AND categoria = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, idFeria);
            pst.setString(2, tipoEgreso);
            pst.setString(3, categoriaEgreso);
            rs = pst.executeQuery();

            while (rs.next()) {
                egreso egreso_pres = new egreso();
                egreso_pres.setId(rs.getString("cod_egreso"));
                String idEgreso = egreso_pres.getId();
                egreso_pres.setProductoServicio(rs.getString("product_serv"));
                egreso_pres.setCantidad(rs.getInt("cantidad"));
                egreso_pres.setPrecio(rs.getInt("precio"));
                listStatusEgreso.add(egreso_pres);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el estado del Egreso: " + e);
        }
        return listStatusEgreso;
    }

    public double totalEgreso(String idFeria) {
        String query = "SELECT SUM(cantidad * precio) AS total_egresos FROM egreso WHERE id_feria = ?";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, idFeria);
            rs = pst.executeQuery();
            if (rs.next()) {
                double totalEgreso = rs.getDouble("total_egresos");
                return totalEgreso;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el total de egresos: " + e.getMessage());
        }
        return 0;
    }

}
