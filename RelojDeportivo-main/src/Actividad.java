
import java.util.Date;

public class Actividad {

    private int id;
    private int idUsuario;
    private Date fecha; // Fecha de la actividad
    private float kmRecorridos;
    private double caloriasQuemadas;
    private double velocidadPromedio;
  

    


public Actividad(int id, int idUsuario, Date fecha ,float kmRecorridos, double caloriasQuemadas, double velocidadPromedio) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.kmRecorridos = kmRecorridos;
        this.caloriasQuemadas = caloriasQuemadas;
        this.velocidadPromedio = velocidadPromedio;
        
}

public Actividad() {
    
}
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getKmRecorridos() {
        return kmRecorridos;
    }

    public void setKmRecorridos(float kmRecorridos) {
        this.kmRecorridos = kmRecorridos;
    }

    public double getCaloriasQuemadas() {
        return caloriasQuemadas;
    }

    public void setCaloriasQuemadas(double caloriasQuemadas) {
        this.caloriasQuemadas = caloriasQuemadas;
    }

    public double getVelocidadPromedio() {
        return velocidadPromedio;
    }

    public void setVelocidadPromedio(double velocidadPromedio) {
        this.velocidadPromedio = velocidadPromedio;
    }

}