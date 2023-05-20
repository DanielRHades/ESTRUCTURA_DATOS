import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import javax.swing.*;
import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
public class seleccion {
    public LinkedList listar() throws Exception {
        LinkedList<producto> lista = new LinkedList<>();
        File dir = new File("productos/");
        String[] files = dir.list();
        for (int i = 0; i < files.length; i++) {
            if(files[i].endsWith("xml")){ //En caso de que el directorio contenga archivos distintos a los xml
                lista.addLast(importarProductos(dir+"/"+files[i]));
            }
        }
        return lista;
    }
    public void checkDirectory(){
        File dir = new File("./");
        String[] files = dir.list();
        assert files != null;
        for (String d: files) {
            if (d == "productos") {
                System.out.println("Directorio productos encontrado");
                return;
            }
        }
        new File("productos").mkdir();
    }
    public int listarLista() throws Exception {
        LinkedList<producto> lista = new LinkedList<>();
        File dir = new File("productos/");
        String[] files = dir.list();
        for (int i = 0; i < files.length; i++) {
            if(files[i].endsWith("xml")){ //El array incluye directorios además de archivos, esto se asegura de que solo cuente los archivos .xml
                lista.addLast(importarProductos(dir+"/"+files[i]));
            }
        }
        return files.length;
    }

    public producto importarProductos(String nombre) throws Exception {//Al llamar este metodo el string nombre incluye la ruta del archivo relativa al directorio raiz del proyecto
        Serializer serializer = new Persister();
        File source = new File(nombre);
        return serializer.read(producto.class, source);
    }


    public int listarProductosID() throws Exception {
        LinkedList<producto> lista = listar();
        Collections.sort(lista, new Comparator<producto>() {
            @Override
            public int compare(producto i1, producto i2) {
                return i1.getID() - i2.getID();
            }
        });
        int ID = 0;
        for (producto producto : lista) {
            ID = producto.getID();
        }
        return ID;
    }
    public int listarProductosID(int a) throws Exception {
        LinkedList<producto> lista = listar();
        Collections.sort(lista, new Comparator<producto>() {
            @Override
            public int compare(producto i1, producto i2) {
                return i1.getID() - i2.getID();
            }
        });
        int ID = 0;
        int i;
        for (i=0 ; i<=a ; i++) {
            ID = lista.get(i).getID();
        }
        return ID;
    }
    public String listarProductosNombre() throws Exception {
        LinkedList<producto> lista = listar();
        Collections.sort(lista, new Comparator<producto>() {
            @Override
            public int compare(producto i1, producto i2) {
                return i1.getID() - i2.getID();
            }
        });
        String nombre = null;
        for (producto producto : lista) {
            nombre = producto.getNombre();
        }
        return nombre;
    }
    public String listarProductosNombre(int a) throws Exception {
        LinkedList<producto> lista = listar();
        Collections.sort(lista, new Comparator<producto>() {
            @Override
            public int compare(producto i1, producto i2) {
                return i1.getID() - i2.getID();
            }
        });
        String nombre = null;
        int i;
        for (i = 0;i<=a;i++) {
            nombre = lista.get(i).getNombre();
        }
        return nombre;
    }
    public String listarProductosTipo() throws Exception {
        LinkedList<producto> lista = listar();
        Collections.sort(lista, new Comparator<producto>() {
            @Override
            public int compare(producto i1, producto i2) {
                return i1.getID() - i2.getID();
            }
        });
        String tipo = null;
        for (producto producto : lista) {
            tipo = producto.getTipo();
        }
        return tipo;
    }
    public String listarProductosTipo(int a) throws Exception {
        LinkedList<producto> lista = listar();
        Collections.sort(lista, new Comparator<producto>() {
            @Override
            public int compare(producto i1, producto i2) {
                return i1.getID() - i2.getID();
            }
        });
        String tipo = null;
        int i;
        for (i = 0 ; i<=a ; i++) {
            tipo = lista.get(i).getTipo();
        }
        return tipo;
    }


    public double listarProductosPrecio() throws Exception {
        LinkedList<producto> lista = listar();
        Collections.sort(lista, new Comparator<producto>() {
            @Override
            public int compare(producto i1, producto i2) {
                return i1.getID() - i2.getID();
            }
        });
        double precio = 0;
        for (producto producto : lista) {
            precio = producto.getPrecio();
        }
        return precio;
    }
    public double listarProductosPrecio(int a) throws Exception {
        LinkedList<producto> lista = listar();
        Collections.sort(lista, new Comparator<producto>() {
            @Override
            public int compare(producto i1, producto i2) {
                return i1.getID() - i2.getID();
            }
        });
        double precio = 0;
        int i;
        for (i = 0; i<=a; i++) {
            precio = lista.get(i).getPrecio();
        }
        return precio;
    }
    public int listarProductosCantidad() throws Exception {
        LinkedList<producto> lista = listar();
        Collections.sort(lista, new Comparator<producto>() {
            @Override
            public int compare(producto i1, producto i2) {
                return i1.getID() - i2.getID();
            }
        });
        int cantidad = 0;
        int i;
        for (producto producto : lista) {
            cantidad = producto.getCantidad();
        }
        return cantidad;
    }
    public int listarProductosCantidad(int a) throws Exception {
        LinkedList<producto> lista = listar();
        Collections.sort(lista, new Comparator<producto>() {
            @Override
            public int compare(producto i1, producto i2) {
                return i1.getID() - i2.getID();
            }
        });
        int cantidad = 0;
        int i;
        for (i=0; i<=a ; i++) {
            cantidad = lista.get(i).getCantidad();
        }
        return cantidad;
    }
    public void añadirProducto(int id) throws Exception {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
        String tipo = JOptionPane.showInputDialog("Ingrese el tipo del producto: ");
        String precior = JOptionPane.showInputDialog("Ingrese el precio del producto: ");
        double precio = Double.parseDouble(precior);
        String cantidadr= JOptionPane.showInputDialog("Ingrese la cantidad del producto: ");
        int cantidad= Integer.parseInt(cantidadr);
        producto producto=new producto(nombre,tipo,precio,cantidad);
        Serializer serializer = new Persister();
        producto.setID(id);
        File file = new File("productos/"+producto.getNombre()+".xml");
        serializer.write(producto, file);
    }
    public void modificarProducto(int id) throws Exception {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
        String tipo = JOptionPane.showInputDialog("Ingrese el tipo del producto: ");
        String precior = JOptionPane.showInputDialog("Ingrese el precio del producto: ");
        double precio = Double.parseDouble(precior);
        String cantidadr= JOptionPane.showInputDialog("Ingrese la cantidad del producto: ");
        int cantidad= Integer.parseInt(cantidadr);
        producto producto=new producto(nombre,tipo,precio,cantidad);
        Serializer serializer = new Persister();
        producto.setID(id);
        File file = new File("productos/"+producto.getNombre()+".xml");
        serializer.write(producto, file);
    }

    public String mantenerNombre(int id) throws Exception {
        LinkedList<producto> lista = listar();
        String nombre = null;
        for (producto producto : lista) {
            if (id == producto.getID()) {
                nombre = producto.getNombre();
            }
        }
        return nombre;
    }
    public String mantenerTipo(int id) throws Exception {
        LinkedList<producto> lista = listar();
        String tipo = null;
        for (producto producto : lista) {
            if (id == producto.getID()) {
                tipo = producto.getTipo();
            }
        }
        return tipo;
    }
    public void modificarProductoPrecioCantidad(int id, String nombre, String tipo) throws Exception {
        String precior = JOptionPane.showInputDialog("Ingrese el precio del producto: ");
        double precio = Double.parseDouble(precior);
        String cantidadr= JOptionPane.showInputDialog("Ingrese la cantidad del producto: ");
        int cantidad= Integer.parseInt(cantidadr);
        producto producto=new producto(precio,cantidad);
        Serializer serializer = new Persister();
        producto.setID(id);
        producto.setNombre(nombre);
        producto.setTipo(tipo);
        File file = new File("productos/"+producto.getNombre()+".xml");
        serializer.write(producto, file);
    }

    public void eliminarProducto(int id) throws Exception {
        LinkedList<producto> lista = listar();
        for (producto producto : lista) {
            if (id == producto.getID()) {
                File dir = new File("productos/"+producto.getNombre()+".xml");
                dir.delete();
            }
        }
    }
    public int generarID() throws Exception {
        LinkedList<producto> lista = listar();
        LinkedList<Integer> ID = new LinkedList<Integer>();
        if (lista.isEmpty()) {
            return 0;
        }else {
            lista.sort(new Comparator<producto>() {
                @Override
                public int compare(producto i1, producto i2) {
                    return i1.getID() - i2.getID();
                }
            });
            for (producto producto : lista) {
                ID.addLast(producto.getID());

            }
            return ID.getLast()+1;
        }
    }
}
