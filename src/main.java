

import java.util.Date;
import java.util.List;




public class Main {

    public static void main(String[] args) {

        Usuario u1 = Repositorio.obtenerUsuarioPorId(1);
        if (u1 != null) {
            estadisticasDelUsuario(u1);
        } else {
            System.out.println("Usuario no encontrado.");
        }




        Usuario usuario = new Usuario(5, "Santiago Flotta", "sflotta@gmail.com", 30, 1.79f, 75.0f, "Masculino");
        Actividad actividad1 = new Actividad(16, 5, new Date(), 10.0f, 500.0f, 12.0f);
        Actividad actividad2 = new Actividad(17, 5, new Date(), 15.0f, 700.0f, 14.0f);
        Repositorio.agregarUsuario(usuario);
        Repositorio.agregarActividad(actividad1);
        Repositorio.agregarActividad(actividad2);

        System.out.println("Actividad correcrtamente registrada: ");

        String consejos = new String();
        
        consejos = ConsejoMotivacional.seleccionarConsejoPersonalizado(usuario, actividad2, actividad2.getVelocidadPromedio());
        System.out.println("Consejo: ");
        System.out.println("---------------------------------");
        System.out.println(consejos);


        System.out.println();

        System.out.println("Actividades del usuario " + usuario.getNombreCompleto() + ":");
        List<Actividad> actividadesUsuario = Repositorio.getActividadesPorUsuario(usuario.getId());
        imprimirActividades(actividadesUsuario);
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

        System.out.println("Estadísticas para el usuario: " + usuario.getNombreCompleto());
        System.out.println("");
        System.out.println("Promedio de KM recorridos: " + estadisticas.promedioKmRecorridos());
        System.out.println("Calorías quemadas en el último mes: " + estadisticas.caloriasQuemadasMensualmente(new Date()));
        System.out.println("");
        System.out.println("Top 3 mayores distancias: " + (estadisticas.mayoresDistancias(3)));
        System.out.println("Top 3 mejores marcas: " + estadisticas.mejoresMarcas(3));
        System.out.println("Top 3 mayores distancias: " + estadisticas.mayoresDistancias(3));
        System.out.println();
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
     
    }} 


    
    
    
    
