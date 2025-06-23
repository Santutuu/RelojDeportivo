import java.util.Calendar;
import java.util.Date;
import java.util.List;

class Prueba_Estadisticas {

    public static void main(String[] args) {

        // Cargo una lista de usuarios

        Usuario u1 = new Usuario(1, "Juan Perez", "juan.perez@gmail.com", 20, 70.0f, 1.75f, "Masculino");
        Usuario u2 = new Usuario(2, "Lucía Gómez", "lucia.gomez@gmail.com", 25, 60.0f, 1.68f, "Femenino");
        Usuario u3 = new Usuario(3, "Carlos Díaz", "carlos.diaz@gmail.com", 30, 80.0f, 1.80f, "Masculino");
        Usuario u4 = new Usuario(4, "Ana Torres", "ana.torres@gmail.com", 28, 55.0f, 1.60f, "Femenino");


        // Genero los objetos tipo Date para las actividades
        // Genero las actividades de los usuarios

        Calendar cal = Calendar.getInstance();

        cal.set(2025, Calendar.JUNE, 20, 8, 0);     // 1
        Actividad a1 = new Actividad(1, 1, new Date(cal.getTimeInMillis()), 3.5f, 150.0, 30.0);

        cal.set(2025, Calendar.JUNE, 20, 18, 0);    // 2
        Actividad a2 = new Actividad(2, 2, new Date(cal.getTimeInMillis()), 4.0f, 200.0, 45.0);

        cal.set(2025, Calendar.JUNE, 21, 7, 30);    // 3
        Actividad a3 = new Actividad(3, 1, new Date(cal.getTimeInMillis()), 5.0f, 250.0, 60.0);

        cal.set(2025, Calendar.JUNE, 21, 19, 0);    // 4
        Actividad a4 = new Actividad(4, 3, new Date(cal.getTimeInMillis()), 4.2f, 180.0, 50.0);

        cal.set(2025, Calendar.JUNE, 22, 9, 0);     // 5
        Actividad a5 = new Actividad(5, 4, new Date(cal.getTimeInMillis()), 3.0f, 120.0, 25.0);

        cal.set(2025, Calendar.JUNE, 22, 19, 30);   // 6
        Actividad a6 = new Actividad(6, 1, new Date(cal.getTimeInMillis()), 6.0f, 300.0, 70.0);

        cal.set(2025, Calendar.JUNE, 23, 6, 45);    // 7
        Actividad a7 = new Actividad(7, 2, new Date(cal.getTimeInMillis()), 5.5f, 270.0, 65.0);

        cal.set(2025, Calendar.JUNE, 23, 20, 15);   // 8
        Actividad a8 = new Actividad(8, 3, new Date(cal.getTimeInMillis()), 4.5f, 190.0, 48.0);

        cal.set(2025, Calendar.JUNE, 24, 7, 0);     // 9
        Actividad a9 = new Actividad(9, 4, new Date(cal.getTimeInMillis()), 2.8f, 100.0, 20.0);

        cal.set(2025, Calendar.JUNE, 24, 18, 30);   // 10
        Actividad a10 = new Actividad(10, 1, new Date(cal.getTimeInMillis()), 4.8f, 220.0, 55.0);

        cal.set(2025, Calendar.JUNE, 25, 8, 15);    // 11
        Actividad a11 = new Actividad(11, 2, new Date(cal.getTimeInMillis()), 3.6f, 160.0, 35.0);

        cal.set(2025, Calendar.JUNE, 25, 19, 0);    // 12
        Actividad a12 = new Actividad(12, 3, new Date(cal.getTimeInMillis()), 5.2f, 280.0, 75.0);

        cal.set(2025, Calendar.JUNE, 26, 9, 0);     // 13
        Actividad a13 = new Actividad(13, 4, new Date(cal.getTimeInMillis()), 3.3f, 130.0, 27.0);

        cal.set(2025, Calendar.JUNE, 26, 20, 30);   // 14
        Actividad a14 = new Actividad(14, 1, new Date(cal.getTimeInMillis()), 6.2f, 320.0, 80.0);

        cal.set(2025, Calendar.JUNE, 27, 7, 45);    // 15
        Actividad a15 = new Actividad(15, 2, new Date(cal.getTimeInMillis()), 4.4f, 210.0, 50.0);

         /* 
        Repositorio.agregarUsuario(u1);
        Repositorio.agregarUsuario(u2);
        Repositorio.agregarUsuario(u3);
        Repositorio.agregarUsuario(u4);

        Repositorio.agregarActividad(a1);
        Repositorio.agregarActividad(a2);
        Repositorio.agregarActividad(a3); 
        Repositorio.agregarActividad(a4);
        Repositorio.agregarActividad(a5);
        Repositorio.agregarActividad(a6);
        Repositorio.agregarActividad(a7);
        Repositorio.agregarActividad(a8);   
        Repositorio.agregarActividad(a9);
        Repositorio.agregarActividad(a10);
        Repositorio.agregarActividad(a11);
        Repositorio.agregarActividad(a12);
        Repositorio.agregarActividad(a13);
        Repositorio.agregarActividad(a14);
        Repositorio.agregarActividad(a15);
         */

        
        // Obtengo las actividades del usuario 2
        List<Actividad> actividadesDelUsuario = u2.obtenerActividades();
    
        // Calculo las estadisticas sobre la lista de actividades del usuario 2
        Estadisticas estadisticas = new Estadisticas(actividadesDelUsuario);
 
        
        // Imprimo el promedio de km recorridos por el usuario 2
        float promedioKm = estadisticas.promedioKmRecorridos();
        System.out.println("Promedio de km recorridos: " + promedioKm);

        // Calculo las calorías quemadas en el último mes hasta la fecha actual
        Date fechaFin = new Date(); // Fecha actual
        double caloriasQuemadas = estadisticas.caloriasQuemadasMensualmente(fechaFin);

        System.out.println("Calorías quemadas en el último mes: " + caloriasQuemadas);



           String consejo;

            consejo = ConsejoMotivacional.seleccionarConsejoPersonalizado( u2, a11, a11.getVelocidadPromedio());

            System.out.println(consejo);


    }

    
 

    

   
}