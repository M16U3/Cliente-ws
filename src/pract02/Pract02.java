/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pract02;

/**
 *
 * @author miguel
 */
import java.util.List;
import com.mig.app.LibroDescripcion;

public class Pract02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      try {  
          
       String token = Servicio.autenticado("*****", "****");   
       
       List<LibroDescripcion> lista = Servicio.getLibros("*****", token);
       
       for (LibroDescripcion l : lista) {
           System.out.println("ISBN: "+l.getIsbn()+" Titulo: "+l.getTitulo()+" Editorial: "+l.getEditorial()+" Autores: "+l.getAutores()+" Categoria: "+l.getCategoria()+" Edicion: "+l.getEdicion());
       }
       
       
      } catch (Exception e) {
          System.out.println(e.getMessage());
      } 
    }
    
    
    
    
}
