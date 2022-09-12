/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.PeliculaAmpliado;
import excepciones.LecturaDatosEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
 
public class AccesoDatosAdiclmpl extends AccesoDatosimpl {
    
    
    
       public List<PeliculaAmpliado> peliFecha = new ArrayList<PeliculaAmpliado>();
    
    public void cargarInformacion(String nombreArchivo) throws LecturaDatosEx, IOException {
       peliFecha = new ArrayList<PeliculaAmpliado>(); 
        try {
            BufferedReader entrada = null;
            File archivo = new File(nombreArchivo);
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while(linea!=null){
                
                String nombrePe;
                String Year;
                String[] arreglo = linea.split(";");
                Year = arreglo[1];
                nombrePe = arreglo[0];
                PeliculaAmpliado pelicula = new PeliculaAmpliado(nombrePe, Year);
                peliFecha.add(pelicula);
                linea = entrada.readLine();
                System.out.println("pelicula = "+pelicula.getNombre() +" Año = "+ pelicula.getFproduccion());
            }
            entrada.close();
            
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }catch ( IOException ex){
            ex.printStackTrace(System.out);
        }
        
    }
    
}
    


