package com.alura.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CrearConexion {
    public Connection recuperaConexion() throws SQLException{
        String url = "jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC";
        String usuario = "root";
        String contrasenia = "zHNiLpf7M7PJiz";

        return DriverManager.getConnection(url, usuario, contrasenia);
    }
}