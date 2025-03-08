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
 *
 * @author fnast
 */
public class Eliminar extends HttpServlet {

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
