import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        FlatDarkLaf.setup();
        new seleccion().checkDirectory();
        JOptionPane.showMessageDialog(null, "Bienvenido al sistema de\nalmacenamiento gratuito:\n              U-STOCK", "U-STOCK",1);
        Ventana principal = new Ventana();
    }
}