import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Estadisticas {

    /*
     A Estadisticas no le importa que Actividades recibe, calcula las estadisticas sobre una lista de actividades.
     */

    private List<Actividad> actividades;


    public Estadisticas(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public float promedioKmRecorridos() {

        if (actividades == null || actividades.isEmpty()) {
            System.out.println("No hay actividades registradas."); 
            return 0;
        } else {

        float total = 0;
        for (Actividad a : actividades) {
            total += a.getKmRecorridos(); 
        } 
        return (total / actividades.size());
    }
}


public double caloriasQuemadasMensualmente(Date fechaFin) {
    /*
     Calcula las calorías quemadas en el último mes hasta la fecha proporcionada.
     Si no hay actividades, devuelve 0.
     */
    if (actividades == null || actividades.isEmpty()) {
        return 0;
    }

    Calendar cal = Calendar.getInstance();
    cal.setTime(fechaFin);
    cal.add(Calendar.MONTH, -1);
    Date fechaInicio = cal.getTime();

    double totalCalorias = 0;

    for (Actividad a : actividades) {
        Date fechaActividad = a.getFecha();
        if (!fechaActividad.before(fechaInicio) && !fechaActividad.after(fechaFin)) {
            totalCalorias += a.getCaloriasQuemadas();
        }
    }

    return totalCalorias;
}


}

/*
public float calcularVelocidad promedio {
    return null;
    }

    public float caloriasQuemadasMensualmente() {
        return null;
    }

    mejoresMarcas() {
        return null;    
    }

    mayoresDistancias(){
        return null;
    }
    
}
} 
*/