import com.google.gson.*;
import com.google.gson.reflect.TypeToken; // Type Token para manejar listas como List<Actividad>

import java.io.FileReader;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat; // sirve para formatear fechas
import java.util.*; // importa todos los paquetes de util como scanner




public class Main {
    public static void main(String[] args) {
        try {
            // Configuración del formato de fecha
            Gson gson = new GsonBuilder() // crea una instancia de Gson personalizada
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
                    .create();

            // Tipo genérico para listas
            Type tipoLista = new TypeToken<List<Actividad>>() {}.getType();

            // Leer archivo JSON con permisos de lectura
            FileReader reader = new FileReader("actividad.json");
            List<Actividad> actividades = gson.fromJson(reader, tipoLista);
			// usa Gson para convertir el contenido JSON  una list<Actividad>

            // Mostrar resultados
            for (Actividad a : actividades) {
                System.out.println(a);
            }

        } catch (Exception e) { // Si ocurre cualuqier error, lo muestra en consola
            e.printStackTrace();
        }
    }
}



/*
Lee un archivo JSON que contiene una lista de actividades.

Convierte ese JSON en objetos Java (Actividad).

Imprime los datos de cada actividad.
*/

    
