

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;




public class Main {

 

    public static void main(String[] args) {
        // Aquí puedes crear instancias de Usuario y Actividad
            Calendar calendar = Calendar.getInstance();
            calendar.set(2025, Calendar.JUNE, 20, 14, 30, 0);
            java.util.Date utilFecha = calendar.getTime();
            Date fecha = new Date(utilFecha.getTime());

            Actividad a1 = new Actividad(1, 1, fecha ,5.0f, 205.0, 10.0);

            
            Almacenamiento almacenamiento = new Almacenamiento();
    
            almacenamiento.guardarDatosEnArchivo(a1, "actividades.json");
    
            List<Actividad> listaActividades = new ArrayList<>();
            
    
            listaActividades = almacenamiento.leerDatosDesdeArchivo("actividad1.json");
    
            imprimirActividades(listaActividades);
           
        }
    
    
    public static void imprimirActividades(List<Actividad> actividades) {
        /*
         Recibe una lista de actividades y las imprime en consola.
        */
            for (Actividad actividad : actividades) {
                System.out.println("ID: " + actividad.getId());
                System.out.println("ID Usuario: " + actividad.getIdUsuario());
                System.out.println("Fecha: " + actividad.getFecha());
                System.out.println("KM Recorridos: " + actividad.getKmRecorridos());
                System.out.println("Calorías Quemadas: " + actividad.getCaloriasQuemadas());
                System.out.println("Velocidad Promedio: " + actividad.getVelocidadPromedio());
                System.out.println("-----------------------------");
            }
        }
    }   
    
      
        
            


