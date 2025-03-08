/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaut3;

/**
 * Clase de prueba para verificar la conexión a la base de datos.
 * Esta clase contiene el método main que crea una instancia de la clase
 * {@link DbManager} y ejecuta el método {@link DbManager#prueba()} para
 * verificar que la conexión con la base de datos es correcta.
 * 
 * @author fnast
 */
public class Test {

     /**
     * Método principal que ejecuta la prueba de conexión a la base de datos.
     * Crea una instancia de {@link DbManager} y llama al método {@link DbManager#prueba()}
     * para realizar una conexión a la base de datos.
     * 
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        DbManager db = new DbManager();
        db.prueba();
    }
}
