package clases;

public class perro extends mamiferos {

    //Atributos
    private String tamaño;
    private String raza;
    private String color;
    private int edad;

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void mostrarInfo() {
        System.out.println("El perro es: " + getTamaño() + " ,es de raza: " + getRaza() + " ,es de color: " + getColor() + " y tiene : " + getEdad() + " anos.");

    }

    public perro(int patas, String pelos, String reproduccion, String pulmones, String tamaño, String raza, String color, int edad) {
        super(patas, pelos, reproduccion, pulmones);
        this.tamaño = tamaño;
        this.raza = raza;
        this.color = color;
        this.edad = edad;
    }

}
