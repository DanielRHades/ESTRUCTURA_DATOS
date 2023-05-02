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
        seleccion sumamaw = new seleccion();
        btAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (comboBox1.getSelectedItem() == "Añadir un producto"){
                    row[0] = "UWU";
                    row[1] = "UWU";
                    row[2] = "UWU";
                    row[3] = "UWU";
                    row[4]="UWU";
                    model.addRow(row);
                }
                if (comboBox1.getSelectedItem() == "Eliminar un producto"){
                    row[0] = "UNU";
                    row[1] = "UNU";
                    row[2] = "UNU";
                    row[3] = "UNU";
                    row[4]="UNU";
                    model.addRow(row);
                }
            }
        });
    }
}
