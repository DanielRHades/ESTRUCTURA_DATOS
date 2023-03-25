package clases;

public class saturno extends planetas {

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void mostrarNombre(){
        System.out.println("El planeta es: "+getNombre());
    }

    public saturno(double gravedad, double masa, double dsol, int nlunas, String nombre) {
        super(gravedad, masa, dsol, nlunas);
        this.nombre=nombre;
    }
}
