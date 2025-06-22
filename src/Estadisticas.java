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