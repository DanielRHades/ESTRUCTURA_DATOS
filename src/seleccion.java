import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class seleccion {

    public LinkedList listar() throws IOException, ClassNotFoundException {
        LinkedList<producto> lista = new LinkedList<>();
        File dir = new File("productos/");
        String[] files = dir.list();

        for (int i = 0; i < files.length; i++) {
            if(files[i].endsWith("csv")){
                lista.addLast(importarProductos(dir+"/"+files[i], i));
            }
        }
        return lista;
    }
    public producto importarProductos(String nombre, int ID) throws IOException, ClassNotFoundException {;
        FileInputStream fin = new FileInputStream(nombre);
        ObjectInputStream ois = new ObjectInputStream(fin);
        producto nuevoProducto = (producto) ois.readObject();
        nuevoProducto.setID(ID);
        ois.close();
        return nuevoProducto;
    }
    public void listarProductos() throws IOException, ClassNotFoundException {
        LinkedList<producto> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            producto producto = lista.get(i);
            System.out.println(producto.getID()+". "+producto.getNombre());
        }
    }

    public producto añadirProducto() throws IOException {
        Scanner sc = new Scanner(System.in);
        producto producto=new producto();
        System.out.println("Ingrese el nombre del producto");
        producto.setNombre(sc.nextLine());
        System.out.println("Ingrese el tipo del producto");
        producto.setTipo(sc.nextLine());
        System.out.println("Ingrese la ruta de la imagen del producto");
        producto.setRutaImagen(sc.nextLine());
        System.out.println("Ingrese el precio del producto");
        producto.setPrecio(Double.parseDouble(sc.nextLine()));
        System.out.println("Ingrese la cantidad del producto");
        producto.setCantidad(Integer.parseInt(sc.nextLine()));
        String fileName= "productos/"+producto.getNombre()+".csv";
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(producto.getNombre());
        oos.close();
        return producto;
    }

}
