import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Ventana extends JFrame {
    private JPanel mainPanel;
    private JTable tbPrincipal;
    private JPanel jpPrimero;
    private JLabel lbTitulo;
    private JButton btAceptar;
    private JPanel jpSegundo;
    private JComboBox comboBox1;
    private JScrollPane scrollPrincipal;

    public Ventana() throws Exception {
        setTitle("U-STOCK");
        setSize(800,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);
        Font fuente = new Font(" ",1,22);
        Object [] columns = {"ID","Nombre","Tipo","Precio","Cantidad"};
        DefaultTableModel model = new DefaultTableModel();
        tbPrincipal.setFont(fuente);
        model.setColumnIdentifiers(columns);
        tbPrincipal.setModel(model);
        tbPrincipal.setRowHeight(30);
        comboBox1.addItem("Añadir producto");
        comboBox1.addItem("Eliminar producto");
        comboBox1.addItem("Modificar producto completo");
        comboBox1.addItem("Modificar precio & cantidad producto");

        BufferedImage icon = ImageIO.read(new File("UI/uStockResized.png"));
        lbTitulo.setIcon(new ImageIcon(icon));

        jpPrimero.setBorder(BorderFactory.createMatteBorder(2,0,2,0,Color.gray));
        tbPrincipal.setBorder(BorderFactory.createMatteBorder(1,0,0,0,Color.gray));
        scrollPrincipal.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));

        Object [] row = new Object[5];
        seleccion seleccion = new seleccion();
        int i=0;
        for (i=0 ; i<seleccion.listarLista() ; i++ ){
            row[0] = seleccion.listarProductosID(i);
            row[1] = seleccion.listarProductosNombre(i);
            row[2] = seleccion.listarProductosTipo(i);
            row[3] = seleccion.listarProductosPrecio(i);
            row[4]= seleccion.listarProductosCantidad(i);
            model.addRow(row);
        }

        btAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (comboBox1.getSelectedItem() == "Añadir producto"){
                    try {
                        seleccion.añadirProducto();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        row[0] = seleccion.listarProductosID();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        row[1] = seleccion.listarProductosNombre();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        row[2] = seleccion.listarProductosTipo();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        row[3] = seleccion.listarProductosPrecio();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        row[4]= seleccion.listarProductosCantidad();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    model.addRow(row);
                }
                if (comboBox1.getSelectedItem() == "Eliminar producto"){
                    String idr = JOptionPane.showInputDialog("Dame el ID del producto a eliminar: ");
                    int id = Integer.parseInt(idr);
                    try {
                        seleccion.eliminarProducto(id);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    int a = model.getRowCount();
                    for (int i=0; i<a ; i++){
                        model.removeRow(0);
                    }
                    try {
                        int i;
                        for (i = 0; i < seleccion.listarLista(); i++) {
                            row[0] = seleccion.listarProductosID(i);
                            row[1] = seleccion.listarProductosNombre(i);
                            row[2] = seleccion.listarProductosTipo(i);
                            row[3] = seleccion.listarProductosPrecio(i);
                            row[4] = seleccion.listarProductosCantidad(i);
                            model.addRow(row);
                        }
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if (comboBox1.getSelectedItem()=="Modificar producto completo"){
                    String idr = JOptionPane.showInputDialog("Dame la ID del producto deseas cambiar: ");
                    int id = Integer.parseInt(idr);
                    try {
                        seleccion.eliminarProducto(id);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        seleccion.añadirProducto2(id);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        row[0] = seleccion.listarProductosID();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        row[1] = seleccion.listarProductosNombre();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        row[2] = seleccion.listarProductosTipo();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        row[3] = seleccion.listarProductosPrecio();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        row[4]= seleccion.listarProductosCantidad();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    model.addRow(row);
                   }
                    int a = model.getRowCount();
                    for (int i=0; i<a ; i++){
                        model.removeRow(0);
                    }
                    try {
                        int i;
                        for (i = 0; i < seleccion.listarLista(); i++) {
                            row[0] = seleccion.listarProductosID(i);
                            row[1] = seleccion.listarProductosNombre(i);
                            row[2] = seleccion.listarProductosTipo(i);
                            row[3] = seleccion.listarProductosPrecio(i);
                            row[4] = seleccion.listarProductosCantidad(i);
                            model.addRow(row);
                        }
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                if (comboBox1.getSelectedItem()=="Modificar precio & cantidad producto"){
                    String idr = JOptionPane.showInputDialog("Dame la ID del producto deseas cambiar: ");
                    int id = Integer.parseInt(idr);

                    String n = null;
                    try {
                        n = seleccion.mantenerNombre(id);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }

                    String t = null;
                    try {
                        t = seleccion.mantenerTipo(id);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        seleccion.eliminarProducto(id);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        seleccion.añadirProductoPrecioCantidad(id,n,t);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        row[0] = seleccion.listarProductosID();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        row[1] = seleccion.listarProductosNombre();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        row[2] = seleccion.listarProductosTipo();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        row[3] = seleccion.listarProductosPrecio();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        row[4]= seleccion.listarProductosCantidad();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    model.addRow(row);
                }
                a = model.getRowCount();
                for (int i=0; i<a ; i++){
                    model.removeRow(0);
                }
                try {
                    int i;
                    for (i = 0; i < seleccion.listarLista(); i++) {
                        row[0] = seleccion.listarProductosID(i);
                        row[1] = seleccion.listarProductosNombre(i);
                        row[2] = seleccion.listarProductosTipo(i);
                        row[3] = seleccion.listarProductosPrecio(i);
                        row[4] = seleccion.listarProductosCantidad(i);
                        model.addRow(row);
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}