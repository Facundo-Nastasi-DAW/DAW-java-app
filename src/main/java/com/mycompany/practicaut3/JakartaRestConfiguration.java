package com.mycompany.practicaut3;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Clase de configuración para los servicios RESTful de Jakarta.
 * Esta clase configura el punto de entrada para las rutas REST de la aplicación,
 * definiendo la ruta base para los recursos de la API.
 * 
 * Se utiliza la anotación {@link ApplicationPath} para especificar el prefijo
 * para todas las rutas de los recursos REST, en este caso, "resources".
 * 
 * @author Juneau
 */
@ApplicationPath("resources")
public class JakartaRestConfiguration extends Application {
    
}
