
import java.util.List;


public class ConsejoMotivacional {

    private List<String> consejosBase;



    public ConsejoMotivacional() {
        this.consejosBase = List.of(
            "¡Sigue adelante, cada paso cuenta!",
            "La perseverancia es la clave del éxito.",
            "No te rindas, los grandes logros requieren tiempo.",
            "Cada día es una nueva oportunidad para mejorar.",
            "Cree en ti mismo y en tus capacidades.",
            "Muy buen tiempo, segui así.",
            "No importa cuán lento vayas, siempre y cuando no te detengas.",
            "Sos un verdaderro tiburon"
            );
            
        
    }

    public List<String> getConsejosBase() {
        return consejosBase;
    }

    public void setConsejosBase(List<String> consejosBase) {
        this.consejosBase = consejosBase;
    }

    String seleccionarConsejoPersonalizado(Usuario usuario, Actividad actividad, float velocidadPromedio) {
        
        if (usuario == null || actividad == null) {
            return "Datos insuficientes para generar un consejo personalizado.";
        }
        return "hola";
    }

}
