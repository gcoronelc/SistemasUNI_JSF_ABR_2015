
/**
 *
 * @author ERIC GUSTAVO CORONEL CASTILLO
 * @email  gcoronelc@gmail.com
 */

package pruebas;

import dao.AlumnoDAO;
import pe.egcc.app.domain.Alumno;

public class Prueba02 {

	public static void main(String[] args) {
		Alumno alumno;
		
		try {
			AlumnoDAO dao = new AlumnoDAO();
			alumno =dao.read(201);
			System.out.println("ID: " + alumno.getId());
			System.out.println("Apellido: " + alumno.getApellido());
			System.out.println("Nombre: " + alumno.getNombre());
			System.out.println("Nota: " + alumno.getNota());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
