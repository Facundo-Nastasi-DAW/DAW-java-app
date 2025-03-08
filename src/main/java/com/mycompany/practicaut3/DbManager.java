/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaut3;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author fnast
 */
public class DbManager {
    
    // Atributos globales
    private final String url = "jdbc:mariadb://192.168.1.4:3306/llibres";
    private final String user = "tomcat";
    private final String pwd = "1234";
    
    // Método para probar la conexión a la db
    public void prueba(){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            Connection c = DriverManager.getConnection(url, user, pwd);
            System.out.println("Conexión realizada correctamente.");
            c.close();
        } catch(Exception e){
            System.err.println("Error en la conexión con la base de datos: " + e.getMessage());
        }
    }
    
    // Método que devuelve una conexión a la db
    public Connection getConnection(){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            Connection c = DriverManager.getConnection(url, user, pwd);
            System.out.println(c + "En DB");
            return c;
        } catch(Exception e){
            System.err.println("Error en la conexión con la base de datos: " + e.getMessage());
            return null;
        }
    }
}
