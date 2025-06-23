import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;


public class Almacenamiento {



public static List<Actividad> leerDatosDesdeArchivo(String rutaArchivo) {
    try {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
                .create();

        FileReader reader = new FileReader(rutaArchivo);
        JsonElement jsonElement = JsonParser.parseReader(reader);

        List<Actividad> actividades = new ArrayList<>();

        if (jsonElement.isJsonArray()) {
            Type tipoLista = new TypeToken<List<Actividad>>() {}.getType();
            actividades = gson.fromJson(jsonElement, tipoLista);
        } else if (jsonElement.isJsonObject()) {
            Actividad a = gson.fromJson(jsonElement, Actividad.class);
            actividades.add(a);
        }

        return actividades;

    } catch (Exception e) {
        e.printStackTrace();
        return Collections.emptyList();
    }
}



public static List<Usuario> leerUsuariosDesdeArchivo(String rutaArchivo) {
    try {
        Gson gson = new Gson();

        FileReader reader = new FileReader(rutaArchivo);
        JsonElement jsonElement = JsonParser.parseReader(reader);

        List<Usuario> usuarios = new ArrayList<>();

        if (jsonElement.isJsonArray()) {
            Type tipoLista = new TypeToken<List<Usuario>>() {}.getType();
            usuarios = gson.fromJson(jsonElement, tipoLista);
        } else if (jsonElement.isJsonObject()) {
            Usuario u = gson.fromJson(jsonElement, Usuario.class);
            usuarios.add(u);
        }

        return usuarios;

    } catch (Exception e) {
        e.printStackTrace();
        return Collections.emptyList();
    }
}

    
   
    public static <T> void guardarDatosEnArchivo(T objeto, String rutaArchivo, boolean append) {
        try {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
                    .setPrettyPrinting()
                    .create();

            FileWriter writer = new FileWriter(rutaArchivo, append); // abre el archivo, con o sin append
            gson.toJson(objeto, writer); // convierte el objeto a JSON y lo escribe
            writer.close(); // cierra el archivo
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Versión sobrecargada con valor por defecto `append = false`
    public static <T> void guardarDatosEnArchivo(T objeto, String rutaArchivo) {
        guardarDatosEnArchivo(objeto, rutaArchivo, false);
    }
}


