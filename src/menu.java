import java.io.*;

public class menu {
    public void imprimirMenu() {
        System.out.println("-------------------------------");
        System.out.println("Elija una opción:");
        System.out.println("1. Añadir producto\n2. Eliminar producto\n3. Listar productos\n4. Salir");
        System.out.println("-------------------------------");
    }
    public void seleccion(int opcion, int nums) throws Exception {
        seleccion seleccion = new seleccion();
        switch (opcion) {
            case 1:
                seleccion.añadirProducto();
                break;
            case 2:
                seleccion.eliminarProducto();
                break;
            case 3:
                seleccion.listarProductos();
                break;
            case 4:
                System.exit(0);
        }
    }
}