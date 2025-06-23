
import java.util.List;


public class ConsejoMotivacional {

   
    public static String seleccionarConsejoPersonalizado(Usuario usuario, Actividad ultimaActividad, double velocidadPromedio) {

    if (usuario == null || ultimaActividad == null) {
        return "Datos insuficientes para generar un consejo personalizado.";
    }

    List<Actividad> actividades = usuario.obtenerActividades();
    if (actividades == null || actividades.isEmpty()) {
        return "Aún no hay suficientes actividades para comparar.";
    }

    Estadisticas estadisticas = new Estadisticas(actividades);
    float promedioKm = estadisticas.promedioKmRecorridos();

    // Calcular promedios de calorías y velocidad manualmente
    double sumaCalorias = 0;
    double sumaVelocidad = 0;

    for (Actividad act : actividades) {
        sumaCalorias += act.getCaloriasQuemadas();
        sumaVelocidad += act.getVelocidadPromedio();
    }

    double promedioCalorias = sumaCalorias / actividades.size();
    double promedioVelocidad = sumaVelocidad / actividades.size();

    StringBuilder consejo = new StringBuilder();

    if (ultimaActividad.getKmRecorridos() > promedioKm) {
        consejo.append("¡Recorriste más que tu promedio! Seguís avanzando\n");
    } else {
        consejo.append("Recorriste menos que otras veces. Cada paso cuenta\n");
    }

    if (ultimaActividad.getCaloriasQuemadas() > promedioCalorias) {
        consejo.append("¡Estás quemando más calorías que nunca!\n");
    } else {
        consejo.append("Hoy quemaste menos calorías. Lo importante es no parar\n");
    }

    if (ultimaActividad.getVelocidadPromedio() > promedioVelocidad) {
        consejo.append("¡Impresionante! Superaste tu velocidad promedio\n");
    } else {
        consejo.append("Tu velocidad fue más baja que lo habitual. No te rindas, mañana será mejor\n");
    }

    return consejo.toString().trim();
}

}
