
/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email  gcoronelc@gmail.com
 */

package pruebas;

import dao.AlumnoDAO;
import pe.egcc.app.domain.Alumno;

public class Prueba04 {

	public static void main(String[] args) {
		Alumno alumno = new Alumno();
		alumno.setId(101);

		try {
			AlumnoDAO dao = new AlumnoDAO();
			dao.update(alumno);
			System.out.println("Ok");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
