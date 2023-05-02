import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
public class seleccion {
    public LinkedList listar() throws Exception {
        LinkedList<producto> lista = new LinkedList<>();
        File dir = new File("productos/");
        String[] files = dir.list();
        for (int i = 0; i < files.length; i++) {
            if(files[i].endsWith("xml")){ //El array incluye directorios además de archivos, esto se asegura de que solo cuente los archivos .xml
                lista.addLast(importarProductos(dir+"/"+files[i]));
            }
        }
        return lista;
    }
    public producto importarProductos(String nombre) throws Exception {//Al llamar este metodo el string nombre incluye la ruta del archivo relativa al directorio raiz del prollecto
        Serializer serializer = new Persister();
        File source = new File(nombre);
        return serializer.read(producto.class, source);
    }
    public void listarProductos() throws Exception {
        LinkedList<producto> lista = listar();
        Collections.sort(lista, new Comparator<producto>() {
            @Override
            public int compare(producto i1, producto i2) {
                return i1.ID - i2.ID;
            }
        });
        for (producto producto : lista) {
            System.out.println(producto.getID() + ". " + producto.getNombre());
        }
    }
    public void añadirProducto() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto");
        String nombre = (sc.nextLine());
        System.out.println("Ingrese el tipo del producto");
        String tipo =(sc.nextLine());
        System.out.println("Ingrese la ruta de la imagen del producto");
        String rutaImagen = (sc.nextLine());
        System.out.println("Ingrese el precio del producto");
        double precio = (Double.parseDouble(sc.nextLine()));
        System.out.println("Ingrese la cantidad del producto");
        int cantidad = (Integer.parseInt(sc.nextLine()));
        producto producto=new producto(nombre,tipo,rutaImagen,precio,cantidad);
        Serializer serializer = new Persister();
        File dir = new File("productos/"); // ruta en la que se van a guardar los archivos
        producto.setID(dir.list().length-1);
        File file = new File("productos/producto"+producto.getNombre()+".xml");
        serializer.write(producto, file);
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
