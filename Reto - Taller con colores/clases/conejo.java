package clases;

public class conejo extends mamiferos {

    //Atributos
    private String color;
    private String raza;
    private String torejas;
    private int edad;

    //Metodos
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTorejas() {
        return torejas;
    }

    public void setTorejas(String torejas) {
        this.torejas = torejas;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void mostrarInfo(){
        System.out.println("El conejo es de color: "+getColor()+" ,es de raza: "+getRaza()+" ,el tamano de sus orejas es: "+getTorejas()+" y tiene : "+getEdad()+" anos.");

        
    }
    

    //Constructor
    public conejo(int patas, String pelos, String reproduccion, String pulmones, String color, String raza, String torejas, int edad) {
        super(patas, pelos, reproduccion, pulmones);
        this.color = color;
        this.raza = raza;
        this.torejas = torejas;
        this.edad = edad;
    }

}
