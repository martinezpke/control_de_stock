package com.alura.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Statement;



public class PruebaConexion {
    public static void main(String[] args) throws SQLException {
        /* DriverManager nos ayuda a hacer la conecion */
        // Aqui hacemos la conexion.
        Connection conexion = DriverManager.getConnection (
            "jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC", 
            "root", 
            "zHNiLpf7M7PJiz"); 

        // Creamos este objeto Statement para que nos permita ejecutar consultas SQL
        Statement statement = conexion.createStatement(); 

        /* Lo colocamos como BOOLEAN para verificar si el resultado es una lista o  */
        boolean result = statement.execute("SELECT ID, NOMBRE, DESCRICION, CANTIDAD FROM PRODUCTO");

        System.out.println(result);

        conexion.close();
    }
}
