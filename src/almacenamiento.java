import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Almacenamiento {



   public static <T> List<T> leerDatosDesdeArchivo(String rutaArchivo, Class<T> clase) {
        try {
            Gson gson = new Gson();
            File archivo = new File(rutaArchivo);

            if (!archivo.exists()) {
                return new ArrayList<>();
            }

            FileReader reader = new FileReader(archivo);
            JsonElement jsonElement = JsonParser.parseReader(reader);
            reader.close();

            List<T> lista = new ArrayList<>();
            if (jsonElement.isJsonArray()) {
                Type tipoLista = TypeToken.getParameterized(List.class, clase).getType();
                lista = gson.fromJson(jsonElement, tipoLista);
            } else if (jsonElement.isJsonObject()) {
                T objeto = gson.fromJson(jsonElement, clase);
                lista.add(objeto);
            }

            return lista;

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static <T> void guardarDatosEnArchivo(T nuevoObjeto, String rutaArchivo, Class<T> clase) {
        List<T> listaExistente = leerDatosDesdeArchivo(rutaArchivo, clase);
        listaExistente.add(nuevoObjeto);
        guardarListaComoJson(listaExistente, rutaArchivo);
    }

    public static <T> void guardarListaComoJson(List<T> lista, String rutaArchivo) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter writer = new FileWriter(rutaArchivo, false);
            gson.toJson(lista, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}













