
public class Usuario {
    
    // Atributos privados
    private int id;
    private String nombreCompleto;
    private String email;
    private int edad;
    private float peso;
    private float altura;
    private String genero;

    // Constructor público
    public Usuario(int id, String nombreCompleto, String email, int edad, float peso, float altura, String genero){
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.genero = genero;
    
    }

    // Métodos públicos (getters y setters)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Método adicional
    //public void registrarActividad(int actividad);
}
