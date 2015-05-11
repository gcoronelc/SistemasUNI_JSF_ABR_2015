
/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email  gcoronelc@gmail.com
 */

package pruebas;

import dao.AlumnoDAO;
import entity.Alumno;
import java.util.List;

public class Prueba05 {

	public static void main(String[] args) {
		List<Alumno> lista = null;

		try {
			AlumnoDAO dao = new AlumnoDAO();
			// lista = dao.readAll1();
			lista = dao.readAll2();
			for (Alumno alumno : lista) {
				System.out.println(alumno.getId() + " - " +
						  alumno.getApellido() + " - " +
						  alumno.getNombre() + " - " +
						  alumno.getNota());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}