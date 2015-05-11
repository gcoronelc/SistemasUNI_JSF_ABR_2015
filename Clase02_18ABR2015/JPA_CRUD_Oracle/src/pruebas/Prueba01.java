

package pruebas;

import dao.AlumnoDAO;
import pe.egcc.app.domain.Alumno;

public class Prueba01 {

	public static void main(String[] args) {
    
		Alumno alumno = new Alumno();
		alumno.setApellido("Fortunato");
		alumno.setNombre("Veliz");
		alumno.setNota(20);

		try {
			AlumnoDAO dao = new AlumnoDAO();
			dao.create(alumno);
			System.out.println("ID: " + alumno.getId());
			System.out.println("Ok");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
