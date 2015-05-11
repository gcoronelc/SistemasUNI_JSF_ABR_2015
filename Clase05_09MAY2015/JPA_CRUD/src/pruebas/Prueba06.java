
/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email  gcoronelc@gmail.com
 */

package pruebas;

import dao.AlumnoDAO;
import entity.Alumno;
import java.util.List;

public class Prueba06 {

	public static void main(String[] args) {
		List<Alumno> lista = null;

		try {
			AlumnoDAO dao = new AlumnoDAO();
			lista = dao.readForName("g");
			for (Alumno alumno : lista) {
				System.out.println(alumno.getId() + " - " +
						  alumno.getApellido() + " - " +
						  alumno.getNombre() + " - " +
						  alumno.getNota());
			}
		} catch (Exception e) {
      e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}