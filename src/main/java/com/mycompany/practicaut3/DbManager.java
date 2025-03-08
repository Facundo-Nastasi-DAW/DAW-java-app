/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaut3;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Clase DbManager encargada de gestionar las conexiones a la base de datos.
 * Esta clase proporciona métodos para probar la conexión y obtener una
 * conexión activa con la base de datos de libros.
 * 
 * @author fnast
 */
public class DbManager {
    
    // Atributos globales
    private final String url = "jdbc:mariadb://192.168.1.4:3306/llibres";
    private final String user = "tomcat";
    private final String pwd = "1234";
    
    /**
     * Método para probar la conexión a la base de datos.
     * Intenta establecer una conexión con la base de datos y
     * muestra un mensaje indicando si la conexión fue exitosa o no.
     */
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
    
    /**
     * Método que devuelve una conexión activa a la base de datos.
     * Establece una conexión con la base de datos usando los parámetros
     * configurados en la clase y la devuelve para su uso en otras operaciones.
     *
     * @return La conexión activa con la base de datos, o null si ocurre un error.
     */
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
