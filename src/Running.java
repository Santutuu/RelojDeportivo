
import java.util.Date;

public class Running extends Actividad {
 
    private float ritmoPromedio;

    public Running(int id, int idUsuario, Date fecha, float kmRecorridos, double caloriasQuemadas, double velocidadPromedio, float ritmoPromedio) {
        super(id, idUsuario, fecha, kmRecorridos, caloriasQuemadas, velocidadPromedio);
        this.ritmoPromedio = ritmoPromedio;
    }

    public float getRitmoPromedio() {
        return ritmoPromedio;
    }

    private void setRitmoPromedio(float ritmoPromedio) {
        this.ritmoPromedio = ritmoPromedio;
    }
    
}
