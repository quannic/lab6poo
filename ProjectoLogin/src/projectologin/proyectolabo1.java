// Joel Seura - RUT: 21.556.232-8

package projectologin;

import gui.VentanaCalculadora;
import javax.swing.SwingUtilities;

public class proyectolabo1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaCalculadora().setVisible(true));
    }
}
