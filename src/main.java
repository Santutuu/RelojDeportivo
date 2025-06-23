

import java.util.Date;
import java.util.List;




public class Main {

    public static void main(String[] args) {
        System.out.println("");
        Usuario u1 = Repositorio.obtenerUsuarioPorId(1);
        if (u1 != null) {
            estadisticasDelUsuario(u1);
        } else {
            System.out.println("Usuario no encontrado.");
        }

        // Creamos actividades, esto simula lo obtenido por el sensor del reloj
        Actividad actividad1 = new Actividad(18, 1, new Date(), 3.2f, 300.0f, 12.0f);
        Actividad actividad2 = new Actividad(20, 1, new Date(), 5.0f, 500.0f, 15.0f);
        
        // Añadimos la actividad al repositorio
        agregarActividad(u1, actividad2);
        System.out.println(""); 

        
       
        // Mostramos todas las actividades de ese usuario
        System.out.println("Tus actividades: " + u1.getNombreCompleto() + ":\n");
        List<Actividad> actividadesUsuario = Repositorio.getActividadesPorUsuario(u1.getId());

        imprimirActividades(actividadesUsuario);
    }





     public static void agregarActividad(Usuario usuario, Actividad nuevaActividad) {
            Repositorio.agregarActividad(nuevaActividad);

            // Mostramos consejos motivacionales personalizados basados en las actividades del usuario
            String consejos = new String();

            consejos = ConsejoMotivacional.seleccionarConsejoPersonalizado(usuario, nuevaActividad, nuevaActividad.getVelocidadPromedio());
            System.out.println("Consejo: ");
            System.out.println("---------------------------------");
            System.out.println(consejos);
        
        }




    public static void estadisticasDelUsuario(Usuario usuario) {
        /*
         Recibe un usuario y muestra estadísticas basadas en sus actividades.
         */

        if (usuario == null) {
            System.out.println("Usuario no puede ser nulo.");
            return;
        }

        List<Actividad> listaActividades = Repositorio.getActividadesPorUsuario(usuario.getId());

        if (listaActividades == null || listaActividades.isEmpty()) {
            System.out.println("No hay actividades registradas para el usuario.");
            return;
        }

        Estadisticas estadisticas = new Estadisticas(listaActividades);

        List<Integer> mayoresDistancias = estadisticas.mayoresDistancias(3);
        List<Integer> mejoresMarcas = estadisticas.mejoresMarcas(3);
        

        System.out.println("Estadísticas para el usuario: " + usuario.getNombreCompleto());
        System.out.println("");
        System.out.println("Promedio de KM recorridos: " + estadisticas.promedioKmRecorridos() + " km por actividad");
        System.out.println("Calorías quemadas en el último mes: " + estadisticas.caloriasQuemadasMensualmente(new Date()) + " Kcal");
        System.out.println("");
        System.out.println("Top 3 mayores distancias: ");
        for (int i = 0; i < mayoresDistancias.size(); i++) {
            System.out.println((i + 1) + " ----> " + mayoresDistancias.get(i) + " km recorridos!");
            }

        System.out.println("\n Top 3 mejores marcas: ");
        for (int i = 0; i < mejoresMarcas.size(); i++) {
            System.out.println((i + 1) + " ----> " + mejoresMarcas.get(i) + " km recorridos!");
        }
        System.out.println("\nVelocidad promedio general: " + estadisticas.calcularVelocidadPromedio() + " Km/h");
        System.out.println();
    }


    
    public static void imprimirActividades(List<Actividad> actividades) {
        /* 
         Recibe una lista de actividades y las imprime en consola.
        */
            for (Actividad actividad : actividades) {
                System.out.println("ID: " + actividad.getId());
                System.out.println("Fecha: " + actividad.getFecha());
                System.out.println("KM Recorridos: " + actividad.getKmRecorridos());
                System.out.println("Calorías Quemadas: " + actividad.getCaloriasQuemadas());
                System.out.println("Velocidad Promedio: " + actividad.getVelocidadPromedio());
                System.out.println("-----------------------------");
            }
     
    }} 


    
    
    
    
