/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.practicaut3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de crear un nuevo libro en la base de datos.
 * Este servlet recibe los datos del libro desde un formulario, los inserta
 * en la base de datos y redirige al usuario a la lista de libros.
 * 
 * @author fnast
 */
public class Crear extends HttpServlet {

    /**
     * Maneja la solicitud POST para crear un nuevo libro en la base de datos.
     * Recibe los datos del libro desde un formulario y los inserta en la tabla
     * de libros de la base de datos.
     *
     * @param request La solicitud HTTP que contiene los parámetros del formulario.
     * @param response La respuesta HTTP que enviará el resultado al cliente.
     * @throws ServletException Si ocurre un error en la ejecución del servlet.
     * @throws IOException Si ocurre un error en la entrada/salida de la solicitud o respuesta.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titol = request.getParameter("titol");
        String isbn = request.getParameter("isbn");
        int any_publicacio = Integer.parseInt(request.getParameter("any_publicacio"));
        int idEditorial = Integer.parseInt(request.getParameter("editorial"));
        DbManager db = new DbManager();
        Connection c = db.getConnection();
        String sql = "INSERT INTO llibres (titol, isbn, any_publicacio, id_editorial) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement s = c.prepareStatement(sql)) {
            s.setString(1, titol);
            s.setString(2, isbn);
            s.setInt(3, any_publicacio);
            s.setInt(4, idEditorial);
            s.executeUpdate();
            response.sendRedirect("Consulta");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al insertar el libro.");
        }
    }
}
