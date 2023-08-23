package com.alura.jdbc.controller;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alura.jdbc.CrearConexion;

public class ProductoController {

    public void modificar(String nombre, String descripcion, Integer id) {
        // TODO
    }

    public void eliminar(Integer id) {
        // TODO
    }

    public List<Map<String, String>> listar() throws SQLException {
        List<Map<String, String>> resultado = new ArrayList<>();

        try (Connection con = new CrearConexion().recuperaConexion()) {
            String consulta = "SELECT ID, NOMBRE, DESCRICION, CANTIDAD FROM PRODUCTO";

            // Creamos este objeto Statement para que nos permita ejecutar consultas SQL
            try (Statement statement = con.createStatement();
                    ResultSet resultSet = statement.executeQuery(consulta)) {

                while (resultSet.next()) {
                    Map<String, String> producto = new HashMap<>();
                    producto.put("ID", String.valueOf(resultSet.getInt("ID")));
                    producto.put("NOMBRE", resultSet.getString("NOMBRE"));
                    producto.put("DESCRIPCION", resultSet.getString("DESCRICION"));
                    producto.put("CANTIDAD", String.valueOf(resultSet.getInt("CANTIDAD")));
                    resultado.add(producto);
                }
            }
        } catch (SQLException e) {
            // Manejar la excepción adecuadamente, ya sea loggeándola o propagándola
            e.printStackTrace();
            throw e;
        }
        return resultado;
    }

    public void guardar(Map<String, String> producto) throws SQLException {
    try (Connection con = new CrearConexion().recuperaConexion();
         PreparedStatement preparedStatement = con.prepareStatement(
                 "INSERT INTO PRODUCTO (NOMBRE, DESCRICION, CANTIDAD) VALUES (?, ?, ?)")) {

        preparedStatement.setString(1, producto.get("NOMBRE"));
        preparedStatement.setString(2, producto.get("DESCRIPCION"));
        preparedStatement.setInt(3, Integer.parseInt(producto.get("CANTIDAD")));

        int filasInsertadas = preparedStatement.executeUpdate();
        if (filasInsertadas > 0) {
            System.out.println("Guardado con éxito");
        } else {
            System.out.println("No se pudo insertar el registro");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    }
}


}
