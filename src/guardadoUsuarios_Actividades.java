import java.util.Calendar;
import java.util.Date;

class guardadoUsuarios_Actividades {

    public static void main(String[] args) {
        Usuario u1 = new Usuario(1, "Juan Perez", "santinodad@gmail.com", 20, 5.0f, 5.0f, "Masculino");
        Usuario u2 = new Usuario(2, "Lucía Gómez", "lucia.gomez@gmail.com", 25, 6.8f, 4.2f, "Femenino");
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JUNE, 20, 14, 30, 0);
        java.util.Date utilFecha = calendar.getTime();
        Date fecha = new Date(utilFecha.getTime());

        Actividad a1 = new Actividad(1, 1, fecha ,5.0f, 205.0, 10.0);


        Repositorio.agregarUsuario(u1);
        Repositorio.agregarUsuario(u2);

        Repositorio.agregarActividad(a1);
    }


   
}