package clases;

public class mamiferos {

    //Atributos
    private int patas;
    private String pelos;
    private String reproduccion;
    private String pulmones;
    //Metodos

    public int getPatas() {
        return patas;
    }

    public void setPatas(int patas) {
        this.patas = patas;
    }

    public String getPelo() {
        return pelos;
    }

    public void setPelo(String pelo) {
        this.pelos = pelo;
    }

    public String getReproduccion() {
        return reproduccion;
    }

    public void setReproduccion(String reproduccion) {
        this.reproduccion = reproduccion;
    }

    public String getPulmones() {
        return pulmones;
    }

    public void setPulmones(String pulmones) {
        this.pulmones = pulmones;
    }

    public void patasPelos() {
        System.out.println("Tiene: " + getPatas() + " patas y : " + getPelo() + " tiene pelos.");
    }

    public void tipoReproduccion() {
        System.out.println("El mamifero se produce de manera: "+getReproduccion());
    }

    public void tienePulmones() {
        System.out.println("El mamifero: "+getPulmones()+" tiene pulmones.");
    }

    //Constructor
    public mamiferos(int patas, String pelos, String reproduccion, String pulmones) {
        this.patas = patas;
        this.pelos = pelos;
        this.reproduccion = reproduccion;
        this.pulmones = pulmones;
    }

}
