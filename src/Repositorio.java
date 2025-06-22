import java.util.ArrayList;
import java.util.List;


public class Repositorio {

    static Almacenamiento almacenamiento = new Almacenamiento();

    public static void agregarActividad(Actividad actividad) {

        almacenamiento.guardarDatosEnArchivo(actividad, "repositorioActividades.json", true);

    }

    public static void agregarUsuario(Usuario usuario) {

        almacenamiento.guardarDatosEnArchivo(usuario, "repositorioUsuarios.json", true);
    }
    
    
    public static List<Actividad> getActividadesPorUsuario(int idUsuario) {
        
        List<Actividad> actividades = almacenamiento.leerDatosDesdeArchivo("repositorioActividades.json");
        
        List<Actividad> actividadesUsuario = new ArrayList<>();
        
        for (Actividad actividad : actividades) {
            if (actividad.getIdUsuario() == idUsuario) {
                actividadesUsuario.add(actividad);
            }
        }
        
        return actividadesUsuario;
    }
    
}