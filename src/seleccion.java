import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class seleccion {

    public LinkedList listar() throws Exception {
        LinkedList<producto> lista = new LinkedList<>();
        File dir = new File("productos/");
        String[] files = dir.list();

        for (int i = 0; i < files.length; i++) {
            if (files[i].endsWith("xml")) {
                lista.addLast(importarProductos(dir + "/" + files[i], i));
            }
        }
        return lista;
    }

    public producto importarProductos(String nombre, int ID) throws Exception {
        Serializer serializer = new Persister();
        File source = new File(nombre);
        producto nuevoProducto = serializer.read(producto.class, source);
        nuevoProducto.setID(ID);
        return nuevoProducto;
    }

    public void listarProductos() throws Exception {
        LinkedList<producto> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            producto producto = lista.get(i);
            System.out.println(producto.getID() + ". " + producto.getNombre());
        }
    }

    public producto añadirProducto() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto");
        String nombre = (sc.nextLine());
        System.out.println("Ingrese el tipo del producto");
        String tipo = (sc.nextLine());
        System.out.println("Ingrese la ruta de la imagen del producto");
        String rutaImagen = (sc.nextLine());
        System.out.println("Ingrese el precio del producto");
        double precio = (Double.parseDouble(sc.nextLine()));
        System.out.println("Ingrese la cantidad del producto");
        int cantidad = (Integer.parseInt(sc.nextLine()));
        producto producto = new producto(nombre, tipo, rutaImagen, precio, cantidad);
        Serializer serializer = new Persister();
        File dir = new File("productos/");
        producto.setID(dir.list().length);
        File file = new File("productos/producto" + producto.getNombre() + ".xml");
        serializer.write(producto, file);
        return producto;
    }

    public void eliminarProducto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el nombre del producto que deseas borrar: ");
        String ep = (sc.nextLine());
        File dir = new File("productos/");
        String[] files = dir.list();
        for (int i = 0; i < files.length; i++) {
            if (files[i].contains(ep)) {
                File cositas = new File("productos/"+files[i]);
                cositas.delete();
              }
            }
        }
    }

