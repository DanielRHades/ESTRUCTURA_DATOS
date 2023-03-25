package clases;

public class planetas {

    //Atributos
    private double gravedad;
    private double masa;
    private double dsol;
    private int nlunas;

    //Metodos
    public double getGravedad() {
        return gravedad;
    }

    public void setGravedad(double gravedad) {
        this.gravedad = gravedad;
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public double getDsol() {
        return dsol;
    }

    public void setDsol(double dsol) {
        this.dsol = dsol;
    }

    public int getNlunas() {
        return nlunas;
    }

    public void setNlunas(int nlunas) {
        this.nlunas = nlunas;
    }

    public void mostrarInfogm() {
        System.out.println("Tiene: "+getGravedad()+" m/s^2 de gravedad, su masa es de: "+getMasa()+" *10^26 kg, su distancia al sol es de: "+getDsol()+" millones de km, y tiene: "+getNlunas()+" lunas.");

    }

    public void mostrarInfodsol() {

    }

    public void mostrarInfonlunas() {

    }

    public planetas(double gravedad, double masa, double dsol, int nlunas) {
        this.gravedad = gravedad;
        this.masa = masa;
        this.dsol = dsol;
        this.nlunas = nlunas;
    }

}
