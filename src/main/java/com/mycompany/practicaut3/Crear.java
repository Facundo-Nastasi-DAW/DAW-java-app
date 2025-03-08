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
public class Crear extends HttpServlet {

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
