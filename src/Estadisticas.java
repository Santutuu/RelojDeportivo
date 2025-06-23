import java.util.ArrayList;
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

public double calcularVelocidadPromedio() {
    if (actividades == null || actividades.isEmpty()) {
        return 0;
    }

    double total = 0;
    for (Actividad a : actividades) {
        total += a.getVelocidadPromedio();
    }
    return total / actividades.size();
}

public List<Integer> mejoresMarcas(int topN) {
    List<Actividad> copia = new ArrayList<>(actividades);

    // Ordenar de mayor a menor velocidad promedio
    for (int i = 0; i < copia.size() - 1; i++) {
        for (int j = i + 1; j < copia.size(); j++) {
            if (copia.get(j).getVelocidadPromedio() > copia.get(i).getVelocidadPromedio()) {
                Actividad temp = copia.get(i);
                copia.set(i, copia.get(j));
                copia.set(j, temp);
            }
        }
    }

    // Devolver los primeros N como enteros
    List<Integer> resultado = new ArrayList<>();
    for (int i = 0; i < topN && i < copia.size(); i++) {
        resultado.add((int) copia.get(i).getVelocidadPromedio());
    }

    return resultado;
}

public List<Integer> mayoresDistancias(int topN) {
    List<Actividad> copia = new ArrayList<>(actividades);

    // Ordenar de mayor a menor distancia
    for (int i = 0; i < copia.size() - 1; i++) {
        for (int j = i + 1; j < copia.size(); j++) {
            if (copia.get(j).getKmRecorridos() > copia.get(i).getKmRecorridos()) {
                Actividad temp = copia.get(i);
                copia.set(i, copia.get(j));
                copia.set(j, temp);
            }
        }
    }

    // Devolver los primeros N como enteros
    List<Integer> resultado = new ArrayList<>();
    for (int i = 0; i < topN && i < copia.size(); i++) {
        resultado.add((int) copia.get(i).getKmRecorridos());
    }

    return resultado;
}
}