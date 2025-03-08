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
 * Servlet encargado de eliminar un libro de la base de datos.
 * Este servlet recibe el ID de un libro, lo elimina de la base de datos
 * y redirige al usuario a la lista de libros.
 * 
 * @author fnast
 */
public class Eliminar extends HttpServlet {

    /**
    * Maneja la solicitud GET para eliminar un libro de la base de datos.
    * Obtiene el ID del libro desde la solicitud, ejecuta la consulta SQL
    * para eliminar el libro y redirige al usuario a la lista de libros.
    *
    * @param request La solicitud HTTP que contiene el ID del libro a eliminar.
    * @param response La respuesta HTTP que enviará el resultado al cliente.
    * @throws ServletException Si ocurre un error en la ejecución del servlet.
    * @throws IOException Si ocurre un error en la entrada/salida de la solicitud o respuesta.
    */
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idLibro = Integer.parseInt(request.getParameter("id"));
        DbManager db = new DbManager();
        Connection c = db.getConnection();
        String sql = "DELETE FROM llibres WHERE id = ?";
        try (PreparedStatement s = c.prepareStatement(sql)) {
            s.setInt(1, idLibro);
            s.executeUpdate();
            response.sendRedirect("Consulta");
        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al borrar el libro: " + e.getMessage());
        }
    }
}
