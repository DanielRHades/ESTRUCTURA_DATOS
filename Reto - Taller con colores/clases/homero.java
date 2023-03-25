package clases;

public class homero extends mamiferos {

    //Atributos
    private String cuantobebe;
    private int edad;
    private String estadocivil;
    private int hijos;

    //Metodos
    public String getCuantobebe() {
        return cuantobebe;
    }

    public void setCuantobebe(String cuantobebe) {
        this.cuantobebe = cuantobebe;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public int getHijos() {
        return hijos;
    }

    public void setHijos(int hijos) {
        this.hijos = hijos;
    }

    public void mostrarInfo() {
        System.out.println("Homero bebe: " + getCuantobebe() + " ,tiene: " + getEdad() + " anos ,esta: " + getEstadocivil() + " y tiene : " + getHijos() + " hijos.");

    }

    public homero(int patas, String pelos, String reproduccion, String pulmones, String cuantobebe, int edad, String estadocivil, int hijos) {
        super(patas, pelos, reproduccion, pulmones);
        this.cuantobebe = cuantobebe;
        this.edad = edad;
        this.estadocivil = estadocivil;
        this.hijos = hijos;
    }

}
