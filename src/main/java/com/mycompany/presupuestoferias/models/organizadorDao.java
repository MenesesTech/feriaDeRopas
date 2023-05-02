
package com.mycompany.presupuestoferias.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class organizadorDao {
    ConnectionMySQL cn = new ConnectionMySQL();
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    //Registrar Organizador
    public boolean registrOrganizador(organizador organizer){
        String query = "INSERT INTO organizadorferia (full_name, email, telephone, idFeria)";
        try {
            conn = cn.getConnection();
            pst = conn.prepareStatement(query);
            pst.setString(1, organizer.getFull_name());
            pst.setString(2, organizer.getEmail());
            pst.setString(3, organizer.getTelephone());
            pst.setInt(4, organizer.getIdFeria());
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar los datos del organizador: " + e);
            return false;
        }
    }
}
