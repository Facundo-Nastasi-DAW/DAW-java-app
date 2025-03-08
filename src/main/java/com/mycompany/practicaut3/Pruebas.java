/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.practicaut3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet de pruebas para comprobar la funcionalidad de la aplicación.
 * Simplemente muestra un mensaje confirmando que los cambios se han
 * actualizado correctamente.
 * 
 * @author fnast
 */
public class Pruebas extends HttpServlet {

    /**
     * Procesa las solicitudes HTTP GET y POST y genera una respuesta
     * con un mensaje HTML simple.
     * 
     * @param request La solicitud HTTP recibida.
     * @param response La respuesta HTTP que se enviará al cliente.
     * @throws ServletException Si ocurre un error específico del servlet.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Pruebas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Los cambios se actualizan correctamente</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
