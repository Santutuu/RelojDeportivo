import java.util.ArrayList;
import java.util.List;


public class Repositorio {

    static Almacenamiento almacenamiento = new Almacenamiento();

    public static void agregarActividad(Actividad nuevaActividad) {

        List<Actividad> registros = almacenamiento.leerDatosDesdeArchivo("repositorioActividades.json", Actividad.class);
        

        for (Actividad actividadRegistrada : registros) {
            if (actividadRegistrada.getId() == nuevaActividad.getId()) {
                System.out.println("Ya existe una actividad con el ID: " + nuevaActividad.getId());
                return; 
            }

            
        }

        almacenamiento.guardarDatosEnArchivo(nuevaActividad, "repositorioActividades.json", Actividad.class);
        System.out.println("Actividad correcrtamente registrada! \n");
    }

    public static void agregarUsuario(Usuario nuevoUsuario) {

        List<Usuario> registros = almacenamiento.leerDatosDesdeArchivo("repositorioUsuarios.json", Usuario.class);

        for (Usuario usuario : registros) {

            if (usuario.getId() == nuevoUsuario.getId()) {
                System.out.println("Ya existe un usuario con el ID: " + nuevoUsuario.getId());
                return;
            }

        }

        almacenamiento.guardarDatosEnArchivo(nuevoUsuario, "repositorioUsuarios.json", Usuario.class);

        System.out.println("Usuario correcrtamente registrado! \n");
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