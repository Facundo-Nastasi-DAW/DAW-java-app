/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.practicaut3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fnast
 */
public class Consulta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection c = null;
        PreparedStatement s = null;
        ResultSet res = null;

        try {
            // Gestionamos la conexión mediante DbManager
            DbManager db = new DbManager();
            c = db.getConnection();
            System.out.println(c + "En Consulta");
            String query = "SELECT llibres.id, llibres.titol, llibres.isbn, llibres.any_publicacio, editorials.nom AS editorial, autors.nom AS autor " +
                         "FROM llibres " +
                         "LEFT JOIN editorials ON llibres.id_editorial = editorials.id " +
                         "LEFT JOIN llibre_autor ON llibres.id = llibre_autor.id_llibre " +
                         "LEFT JOIN autors ON llibre_autor.id_autor = autors.id";

            s = c.prepareStatement(query);
            res = s.executeQuery();

            List<Map<String, String>> llibres = new ArrayList<>();

            // Recorremos el resultado
            while (res.next()) {
                Map<String, String> llibre = new HashMap<>();
                llibre.put("id", String.valueOf(res.getInt("id")));
                llibre.put("titol", res.getString("titol"));
                llibre.put("autor", res.getString("autor") != null ? res.getString("autor") : "Desconegut");
                llibre.put("isbn", res.getString("isbn"));
                llibre.put("anyPublicacio", String.valueOf(res.getInt("any_publicacio")));
                llibre.put("editorial", res.getString("editorial") != null ? res.getString("editorial") : "Sense editorial");

                    llibres.add(llibre);
            }
            // Establecer la información visible para el jsp
            request.setAttribute("llibres", llibres);
            request.getRequestDispatcher("llibreria.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error en la consulta: " + e.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (res != null) res.close();
                if (s != null) s.close();
                if (c != null) c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
