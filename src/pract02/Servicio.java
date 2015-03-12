/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pract02;

import java.util.List;
import com.mig.app.ApartadoRespuesta;
import com.mig.app.BibliotecaRespuesta;
import com.mig.app.ServicioApartadoService;
import com.mig.app.ServicioApartado;
import com.mig.app.LibroDescripcion;
import com.mig.app.BibliotecaRespuesta;

/**
 *
 * @author miguel
 */
public class Servicio {

    public static String autenticado(String usuario, String password) throws Exception {
        ServicioApartadoService serv = new ServicioApartadoService();
        ServicioApartado port = serv.getServicioApartadoPort();
        com.mig.app.AutenticadoRespuesta resp = port.autenticar(usuario, password);
        if (resp.getMensaje() != null) {
            System.out.println(resp.getMensaje());
            throw new Exception(resp.getMensaje());            
        }
        
       return port.autenticar(usuario, password).getToken();
    }
    
    public static List<LibroDescripcion> getLibros(String usuario,String token) throws Exception {
        
        ServicioApartadoService serv = new ServicioApartadoService();
        ServicioApartado port = serv.getServicioApartadoPort();
        BibliotecaRespuesta resp = port.consultarLibros(usuario, token);
      
        if (resp.getMensaje() != null) {
            System.out.println(resp.getMensaje());
            throw new Exception(resp.getMensaje());            
        }
       return resp.getLibroDescrip();
    }

    
}
