import java.util.Date;

public class Natacion extends Actividad {

    private int cantidadLargos;

    public Natacion(int id, int idUsuario, Date fecha, float kmRecorridos, double caloriasQuemadas, double velocidadPromedio, int cantidadLargos) {
        super(id, idUsuario, fecha, kmRecorridos, caloriasQuemadas, velocidadPromedio);
        this.cantidadLargos = cantidadLargos;
    }

    public int getCantidadLargos() {
        return cantidadLargos;
    }

    public int setCantidadLargos(int cantidadLargos) {
        this.cantidadLargos = cantidadLargos;
    
    return cantidadLargos;
    }
    
}
