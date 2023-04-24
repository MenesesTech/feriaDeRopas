package com.mycompany.presupuestoferias.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {

    //Definimos las variables con los datos de conexion
    private String database_name = "feriaropasbd";
    private String user = "root";
    private String password = "root";
    private String url = "jdbc:mysql://us-east.connect.psdb.cloud:3306/" + database_name;

    Connection conn = null;

    //Metodo para conectar java con mySQL
    public Connection getConnection() {
        try {
            //obtener valor del Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Obtener la conexion
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Ha ocurrido un ClassNotFoundException " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un SQLExcpetion " + e.getMessage());
        }
        return conn;
    }
}
