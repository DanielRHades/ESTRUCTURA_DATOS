
package clases;


public class Clases {

    public static void main(String[] args) {
        
        conejo c1 = new conejo(4,"Si","Sexual","Si","Rojo","Rex","Grandes",5);
        c1.mostrarInfo();
        c1.patasPelos();
        c1.tienePulmones();
        c1.tipoReproduccion();
        System.out.println(" ");
        homero h1 = new homero(2,"Si","Sexual","Si","Mucho",66,"Casado",3);
        h1.mostrarInfo();
        h1.patasPelos();
        h1.tienePulmones();
        h1.tipoReproduccion();
        System.out.println(" ");
        perro p1 = new perro(4,"Si","Sexual","Si","Grande","Lobo siberiano","Blanco con negro",8);
        p1.mostrarInfo();
        p1.patasPelos();
        p1.tienePulmones();
        p1.tipoReproduccion();
        System.out.println(" ");
        saturno s1 = new saturno(10.44,5.683,1418,53,"Saturno");
        s1.mostrarNombre();
        s1.mostrarInfodsol();
        s1.mostrarInfogm();
        s1.mostrarInfonlunas();

    }
    
}
