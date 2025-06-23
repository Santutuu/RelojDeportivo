import java.util.ArrayList;
import java.util.List;


public class Repositorio {

    static Almacenamiento almacenamiento = new Almacenamiento();

    public static void agregarActividad(Actividad actividad) {

        almacenamiento.guardarDatosEnArchivo(actividad, "repositorioActividades.json", Actividad.class);

    }

    public static void agregarUsuario(Usuario usuario) {

        almacenamiento.guardarDatosEnArchivo(usuario, "repositorioUsuarios.json", Usuario.class);
    }
    
    
    public static List<Actividad> getActividadesPorUsuario(int idUsuario) { // Obtiene una lista de actividades asociadas a un usuario específico

        // Utiliza la clase Almacenamiento para leer las actividades desde el archivo
        
        List<Actividad> actividades = almacenamiento.leerDatosDesdeArchivo("repositorioActividades.json", Actividad.class);
        
        List<Actividad> actividadesUsuario = new ArrayList<>();
        
        for (Actividad actividad : actividades) {
            if (actividad.getIdUsuario() == idUsuario) {
                actividadesUsuario.add(actividad);
            }
        }
        
        return actividadesUsuario;
    }
    
    public static Usuario obtenerUsuarioPorId(int idBuscado) {  
        /*
        Busca un usuario por su ID en el repositorio de usuarios
        */ 
        List<Usuario> usuarios = Almacenamiento.leerDatosDesdeArchivo("RepositorioUsuarios.json", Usuario.class);

        for (Usuario u : usuarios) {
            if (u.getId() == idBuscado) {
                return u;
            }
        }
        return null;
}



}