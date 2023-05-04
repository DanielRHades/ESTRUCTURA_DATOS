import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    private JPanel mainPanel;
    private JTable tbPrincipal;
    private JPanel jpPrimero;
    private JLabel lbTitulo;
    private JButton btAceptar;
    private JPanel jpSegundo;
    private JComboBox comboBox1;

    public Ventana() {
        setTitle("U-SHOP");
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
        comboBox1.addItem("Añadir un producto");
        comboBox1.addItem("Eliminar un producto");

        Object [] row = new Object[5];
        seleccion seleccion = new seleccion();
        btAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (comboBox1.getSelectedItem() == "Añadir un producto"){
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
                if (comboBox1.getSelectedItem() == "Eliminar un producto"){
                    String idr = JOptionPane.showInputDialog("Dame el ID del producto a eliminar: ");
                    int id = Integer.parseInt(idr);
                    try {
                        seleccion.eliminarProducto(id);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);

                    }
                    try {
                        if (seleccion.eliminarProductoID(id)==id){
                            model.removeRow(seleccion.eliminarProductoID(id));
                        }
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }
}
