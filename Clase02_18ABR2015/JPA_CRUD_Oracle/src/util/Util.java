/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email  gcoronelc@gmail.com
 */
package util;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Util {

	public static void showMessage(Component parent, String message) {
		JOptionPane.showMessageDialog(parent, message, "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showError(Component parent, String message) {
		JOptionPane.showMessageDialog(parent, message, "ERROR", JOptionPane.ERROR_MESSAGE);
	}
}
