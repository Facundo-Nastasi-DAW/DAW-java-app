/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.practicaut3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fnast
 */
public class Actualizar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idLibro = Integer.parseInt(request.getParameter("id"));
        System.out.println("idLibro: " + idLibro);
        DbManager db = new DbManager();
        Connection c = db.getConnection();
        String sql = "SELECT * FROM llibres WHERE id = ?";
        
        try (PreparedStatement s = c.prepareStatement(sql)) {
            s.setInt(1, idLibro);
            ResultSet res = s.executeQuery();
            
            if (res.next()) {
                String titol = res.getString("titol");
                String isbn = res.getString("isbn");
                int anyPublicacio = res.getInt("any_publicacio");
                int idEditorial = res.getInt("id_editorial");
                System.out.println("Datos libro: " + titol + ", " + isbn + ", " + anyPublicacio + ", " + idEditorial);

                request.setAttribute("titol", titol);
                request.setAttribute("isbn", isbn);
                request.setAttribute("anyPublicacio", anyPublicacio);
                request.setAttribute("idEditorial", idEditorial);

                request.getRequestDispatcher("modificar.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Libro no encontrado.");
            }
        } catch (Exception e) {
            throw new ServletException("Error al obtener los datos del libro.", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titol = request.getParameter("titol");
        String isbn = request.getParameter("isbn");
        String anyPublicacioParam = request.getParameter("any_publicacio");
        String editorialParam = request.getParameter("editorial");

        int anyPublicacio = Integer.parseInt(anyPublicacioParam); // Asumimos que "any_publicacio" será válido
        int editorialId = Integer.parseInt(editorialParam); // Asumimos que "editorial" será válido
        DbManager db = new DbManager();
        Connection c = db.getConnection();
        String updateQuery = "UPDATE llibres SET titol = ?, isbn = ?, any_publicacio = ?, id_editorial = ? WHERE id = ?";
        try (PreparedStatement s = c.prepareStatement(updateQuery)) {
            s.setString(1, titol);
            s.setString(2, isbn);
            s.setInt(3, anyPublicacio);
            s.setInt(4, editorialId);
            s.setInt(5, Integer.parseInt(request.getParameter("id")));

            int rowsAffected = s.executeUpdate();
            if (rowsAffected > 0) {
                response.sendRedirect("Consulta");  // Redirigir a la lista de libros
            } else {
                request.setAttribute("error", "No se pudo actualizar el libro.");
                request.getRequestDispatcher("modificar.jsp").forward(request, response);
            }
        } catch (Exception e) {
            throw new ServletException("Error al actualizar el libro.", e);
        }
    }
}